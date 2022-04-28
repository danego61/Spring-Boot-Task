package yusuf.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import yusuf.task.model.converter.AddUserDtoToUser;
import yusuf.task.model.converter.UserToUserDto;

@Configuration
public class ConverterConfig {

    @Bean
    @Primary
    public ConfigurableConversionService applicationConversionService() {
        final ConfigurableConversionService conversionService = new GenericConversionService();
        conversionService.addConverter(new AddUserDtoToUser());
        conversionService.addConverter(new UserToUserDto());
        return conversionService;
    }

}
