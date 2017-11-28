package com.nice.naor.ctrl;

import com.nice.naor.model.User;
import com.nice.naor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Haimov on 25/11/2017.
 */

@Controller
@RequestMapping("/userhub")
public class UserHubCtrl {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String greetings() {
        return "Welcome to UserHub";
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {return userService.getAllUsers();}

    @RequestMapping(value = { "/getUserById" }, method = RequestMethod.POST)
    @ResponseBody
    public User getUserById(@RequestBody int id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = { "/deleteUserById" }, method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteUserById(@RequestBody int id) {
        return userService.deleteUserById(id);
    }
}

