package exercise.controller;

import exercise.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import exercise.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "")
    public Flux<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> getById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public Mono<User> create(@RequestBody User user) {
        return userService.create(user);
    }

    @PatchMapping("/{id}")
    public Mono<User> update(@PathVariable(value = "id") Long id,
                             @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public Mono deleteById(@PathVariable(value = "id") Long id) {
        return userService.remove(id);
    }

}
