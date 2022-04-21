package me.myjju.springwebfluxex;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebClientController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/resource")
    public Map<String, String> getResouce() {
        Map<String, String> response = new HashMap<>();
        response.put("field", "value");
        return response;
    }

    @PostMapping("/resource")
    public Mono<String> postStringResouce(@RequestBody Mono<String> bodyString) {
        return bodyString.map(body -> "procesed-" + body);
    }

    @PostMapping("/resource-foo")
    public Mono<String> FooResouce(@RequestBody Mono<Foo> bodyFoo) {
        return bodyFoo.map(foo -> "procesedFoo-" + foo.getName());
    }

    @PostMapping(value = "/resource-multipart", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFormUpload(@RequestPart("key1") String value1, @RequestPart("key2") String value2) {
        return "processed-" + value1 + '-' + value2;
    }

}
