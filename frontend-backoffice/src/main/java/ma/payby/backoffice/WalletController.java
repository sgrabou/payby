package ma.payby.backoffice;

import ma.payby.common.dto.WalletDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class WalletController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WalletController.class);

	@RequestMapping(value = "/wallet")
	public ModelAndView wallet(Model model,
							 @Valid @ModelAttribute("walletForm") WalletDTO walletForm,
							 BindingResult bindingResult,
							 RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("wallet");
		mav.addObject("myvar");
		return mav;
	}
	@RequestMapping(value = "/wallet/actions/add", method = RequestMethod.POST)
	public String saveForm(Model model,
						   @RequestParam("additionalParam") Integer additionalParam,
						   @Valid @ModelAttribute("walletForm") WalletDTO walletForm,
						   BindingResult bindingResult,
						   RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("hasError", true);
			return "your/template :: yourFragment";
		}

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<WalletDTO> request = new HttpEntity<>(walletForm, headers);
		LOGGER.info("Call Api Wallet wallet: " +walletForm.getWalletName());
		ResponseEntity<Object> response = restTemplate.exchange(
				"http://localhost:8060/admin/api/v1/wallet", HttpMethod.POST, request, Object.class);
		additionalParam = 1;
		redirectAttributes.addAttribute("additionalParam", additionalParam);
		return "redirect:/wallet";

	}
	@RequestMapping(value = "logo/{logo}")
	@ResponseBody
	public byte[] getImage(@PathVariable(value = "logo") String logo) throws IOException {

		File serverFile = new File("/home/user/uploads/" + logo + ".jpg");

		return Files.readAllBytes(serverFile.toPath());
	}

}