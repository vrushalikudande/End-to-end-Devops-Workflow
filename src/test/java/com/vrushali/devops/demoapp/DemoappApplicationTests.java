package com.vrushali.devops.demoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoappApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void homePage_ShouldContainVrushaliName() {
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertThat(response).contains("Vrushali Kudande");
	}

	@Test
	void homePage_ShouldContainCorrectGitHubLink() {
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertThat(response).contains("https://github.com/vrushalikudande");
	}

	@Test
	void homePage_ShouldContainMainHeading() {
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		assertThat(response).contains("End-to-end Devops Workflow Implementation");
	}
}
