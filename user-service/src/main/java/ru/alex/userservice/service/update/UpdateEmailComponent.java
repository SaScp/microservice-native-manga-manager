package ru.alex.userservice.service.update;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.model.User;

import java.util.Optional;

@Component
public class UpdateEmailComponent implements UpdateStrategy {
    @Override
    public void execute(UserDto newEntity, User oldEntity) {
        if (Optional.ofNullable(newEntity.getEmail()).isPresent()) {
            oldEntity.setUsername(newEntity.getEmail());
        }
    }
}
