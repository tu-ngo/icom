package com.nab.icommerce.controler;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ICommerceErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        //TODO: Improve error page to have correct error message
        return "Hey, ask Google Maps for wrong navigation";
    }
}
