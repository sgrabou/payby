package ma.payby.backoffice;

import ma.payby.common.dto.ConfirmPaymentMerchantRequestDTO;
import ma.payby.common.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BackOfficeUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BackOfficeUserDetailsService.class);

    @Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(name, headers);
        LOGGER.info("Call Api User username: " +name);
        ResponseEntity<UserDTO> response = restTemplate.exchange(
                "http://localhost:8060/admin/api/v1/user/admin", HttpMethod.GET, request, UserDTO.class);
        UserDTO user = response.getBody();
		return new User(user.getName(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRoles()));
	}

}
