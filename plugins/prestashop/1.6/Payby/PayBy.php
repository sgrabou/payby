<?php

if (!defined('_PS_VERSION_')) exit;

class PayBy extends PaymentModule {

	public static $ACTIVE=1;
	public static $TRANSACTION_CAPTURE="yes";
	public static $CREATE_ORDER="Y";
	public static $URL_PayBy="";
	public static $CUSTOMER_MESSAGE="";
	public static $MERCHANT_ID="" ;
	public static $Payment_On_Delivery="yes";
	public static $Convertion="yes";
	public static $MERCHANT_KEY="";
	public static $MERCHANT_URL = "";
 	private static $site_url;

	public function __construct() {

		$this->name = 'PayBy';
		$this->tab = 'payments_gateways';
		$this->version = '1.0.0';
		$this->author = 'PayBy';
		parent::__construct();
		$this->displayName = $this->l('PayBy');
		$this->description = $this->l('Paiement en ligne avec la plateforme PayBy');

		if (self::$site_url === NULL) { 
			if(method_exists('Tools', 'getProtocol')) {
				self::$site_url = Tools::htmlentitiesutf8(Tools::getProtocol().$_SERVER['HTTP_HOST'].__PS_BASE_URI__);
			}
			else {
				self::$site_url = Tools::htmlentitiesutf8((!is_null($use_ssl) && $use_ssl ? 'https://' : 'http://').$_SERVER['HTTP_HOST'].__PS_BASE_URI__);
			}
		}
		
 		self::$MERCHANT_URL = Configuration::get('PayBy_MERCHANT_URL');
		self::$ACTIVE = Configuration::get('PayBy_ACTIVE');				
		self::$TRANSACTION_CAPTURE = Configuration::get('TRANSACTION_CAPTURE');
 		self::$URL_PayBy = Configuration::get('PayBy_URL_PayBy');
 		self::$CUSTOMER_MESSAGE = Configuration::get('PayBy_CUSTOMER_MESSAGE');
 		self::$Payment_On_Delivery = Configuration::get('Payment_On_Delivery');
 		self::$Convertion = Configuration::get('Convertion');
		self::$MERCHANT_ID = Configuration::get('PayBy_MERCHANT_ID');								
		self::$MERCHANT_KEY = Configuration::get('PayBy_MERCHANT_KEY');

 		if (!Configuration::get('PS_OS_PayBy_ATTENTE')) {

			$orderState = new OrderState();
			$orderState->name = array();

			foreach (Language::getLanguages() as $language) {
				if (strtolower($language['iso_code']) == 'fr') {
					$orderState->name[$language['id_lang']] = 'En attente de paiement PayBy';
				} else {
					$orderState->name[$language['id_lang']] = 'Awaiting payment PayBy';
				}
			}

			$orderState->send_email = false;
			$orderState->color = '#123490';
			$orderState->hidden = false;
			$orderState->delivery = false;
			$orderState->logable = false;
			$orderState->invoice = false;

			if ($orderState->add()) {
				copy(dirname(__FILE__).'/logo.gif', dirname(__FILE__).'/../../img/os/'.(int)$orderState->id.'.gif');
			}

			Configuration::updateValue('PS_OS_PayBy_ATTENTE', (int)$orderState->id);

		}


		if (!Configuration::get('PS_OS_PayBy_CAPTURED')) {

			$orderState = new OrderState();
			$orderState->name = array();

			foreach (Language::getLanguages() as $language) {
				if (strtolower($language['iso_code']) == 'fr') {
					$orderState->name[$language['id_lang']] = 'Paiement Capturé';
				} else {
					$orderState->name[$language['id_lang']] = 'Payment Captured';
				}
			}

			$orderState->send_email = false;
			$orderState->color = '#32CD32';
			$orderState->hidden = false;
			$orderState->delivery = false;
			$orderState->logable = false;
			$orderState->invoice = false;

			if ($orderState->add()) {
				copy(dirname(__FILE__).'/logo.gif', dirname(__FILE__).'/../../img/os/'.(int)$orderState->id.'.gif');
			}

			Configuration::updateValue('PS_OS_PayBy_CAPTURED', (int)$orderState->id);

		}

		if (!Configuration::get('PS_OS_PayBy_ABANDONED')) {

			$orderState = new OrderState();
			$orderState->name = array();

			foreach (Language::getLanguages() as $language) {
				if (strtolower($language['iso_code']) == 'fr') {
					$orderState->name[$language['id_lang']] = 'Paiement Abandonné';
				}else {
					$orderState->name[$language['id_lang']] = 'Payment Abandoned';
				}
			}

			$orderState->send_email = false;
			$orderState->color = '#FF8C00';
			$orderState->hidden = false;
			$orderState->delivery = false;
			$orderState->logable = false;
			$orderState->invoice = false;

			if ($orderState->add()) {
				copy(dirname(__FILE__).'/logo.gif', dirname(__FILE__).'/../../img/os/'.(int)$orderState->id.'.gif');
			}

			Configuration::updateValue('PS_OS_PayBy_ABANDONED', (int)$orderState->id);

		}

		//mettre à jour la couleur de l'état : Paiement accépté.

		if (Configuration::get('PS_OS_PAYMENT')) {
			$orderState = new OrderState(intval(Configuration::get('PS_OS_PAYMENT')));
			$orderState->color = '#32cd32';
			$orderState->save();
		}

 		/* For 1.4.3 and less compatibility */
		$updateConfig = array('PS_OS_CHEQUE', 'PS_OS_PREPARATION', 'PS_OS_PAYMENT', 'PS_OS_SHIPPING', 'PS_OS_CANCELED', 'PS_OS_REFUND', 'PS_OS_ERROR', 'PS_OS_OUTOFSTOCK', 'PS_OS_BANKWIRE', 'PS_OS_PAYPAL', 'PS_OS_WS_PAYMENT','PS_OS_PayBy_ATTENTE','PS_OS_PayBy_CAPTURED');

		if (!Configuration::get('PS_OS_PAYMENT')) {
			
			foreach ($updateConfig as $u) {
			
				if (!Configuration::get($u) && defined('_'.$u.'_')) {

					Configuration::updateValue($u, constant('_'.$u.'_'));
				}
				
			}
			
		}
		
	} // ENd __construct()

