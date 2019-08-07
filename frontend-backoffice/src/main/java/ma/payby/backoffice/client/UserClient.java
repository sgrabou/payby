package ma.payby.backoffice.client;

import ma.payby.common.dto.UserDTO;
import ma.payby.common.exception.BusinessException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "admin-service")
public interface UserClient {
    @GetMapping("/api/v1/user/{name}")
    UserDTO findByName(@PathVariable("name") String name) throws BusinessException;

}
