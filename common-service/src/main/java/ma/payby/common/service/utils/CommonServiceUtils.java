package ma.payby.common.service.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CommonServiceUtils {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

}