	public function install() {

		$url = 'index.php?fc=module&module=PayBy&controller=reponse';
		return (parent::install()
			AND $this->registerHook('orderConfirmation')
			AND $this->registerHook('payment')
			AND Configuration::updateValue('PayBy_ACTIVE', '1')									
			AND Configuration::updateValue('TRANSACTION_CAPTURE', 'yes')
			AND Configuration::updateValue('PayBy_URL_PayBy', '')
			AND Configuration::updateValue('PayBy_CUSTOMER_MESSAGE', '')
			AND Configuration::updateValue('Payment_On_Delivery', '')
			AND Configuration::updateValue('Convertion', '')
			AND Configuration::updateValue('PayBy_MERCHANT_URL', self::$site_url.(substr(trim(self::$site_url), -1, 1) === '/' ? '' : '/').$url)
		);

	} // End install()

	public function uninstall() {

		return (parent::uninstall()
			AND Configuration::deleteByName('PayBy_ACTIVE')			
			AND Configuration::deleteByName('TRANSACTION_CAPTURE')			
 			AND Configuration::deleteByName('PayBy_URL_PayBy')
 			AND Configuration::deleteByName('PayBy_CUSTOMER_MESSAGE')
 			AND Configuration::deleteByName('Payment_On_Delivery')
 			AND Configuration::deleteByName('Convertion')
			AND Configuration::deleteByName('PayBy_MERCHANT_ID')						
			AND Configuration::deleteByName('PayBy_MERCHANT_KEY')
 			AND Configuration::deleteByName('PayBy_MERCHANT_URL')
		);

	} // End uninstall()

   	public function hookOrderConfirmation($params) {

		if (!$this->active) {
			return;
		}

		if ($params['objOrder']->module != $this->name) {
			return;
		}

	} // End hookOrderConfirmation()

