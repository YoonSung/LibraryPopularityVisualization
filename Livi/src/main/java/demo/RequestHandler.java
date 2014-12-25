package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestHandler {
	
	private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);
	
	@RequestMapping("/")
	public @ResponseBody String home() {
		
		log.info("homeRequest");
		try {
			new BasicCrawlController("/Users/yoon/Desktop", 1);
		} catch (Exception e) {
			log.info("CrawlError : {}", e.getMessage());
			e.printStackTrace();
		}
		return "home";
	}
	
}