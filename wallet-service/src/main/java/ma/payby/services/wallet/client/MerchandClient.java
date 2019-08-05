package ma.payby.services.wallet.client;

import ma.payby.common.dto.OrderDTO;
import ma.payby.common.dto.OrderEditStatusRequestDTO;
import ma.payby.common.exception.BusinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "merchand-service")
public interface MerchandClient {
    @GetMapping("/api/v1/order/reference/{reference}")
    OrderDTO findOrderByReference(@PathVariable("reference") String reference) throws BusinessException;

    @PostMapping("/api/v1/order/edit/status")
    OrderDTO editOrderStatus(@RequestBody OrderEditStatusRequestDTO orderEditStatusRequestDTO) throws BusinessException;
}
