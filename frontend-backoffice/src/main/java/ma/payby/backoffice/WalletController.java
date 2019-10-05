package ma.payby.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WalletController {
	@RequestMapping(value = "/wallet")
	public ModelAndView wallet() {
		ModelAndView mav = new ModelAndView("wallet");
		mav.addObject("myvar");
		return mav;
	}

}