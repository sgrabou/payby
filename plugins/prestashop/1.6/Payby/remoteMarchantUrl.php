<?php
include(dirname(__FILE__). '/../../config/config.inc.php');
include(_PS_ROOT_DIR_.'/init.php');
include(dirname(__FILE__).'/PayBy.php');

$OBJ_PayBy = new PayBy();
$SECRETKEY = $OBJ_PayBy->MERCHANT_KEY;

header('Content-type: application/json');
header('Cache-Control: no-cache, must-revalidate');
define ('HMAC_SHA256', 'sha256');
$RESPONSE="ACKNOWLEDGE=OK";

function signData($data, $SECRETKEY) {
   return hash_hmac('sha256', $data, $SECRETKEY, true);
} // End signData()
function addLog($txt) {
    if (!file_exists("log.txt")) file_put_contents("log.txt", "");
    file_put_contents("log.txt",date("[j/m/y H:i:s]")." - $txt \r\n".file_get_contents("log.txt"));
} // End function addLog()

// Lire la variable d'entrée
$buff = file_get_contents("php://input");

// Extraire le contenu JSON dans un vecteur
$data = json_decode($buff, true);      
$SIGNATURE=$data[SIGNATURE];
$PayBy_MERCHANT_URL=$data[PayBy_MERCHANT_URL];

// Construire la trame à signer
$dt=$PayBy_MERCHANT_URL;

// calcul et signature de la trame avec la clé secrete
$digest = signData($dt,$SECRETKEY);
$hexdigest = bin2hex($digest);

addLog("SIGNATURE =".$SIGNATURE);
addLog("PayBy_MERCHANT_URL =".$PayBy_MERCHANT_URL);
addLog("signature brute =".$dt);
addLog("Received signature  =".strtoupper($SIGNATURE));
addLog("Calculated signature =".strtoupper($hexdigest));

// Vérification du Hash
if(strtoupper($hexdigest)==strtoupper($SIGNATURE)) {
	$ACK_CHANGEMENT=true;;

	//changement de l'URL
	Configuration::updateValue('PayBy_MERCHANT_URL', $PayBy_MERCHANT_URL);
	addLog( $this->l('Update URL KO') );
} else {
	$ACK_CHANGEMENT=false;
	addLog( $this->l('Different signature: Update URL KO') );
}

// Contruire la variable de retour
$retour = array(
    'ACK_CHANGEMENT'=>($ACK_CHANGEMENT)
);

// Envoyer un retour formaté JSON
echo json_encode($retour);

?>