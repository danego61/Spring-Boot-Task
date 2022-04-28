package yusuf.task.service;

import yusuf.task.exception.BadRequestException;
import yusuf.task.exception.NotFoundException;
import yusuf.task.exception.UserAlreadyExsistException;
import yusuf.task.model.dto.AddUserDto;
import yusuf.task.model.dto.UpdateUserDto;
import yusuf.task.model.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto getUserById(final Long userId) throws NotFoundException;

    List<UserDto> getUsers();

    UserDto addUser(final AddUserDto newUser) throws UserAlreadyExsistException, BadRequestException;

    UserDto updateUser(final Long userId, final UpdateUserDto updateUser) throws NotFoundException;

}
