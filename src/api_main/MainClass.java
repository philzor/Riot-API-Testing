package api_main;
import java.io.BufferedReader;
import java.io.FileReader;

import api_categories.SummonerAPI;
import api_pojo.SummonerByName;


public class MainClass {
	
	public static void main(String[] args) throws Exception {
		
		String apiFile = "F:\\workspace\\apikey.txt";
		String apiKey = null;
		@SuppressWarnings("resource")
		// read API Key from first line of local textfile (temporary solution)
		BufferedReader br = new BufferedReader(new FileReader(apiFile));
		apiKey = br.readLine();
		br.close();
		
		String protocol = "https://";
		String baseURL = "prod.api.pvp.net/api/lol/{staticData}/{region}/{apiVersion}/{category}";
		String urlSuffix = "?api_key="+apiKey;
		String staticData = "";
		String region = "euw";
		String apiVersion = "1.3";

		SummonerAPI summAPI = new SummonerAPI(staticData, region, apiVersion);		
		SummonerByName newSumm = summAPI.getSummonerByName(protocol, baseURL, urlSuffix, "g00fy2");
		System.out.println(newSumm.name);
	}



}