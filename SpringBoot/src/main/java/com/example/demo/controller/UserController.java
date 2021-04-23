package com.example.demo.controller;


import com.example.demo.dto.UserPatch;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

        @Autowired
        UserService userService;


    @RequestMapping("/user")
    public List<User> getall(HttpServletResponse response) {
            response.setStatus(200);
            return  userService.getAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> get(@PathVariable() int id) {
            return  userService.getUser(id);
    }

    @PostMapping("/user")
    public ResponseEntity post(@RequestBody User user) {
        try{
            return  new  ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable() int id,HttpServletResponse response) {
        String str = userService.deleteUser(id);
         if(str == null){
             response.setStatus(404);
             return "Unable to Delete";
         } else {
             response.setStatus(200);
             return str;
         }
    }

    @PutMapping("/user")
    public ResponseEntity put(@RequestBody User user){
//       return userService.update(id,user);
        try{
            return  new  ResponseEntity<User>(userService.updateUser(user), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users") // page=0 size=2
    public List<User> page(@RequestParam() int page, @RequestParam() int size ){
        try {
            return userService.pagination(page, size);
        }catch (Exception e){
            throw new IllegalArgumentException(e);
        }
    }

    @GetMapping("/headers")
    public String header(@RequestHeader() Integer auth){
        if(auth==123)
            return "Valid Auth token";
        return "Invalid Auth token";
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<User> patch(@PathVariable() int id, @RequestBody List<UserPatch> user){
        try{
            userService.patchUser(id,user);
            return  new  ResponseEntity("Successfully Updated..!", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}