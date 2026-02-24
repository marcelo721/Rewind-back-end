package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.userDto;

import com.marcelo721.rewind_back_end.domain.model.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserDto(
        @NotBlank(message = "Nick name is required")
        @Size(max = 21, message = "Nick name must have at most 21 characters")
        String nickName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must have at least 6 characters")
        String password,

        @NotBlank(message = "Description is required")
        @Size(max = 100, message = "Description must have at most 100 characters")
        String description
) {

        public  User toUser() {
                User user = new User();
                user.setNickName(nickName);
                user.setEmail(email);
                user.setPassword(password);
                user.setDescription(description);
                return user;
        }
}
