package com.handbookparser.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;

public class LinkParser {
	
	public static String parseLink(String url) throws IOException{
        Document document = Jsoup.connect(url).get();
                
		Elements programmingStack = document.select("#readme > article > table:nth-child(2) > tbody");
        Elements buildStack = document.select("#readme > article > table:nth-child(4) > tbody");
        Elements infrastructure = document.select("#readme > article > table:nth-child(6) > tbody");
        
        JSONObject json = new JSONObject();
        
        JSONArray programmingStackJsonArray = new JSONArray();
        programmingStack.select("tr").forEach(element-> {
        	Elements elements = element.select("td");
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put(elements.get(0).text(), elements.get(1).text());
        	programmingStackJsonArray.add(jsonObject);
        });
        
        json.put("Programming Stack", programmingStackJsonArray);
        
        JSONArray buildStackJsonArray = new JSONArray();
        buildStack.select("tr").forEach(element-> {
        	Elements elements = element.select("td");
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put(elements.get(0).text(), elements.get(1).text());
        	buildStackJsonArray.add(jsonObject);
        });
        
        json.put("Build Stack", buildStackJsonArray);
        
        JSONArray infrastructureJsonArray = new JSONArray();
        infrastructure.select("tr").forEach(element-> {
        	Elements elements = element.select("td");
        	JSONObject jsonObject = new JSONObject();
        	jsonObject.put(elements.get(0).text(), elements.get(1).text());
        	infrastructureJsonArray.add(jsonObject);
        });
        
        json.put("Infrastructure", infrastructureJsonArray);
        
        return json.toJSONString();
	}
}