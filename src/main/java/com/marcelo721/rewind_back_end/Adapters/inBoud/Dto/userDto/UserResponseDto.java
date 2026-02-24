package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.userDto;

import com.marcelo721.rewind_back_end.domain.model.entities.User;
import com.marcelo721.rewind_back_end.domain.model.enums.StatusAccount;
import com.marcelo721.rewind_back_end.domain.model.enums.UserType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record UserResponseDto(
        UUID id,
        String nickName,
        String email,
        String description,
        UserType userType,
        StatusAccount statusAccount,
        LocalDateTime createdAt
) {

    public static UserResponseDto toDto(User user){

        if (user == null) return null;
        return new UserResponseDto(
                user.getID(),
                user.getNickName(),
                user.getEmail(),
                user.getDescription(),
                user.getUserType(),
                user.getStatusAccount(),
                user.getCreatedAt()
        );
    }

    public static List<UserResponseDto> toListDto(List<User> users){
        List<UserResponseDto> dtos = new ArrayList<>();

        for(User user : users){
            dtos.add(toDto(user));
        }
        return dtos;
    }

}
