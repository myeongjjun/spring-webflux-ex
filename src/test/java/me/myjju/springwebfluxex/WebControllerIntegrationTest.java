package me.myjju.springwebfluxex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringWebfluxExApplication.class)
class WebControllerIntegrationTest {

    @LocalServerPort
    int randomServerPort;

    @Autowired
    private WebTestClient testClient;

    @Autowired
    private WebController webController;

    @BeforeEach
    public void setup() {
        webController.setServerPort(randomServerPort);
    }

    @Test
    void whenEndpointWithBlockingClientIsCalled_thenThreeTweetsAreReceived() {
        testClient.get()
                .uri("/tweets-blocking")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Tweet.class)
                .hasSize(3);
    }

    @Test
    void whenEndpointWithNonBlockingClientIsCalled_thenThreeTweetsAreReceived() {
        testClient.get()
                .uri("/tweets-non-blocking")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Tweet.class)
                .hasSize(3);

    }



}