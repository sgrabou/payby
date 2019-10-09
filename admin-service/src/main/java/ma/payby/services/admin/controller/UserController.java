package ma.payby.services.admin.controller;

import ma.payby.common.dto.UserDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.services.admin.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping("/api/v1/user/{name}")
    public ResponseEntity<UserDTO> findByName(@PathVariable("name") String name) throws BusinessException {
        LOGGER.info("User find: name={}", name);
        return new ResponseEntity<>(userService.getUserByName(name), HttpStatus.OK);
    }

    @GetMapping("/api/v1/user")
    public ResponseEntity<List<UserDTO>> findAll() throws BusinessException {
        LOGGER.info("User find All");
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @PostMapping(value ="/api/v1/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserDTO> add(@RequestBody UserDTO userDTO) {
        LOGGER.info("UserDTO add: {}", userDTO);
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/user/edit")
    public ResponseEntity<UserDTO> edit(@RequestBody UserDTO userDTO) throws BusinessException {
        LOGGER.info("UserDTO edit: {}", userDTO);
        return new ResponseEntity<>(userService.editUser(userDTO), HttpStatus.OK);
    }
}
