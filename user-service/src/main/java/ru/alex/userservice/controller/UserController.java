package ru.alex.userservice.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Qualifier("defaultUserService")
    private UserService userService;

    private ModelMapper modelMapper;

    @GetMapping("/{id:^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$}")
    public ResponseEntity<UserDto> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(modelMapper.map(userService.findById(id), UserDto.class));
    }

    @GetMapping("/{email:^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$}")
    public ResponseEntity<UserDto> findByEmail(@PathVariable("email") String id) {
        return ResponseEntity.ok(modelMapper.map(userService.findByEmail(id), UserDto.class));
    }
}
