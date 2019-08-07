package ma.payby.common.service.mapper;

import ma.payby.common.dto.UserDTO;
import ma.payby.common.jpa.model.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    public static UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public static User toUser(UserDTO userDTO){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
