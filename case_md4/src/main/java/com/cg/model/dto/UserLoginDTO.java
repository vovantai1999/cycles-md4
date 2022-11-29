package com.cg.model.dto;

import com.cg.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserLoginDTO {
    private Long id;

    @NotBlank(message = "email là bắt buộc")
    @Email(message = "Địa chỉ email không hợp lệ ")
    @Size(max = 50, message = "Độ dài email 5 - 50 kí tự ")
    private String username;

    @NotBlank(message = "Mật khẩu là bắt buộc ")
    @Size(max = 30, message = "Độ dài mật khẩu tối đa 30 ký tự")
    private String password;


    public UserLoginDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setUsername(username)
                .setPassword(password);
    }
}
