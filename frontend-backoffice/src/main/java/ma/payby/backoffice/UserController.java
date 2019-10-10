package ma.payby.backoffice;

import ma.payby.common.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/user")
	public ModelAndView user(Model model,
							 @Valid @ModelAttribute("userForm") UserDTO userForm,
							 BindingResult bindingResult,
							 RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("user");
		mav.addObject("myvar");
		return mav;
	}
	@RequestMapping(value = "/user/actions/add", method = RequestMethod.POST)
	public String saveForm(Model model,
						   @RequestParam("additionalParam") Integer additionalParam,
						   @Valid @ModelAttribute("userForm") UserDTO userForm,
						   BindingResult bindingResult,
						   RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("hasError", true);
			return "your/template :: yourFragment";
		}

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<UserDTO> request = new HttpEntity<>(userForm, headers);
		LOGGER.info("Call Api User username: " +userForm.getName());
		ResponseEntity<Object> response = restTemplate.exchange(
				"http://localhost:8060/admin/api/v1/user", HttpMethod.POST, request, Object.class);
		additionalParam = 1;
		redirectAttributes.addAttribute("additionalParam", additionalParam);
		return "redirect:/user";

	}
}