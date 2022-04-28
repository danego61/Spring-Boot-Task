package yusuf.task.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Service;
import yusuf.task.exception.BadRequestException;
import yusuf.task.exception.NotFoundException;
import yusuf.task.exception.UserAlreadyExsistException;
import yusuf.task.model.dto.AddUserDto;
import yusuf.task.model.dto.UpdateUserDto;
import yusuf.task.model.dto.UserDto;
import yusuf.task.model.entity.User;
import yusuf.task.repository.UserRepositoryDAO;
import yusuf.task.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("userService")
public class UserServiceImpl implements UserService {

    private final ConfigurableConversionService conversionService;

    private final UserRepositoryDAO userRepository;

    @Override
    public UserDto getUserById(final Long userId) throws NotFoundException {
        final Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw new NotFoundException("User not found!");
        return conversionService.convert(user.get(), UserDto.class);
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> retval = userRepository.findAll();
        return retval.stream().map(user -> conversionService.convert(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto addUser(final AddUserDto newUser) throws UserAlreadyExsistException, BadRequestException {
        final User user = conversionService.convert(newUser, User.class);

        if (user == null)
            throw new BadRequestException();

        if (userRepository.findUserByEmailOrTelephone(newUser.getUserEmail(), newUser.getUserTelephone()).isPresent())
            throw new UserAlreadyExsistException(user);

        return conversionService.convert(userRepository.save(user), UserDto.class);
    }

    @Override
    public UserDto updateUser(final Long userId, final UpdateUserDto updateUser) throws NotFoundException {
        final Optional<User> oUser = userRepository.findById(userId);
        if (oUser.isEmpty())
            throw new NotFoundException("User not found!");
        final User user = oUser.get();
        if (updateUser.getUserName() != null)
            user.setName(updateUser.getUserName());
        if (updateUser.getUserSurname() != null)
            user.setSurname(updateUser.getUserSurname());
        return conversionService.convert(userRepository.save(user), UserDto.class);
    }

}
