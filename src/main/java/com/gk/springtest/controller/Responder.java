package com.gk.springtest.controller;

import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.UnsupportedEncodingException;

/**
 * Created by Padmaka on 7/18/16.
 */

@Controller
@EnableWebMvc
public class Responder {
    private static final Logger LOGGER = Logger.getLogger(Responder.class);


    @RequestMapping(value = "/hi/{name}", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> respond(@PathVariable("name") String name) throws UnsupportedEncodingException {
        JsonObject customer = new JsonObject();
        customer.addProperty("name", name);
        customer.addProperty("no", "077youWish");
        customer.addProperty("address", "Naaaah");
        customer.addProperty("age", "25");
        String responce = customer.toString();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");
        return new ResponseEntity<String>(responce, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/hi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getNLog(@RequestBody String msg) throws UnsupportedEncodingException {

        LOGGER.info(msg);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
