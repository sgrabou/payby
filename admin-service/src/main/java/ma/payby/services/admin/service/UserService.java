package ma.payby.services.admin.service;

import ma.payby.common.dto.UserDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.jpa.model.User;
import ma.payby.common.jpa.repository.UserRepository;
import ma.payby.common.service.mapper.UserMapper;
import ma.payby.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserByName(String name) throws BusinessException {
        User user = userRepository.findByName(name);
        if(user == null)
            throw new BusinessException("M00001", CommonUtils.ERROR_BUSINESS.get("M00001"));

        return UserMapper.toUserDTO(user);
    }

    public List<UserDTO> getAllUser() throws BusinessException {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = users.stream()
                .map(e -> UserMapper.toUserDTO(e)).collect(Collectors.toList());
        return userDTOList;
    }

    public UserDTO addUser(UserDTO userDTO){
        User savedUser = userRepository.save(UserMapper.toUser(userDTO));
        return UserMapper.toUserDTO(savedUser);
    }

    public UserDTO editUser(UserDTO userDTO) throws BusinessException{
        User user = userRepository.findByName(userDTO.getName());
        if(user ==null)
            throw new BusinessException("M00001", CommonUtils.ERROR_BUSINESS.get("M00001"));
        User savedUser = userRepository.save(UserMapper.toUser(userDTO));
        return UserMapper.toUserDTO(savedUser);
    }
}
