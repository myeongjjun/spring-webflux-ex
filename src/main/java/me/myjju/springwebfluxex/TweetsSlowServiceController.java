package me.myjju.springwebfluxex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TweetsSlowServiceController {

    @GetMapping("/slow-service-tweets")
    private List<Tweet> getAllTweets() throws InterruptedException {
        Thread.sleep(2000L);
        return Arrays.asList(
                new Tweet("RestTemplate rules", "@user1"),
                new Tweet("WebClient is better", "@user2"),
                new Tweet("OK, both are useful", "@user1"));
    }

}