	private function preProcess() {
		
		if (Tools::isSubmit('submitModule')) {
			self::$MERCHANT_URL = ((Validate::isUrl(Tools::getValue('acceptedUrl'))) ? Tools::getValue('acceptedUrl') : self::$MERCHANT_URL);
			self::$URL_PayBy = ((Validate::isUrl(Tools::getValue('INPUT_URL_PayBy'))) ? Tools::getValue('INPUT_URL_PayBy') : self::$URL_PayBy);
			self::$CUSTOMER_MESSAGE = ((Validate::isUrl(Tools::getValue('INPUT_CUSTOMER_MESSAGE'))) ? Tools::getValue('INPUT_CUSTOMER_MESSAGE') : self::$CUSTOMER_MESSAGE);
			self::$ACTIVE = (Tools::getValue('INPUT_ACTIVE') !== '' ? Tools::getValue('INPUT_ACTIVE') : self::$ACTIVE);			self::$Payment_On_Delivery = (Tools::getValue('INPUT_Payment_On_Delivery') !== '' ? Tools::getValue('INPUT_Payment_On_Delivery') : self::$Payment_On_Delivery);
			self::$ACTIVE = (Tools::getValue('INPUT_ACTIVE') !== '' ? Tools::getValue('INPUT_ACTIVE') : self::$ACTIVE);			self::$Convertion = (Tools::getValue('INPUT_Convertion') !== '' ? Tools::getValue('INPUT_Convertion') : self::$Convertion);
			self::$ACTIVE = (Tools::getValue('INPUT_ACTIVE') !== '' ? Tools::getValue('INPUT_ACTIVE') : self::$ACTIVE);	
			self::$TRANSACTION_CAPTURE = (Tools::getValue('INPUT_TRANSACTION_CAPTURE') !== '' ? Tools::getValue('INPUT_TRANSACTION_CAPTURE') : self::$TRANSACTION_CAPTURE);
			self::$MERCHANT_ID = (Tools::getValue('INPUT_MERCHANT_ID') !== '' ? Tools::getValue('INPUT_MERCHANT_ID') : self::$MERCHANT_ID);			
			self::$CREATE_ORDER = (Tools::getValue('INPUT_CREATE_ORDER') !== '' ? Tools::getValue('INPUT_CREATE_ORDER') : self::$CREATE_ORDER);
			self::$MERCHANT_KEY = (Tools::getValue('INPUT_MERCHANT_KEY') !== '' ? Tools::getValue('INPUT_MERCHANT_KEY') : self::$MERCHANT_KEY);
			Configuration::updateValue('PayBy_ACTIVE', self::$ACTIVE);			
			Configuration::updateValue('TRANSACTION_CAPTURE', self::$TRANSACTION_CAPTURE);
			Configuration::updateValue('PayBy_URL_PayBy', self::$URL_PayBy);
			Configuration::updateValue('PayBy_CUSTOMER_MESSAGE', self::$CUSTOMER_MESSAGE);
			Configuration::updateValue('Payment_On_Delivery', self::$Payment_On_Delivery);
			Configuration::updateValue('Convertion', self::$Convertion);
			Configuration::updateValue('PayBy_MERCHANT_ID', self::$MERCHANT_ID);
			Configuration::updateValue('PayBy_CREATE_ORDER', self::$CREATE_ORDER);
			Configuration::updateValue('PayBy_MERCHANT_KEY', self::$MERCHANT_KEY);
			Configuration::updateValue('PayBy_MERCHANT_URL', self::$MERCHANT_URL);
			return '<div class="conf confirm">'.$this->l('saved settings').'</div>';
		}
		return '';

	} // End preProcess()

	private function _displayPresentation() {
		$out = '';
		return $out;
		
	} // ENd _displayPresentation()

