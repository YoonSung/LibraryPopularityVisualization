package demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestHandler {
	
	@RequestMapping("/")
	public @ResponseBody String home() {
		return "home";
	}
	
}