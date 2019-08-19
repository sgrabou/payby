package ma.payby.frontend.backoffice.controller;

import ma.payby.common.dto.UserDTO;
import ma.payby.frontend.backoffice.client.UserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserClient userClient;
    @GetMapping("/api/v1/user")
    public ResponseEntity<List<UserDTO>> findAll() {
        LOGGER.info("Order find All");
        return new ResponseEntity<List<UserDTO>>(userClient.findAllUser(), HttpStatus.OK);
    }
}
