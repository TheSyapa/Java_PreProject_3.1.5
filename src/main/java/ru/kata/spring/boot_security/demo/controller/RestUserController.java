package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/userApi")
public class RestUserController {
    private UserService userService;

    @Autowired
    public RestUserController(UserService userService) {
        this.userService = userService;
    }
   /* @GetMapping(value = "/profile")
    public ResponseEntity<User> showUser(@AuthenticationPrincipal User user) {

        return ResponseEntity.ok(user);
    }*/

    /*@GetMapping(value = "/profile")
    public ResponseEntity<User> showUser(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }*/

    @GetMapping(value = "/profile")
    public ResponseEntity<User> showUser(Principal principal) {
        User user = userService.findByEmail(principal.getName());
        return ResponseEntity.ok(user);
    }

}
