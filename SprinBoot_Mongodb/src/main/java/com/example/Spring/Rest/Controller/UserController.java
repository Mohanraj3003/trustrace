package com.example.Spring.Rest.Controller;


import com.example.Spring.Rest.Model.UserModel;
import com.example.Spring.Rest.Services.UserService;
import com.example.Spring.Rest.dto.UserPatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List> getall(){
            return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> get(@PathVariable() String id){
            return  new ResponseEntity<>(userService.getOneUser(id),HttpStatus.OK);
    }

    @GetMapping("/pagination") // page=0 size=2
    public List<UserModel> page(@RequestParam() int page, @RequestParam() int size ){
        return userService.pagination(page, size);
    }
    @PostMapping("/user")
    public ResponseEntity<?> post(@RequestBody UserModel user)  {
            return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/user")
    public ResponseEntity<UserModel> put(@RequestBody UserModel user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<?> patch(@PathVariable String id, @RequestBody List<UserPatch> user){
        return new ResponseEntity<>(userService.patchUser(id,user),HttpStatus.OK);
    }

}
