package yusuf.task.model.converter;

import org.springframework.core.convert.converter.Converter;
import yusuf.task.model.dto.AddUserDto;
import yusuf.task.model.entity.User;

public class AddUserDtoToUser implements Converter<AddUserDto, User> {

    @Override
    public User convert(AddUserDto source) {
        return new User(
                0L,
                source.getUserName(),
                source.getUserSurname(),
                source.getUserEmail(),
                source.getUserTelephone()
        );
    }

}
