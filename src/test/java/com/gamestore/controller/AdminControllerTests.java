package com.gamestore.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;

import org.apache.http.client.utils.URIBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql({ "data.sql" })
public class AdminControllerTests {
    @Value(value="${local.server.port}")
	private int port;

    @Autowired
	private TestRestTemplate restTemplate;

    @Test
	public void getGamesShouldWork() throws Exception {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http");
        builder.setHost("localhost");
        builder.setPort(port);
        builder.setPath("/v1/games");
        // builder.addParameter("abc", "xyz");
        String url = builder.build().toString();

		// assertThat(this.restTemplate.getForObject(url,
		// 		GamesRetrievalResponseDTO.class)).contains("{}");
	}
}
