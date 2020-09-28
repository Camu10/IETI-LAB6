package edu.escuelaing.ieti.TaskPlanner.controllers;

import edu.escuelaing.ieti.TaskPlanner.model.User;
import edu.escuelaing.ieti.TaskPlanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService us = null;

    @RequestMapping(value = "/{id}", method =  RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String id){
        User user = us.getById(id);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/", method =  RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        List<User> users = us.getAll();
        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/addUser", method =  RequestMethod.POST)
    public ResponseEntity<?> addUser(@RequestBody User user){
        User newUser = us.create(user);
        return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/update", method =  RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User newUser = us.update(user);
        return new ResponseEntity<>(newUser,HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/deleteUser/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> DeleteUniversity(@PathVariable String id){
            us.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
