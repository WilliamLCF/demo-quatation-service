package com.bpaas.quatation.v1.restcontroller;


import com.bpaas.quatation.HelloWorldResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(path = "${api.path.prefix}", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController("DemoController")
@Slf4j
public class DemoController{

    private Map<Integer, String> userMapping = new HashMap<>() {{
        put(1,"William");
        put(2,"Kevin");
        put(3,"Jerry");
        put(4,"Andy");
    }};

    @Operation(summary = "HelloWorld", description = "Swagger測試")
    @GetMapping(path = "/Hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloWorldResponse> helloWorld(@RequestParam String username) {
        String msg = String.format("Hello! %s", username);
        HelloWorldResponse response = new HelloWorldResponse();
        response.setMsg(msg);
        return new ResponseEntity<HelloWorldResponse>(response, HttpStatus.OK);
    }

//    @Operation(summary = "QueryUser", description = "Swagger測試2")
//    @GetMapping(path = "/User/{seq}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<HelloWorldResponse> queryUser(@PathVariable Integer seq) {
//
//        String msg = String.format("Hello! %s",   userMapping.get(seq));
//        HelloWorldResponse response = new HelloWorldResponse();
//        response.setMsg(msg);
//        return new ResponseEntity<HelloWorldResponse>(response, HttpStatus.OK);
//    }
}
