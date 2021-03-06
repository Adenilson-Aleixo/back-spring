package br.inf.datainfo.desafio.web.controller;

import br.inf.datainfo.desafio.domain.entity.User;
import br.inf.datainfo.desafio.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@PropertySource("classpath:messages.properties")
@AllArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Environment env;

    @GetMapping("/all")
    ResponseEntity<?> findAll(
        Pageable pageable,
        @RequestParam("onlyEnable") final String onlyEnable,
        @RequestParam("noUser") final String noUser,
        @RequestParam("icUserProfile") final String icUserProfile ) {

        Page<User> users = userService.filter(pageable, noUser, onlyEnable, icUserProfile);
        return ResponseEntity.ok().body(users);
    }

    @CrossOrigin
    @PostMapping("/save")
    ResponseEntity<?> save(@RequestBody User newUser) {
        try {
            User user = userService.save(newUser);
            return ResponseEntity.ok().body(env.getProperty("user.MN001"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/{nuCpf}")
    public ResponseEntity<?> delete(@PathVariable("nuCpf") final String nuCpf) {
        try {
            userService.delete(nuCpf);
            return ResponseEntity.ok().body(env.getProperty("user.MN005"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e);
        }
    }

    @CrossOrigin
    @PutMapping(path = "/disable/{nuCpf}")
    public ResponseEntity<?> disableUser(
            @PathVariable("nuCpf") final String nuCpf,
            @RequestParam("onlyEnable") final Boolean onlyEnable)
    {
        try {
            userService.disableUser(nuCpf, onlyEnable);

            String message = onlyEnable ? "user.MN033" : "user.MN032";

            return ResponseEntity.ok().body(env.getProperty(message));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e);
        }
    }

    @CrossOrigin
    @PostMapping("/update")
    ResponseEntity<?> update(@RequestBody User newUser) {
        try {
            User user = userService.update(newUser);
            return ResponseEntity.ok().body(env.getProperty("user.MN030"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
