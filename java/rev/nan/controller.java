package rev.nan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
	@RequestMapping("/display")
	public ModelAndView getpage() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("wlcm");
		return mav;
	}

}
