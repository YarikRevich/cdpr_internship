package com.gamestore.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.apache.http.client.utils.URIBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdminControllerTests {
    @Value(value="${local.server.port}")
	private int port;

    @Autowired
	private TestRestTemplate restTemplate;

    @Test
	public void greetingShouldReturnDefaultMessage() throws Exception {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost("localhost");
        builder.setPort(port);
        builder.setPath("/foldername/1234");
        builder.addParameter("abc", "xyz");
        String url = builder.build().toString();

		assertThat(this.restTemplate.getForObject(url,
				String.class)).contains("Hello, World");
	}
}
