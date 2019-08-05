package ma.payby.services.admin.controller;

import ma.payby.common.dto.MerchandDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.services.admin.service.AdminMerchandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminMerchandController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminMerchandController.class);
	@Autowired
	AdminMerchandService adminMerchandService;

	@GetMapping("/api/v1/merchand/{name}")
	public ResponseEntity<MerchandDTO> findByName(@PathVariable("name") String name) throws BusinessException {
		LOGGER.info("Merchand find: name={}", name);
		return new ResponseEntity<>(adminMerchandService.getMerchandByName(name), HttpStatus.OK);
	}

	@GetMapping("/api/v1/merchand")
	public ResponseEntity<List<MerchandDTO>> findAll() throws BusinessException {
		LOGGER.info("Merchand find All");
		return new ResponseEntity<>(adminMerchandService.getAllMerchand(), HttpStatus.OK);
	}

	@PostMapping("/api/v1/merchand")
	public ResponseEntity<MerchandDTO> add(@RequestBody MerchandDTO merchandDTO) {
		LOGGER.info("MerchandDTO add: {}", merchandDTO);
		return new ResponseEntity<>(adminMerchandService.addMerchand(merchandDTO), HttpStatus.OK);
	}

	@PostMapping("/api/v1/merchand/edit")
	public ResponseEntity<MerchandDTO> edit(@RequestBody MerchandDTO merchandDTO) throws BusinessException {
		LOGGER.info("MerchandDTO edit: {}", merchandDTO);
		return new ResponseEntity<>(adminMerchandService.editMerchand(merchandDTO), HttpStatus.OK);
	}

}
