/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ma.payby.backoffice.config;

import ma.payby.backoffice.client.UserClient;
import ma.payby.common.dto.UserDTO;
import ma.payby.common.exception.BusinessException;
import ma.payby.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Component
public class AdminUserDetailsService implements UserDetailsService {

	@Autowired
	UserClient userClient;

	@Override
	public UserDetails loadUserByUsername(String name)
			throws UsernameNotFoundException{
		UserDTO userDTO = new UserDTO();
		try {
			userDTO = userClient.findByName(name);
		} catch (BusinessException e) {
			throw new UsernameNotFoundException(CommonUtils.ERROR_BUSINESS.get("A00001"));
		}

		return new User(userDTO.getName(), userDTO.getPassword(),
				AuthorityUtils.createAuthorityList(userDTO.getRoles()));
	}

}
// end::code[]
