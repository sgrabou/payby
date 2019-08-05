package ma.payby.services.wallet.controller;

import feign.FeignException;
import ma.payby.common.dto.*;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.utils.ApiError;
import ma.payby.common.utils.CommonUtils;
import ma.payby.services.wallet.service.WalletOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WalletController {

	@Autowired
	WalletOrderService walletOrderService;
	private static final Logger LOGGER = LoggerFactory.getLogger(WalletController.class);

	@GetMapping("/api/v1/order/{reference}")
	public ResponseEntity<OrderWalletResponseDTO> findByReference(@PathVariable("reference") String reference) throws BusinessException {
		LOGGER.info("Order find: reference = {}", reference);
		return new ResponseEntity<>(walletOrderService.getOrderForPayment(reference),HttpStatus.OK);
	}

	@PostMapping("/api/v1/order/confirm")
	public ResponseEntity<PaiementDTO>  confirmPayment(@RequestBody ConfirmPaymentWalletRequestDTO confirmPaymentWalletRequestDTO) throws BusinessException {
		LOGGER.info("Confirm Payment orderReference: reference = {}", confirmPaymentWalletRequestDTO.getRefernece());
		return new ResponseEntity<>(walletOrderService.confirmPayment(confirmPaymentWalletRequestDTO),HttpStatus.OK);
	}


	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ApiError> handleBusinessException(
			BusinessException ex) {
		ApiError apiError = new ApiError();
		apiError.setCode(ex.getCode());
		apiError.setMessage(ex.getMessage());
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FeignException.class)
	protected ResponseEntity<ApiError> handleBusinessException(
			FeignException ex) {
		ApiError apiError = new ApiError();
		apiError.setCode("M00002");
		apiError.setMessage(CommonUtils.ERROR_BUSINESS.get("M00002"));
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}
/*
	@PostMapping("/")
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department add: {}", department);
		return repository.add(department);
	}


	@GetMapping("/")
	public List<Department> findAll() {
		LOGGER.info("Department find");
		return repository.findAll();
	}
	
	@GetMapping("/wallet/{organizationId}")
	public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		return repository.findByOrganization(organizationId);
	}
	
	@GetMapping("/wallet/{organizationId}/with-employees")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
		LOGGER.info("Department find: organizationId={}", organizationId);
		List<Department> departments = repository.findByOrganization(organizationId);
		departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
		return departments;
	}
	*/
}
