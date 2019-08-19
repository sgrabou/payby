<?php

class PayByPack{

	private $logger;
	
	//function to encrypt data.
	public function signData($data, $SECRETKEY) {
	   return hash_hmac('sha256', $data, $SECRETKEY, true);
	}
	
	//function to add logs
	public function addLog($url,$txt) {
		
		$fileName=$url.'/log/SendData_'.date("Y-m-d").'.log';
        $this->logger = new FileLogger();
        $this->logger->setFilename($fileName);
        $this->logger->logInfo($txt);
		
	}
	 
	//function to send data
	public function sendData($BASE,$URL,$DATA) {
		
		$this->addLog($BASE,"**** Begin sendData ****");
		
		$id_marchant  = $DATA['MERCHANT_ID'];
		$capture      = $DATA['TRANSACTION_CAPTURE'] == "true" ? true: false;
		$hmac         = $DATA['MERCHANT_CLE'];
		$url_PayBy     = $DATA['PayBy_URL'];
		$id_order     = $DATA['ORDER_ID'];
		$amount       = $DATA['AMOUNT'];
		$url_marchant = $DATA['MERCHANT_URL'];
		$description  = $DATA['ORDER_DETAILS'];
		$firstname    = $DATA['CUSTOMER_FIRSTNAME'];
		$lastname     = $DATA['CUSTOMER_LASTNAME'];
		$address      = $DATA['CUSTOMER_ADDRESS'];
		$zipcode      = $DATA['CUSTOMER_ZIPCODE'];
		$city         = $DATA['CUSTOMER_CITY'];
		$state        = $DATA['CUSTOMER_STATE'];
		$country      = $DATA['CUSTOMER_COUNTRY'];
		$phone        = $DATA['CUSTOMER_PHONE'];
		$email        = $DATA['CUSTOMER_EMAIL'];
		$lang         = $DATA['LANGUAGE'];
		$url_reponse  = $DATA['PayBy_URLREPAUTO'];
			
		//check data
		
		$PayBy_MESSAGE_VERSION = $DATA['PayBy_MESSAGE_VERSION'];
		$MERCHANT_ID          = (string)($id_marchant);
		$AMOUNT               = (string)($amount*100);
		$CURRENCY_CODE        = $DATA['CURRENCY_CODE'];
		$AMOUNT_CONVERSION    = $DATA['AMOUNT_CONVERSION'];
		$CONVERTED_AMOUNT     = $DATA['CONVERTED_AMOUNT'];
		$CONVERSION_CURRENCY  = $DATA['CONVERSION_CURRENCY'];
		$CUSTOMER_MESSAGE     = $DATA['CUSTOMER_MESSAGE'];
		$TRANSACTION_CAPTURE  = $capture;
		$TRANSACTION_TYPE     = 'AUTH';
		$TRANSACTION_MODE     = 'MODE';
		$CUSTOM_DATA          = 'data';

		/* ORDER_ID */
		if($id_order){
			if(strlen($id_order)>45) $ORDER_ID=substr((string)($id_order), 0, 45);
			else $ORDER_ID=(string)($id_order);
		}
		else $ORDER_ID=' ';
		
		/* ORDER_DETAILS */
		if(strlen($description)>125) $ORDER_DETAILS=substr((string)($description), 0, 125);
		else $ORDER_DETAILS=(string)($description);
				
		/* MERCHANT_URL */
		$MERCHANT_URL=substr($url_marchant, 0, 255);
		
		/* CUSTOMER_LASTNAME */
		if($lastname){
			if(strlen($lastname)>45) $CUSTOMER_LASTNAME=substr((string)($lastname), 0, 45);
			else $CUSTOMER_LASTNAME=(string)($lastname);
		}
		else $CUSTOMER_LASTNAME=' ';
		
		/* CUSTOMER_FIRSTNAME */
		if($firstname){
			if(strlen($firstname)>45) $CUSTOMER_FIRSTNAME=substr((string)($firstname), 0, 45);
			else $CUSTOMER_FIRSTNAME=(string)($firstname);
		}
		else $CUSTOMER_FIRSTNAME=' ';
			
		/* CUSTOMER_ADDRESS */
		if($address){
			if(strlen($address)>255) $CUSTOMER_ADDRESS=substr((string)($address), 0, 255);
			else $CUSTOMER_ADDRESS=(string)($address);
		}
		else $CUSTOMER_ADDRESS=' ';
		
		/* CUSTOMER_ZIPCODE */
		if($zipcode){
			if(strlen($zipcode)>12) $CUSTOMER_ZIPCODE=substr((string)($zipcode), 0, 12);
			else $CUSTOMER_ZIPCODE=(string)($zipcode);
		}
		else $CUSTOMER_ZIPCODE=' ';
		
		/* CUSTOMER_CITY */
		if($city){
			if(strlen($city)>45) $CUSTOMER_CITY=substr((string)($city), 0, 45);
			else $CUSTOMER_CITY=(string)($city);
		}
		else $CUSTOMER_CITY=' ';
			
		/* CUSTOMER_STATE */
		if($state){
			if(strlen($state)>45) $CUSTOMER_STATE=substr((string)($state), 0, 45);
			else $CUSTOMER_STATE=(string)($state);
		}
		else $CUSTOMER_STATE=' ';
		
		/* CUSTOMER_COUNTRY */
		if($country){
			if(strlen($country)>45) $CUSTOMER_COUNTRY=substr((string)($country), 0, 45);
			else $CUSTOMER_COUNTRY=(string)($country);
		}
		else $CUSTOMER_COUNTRY=' ';
		
		/* CUSTOMER_PHONE */
		if($phone){
			if(strlen($phone)>15) $CUSTOMER_PHONE=substr((string)($phone), 0, 15);
			else $CUSTOMER_PHONE=(string)($phone);
		}
		else $CUSTOMER_PHONE=' ';
		
		/* CUSTOMER_EMAIL */
		if($email){
			if(strlen($email)>45) $CUSTOMER_EMAIL=substr((string)($email), 0, 45);
			else $CUSTOMER_EMAIL=(string)($email);
		}
		else $CUSTOMER_EMAIL=' ';
			
		/* LANGUAGE */
		if($lang){
			if(strlen($lang)>2) $LANGUAGE=substr((string)($lang), 0, 2);
			else $LANGUAGE=(string)($lang);
		}
		else $LANGUAGE=' ';
		
		/* PayBy_URLREPAUTO */
		if($url_reponse){
			if(strlen($url_reponse)>125) $PayBy_URLREPAUTO=substr((string)($url_reponse), 0, 125);
			else $PayBy_URLREPAUTO=(string)($url_reponse);
		}
		else $PayBy_URLREPAUTO=' ';
			
		$message='';
			
		// converte $TRANSACTION_CAPTURE to String fo MESSAGE_SIGNATURE
		$TRANSACTION_CAPTURE = ($TRANSACTION_CAPTURE) ? 'true' : 'false';
	/*	$message=$PayBy_MESSAGE_VERSION.$MERCHANT_ID.$AMOUNT.$CURRENCY_CODE.$TRANSACTION_CAPTURE.$TRANSACTION_TYPE.$TRANSACTION_MODE.$CUSTOM_DATA.$ORDER_ID.$ORDER_DETAILS.$MERCHANT_URL.$CUSTOMER_LASTNAME.$CUSTOMER_FIRSTNAME.$CUSTOMER_ADDRESS.$CUSTOMER_ZIPCODE.$CUSTOMER_CITY.$CUSTOMER_STATE.$CUSTOMER_COUNTRY.$CUSTOMER_PHONE.$CUSTOMER_EMAIL.$LANGUAGE.$PayBy_URLREPAUTO;
	*/
	$message=$PayBy_MESSAGE_VERSION.$MERCHANT_ID.$AMOUNT.$CURRENCY_CODE.$ORDER_ID.$ORDER_DETAILS.$MERCHANT_URL.$CUSTOMER_LASTNAME.$CUSTOMER_FIRSTNAME.$CUSTOMER_ADDRESS.$CUSTOMER_ZIPCODE.$CUSTOMER_CITY.$CUSTOMER_COUNTRY.$CUSTOMER_PHONE.$CUSTOMER_EMAIL.$PayBy_URLREPAUTO;
	$this->addLog($BASE, "> PayBy_MESSAGE_VERSION :".$PayBy_MESSAGE_VERSION );
	$this->addLog($BASE, "> MERCHANT_ID :".$MERCHANT_ID );
	$this->addLog($BASE, "> AMOUNT :".$AMOUNT );
	$this->addLog($BASE, "> CURRENCY_CODE :".$CURRENCY_CODE );
	$this->addLog($BASE, "> ORDER_ID :".$ORDER_ID );
	$this->addLog($BASE, "> ORDER_DETAILS :".$ORDER_DETAILS );
	$this->addLog($BASE, "> MERCHANT_URL :".$MERCHANT_URL );
	$this->addLog($BASE, "> CUSTOMER_LASTNAME :".$CUSTOMER_LASTNAME );
	$this->addLog($BASE, "> CUSTOMER_FIRSTNAME :".$CUSTOMER_FIRSTNAME );
	$this->addLog($BASE, "> CUSTOMER_ADDRESS :".$CUSTOMER_ADDRESS );
	$this->addLog($BASE, "> CUSTOMER_ZIPCODE :".$CUSTOMER_ZIPCODE );
	$this->addLog($BASE, "> CUSTOMER_CITY :".$CUSTOMER_CITY );
	$this->addLog($BASE, "> CUSTOMER_COUNTRY :".$CUSTOMER_COUNTRY );
	$this->addLog($BASE, "> CUSTOMER_PHONE :".$CUSTOMER_PHONE );
	$this->addLog($BASE, "> CUSTOMER_EMAIL :".$CUSTOMER_EMAIL );
	$this->addLog($BASE, "> PayBy_URLREPAUTO :".$PayBy_URLREPAUTO );

		$PayBy_MERCHANT_KEY = $hmac;
		$MESSAGE_SIGNATURE = hash_hmac('sha256',$message,$PayBy_MERCHANT_KEY);  
		$hexdigest         = bin2hex($MESSAGE_SIGNATURE);
		$MESSAGE_SIGNATURE = strtoupper($MESSAGE_SIGNATURE);
		
		//JSON
		$retour = array(
			'PayBy_MESSAGE_VERSION' => $PayBy_MESSAGE_VERSION,
			'MERCHANT_ID'          => $MERCHANT_ID,
			'AMOUNT'               => $AMOUNT,
			'CURRENCY_CODE'        => $CURRENCY_CODE,				
			'TRANSACTION_CAPTURE'  => $TRANSACTION_CAPTURE,
			'TRANSACTION_TYPE'     => $TRANSACTION_TYPE,
			'TRANSACTION_MODE'     => $TRANSACTION_MODE,
			'CUSTOM_DATA'          => $CUSTOM_DATA,
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
			'PayBy_URLREPAUTO'      => $PayBy_URLREPAUTO,		
			'MESSAGE_SIGNATURE'    => $MESSAGE_SIGNATURE,
			'CUSTOMER_MESSAGE'     => $CUSTOMER_MESSAGE,
			'AMOUNT_CONVERSION'    => $AMOUNT_CONVERSION,		
			'CONVERTED_AMOUNT'     => $CONVERTED_AMOUNT,
			'CONVERSION_CURRENCY'  => $CONVERSION_CURRENCY
		);

        $this->addLog($BASE, "> Data from sendData :".json_encode($retour) );

		// script to send JSON Data to FrontEnd.

		$content = json_encode($retour);
		$curl = curl_init($url_PayBy);
		$headers = array(
			'Content-Type:application/json',
			'Authorization: Basic '. base64_encode($MERCHANT_ID.":".$hmac) // <---
);
curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
		curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
		curl_setopt($curl, CURLOPT_HTTPHEADER,$headers);
		curl_setopt($ch, CURLOPT_HEADER, 1);
		curl_setopt($curl, CURLOPT_POST, true);
		curl_setopt($curl, CURLOPT_POSTFIELDS, $content);
		curl_setopt($curl, CURLOPT_SSL_VERIFYPEER, false);
		
		// For Production Server
		curl_setopt($curl, CURLOPT_SSLVERSION, CURL_SSLVERSION_TLSv1);
		
		// For Test Server
		//curl_setopt($curl, CURLOPT_SSL_VERIFYHOST, 0);
		//curl_setopt($curl, CURLOPT_SSLVERSION,1);
		
		$json_response = curl_exec($curl);
		$status = curl_getinfo($curl, CURLINFO_HTTP_CODE);
		if ( $status != 201 && $status != 200) {
			//die("Error: call to URL $url_PayBy failed with status $status, response $json_response, curl_error " . curl_error($curl) . ", curl_errno " . curl_errno($curl));
			$this->addLog($BASE,'**** Erreur retournee par le front curl error');
			$this->addLog($BASE,"< ERREUR : Error: call to URL $url_PayBy failed with status $status, response $json_response, curl_error " . curl_error($curl) . ", curl_errno " . curl_errno($curl));
			return 0;
		 }

		$this->addLog($BASE,"> Sending JSON Data to Front >");
		curl_close($curl);

		// Response in JSON Format
		$response      = json_decode($json_response, true);
		$RESPONSE_CODE = $response['RESPONSE_CODE'];
		$REASON_CODE   = $response['REASON_CODE'];
		$this->addLog($BASE,"< RESPONSE_CODE        : $RESPONSE_CODE ");
		$this->addLog($BASE,"< REASON_CODE          : $REASON_CODE ");
		$REP=(int)$RESPONSE_CODE;

		// If Errors
		
		if($REP!=0){
			
			// Errors
			$this->addLog($BASE,'|**** !! Erreur retournee par le front ****|');
			$this->addLog($BASE,"< RESPONSE_CODE        : $RESPONSE_CODE ");
			$this->addLog($BASE,"< REASON_CODE          : $REASON_CODE ");
			return 0;
			
		} else {

			$ORDER_ID             = $response['ORDER_ID'];
			$PayBy_MESSAGE_VERSION = $response['PayBy_MESSAGE_VERSION'];
			$MERCHANT_ID          = $response['MERCHANT_ID'];
			$RESPONSE_CODE        = $response['RESPONSE_CODE'];
			$REASON_CODE          = $response['REASON_CODE'];
			$REFERENCE_ID         = $response['REFERENCE_ID'];
			$REFERENCE_EXTERNE             = $response['REFERENCE_EXTERNE'];
			$PayBy_URL      = $response['PayBy_URL'];
			$MESSAGE_SIGNATURE    = $response['MESSAGE_SIGNATURE'];
		
			$this->addLog($BASE,"< PayBy_MESSAGE_VERSION : $PayBy_MESSAGE_VERSION ");
			$this->addLog($BASE,"< MERCHANT_ID          : $MERCHANT_ID ");
			$this->addLog($BASE,"< RESPONSE_CODE        : $RESPONSE_CODE ");
			$this->addLog($BASE,"< REASON_CODE          : $REASON_CODE ");
			$this->addLog($BASE,"< ORDER_ID             : $ORDER_ID ");
			$this->addLog($BASE,"< REFERENCE_ID         : $REFERENCE_ID ");
			$this->addLog($BASE,"< REFERENCE_EXTERNE             : $REFERENCE_EXTERNE ");
			$this->addLog($BASE,"< PayBy_URL             : $PayBy_URL ");
			$this->addLog($BASE,"< MESSAGE_SIGNATURE    : $MESSAGE_SIGNATURE ");

			$dt=$PayBy_MESSAGE_VERSION.$MERCHANT_ID.$RESPONSE_CODE.$REASON_CODE.$ORDER_ID.$REFERENCE_ID.$REFERENCE_EXTERNE.$PayBy_URL;
			
			//send data by POST to PayBy

			$home_url = $URL . '/send_Data.php?PayBy_URL='.$PayBy_URL.'&ORDER_ID='.$ORDER_ID.'&REFERENCE_ID='.$REFERENCE_ID.'&REFERENCE_EXTERNE='.$REFERENCE_EXTERNE;
			$this->addLog($BASE,'> Sending Data to URL > '.$home_url);
			$this->addLog($BASE,"**** End sendData ****");
			$this->addLog($BASE,"|-------------------------------- End validation ORDER_ID : $ORDER_ID ---------------------------------|");
			
			header('Location: ' . $home_url);
			exit();

		}
		
	} // End sendData()
	 
