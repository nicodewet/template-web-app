package com.nicodewet.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nicodewet.domain.TravelInsurance;

@Controller
public class InsuranceController {

	private static final Logger logger = LoggerFactory.getLogger(InsuranceController.class);

	public InsuranceController() {
	}

    @RequestMapping(value="/insurance", method=RequestMethod.GET)
    public String showTravelInsurance(final TravelInsurance travelInsurance) {
        return "insurance";
    }


}
