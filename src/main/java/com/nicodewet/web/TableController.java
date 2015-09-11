package com.nicodewet.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableController {
	
	@RequestMapping("/table")
    String table() {
        return "table";
    }
}
