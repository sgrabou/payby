package ma.payby.services.admin.controller;

import ma.payby.common.dto.MerchantDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.services.admin.service.AdminMerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminMerchantController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminMerchantController.class);
	@Autowired
	AdminMerchantService adminMerchantService;

	@GetMapping("/api/v1/merchant/{name}")
	public ResponseEntity<MerchantDTO> findByName(@PathVariable("name") String name) throws BusinessException {
		LOGGER.info("Merchant find: name={}", name);
		return new ResponseEntity<>(adminMerchantService.getMerchantByName(name), HttpStatus.OK);
	}

	@GetMapping("/api/v1/merchant")
	public ResponseEntity<List<MerchantDTO>> findAll() throws BusinessException {
		LOGGER.info("Merchant find All");
		return new ResponseEntity<>(adminMerchantService.getAllMerchant(), HttpStatus.OK);
	}

	@PostMapping("/api/v1/merchant")
	public ResponseEntity<MerchantDTO> add(@RequestBody MerchantDTO merchantDTO) {
		LOGGER.info("MerchantDTO add: {}", merchantDTO);
		return new ResponseEntity<>(adminMerchantService.addMerchant(merchantDTO), HttpStatus.OK);
	}

	@PostMapping("/api/v1/merchant/edit")
	public ResponseEntity<MerchantDTO> edit(@RequestBody MerchantDTO merchantDTO) throws BusinessException {
		LOGGER.info("MerchantDTO edit: {}", merchantDTO);
		return new ResponseEntity<>(adminMerchantService.editMerchant(merchantDTO), HttpStatus.OK);
	}

}
