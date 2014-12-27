package application.runner;

import java.io.IOException;
import java.util.List;

import model.GithubRepositoryMetaData;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import crawler.GithubCrawler;

@RestController
public class RequestHandler {

	private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

	@RequestMapping("/")
	public List<GithubRepositoryMetaData> home(String keyword) {
		log.info("keyword : {}", keyword);
		
		GithubCrawler githubCrawler = new GithubCrawler("image crop");
		
		try {
			return githubCrawler.getMetaDataList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}