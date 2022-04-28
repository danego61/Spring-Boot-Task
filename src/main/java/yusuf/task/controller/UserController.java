package yusuf.task.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import yusuf.task.exception.BadRequestException;
import yusuf.task.exception.NotFoundException;
import yusuf.task.exception.UserAlreadyExsistException;
import yusuf.task.model.Response;
import yusuf.task.model.dto.AddUserDto;
import yusuf.task.model.dto.UpdateUserDto;
import yusuf.task.model.dto.UserDto;
import yusuf.task.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Valid
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{userId}")
    public Response<UserDto> getUser(@PathVariable Long userId) throws NotFoundException {
        return new Response<>(userService.getUserById(userId), "Success", HttpStatus.OK);
    }

    @GetMapping
    public Response<List<UserDto>> getUsers() {
        return new Response<>(userService.getUsers(), "Success", HttpStatus.OK);
    }

    @PostMapping
    public Response<UserDto> newUser(@RequestBody @Valid AddUserDto newUser) throws UserAlreadyExsistException, BadRequestException {
        UserDto user = userService.addUser(newUser);
        return new Response<>(user, "Success", HttpStatus.CREATED);
    }

    @PutMapping ("{userId}")
    public Response<UserDto> updateUser(@PathVariable Long userId, @RequestBody @Valid UpdateUserDto updateUserDto) throws NotFoundException {
        return new Response<>(userService.updateUser(userId, updateUserDto), "Success", HttpStatus.OK);
    }

}
