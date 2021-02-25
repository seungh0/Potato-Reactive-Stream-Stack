package com.potato.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = MainController.class)
public class MainControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void ping_test() {
		// given
		webTestClient.get().uri("/ping")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("pong");
	}

}
