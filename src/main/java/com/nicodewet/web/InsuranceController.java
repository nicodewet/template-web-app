package com.nicodewet.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicodewet.domain.insurance.DestinationType;
import com.nicodewet.domain.insurance.Insurance;

@Controller
public class InsuranceController {

	private static final Logger logger = LoggerFactory.getLogger(InsuranceController.class);

	public InsuranceController() {
	}

	@ModelAttribute("allTypes")
    public DestinationType[] populateTypes() {
        return new DestinationType[] { DestinationType.AUSTRALIA_PACIFIC_ISLANDS,
        								DestinationType.WORLDWIDE_EXCL, DestinationType.WORDWIDE };
    }

    @RequestMapping(value="/insurance", method=RequestMethod.GET)
    public String showTravelInsurance(final Insurance travelInsurance) {
        return "insurance";
    }

    @RequestMapping(value="/insurance", method=RequestMethod.POST)
    public String subscribe(@Valid final Insurance insurance, final BindingResult bindingResult, final ModelMap model, RedirectAttributes redirectAttributes) {
    	if (bindingResult.hasErrors()) {
            return "insurance";
        } else {
        	logger.info("JUST ADDED INSURANCE: " + insurance);
        	model.clear();
        	redirectAttributes.addFlashAttribute("lodged", "success");
        	return "redirect:/insurance";
        }
    }


}
