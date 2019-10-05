package ma.payby.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MerchantController {
	@RequestMapping(value = "/merchant")
	public ModelAndView merchant() {
		ModelAndView mav = new ModelAndView("merchant");
		mav.addObject("myvar");
		return mav;
	}

}