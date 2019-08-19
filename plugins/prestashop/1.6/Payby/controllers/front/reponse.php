<?php

require_once dirname(dirname(dirname(__FILE__))) . '/PayBy.php';
require_once dirname(dirname(dirname(__FILE__))) . '/package_PayBy/pbw_Function.php'; 
require_once dirname(dirname(dirname(dirname(dirname(__FILE__))))) . '/classes/PaymentModule.php';

class PayByReponseModuleFrontController extends ModuleFrontController
{
    function PostProcess() {
	
		$logger = new FileLogger(); //0 == debug level, logInfo() won’t work without this.
		$logger->setFilename(_PS_ROOT_DIR_.'/modules/PayBy/log/ReceiveData_'.date("Y-m-d").'.log');
		// Si il y'a un retour marchand
        if( !empty($_GET["ORDER_ID"]) && !empty($_GET["REFERENCE_ID"])){
			$logger->logInfo('|-------------------------------- Begin Back to Merchant Page : '.$_GET['ORDER_ID'].' ---------------------------------|');

            $ORDER_ID      = $_GET['ORDER_ID'];
            $REFERENCE_ID  = $_GET['REFERENCE_ID'];
            $REFERENCE_EXTERNE      = $_GET['REFERENCE_EXTERNE'];
            $RESPONSE_CODE = $_GET['RESPONSE_CODE'];

			$logger->logInfo("> _GET :".json_encode($_GET) );

            $cart_id     = $ORDER_ID;
            $cart        = new Cart((int)$cart_id);
            $order_total = number_format($cart->getOrderTotal(true, Cart::BOTH), 2, '.', ' ');

            $this->context->smarty->assign(array(
                'REFERENCE_ID'  =>  $REFERENCE_ID, 
                'REFERENCE_EXTERNE'      =>  $REFERENCE_EXTERNE, 
                'ORDER_ID'      =>  $ORDER_ID,
                'order_total'   =>  $order_total
            ));

            if($RESPONSE_CODE==0){

                $logger->logInfo('> Redirection to success page');
                $this->setTemplate('result_success.tpl');

            } else if ($RESPONSE_CODE==1028){

                $logger->logInfo('> Redirection to abandoned page');
                $this->setTemplate('result_abandoned.tpl');

            } else{
               
                $logger->logInfo('> Redirection to declined page');
                $this->setTemplate('result_declined.tpl');

			}
			
			$logger->logInfo('|-------------------------------- End Back to Merchant Page : '.$_GET['ORDER_ID'].' ---------------------------------|');

		} else {

			$fctPayBy = new PayByPack();
			$fctPayBy->receiveData($logger, $this->module);

		} // End si la demande est POST BACK URL From PayBy
        
    } // ENd of function PostProcess()

    public function signData($dat, $SECR) {

        return hash_hmac('sha256', $dat, $SECR, true);

    }

} // END Class

