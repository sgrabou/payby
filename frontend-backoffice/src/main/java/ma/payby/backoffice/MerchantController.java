package ma.payby.backoffice;

import ma.payby.common.dto.MerchantDTO;
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
public class MerchantController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MerchantController.class);
	@RequestMapping(value = "/merchant")
	public ModelAndView merchant(Model model,
								 @Valid @ModelAttribute("merchantForm") MerchantDTO merchantForm,
								 BindingResult bindingResult,
								 RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("merchant");
		mav.addObject("myvar");
		return mav;
	}
	@RequestMapping(value = "/merchant/actions/add", method = RequestMethod.POST)
	public String saveForm(Model model,
						   @RequestParam("additionalParam") Integer additionalParam,
						   @Valid @ModelAttribute("merchantForm") MerchantDTO merchantForm,
						   BindingResult bindingResult,
						   RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("hasError", true);
			return "your/template :: yourFragment";
		}

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<MerchantDTO> request = new HttpEntity<>(merchantForm, headers);
		LOGGER.info("Call Api Merchant merchant: " +merchantForm.getUserName());
		ResponseEntity<Object> response = restTemplate.exchange(
				"http://localhost:8060/admin/api/v1/merchant", HttpMethod.POST, request, Object.class);
		additionalParam = 1;
		redirectAttributes.addAttribute("additionalParam", additionalParam);
		return "redirect:/merchant";

	}

}