package ma.payby.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping(value = "/user")
	public ModelAndView user() {
		ModelAndView mav = new ModelAndView("user");
		mav.addObject("myvar");
		return mav;
	}

}