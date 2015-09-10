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
package com.nicodewet.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Subscription {

	private String firstname;
	private String surname;
	private String email;
    private SubscriptionType subscriptionType = SubscriptionType.ALL_EMAILS;
    
    public Subscription() {
        super();
    }

    @NotEmpty
    @Email
    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }
    
    @NotEmpty
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@NotEmpty
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

    public SubscriptionType getSubscriptionType() {
        return this.subscriptionType;
    }

    public void setSubscriptionType(final SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
    
	@Override
	public String toString() {
		return "Subscription [firstname=" + firstname + ", surname=" + surname + ", email=" + email
				+ ", subscriptionType=" + subscriptionType + "]";
	}
}