package com.kocsistem.krediBasvuru.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.jboss.logging.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/application")
@CrossOrigin(origins = {
    "http://172.17.0.2:3000",
    "http://172.17.0.2:3030",
    "http://localhost:3000",
    "http://localhost:3030"
})
public class Start {

    public static Logger logger = Logger.getLogger(Start.class);

    @RequestMapping("/hi")
    public String hello() {
        return "Hello From Koç Sistem!!!";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody String process(@RequestBody(required = false) HashMap<Object, Object> map) throws Exception {

        logger.info(map);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(CreditProcess.process(map));
    }

}
