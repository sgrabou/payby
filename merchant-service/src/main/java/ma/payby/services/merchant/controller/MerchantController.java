package ma.payby.services.merchant.controller;


import ma.payby.common.dto.InitierPaymentMerchantRequestDTO;
import ma.payby.common.dto.InitierPaymentMerchantResponseDTO;
import ma.payby.common.dto.OrderDTO;
import ma.payby.common.dto.OrderEditStatusRequestDTO;
import ma.payby.common.enums.OrderStatus;
import ma.payby.common.exception.BusinessException;
import ma.payby.services.merchant.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MerchantController {

    @Autowired
    OrderService orderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(MerchantController.class);

    @GetMapping("/api/v1/order/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("id") Long id) throws BusinessException {
        LOGGER.info("Order find: id={}", id);
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/api/v1/order/reference/{reference}")
    public ResponseEntity<OrderDTO> findByReference(@PathVariable("reference") String reference) throws BusinessException {
        LOGGER.info("Order find: reference={}", reference);
        return new ResponseEntity<>(orderService.getOrderByReference(reference), HttpStatus.OK);
    }

    @GetMapping("/api/v1/order/status/{reference}")
    public ResponseEntity<OrderStatus> findOrderStatusByReference(@PathVariable("reference") String reference) throws BusinessException {
        LOGGER.info("Order find: reference={}", reference);
        return new ResponseEntity<>(orderService.getOrderStatusByReference(reference), HttpStatus.OK);
    }

    @GetMapping("/api/v1/order")
    public ResponseEntity<List<OrderDTO>> findAll() throws BusinessException {
        LOGGER.info("Order find All");
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    @PostMapping("/api/v1/order")
    public ResponseEntity<InitierPaymentMerchantResponseDTO> add(@RequestBody InitierPaymentMerchantRequestDTO initierPaymentMerchantRequestDTO) throws BusinessException{
        LOGGER.info("Order add: {}", initierPaymentMerchantRequestDTO);
        return new ResponseEntity<>(orderService.addOrder(initierPaymentMerchantRequestDTO), HttpStatus.OK);
    }

    @PostMapping("/api/v1/order/edit/status")
    public ResponseEntity<OrderDTO> editStatus(@RequestBody OrderEditStatusRequestDTO orderEditStatusRequestDTO) throws BusinessException{
        LOGGER.info("OrderDTO edit idOrder: {}  Status: {}", orderEditStatusRequestDTO.getId(),orderEditStatusRequestDTO.getOrderStatus());
        return new ResponseEntity<>(orderService.editStatutOrder(orderEditStatusRequestDTO), HttpStatus.OK);
    }
}
