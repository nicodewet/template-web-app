/*
 * =============================================================================
 *
 *   Copyright (c) 2011, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.nicodewet.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nicodewet.domain.Subscription;
import com.nicodewet.domain.SubscriptionType;
import com.nicodewet.web.validation.ErrorMessage;
import com.nicodewet.web.validation.ValidationResponse;

@Controller
public class SubscribeController {

    private static final Logger log = Logger.getLogger(SubscribeController.class);

    public SubscribeController() {
        super();
    }

    @ModelAttribute("allTypes")
    public SubscriptionType[] populateTypes() {
        return new SubscriptionType[] { SubscriptionType.ALL_EMAILS, SubscriptionType.DAILY_DIGEST };
    }

    @RequestMapping(value="/subscribeth", method=RequestMethod.GET)
    public String showSubscription(final Subscription subscription) {
        return "subscribeth";
    }

    @RequestMapping(value="/subscribeth", method=RequestMethod.POST)
    public String subscribe(@Valid final Subscription subscription, final BindingResult bindingResult, final ModelMap model, RedirectAttributes redirectAttributes) {
    	if (bindingResult.hasErrors()) {
            return "subscribeth";
        } else {
        	log.info("JUST ADDED SUBSCRIPTION: " + subscription);
        	model.clear();
        	redirectAttributes.addFlashAttribute("subscribed", "success");
        	return "redirect:/subscribeth";
        }
    }

    @RequestMapping(value="/subscribeth.json", method=RequestMethod.POST)
    public @ResponseBody ValidationResponse processForm(@Valid final Subscription subscription, final BindingResult bindingResult, final ModelMap model) {
    	log.info("Validation");
    	ValidationResponse res = new ValidationResponse();
    	if (!bindingResult.hasErrors()) {
    		res.setStatus("SUCCESS");
    	} else {
    		res.setStatus("FAIL");
    		List<FieldError> allErrors = bindingResult.getFieldErrors();
			List<ErrorMessage> errorMesages = new ArrayList<ErrorMessage>();
			for (FieldError objectError : allErrors) {
				errorMesages.add(new ErrorMessage(objectError.getField(), objectError.getField() + "  " + objectError.getDefaultMessage()));
			}
			res.setErrorMessageList(errorMesages);
    	}
    	return res;
    }

}
