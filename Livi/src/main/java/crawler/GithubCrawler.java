package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.Constant;
import model.GithubRepositoryMetaData;

public class GithubCrawler {

	private String keyword;
	
	private static final Logger log = LoggerFactory.getLogger(GithubCrawler.class);

	public GithubCrawler(String keyword) {
		this.keyword = keyword;
	}

	public List<GithubRepositoryMetaData> getMetaDataList() throws IOException {

		long startTime = System.currentTimeMillis();
		log.info("Github Crawling Start");
		
		
		Document doc = Jsoup.connect(getUrl(1)).timeout(0).get();
		Elements elePageNum = doc.select(Constant.SELECTOR_GITHUB_PAGENUMBER_LIST);
		int lastPageNum = Integer.parseInt(elePageNum.last().previousElementSibling().text());
		
		List<GithubRepositoryMetaData> metaDataList = new ArrayList<GithubRepositoryMetaData>();
		for (int index = 1; index <= lastPageNum; index++) {
			
			if (index == Constant.GITHUB_MAX_CRAWLING_PAGE_NUM)
				break;
			/*
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
			List<GithubRepositoryMetaData> pageList = getMetaDataListFromPage(index);
			metaDataList.addAll(pageList);
		}
		
		long endTime = System.currentTimeMillis();
		log.info("Github Crawling End, Time : {}", (endTime - startTime));
		
		return metaDataList;
	}

	protected List<GithubRepositoryMetaData> getMetaDataListFromPage(int pageNumber) throws IOException {
		
		Document doc = Jsoup.connect(getUrl(pageNumber)).timeout(0).ignoreHttpErrors(true).get();
		//Document doc = Jsoup.connect(getUrl(pageNumber)).timeout(0).get();
		// log.info("doc : {},", doc.getAllElements().toString());
		
		Elements eles = doc.select(Constant.SELECTOR_GITHUB_REPOSITORY_LIST);

		List<GithubRepositoryMetaData> pageList = new ArrayList<GithubRepositoryMetaData>();
		
		for (Element element : eles) {
			Elements aTags = element.select(Constant.SELECTOR_GITHUB_ATAG_FROM_REPOSITORY_ELEMENT);
			String star = aTags.get(0).text();
			String fork = aTags.get(1).text();
			String subURL = element.select(Constant.SELECTOR_GITHUB_URL_FROM_REPOSITORY_ELEMENT).attr("href");
			String description = element.select(Constant.SELECTOR_GITHUB_DESCRIPTION_FROM_REPOSITORY_ELEMENT).text();
			String lastUpdatedTime = element.select(Constant.SELECTOR_GITHUB_TIME_FROM_REPOSITORY_ELEMENT).text();

			pageList.add(new GithubRepositoryMetaData(subURL, description, star, fork, lastUpdatedTime));
		}
		
		return pageList;
	}

	private String getUrl(int pageNumber) {
		return Constant.GITHUB_URL+"/search?o=desc&p="
				+ pageNumber
				+ "&q="+keyword.replaceAll(" ", "+")
				+ "&ref=searchresults&s=updated&type=Repositories&utf8=true";
	}
}
