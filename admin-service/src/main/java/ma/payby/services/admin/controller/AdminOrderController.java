package ma.payby.services.admin.controller;


import ma.payby.common.dto.OrderDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.services.admin.service.AdminWalletOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminOrderController {


    @Autowired
    AdminWalletOrderService adminWalletOrderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminOrderController.class);

    @GetMapping("/api/v1/order/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") Long id) throws BusinessException {
        LOGGER.info("Order find: id={}", id);
        return new ResponseEntity<>(adminWalletOrderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/api/v1/order/reference/{reference}")
    public ResponseEntity<OrderDTO> findByReference(@PathVariable("reference") String reference) throws BusinessException {
        LOGGER.info("Order find: reference={}", reference);
        return new ResponseEntity<>(adminWalletOrderService.getOrderByReference(reference), HttpStatus.OK);
    }

    @GetMapping("/api/v1/order")
    public ResponseEntity<List<OrderDTO>> findAll() throws BusinessException {
        LOGGER.info("Order find All");
        return new ResponseEntity<>(adminWalletOrderService.getAllOrder(), HttpStatus.OK);
    }



}
