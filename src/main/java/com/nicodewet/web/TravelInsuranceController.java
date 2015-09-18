package com.nicodewet.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nicodewet.domain.TravelInsurance;

@Controller
public class TravelInsuranceController {

	private static final Logger logger = LoggerFactory.getLogger(TravelInsuranceController.class);

	public TravelInsuranceController() {
	}

    @RequestMapping(value="/subscribeth", method=RequestMethod.GET)
    public String showTravelInsurance(final TravelInsurance travelInsurance) {
        return "travelinsurance";
    }


}
