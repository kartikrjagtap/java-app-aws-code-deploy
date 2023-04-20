package com.regioncheck;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	@GetMapping(value = "/checkRegion")
	// public ResponseData getProduct() throws URISyntaxException {
	public String getProduct() throws URISyntaxException {
		String activeRegion = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Bearer " + "token");
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "https://gorest.co.in/public/v1/posts";
		URI uri = new URI(baseUrl);
		ResponseEntity<ResponseData> result = restTemplate.exchange(uri, HttpMethod.GET, entity, ResponseData.class);
		System.out.println(result.getBody());
		for (Data d : result.getBody().getData()) {
			if (d.getStatus().equals("ONLINE")) {
				activeRegion = d.getRegion();
				break;
			}
		}
		return activeRegion;
	}
}
