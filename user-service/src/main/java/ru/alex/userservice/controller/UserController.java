package ru.alex.userservice.controller;

import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.service.UserService;

import java.net.URI;
import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Qualifier("defaultUserService")
    private UserService userService;

    private ModelMapper modelMapper;

    @GetMapping("/{id:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$}")
    public ResponseEntity<CompletableFuture<UserDto>> findById(@PathVariable("id") String id) {
        return ResponseEntity
                        .ok(userService.findById(id)
                                .thenApply(user -> modelMapper.map(user, UserDto.class)));
    }

    @GetMapping("/{email:^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$}")
    public ResponseEntity<CompletableFuture<UserDto>> findByEmail(@PathVariable("email") String id) {
        return ResponseEntity
                .ok(userService.findByEmail(id)
                        .thenApply(user -> modelMapper.map(user, UserDto.class)));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@Validated @RequestBody UserDto userDto) {
        return ResponseEntity.created(URI.create("/user/create"))
                .body(modelMapper.map(userService.createUser(userDto), UserDto.class));
    }

    @PatchMapping("/update")
    public ResponseEntity<?> update(@Validated @RequestBody UserDto userDto) {
        return null;
    }
}
