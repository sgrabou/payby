package ma.payby.services.admin.client;

import ma.payby.common.dto.OrderDTO;
import ma.payby.common.exception.BusinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "merchand-service")
public interface AdminMerchandClient {
    @GetMapping("/api/v1/order/{id}")
    OrderDTO findById(@PathVariable("id") Long reference) throws BusinessException;

    @GetMapping("/api/v1/order/reference/{reference}")
    OrderDTO findByReference(@PathVariable("reference") String reference) throws BusinessException;

    @GetMapping("/api/v1/order")
    List<OrderDTO> findAll() throws BusinessException;


}
