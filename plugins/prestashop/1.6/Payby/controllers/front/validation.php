<?php

require_once dirname(dirname(dirname(__FILE__))) . '/PayBy.php';
require_once dirname(dirname(dirname(__FILE__))) . '/package_PayBy/pbw_Function.php';

class PayByvalidationModuleFrontController extends ModuleFrontController
{

    /**
     * Validation du paiement standard
     * Puis redirection vers la page de succès de commande
     */
    public function postProcess() {
        $logger = new FileLogger();
        $logger->setFilename(_PS_ROOT_DIR_.'/modules/PayBy/log/SendData_'.date("Y-m-d").'.log');

        $cart = $this->context->cart;
        $logger->logInfo('|-------------------------------- Begin validation ORDER_ID : '.$cart->id.' ---------------------------------|');

        if ($cart->id_customer == 0 || $cart->id_address_delivery == 0 || $cart->id_address_invoice == 0 || !$this->module->active) {
            $logger->logInfo('Create order after redirect to PayBy ');
            Tools::redirect('index.php?controller=order&step=1');
        }

        $customer = new Customer($cart->id_customer);
        if (!Validate::isLoadedObject($customer)) {
            Tools::redirect('index.php?controller=order&step=1');
        }

        $currency = $this->context->currency;
        $total    = (float)$cart->getOrderTotal(true, Cart::BOTH);
        global $currency;

        // $my_currency_iso_code = $currency->iso_code;
        $currency  = $this->context->currency;
        $currencyi = ($currency->iso_code_num);
        $lang      = new Language(intval($cart->id_lang));
        $customer  = new Customer(intval($cart->id_customer));
        $address   = new Address(intval($cart->id_address_invoice));
        $country   = $address->country;
        $products  = $cart->getProducts();
        
        $description = ' ';
		$i=0;
        foreach ($products as $product) {
			if($i==0){
				$description .= $product['name'].' ' ;
				$i++;
			}
			else 	
            $description .= ' - '.$product['name'].' ' ; 
        }
        $lang = Db::getInstance()->getValue('SELECT iso_code FROM '._DB_PREFIX_.'lang  WHERE id_lang='.$customer->id_lang);
        $logger->logInfo("> LANGUAGE : $lang");
        $logger->logInfo("> currency->conversion_rate : $currency->conversion_rate");
        $amount =number_format($cart->getOrderTotal(true, Cart::BOTH), 2, '.', '');
        $string_tr = (string)Configuration::get('TRANSACTION_CAPTURE');
        $CURRENCY_CODE=$currencyi;

        // Contruction of variables for function: sendData()
        $PayBy_MESSAGE_VERSION = '1.0';
        $MERCHANT_ID          = (string)(Configuration::get('PayBy_MERCHANT_ID'));;
        $AMOUNT               = (string)($amount);
        $TRANSACTION_CAPTURE  = $string_tr == "yes" ? 'true': 'false';
        $CURRENCY_CODE        = $CURRENCY_CODE;
        $ORDER_ID             = (string)($cart->id);
        $ORDER_DETAILS        = (string)($description);
        $MERCHANT_URL         = Configuration::get('PayBy_MERCHANT_URL');
        $CUSTOMER_LASTNAME    = (string)($customer->lastname);
        $CUSTOMER_FIRSTNAME   = (string)($customer->firstname);
        $CUSTOMER_ADDRESS     = (string)($address->address1);
        $CUSTOMER_ZIPCODE     = (string)($address->postcode);
        $CUSTOMER_CITY        = (string)($address->city);
        $CUSTOMER_STATE       = 'stat';
        $CUSTOMER_COUNTRY     = (string)($country);
        $CUSTOMER_EMAIL       = (string)($customer->email);
        $LANGUAGE             = $lang;
        $PayBy_URLREPAUTO      = Configuration::get('PayBy_MERCHANT_URL');
        $MERCHANT_CLE         = Configuration::get('PayBy_MERCHANT_KEY');
        $PayBy_URL             = Configuration::get('PayBy_URL_PayBy');
        $CUSTOMER_MESSAGE     = Configuration::get('PayBy_CUSTOMER_MESSAGE');

        if( $address->phone == "" ) $CUSTOMER_PHONE=(string)($address->phone_mobile);
        else $CUSTOMER_PHONE=(string)($address->phone);

        $Devise_Panier = (string)Configuration::get('Devise_Panier');
        $Convertion    = (string)Configuration::get('Convertion');
        $logger->logInfo("> Devise_Panier : $Devise_Panier");
        $logger->logInfo("> Convertion    : $Convertion");
        $Id_Currency_Default = (int)Configuration::get('PS_CURRENCY_DEFAULT');
        $Code_Iso_Default    = Db::getInstance()->getValue('SELECT iso_code_num FROM '._DB_PREFIX_.'currency  WHERE id_currency='.$Id_Currency_Default);
        $logger->logInfo('> Code_Iso_Default : '.$Code_Iso_Default);
        $CURRENCY_CODE_select=$currency->iso_code;
        $logger->logInfo('> CURRENCY_CODE_select : '.$CURRENCY_CODE_select);

        // bloc de devise du panier //
        if ($Devise_Panier=="yes") {

            $AMOUNT_CONVERSION="false";
            $CONVERTED_AMOUNT='';
            $CONVERSION_CURRENCY='';
            $logger->logInfo("> AMOUNT_CONVERSION : ".$AMOUNT_CONVERSION);
            $logger->logInfo("> CONVERTED_AMOUNT : ".$CONVERTED_AMOUNT);
            $logger->logInfo("> CONVERSION_CURRENCY : ".$CONVERSION_CURRENCY);
            $logger->logInfo("> SELECT CURRENCY PANIER, AMOUNT CONVERSION  FALSE ne pas afficher.");
            $logger->logInfo("> AMOUNT CONVERSION : ".$AMOUNT_CONVERSION);
            $logger->logInfo("> SELECT CURRENCY PANIER ");

        } else {

            // bloc de devise du site
            $AMOUNT=number_format(($AMOUNT/$currency->conversion_rate), 2, '.', '');
            $CURRENCY_CODE=$Code_Iso_Default;
/*
            if ($Convertion=="yes") {
            
                if ($currency->conversion_rate!="" && $currency->iso_code_num!= $Code_Iso_Default) {
                    $AMOUNT_Convert=number_format(($AMOUNT*$currency->conversion_rate), 2, '.', '');
                    $logger->logInfo('> convertion amount');
                    $AMOUNT_CONVERSION   = "true";
                    $CONVERTED_AMOUNT    = $AMOUNT_Convert;
                    $CONVERSION_CURRENCY = $CURRENCY_CODE_select;
                } else {
                    $logger->logInfo('> convertion amount false: Convertion false');
                    $AMOUNT_CONVERSION="false";
                    $CONVERTED_AMOUNT='';
                    $CONVERSION_CURRENCY='';
                }

            } else {

                $logger->logInfo('DEVISE PAR DEFAULT DE SITE SELECTE and  AMOUNT_CONVERSION false');
                if ($currency->conversion_rate!='') {
                    $AMOUNT_Convert=number_format(($AMOUNT/$currency->conversion_rate), 2, '.', '');
                    $logger->logInfo('> convertion amount ne pas afficher');
                    $AMOUNT_CONVERSION   = "false";
                    $CONVERTED_AMOUNT    = '';
                    $CONVERSION_CURRENCY = '';
                } else {
					$logger->logInfo('> convertion amount false :Convertion no');
					$AMOUNT_CONVERSION   = "false";
					$CONVERTED_AMOUNT    = '';
					$CONVERSION_CURRENCY = '';
                }

            }
*/
        }

        $data = array(
            'PayBy_MESSAGE_VERSION' => $PayBy_MESSAGE_VERSION,
            'MERCHANT_ID'          => $MERCHANT_ID,
            'AMOUNT'               => $AMOUNT,
            'CURRENCY_CODE'        => $CURRENCY_CODE,              
            'TRANSACTION_CAPTURE'  => $TRANSACTION_CAPTURE,
            'ORDER_ID'             => $ORDER_ID,
            'ORDER_DETAILS'        => $ORDER_DETAILS,
            'MERCHANT_URL'         => $MERCHANT_URL,
            'CUSTOMER_LASTNAME'    => $CUSTOMER_LASTNAME,
            'CUSTOMER_FIRSTNAME'   => $CUSTOMER_FIRSTNAME,
            'CUSTOMER_ADDRESS'     => $CUSTOMER_ADDRESS,
            'CUSTOMER_ZIPCODE'     => $CUSTOMER_ZIPCODE,
            'CUSTOMER_CITY'        => $CUSTOMER_CITY,
            'CUSTOMER_STATE'       => $CUSTOMER_STATE,
            'CUSTOMER_COUNTRY'     => $CUSTOMER_COUNTRY,
            'CUSTOMER_PHONE'       => $CUSTOMER_PHONE,
            'CUSTOMER_EMAIL'       => $CUSTOMER_EMAIL,
            'LANGUAGE'             => $LANGUAGE,
            'PayBy_URLREPAUTO'      => $MERCHANT_URL,        
            'MERCHANT_CLE'         => $MERCHANT_CLE,
            'PayBy_URL'             => $PayBy_URL,
            'CUSTOMER_MESSAGE'     => $CUSTOMER_MESSAGE,
            'AMOUNT_CONVERSION'    => $AMOUNT_CONVERSION,
            'CONVERTED_AMOUNT'     => $CONVERTED_AMOUNT,
            'CONVERSION_CURRENCY'  => $CONVERSION_CURRENCY
        );

        $logger->logInfo("> Data from validation :".json_encode($data) );

        $package_Url = Tools::htmlentitiesutf8('http' . (isset($_SERVER['HTTPS']) ? 's' : '') . '://' .$_SERVER['HTTP_HOST'].__PS_BASE_URI__.'modules/PayBy/package_PayBy');
        $packageFolder=realpath(dirname(dirname(dirname(__FILE__))));
        
        $logger->logInfo("> package_Url : "  . $package_Url);
        $logger->logInfo("> packageFolder : ". $packageFolder);
        
        $fctPayBy = new PayByPack();
        $validation=$fctPayBy->sendData($packageFolder,$package_Url,$data);
        
        if($validation == 0) {
            $this->context->cookie->redirect_errors[] = Tools::displayError('Please log in to reorder.');
            $logger->logInfo('*** Erreur retourner par la fonction de validation. $validation =  ' . $validation);
            $logger->logInfo("|-------------------------------- End validation ORDER_ID : $cart->id ---------------------------------|");
            Tools::redirect('order');
            die();
        }
        die();
        //Tools::redirect('index.php?controller=order-confirmation&id_cart='.(int)$cart->id.'&id_module='.(int)$this->module->id.'&id_order='.$this->module->currentOrder.'&key='.$customer->secure_key);

        // a command passe directement en statut payé
        // $this->module->validateOrder((int)$cart->id, Configuration::get('PS_OS_PAYMENT'), $total, $this->module->displayName, null, array(), (int)$currency->id, false, $customer->secure_key);
        
    }

}