package demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
			log.info("crawling start");
			// TODO
			Document doc = Jsoup.connect("https://github.com/search?o=desc&p=1&q=+image+crop&ref=searchresults&s=updated&type=Repositories&utf8=true").get();
			//log.info("doc : {},", doc.getAllElements().toString());
			Elements eles = doc.select(".repo-list-item");
			
			Elements elePageNum = doc.select(".pagination a");
			log.info("elePageNum Size : {}", elePageNum.size());
			
			log.info("lastPageNum : {}", elePageNum.last().previousElementSibling().text());
			
			for (Element element : eles) {
				Elements aTags = element.select(".repo-list-stats a");
				String star = aTags.get(0).text();
				String fork = aTags.get(1).text();
				String name = element.select(".repo-list-name a").attr("href");
				String description = element.select(".repo-list-description").text();
				String updatedTime = element.select(".repo-list-meta time").text();
				
				log.info("start : {}", Integer.parseInt(star.replaceAll(",", "")));
				log.info("fork : {}", Integer.parseInt(fork.replaceAll(",", "")));	
				log.info("name : {}", name);
				log.info("description : {}", description);
				log.info("updatedTime : {}", updatedTime);
				log.info("=========================\n\n");
			}

			log.info("crawling End");
		} catch (Exception e) {
			log.info("CrawlError : {}", e.getMessage());
			e.printStackTrace();
		}
		return "home";
	}

}