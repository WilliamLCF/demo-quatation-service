package com.bpaas.quatation.v1.restcontroller;


import com.bpaas.quatation.HelloWorldResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RequestMapping(path = "${api.path.prefix}", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController("DemoController")
@Slf4j
public class DemoController {

    @Operation(summary = "HelloWorld", description = "Swagger測試")
    @GetMapping(path = "/Hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HelloWorldResponse> helloWorld(@RequestParam String username) {
        String msg = String.format("Hello! %s", username);
        HelloWorldResponse response = new HelloWorldResponse();
        response.setMsg(msg);
        return new ResponseEntity<HelloWorldResponse>(response, HttpStatus.OK);
    }
}
