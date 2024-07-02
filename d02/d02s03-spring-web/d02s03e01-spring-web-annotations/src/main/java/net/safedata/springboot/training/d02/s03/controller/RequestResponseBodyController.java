package net.safedata.springboot.training.d02.s03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * A Spring {@link Controller} used to showcase the usages of the {@link RequestMapping} Spring web annotation
 *
 * @author bogdan.solga
 */
@RestController
public class RequestResponseBodyController {

    @RequestMapping(
            method = {
                    RequestMethod.POST,
                    RequestMethod.PATCH
            },
            path = "/requestBody"
    )
    public String requestBody(@RequestBody String request) {
        return "Getting the body of a POST request using the @RequestBody annotation - " + request;
    }

    @PostMapping("/responseBody")
    public String responseBody() {
        return "Returning a response as a @ResponseBody";
    }
}
