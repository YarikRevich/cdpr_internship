package com.gamestore.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.jdbc.Sql;

import org.apache.http.client.utils.URIBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @Sql({ "data.sql" })
public class AdminControllerTest {
    @Value(value="${local.server.port}")
	private int port;

    @Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    URIBuilder getURIBuilder() {
        return new URIBuilder()
        .setScheme("http")
        .setHost("localhost")
        .setPort(port);
    }

    @Test
	public void createShouldWork() throws Exception {
        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admin");
        builder.addParameter("id", "1");
        String url = builder.build().toString();

        // this.restTemplate.postForObject(url)
		// assertThat(this.restTemplate.getForObject(url,
		// 		GamesRetrievalResponseDTO.class)).contains("{}");
	}

    @Test
	public void getShouldWork() throws Exception {
        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admin");
        builder.addParameter("id", "1");
        String url = builder.build().toString();

        System.out.println(url);
		// assertThat(this.restTemplate.getForObject(url,
		// 		GamesRetrievalResponseDTO.class)).contains("{}");
	}

    @Test
	public void getAllShouldWork() throws Exception {
        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admins");
        String url = builder.build().toString();

        System.out.println(url);
		// assertThat(this.restTemplate.getForObject(url,
		// 		GamesRetrievalResponseDTO.class)).contains("{}");
	}

    @Test
	public void deleteShouldWork() throws Exception {
        URIBuilder builder = this.getURIBuilder();
        builder.setPath("/v1/admin");
        builder.addParameter("id", "1");
        String url = builder.build().toString();

        System.out.println(url);
		// assertThat(this.restTemplate.getForObject(url,
		// 		GamesRetrievalResponseDTO.class)).contains("{}");
	}
}
