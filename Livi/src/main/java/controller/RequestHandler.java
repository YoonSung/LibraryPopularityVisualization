package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import model.GithubRepositoryMetaData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import crawler.GithubCrawler;

@Controller
public class RequestHandler {

	private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

	@RequestMapping("/")
	public String test() {
		return "main";
	}
	
	@RequestMapping("/getJson/{keyword}")
	public @ResponseBody List<GithubRepositoryMetaData> home(@PathVariable String keyword) {
		log.info("keyword : {}", keyword);
		GithubCrawler githubCrawler = new GithubCrawler("image crop");
		
		try {
			return githubCrawler.getMetaDataList();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("/testJson")
	public @ResponseBody String loadTestJson() {
		return getTestJson();
	}
	
	private String getTestJson() {
		try {
			FileReader fr = new FileReader(new File("./src/main/resources/test.json"));
			BufferedReader br = new BufferedReader(fr);
			
			StringBuilder sb = new StringBuilder();
			String readLine = null;
			while ((readLine = br.readLine()) != null) {
				sb.append(readLine);
			}
			br.close();
			fr.close();
			
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		
	}
	
}