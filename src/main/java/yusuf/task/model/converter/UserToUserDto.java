package yusuf.task.model.converter;

import org.springframework.core.convert.converter.Converter;
import yusuf.task.model.dto.UserDto;
import yusuf.task.model.entity.User;

public class UserToUserDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        return new UserDto(
                source.getUserId(),
                source.getName(),
                source.getSurname(),
                source.getEmail(),
                source.getTelephone()
        );
    }

}
