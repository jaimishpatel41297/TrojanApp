/*
package com.com.trojans.controller;

import com.com.trojans.dataservice.UserDataService;
import com.com.trojans.model.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
//GET: READ
//PUT: SAVE or UPDATE
//POST: CREATE
//DELETE: DELETE RECORD

@Controller
public class LoginController {
    @Autowired
    private UserDataService userDataService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        LoginUser user = new LoginUser();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid LoginUser user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        LoginUser userExists = userDataService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "The email has been used");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userDataService.saveUser(user);
            modelAndView.addObject("successMessage", "Voilà! Successfully registered");
            modelAndView.addObject("user", new LoginUser());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/admin/adminHome", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LoginUser user = userDataService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "HELLO " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("adminMessage","Authorized Admin");
        modelAndView.setViewName("admin/adminHome");
        return modelAndView;
    }

    @RequestMapping(value="/user/userHome", method = RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        LoginUser user = userDataService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "HEllO " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        modelAndView.addObject("userMessage","This is for users");
        modelAndView.setViewName("user/userHome");
        return modelAndView;
    }
}

*/