	public function getContent() {

		$str = $this->preProcess();
		$str .= '<h2>'.$this->displayName.'</h2>'.$this->_displayPresentation().'<br />

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(function(){

				var1=$(".Class_Commande").val();

				if (var1!="yes") {
				$(".divselect").show();
				}
				else { $(".divselect").hide();}

				$(".Class_Commande").change(function(){
				var1=$(".Class_Commande").val();
				if (var1!="yes") {
				$(".divselect").show();
				}
				else { $(".divselect").hide();}
				})

			})
		</script>

		<form action="'.Tools::htmlentitiesutf8($_SERVER['REQUEST_URI']).'" method="post">

			<fieldset>

				<legend><img src="../img/admin/contact.gif" />Configuration</legend>
				';

		$str .= '<label>'.$this->l('Enable the module').'<sup style="color:red;">*</sup></label>

					<div class="margin-form"> <input type="checkbox" name="INPUT_ACTIVE" value="1" ';

		if(Tools::safeOutput(self::$ACTIVE)=='1') $str .= ' checked="checked"	 ';

		$str .= ' />

				</div>

				<label>'.$this->l('URL Gateway').'<sup style="color:red;">*</sup></label>

				<div class="margin-form">
					<input type="text" size="80" name="INPUT_URL_PayBy" value="'.Tools::safeOutput(self::$URL_PayBy).'" />
				</div>'		
/*
				<label>'.$this->l('Capture mode').'<sup style="color:red;">*</sup></label>	

				<div class="margin-form">					

					<input type="radio" name="INPUT_TRANSACTION_CAPTURE" value="yes" ';		

		if(Tools::safeOutput(self::$TRANSACTION_CAPTURE)=='yes') $str .= ' checked="checked" ';                

		$str .= ' > '.$this->l('Automatic capture').'<br><input type="radio" name="INPUT_TRANSACTION_CAPTURE" value="no" ';				

		if(Tools::safeOutput(self::$TRANSACTION_CAPTURE)=='no') $str .= ' checked="checked"	 ';                

		$str .= ' > '.$this->l('Manual capture').'<br>															 				

				</div>
*/
				.'<label>'.$this->l('Merchant ID').' <sup style="color:red;">*</sup></label>

				<div class="margin-form">

					<input type="text" size="80" name="INPUT_MERCHANT_ID" value="'.Tools::htmlentitiesUTF8(self::$MERCHANT_ID).'" />

				</div>	

				<label>'.$this->l('Secret key').'<sup style="color:red;">*</sup></label>

				<div class="margin-form">

					<input type="password" size="80" name="INPUT_MERCHANT_KEY" value="'.Tools::htmlentitiesUTF8(self::$MERCHANT_KEY).'" />

				</div>

				<label>'.$this->l('URL validation').' <sup style="color:red;">*</sup></label>

				<div class="margin-form">

					<input type="text" size="80" name="acceptedUrl" value="'.Tools::safeOutput(self::$MERCHANT_URL).'" />

					<p>'.$this->l('Address returns page after validation of payment by PayBy').'</p>

				</div>

				<label>'.$this->l('Custom message').'</label>

				<div class="margin-form">
					<textarea style="width:523px;" placeholder="'.$this->l('The content of this field will be displayed to your customers in the payment page').'" name="INPUT_CUSTOMER_MESSAGE">'.Tools::safeOutput(self::$CUSTOMER_MESSAGE).'</textarea>
				</div>

				<label>'.$this->l('Autoriser Payment à la livraison').' <sup>*</sup></label>

			

				<div class="margin-form">					
																 				
				<select name="INPUT_Payment_On_Delivery" class="Class_Commande">

				<option value="yes"'; if(Tools::safeOutput(self::$Payment_On_Delivery)=='yes') $str .= ' selected="selected"	 ';
				$str.='>Oui</option>
				<option value="no"'; if(Tools::safeOutput(self::$Payment_On_Delivery)=='no') $str .= ' selected="selected"	 ';
				$str.='>Non</option>

				</select>

				</div>

				<br /><div class="margin-form"><input type="submit" name="submitModule" value="'.$this->l('Save').'" class="button" /></div>

			</fieldset>

		</form>';

		return $str;

	} // End getContent()

	public function hookPayment($params) {

		if ((self::$ACTIVE === false || self::$ACTIVE === '' || self::$ACTIVE === NULL) ) return '';
		$this->context->smarty->assign('PayBy_valide_commade', 'index.php?fc=module&module=PayBy&controller=validation"');
		$this->context->smarty->assign('version_presta', _PS_VERSION_);
		return $this->display(__FILE__, 'PayBy.tpl');

	} // End hookPayment()

	public function UpdateCurrentState($id_cart, $id_order_state) {

        if($id_cart !== null && $id_order_state !== null) {

            $history = new OrderHistory();
            $history->id_order = (int)($this->id);
            $history->changeIdOrderState((int)$id_order_state, (int)($this->id));
			$history->addWithemail(true);

        }

    } // End UpdateCurrentState()

} // ENd Class



