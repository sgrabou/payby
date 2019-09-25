package ma.payby.common.service.mapper;


import ma.payby.common.dto.UserDTO;
import ma.payby.common.jpa.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserMapper.class)
public class UserMapperUTest {
    User user;
    UserDTO userDTO;

    @BeforeEach
    public void setUp (){
        user = new User();
        user.setId(1L);
        user.setName("sam");
        user.setPassword("samy");
        String[] roles = {"admin", "user"};

        user.setRoles(roles);




        userDTO = new UserDTO();
        userDTO.setId(6L);
        userDTO.setName("samir");
        userDTO.setPassword("sam");
        String[] eroles = {"admin", "user"};
        userDTO.setRoles(roles);





    }

    @Test
    public void usertoUserDTO (){
        UserDTO userDTO = UserMapper.toUserDTO(user);
        Assertions.assertEquals(new Long(1),user.getId());
        Assertions.assertEquals("sam",user.getName());
        Assertions.assertEquals("samy",user.getPassword());
        Assertions.assertEquals(user.getRoles(),userDTO.getRoles());

    }
    @Test
    public void userDTOToUser(){
        User user = UserMapper.toUser(userDTO);
        Assertions.assertEquals(new Long(6),userDTO.getId());
        Assertions.assertEquals("samir",userDTO.getName());
        Assertions.assertEquals("sam",userDTO.getPassword());
        Assertions.assertEquals(userDTO.getRoles(),user.getRoles());

    }
}
