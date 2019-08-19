package ma.payby.frontend.backoffice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Tester {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        System.out.print(PASSWORD_ENCODER.encode("admin"));
    }
}
