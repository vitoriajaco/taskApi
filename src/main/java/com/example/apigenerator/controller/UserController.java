package com.example.apigenerator.controller;

import com.example.apigenerator.model.UserModel;

import com.example.apigenerator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController {

    @Autowired
    UserService userService;


        @PostMapping
        public ResponseEntity<UserModel> createUser(@RequestBody UserModel user) {
            UserModel createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel userDetails) {
            UserModel updatedUser = userService.updateUser(id, userDetails);
            return ResponseEntity.ok(updatedUser);
        }

        @GetMapping("/{id}")
        public ResponseEntity<UserModel> findUserById(@PathVariable Long id) {
            UserModel user = userService.findUserById(id);
            return ResponseEntity.ok(user);
        }
    }

