package edu.cs390p.flashcards.controllers;

import java.util.Map;

import edu.cs390p.flashcards.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.cs390p.flashcards.services.UserService;

/*
 * Reference:
 * www.bytestree.com/spring/restful-web-services-unit-testing-spring-boot/
 */

/**
 * Controller for the User class.
 *
 * @author Group 6
 */
@Controller
public class UserController {

    /** The user service. */
    @Autowired
    private UserService userService;

    /**
     * Gets the list of all users.
     *
     * @return the list of all users
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView getAllUsers() {
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("allusers", userService.getAllUsers());
        return mav;
    }

    /**
     * Gets a user by id number.
     *
     * @param id the user id
     * @return the user
     */
    @RequestMapping(method = RequestMethod.GET, value = "/users/getuser/{id}")
    public ModelAndView getUser(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showuser");
        mav.addObject("user", userService.getUser(id));
        return mav;
    }

    /**
     * Adds a user.
     *
     * @param body the user info
     * @return the user
     */
    @RequestMapping(method = RequestMethod.POST, value = "/users/adduser")
    public ModelAndView addUser(@RequestParam final Map<String, String> body) {
        System.out.println("Post request hit /users/adduser containing "
                + body.size() + " elements");
        for (String key : body.keySet()) {
            String val = body.get(key);
            System.out.println(key + ": " + val);
        }

        User user = new User();
        String firstName = body.get("firstName");
        String lastName = body.get("lastName");

        user.setFirstName(firstName);
        user.setLastName(lastName);

        userService.addUser(user);
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("allusers", userService.getAllUsers());
        return mav;
    }

    /**
     * Updates an existing user.
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param id the user's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/users/updateuser/{id}")
    public ModelAndView updateUser(@RequestParam final String firstName,
            final String lastName, @PathVariable final String id) {
        User user = userService.getUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userService.updateUser(user);
        ModelAndView mav = new ModelAndView("showuser");
        mav.addObject("user", userService.getUser(id));
        return mav;
    }

    /**
     * Deletes a user.
     *
     * @param id the user id
     * @return void
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/users/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable final String id) {
        User user = userService.getUser(id);
        if (user == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            userService.deleteUser(id);
            return new ResponseEntity<Void>(HttpStatus.GONE);
        }
    }

    /**
     * Deletes the selected user.
     *
     * @param id The id of the user
     * @return ModelAndView containing the list of all users
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/users/deleteuser/{id}")
    public ModelAndView deleteUserRedirect(@PathVariable final String id) {
        userService.deleteUser(id);
        ModelAndView mav = new ModelAndView("users");
        mav.addObject("allusers", userService.getAllUsers());
        return mav;
    }

    /**
     * Maps to the add user form.
     *
     * @return ModelAndView containing the global school name, redirecting to
     * the add user form
     */
    @RequestMapping("/users/adduser")
    public ModelAndView addUserForm() {
        ModelAndView mav = new ModelAndView("adduserform");
        return mav;
    }

    /**
     * Maps to the edit user form.
     *
     * @param id The sid of the selected user
     * @return ModeAndView containing the selected user
     */
    @RequestMapping("/users/edituser/{id}")
    public ModelAndView editUser(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("edituserform");
        mav.addObject("user", userService.getUser(id));
        return mav;
    }

}
