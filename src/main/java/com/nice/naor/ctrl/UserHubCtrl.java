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
public class UserHubCtrl {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = { "/getUserById" }, method = RequestMethod.POST)
    @ResponseBody
    public User getUserById(@RequestParam(value = "id") long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
    @ResponseBody
    public boolean updateUser(@RequestParam(value = "user") User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = { "/deleteUser" }, method = RequestMethod.POST)
    @ResponseBody
    public boolean deleteUser(@RequestParam(value = "user") User user) {
        return userService.updateUser(user);
    }
}

