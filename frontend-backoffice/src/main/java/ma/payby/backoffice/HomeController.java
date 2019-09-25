package ma.payby.backoffice;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/home")
	public ModelAndView index() {
		String variable = "hhhhh Othman Samir :D";
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("myvar", variable);
		return mav;
	}

}