	public function receiveData($logger, $module) {

	//	header('Content-type: application/json');	//	header('Content-type: application/json');
	//	header('Cache-Control: no-cache, must-revalidate');
	$headers = apache_request_headers();

		// Verifie if receive data.
		if( $data = file_get_contents("php://input")) {
            // Read data
			$buff = file_get_contents("php://input");
			$data = json_decode($buff, true);

			
			$logger->logInfo('|-------------------------------- Begin POST BACK URL From FPAY : '.$data['ORDER_ID'].' with status : '.$data['TRANSACTION_STATE'].' ---------------------------------|');
			
			$FPAY_MESSAGE_VERSION = $data['FPAY_MESSAGE_VERSION'];
			$MERCHANT_ID          = $data['MERCHANT_ID'];
			$REFERENCE_ID         = $data['REFERENCE_ID'];
			$REFERENCE_EXTERNE             = $data['REFERENCE_EXTERNE'];
			$RESPONSE_CODE        = $data['RESPONSE_CODE'];
			$REASON_CODE          = $data['REASON_CODE'];
			$ORDER_ID             = $data['ORDER_ID'];
			$TRANSACTION_DATE     = $data['TRANSACTION_DATE'];
			$AMOUNT               = $data['AMOUNT'];
			$TRANSACTION_STATE    = $data['TRANSACTION_STATE'];
			$MESSAGE_SIGNATURE    = $data['MESSAGE_SIGNATURE'];

			$logger->logInfo("> DATA :".json_encode($data) );

			// Build the string to hache
			
			$dt=$FPAY_MESSAGE_VERSION.$MERCHANT_ID.$REFERENCE_ID.$REFERENCE_EXTERNE.$RESPONSE_CODE.$REASON_CODE.$ORDER_ID.$TRANSACTION_DATE.$AMOUNT.$TRANSACTION_STATE;
			$logger->logInfo(">donnes a crypter: ".$dt);
			$secretKey =Configuration::get('PayBy_MERCHANT_KEY');
						$logger->logInfo(">secretKey ".$secretKey);
			$digest = $this->signData($dt,$secretKey);
			$hexdigest = bin2hex($digest);

			$logger->logInfo("> signature brute      = ".$dt);
			$logger->logInfo("> Received signature   = ".strtoupper($MESSAGE_SIGNATURE));
			$logger->logInfo("> Calculated signature = ".strtoupper($hexdigest));
			$logger->logInfo("> signature brute      = ".$dt);
			$logger->logInfo("> Received signature   = ".strtoupper($MESSAGE_SIGNATURE));
			$logger->logInfo("> Calculated signature = ".strtoupper($hexdigest));

			if($ORDER_ID == null or $TRANSACTION_STATE == null){
				$logger->logInfo("**** TRANSACTION STATUS or ORDER_ID is null");
				http_response_code(400);
				exit;
			}
			
			// Vérifier c'est le statut envoyer par PayBy est Valide
			if( $TRANSACTION_STATE != "AUTHORIZED" and 
				$TRANSACTION_STATE !=   "REVERSED" and 
				$TRANSACTION_STATE !=   "CAPTURED" and 
				$TRANSACTION_STATE !=   "REFUNDED" and 
				$TRANSACTION_STATE !=   "DECLINED" and 
				$TRANSACTION_STATE !=    "EXPIRED" ) {
				$logger->logInfo("**** TRANSACTION STATUS NOT VALID [ TRANSACTION_STATE_PayBy = ".$TRANSACTION_STATE."] ****");
				http_response_code(400);
				exit;
			}
					
			// Commencer les test si la signature est authentique
			if(strtoupper($hexdigest) != strtoupper($MESSAGE_SIGNATURE)) {

				$logger->logInfo("> MESSAGE_SIGNATURE NOK");
				http_response_code(400);
				exit;

			} else {  
			
				$logger->logInfo("> MESSAGE_SIGNATURE OK");
		
				$cart = new Cart((int) $ORDER_ID);
				$currency = new Currency(intval($ORDER_ID));
				$customer =  new Customer($cart->id_customer);
				$total=($AMOUNT/100);

				$total =number_format($total, 2, '.', '');

				$Devise_Panier = (string)Configuration::get('Devise_Panier');
				$logger->logInfo('> Devise_Panier : '.$Devise_Panier);

				if ($Devise_Panier!="yes") {
					$conversion_rateSQL = Db::getInstance()->getValue('SELECT conversion_rate FROM '._DB_PREFIX_.'currency  WHERE id_currency='.$cart->id_currency);
					$logger->logInfo('> conversion_rateSQL : '.json_encode($conversion_rateSQL) );
					$logger->logInfo('> cart->id_currency : '.$cart->id_currency);
					$total =number_format($total*$conversion_rateSQL, 2, '.', '');
					$logger->logInfo('> currency->conversion_rate : '.$currency->id);
					$logger->logInfo('> total : '.$total);
					$logger->logInfo('> convert total_amount');
				}

				$logger->logInfo('> ID CARTE DE LA COMMANDE : '.$cart->id);

				if($RESPONSE_CODE==0){

					if($TRANSACTION_STATE=="AUTHORIZED"){

						// Paiement accépté.

						$logger->logInfo('--> Begin PAYMENT AUTHORIZED');

						$logger->logInfo('> cart id :'.$cart->id);
						$logger->logInfo('> PS_OS_PAYMENT:'.Configuration::get('PS_OS_PAYMENT'));
						$logger->logInfo('> total :'.$total);
						$logger->logInfo('> displayName :'.$this->module->displayName);
						$logger->logInfo('> customer->secure_key :'.$customer->secure_key);
						
						$Statut_cmd = Db::getInstance()->getValue('SELECT current_state FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
						$logger->logInfo('> STATUT DE LA COMMANDE : '.json_encode($Statut_cmd) );
						
						if($Statut_cmd == null) {
							$module->validateOrder((int)$cart->id, Configuration::get('PS_OS_PAYMENT'), $total, $module->displayName, null, array(), (int)$currency->id, false, $customer->secure_key);
						} else if ($Statut_cmd==Configuration::get('PS_OS_PAYMENT')) {
							$logger->logInfo('> La commande est déja authorisé (AUTHORIZED)');
							http_response_code(200);
						} else {
							$logger->logInfo('> La commande ne peut pas être authorisé (AUTHORIZED)');
							http_response_code(400);
							exit;
						}
							
					} else if($TRANSACTION_STATE=="REFUNDED"){

						// Paiement remboursé
						$logger->logInfo('--> PAYMENT REFUNDED');
						$ID_ORDER = Db::getInstance()->getValue('SELECT id_order FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
						$logger->logInfo('> ID_ORDER : '.json_encode($ID_ORDER) );

						$Statut_cmd = Db::getInstance()->getValue('SELECT current_state FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
						$logger->logInfo('> STATUT DE LA COMMANDE : '.json_encode($Statut_cmd) );

						if ($Statut_cmd==_PS_OS_REFUND_) {
							$logger->logInfo('> La commande est déja remboursé (REFUNDED)');
							http_response_code(200);
						} else if ( $Statut_cmd == _PS_OS_CANCELED_ ){
							$logger->logInfo('> La commande ne peut pas être remboursé (REFUNDED)');
							http_response_code(400);
							exit;
						} else if ($Statut_cmd==Configuration::get('PS_OS_PAYMENT')){
							// Rembourssé la comand
							$sql =  'UPDATE '._DB_PREFIX_.'orders SET current_state='._PS_OS_REFUND_.' WHERE id_order='.$ID_ORDER ; /* on change le statut de la commande */
							$res = Db::getInstance()->Execute($sql);
							if ($res) {
								$logger->logInfo('> UPDATE SUCCESS');
							} else {$logger->logInfo('> UPDATE NOT SUCCESS'); }
						}

					} else if($TRANSACTION_STATE=="REVERSED"){
						
						// Paiement annulé.
						$logger->logInfo('--> PAYMENT REVERSED');
						$ID_ORDER = Db::getInstance()->getValue('SELECT id_order FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
						$logger->logInfo('> ID_ORDER : '.json_encode($ID_ORDER) );

						$Statut_cmd = Db::getInstance()->getValue('SELECT current_state FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
						$logger->logInfo('> STATUT DE LA COMMANDE : '.json_encode($Statut_cmd) );

						if ($Statut_cmd==_PS_OS_CANCELED_) {
							$logger->logInfo('> La commande est déja annulé (REVERSED)');
							http_response_code(200);
						}else if ( $Statut_cmd == _PS_OS_REFUND_ ){
							$logger->logInfo('> La commande ne peut pas être annulé (REVERSED)');
							http_response_code(400);
							exit;
						} else if ($Statut_cmd==Configuration::get('PS_OS_PAYMENT')){
							$sql =  'UPDATE '._DB_PREFIX_.'orders SET current_state='._PS_OS_CANCELED_.' WHERE id_order='.$ID_ORDER ; /* on change le statut de la commande */
							$res = Db::getInstance()->Execute($sql);
							if ($res) {
								$logger->logInfo('> UPDATE SUCCESS');
							}else {$logger->logInfo('> UPDATE NOT SUCCESS'); }
						}
						
					
					} else if($TRANSACTION_STATE=="CAPTURED"){
						
						//  MAJ avec Paiement capturé.
						$logger->logInfo('--> PAYMENT CAPTURED');
						$ID_ORDER = Db::getInstance()->getValue('SELECT id_order FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
						$logger->logInfo('> ID_ORDER : '.json_encode($ID_ORDER) );
						
						$Statut_cmd = Db::getInstance()->getValue('SELECT current_state FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
						$logger->logInfo('> STATUT DE LA COMMANDE : '.json_encode($Statut_cmd) );
						if ($ID_ORDER!="") {
							
							$logger->logInfo('> ORDER_ID diferent de null : ');

							if ( $Statut_cmd == _PS_OS_PAYMENT_ ){
								$logger->logInfo('> La commande est déja capturé (CAPTURED)');
								http_response_code(200);
							} else if( $Statut_cmd != _PS_OS_PAYMENT_ || $Statut_cmd != _PS_OS_CANCELED_ || $Statut_cmd != _PS_OS_REFUND_ ) {
								$logger->logInfo('> La commande ne peut pas être capturé (CAPTURED)');
								http_response_code(400);
								exit;
							}

						}else {

							$logger->logInfo('> ORDER_ID = null : ');

							if ( $Statut_cmd == _PS_OS_PAYMENT_ ){
								$logger->logInfo('> La commande est déja capturé (CAPTURED)');
								http_response_code(200);
							} else {
								$module->validateOrder((int)$cart->id, Configuration::get('PS_OS_PAYMENT'), $total, $module->displayName, null, array(), (int)$currency->id, false, $customer->secure_key);
								$logger->logInfo('> CREATE CMD EN STATUT CAPTURED');
							}

						}

						/*  $sql =  'UPDATE '._DB_PREFIX_.'orders SET current_state='.Configuration::get('PS_OS_PayBy_CAPTURED').' WHERE id_order='.$ID_ORDER ; /* on change le statut de la commande 
							$res = Db::getInstance()->Execute($sql);
							if ($res) {
								$logger->logInfo('UPDATE SUCCESS');
							}else {$logger->logInfo('UPDATE NOT SUCCESS'); }*/

					} // End Captured

				} else {

					if($TRANSACTION_STATE=="EXPIRED"){
						//  MAJ Paiement abondonné
						$logger->logInfo('--> PAYMENT EXPIRED');
					}else{
						//  MAJ Paiement refusé.
						$logger->logInfo('--> PAYMENT REFUSE');
					}

				} // End of $RESPONSE_CODE!=0 

				// Vérifier le statut de la command 
				$COMMAND = Db::getInstance()->getRow('SELECT * FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
				$logger->logInfo("> COMMAND :".json_encode($COMMAND) );

				if(!$COMMAND) { // COMMAND NOT CREATED

					if ($TRANSACTION_STATE != "AUTHORIZED" and $TRANSACTION_STATE != "CAPTURED") {
						$logger->logInfo("**** THE TRANSACTION IS NOT ALREADY CREATED WITH ORDER_ID = " . $ORDER_ID . ""); 
					}

				} else {
					$status=2;
					$logger->logInfo('> TRANSACTION_STATE: '.$TRANSACTION_STATE);
					if ( $TRANSACTION_STATE == "CAPTURED") {
						$status = Configuration::get('PS_OS_PayBy_CAPTURED');
					} else  if ( $TRANSACTION_STATE == "EXPIRED") {
						$status = Configuration::get('PS_OS_PayBy_EXPIRED');
					} else  if ( $TRANSACTION_STATE == "REVERSED") {
						$status = Configuration::get('PS_OS_PayBy_REVERSED');
					} else  if ( $TRANSACTION_STATE == "REFUNDED") {
						$status = Configuration::get('PS_OS_PayBy_REFUNDED');
					} else  if ( $TRANSACTION_STATE == "AUTHORIZED") {
						$status = Configuration::get('PS_OS_PayBy_AUTHORIZED');
					}
						
						  $sql =  'UPDATE '._DB_PREFIX_.'orders SET current_state='.$status.' WHERE id_order='.$COMMAND['id_order'] ; // on change le statut de la commande 
							$res = Db::getInstance()->Execute($sql);
							$logger->logInfo('> COMMAND_id: '.$COMMAND['id_order']);
							$logger->logInfo('> ID_ORDER: '.$ID_ORDER);
							$logger->logInfo('> sql: '.$sql);
							$logger->logInfo('> res: '.$res);
							if ($res) {
								$logger->logInfo('UPDATE SUCCESS');
							}else {$logger->logInfo('UPDATE NOT SUCCESS'); }
				}

			} // End of check Signature

			$ReferenceCmd = Db::getInstance()->getValue('SELECT reference FROM '._DB_PREFIX_.'orders  WHERE id_cart='.$cart->id);
			$logger->logInfo('> REFERENCE DE LA COMMANDE : '.json_encode($ReferenceCmd) );

			/* Contruire la variable de retour */
			
			$retour = array(
				'PayBy_MESSAGE_VERSION' => '4',
				'MERCHANT_ID'          => strtoupper($MERCHANT_ID),
				'ORDER_ID'             => ($ORDER_ID),
				'REFERENCE_ID'         => ($REFERENCE_ID),
				'REFERENCE_EXTERNE'             => ($REFERENCE_EXTERNE),
				'MESSAGE_SIGNATURE'    => ($MESSAGE_SIGNATURE)
			);

			$logger->logInfo('> $retour : '.json_encode($retour));

			$logger->logInfo('|-------------------------------- End POST BACK URL From PayBy : '.$ORDER_ID.' with status : '.$TRANSACTION_STATE.' ---------------------------------|');

			/* Envoyer un retour formaté JSON */
			echo json_encode($retour);
			die;
			
		} else { 
		
			$logger->logInfo('get parameter for GET ');
			$logger->logInfo('{"PayBy_MESSAGE_VERSION":null,"MERCHANT_ID":null,"ORDER_ID":null,"REFERENCE_ID":null, "REFERENCE_EXTERNE":null} ');
			die;
			
		} // End Verifie if receive data.
	}
}	  
 ?>