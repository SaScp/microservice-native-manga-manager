package ru.alex.userservice.service.update;

import ru.alex.userservice.dto.UserDto;
import ru.alex.userservice.model.User;

public interface UpdateStrategy {
    void execute(UserDto newEntity, User oldEntity);
}
