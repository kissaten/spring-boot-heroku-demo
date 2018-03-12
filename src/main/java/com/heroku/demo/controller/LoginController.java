/*
 * Copyright 2015 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.heroku.demo.controller;

import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.heroku.demo.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private PersonRepository personRepository;

    @Autowired
    public LoginController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
       return "login";
    }
    
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public ModelAndView userLogin(Person person) {
		ModelAndView model = new ModelAndView("test");
			System.out.println("userlogin============"+person.getFirstname());
			System.out.println("userlogin============"+person.getLastname());
			
			List<Person> persons = new ArrayList<Person>();
			persons.add(person);
	        model.addAttribute("persons", persons);
	        model.addAttribute("insertPerson", new Person());
			
			return model;
	}
	
	

//    @RequestMapping(method = RequestMethod.POST)
//    public String insertData(ModelMap model, @ModelAttribute("insertPerson") @Valid Person person,
//                             BindingResult result) {
//        if (!result.hasErrors()) {
//        	personRepository.save(person);
//        }
//        return home(model);
//    }
}
