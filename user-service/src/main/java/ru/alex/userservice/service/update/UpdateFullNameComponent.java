package ru.alex.userservice.service.update;

import org.springframework.stereotype.Component;
import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.model.User;

import java.util.Optional;

@Component
public class UpdateFullNameComponent implements UpdateStrategy {
    @Override
    public void execute(UserDto newEntity, User oldEntity) {
        if (Optional.ofNullable(newEntity.getFullName()).isPresent()) {
            oldEntity.setUsername(newEntity.getFullName());
        }
    }
}
