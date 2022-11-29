package com.cg.model.dto;

import com.cg.model.User;
import lombok.*;
import lombok.experimental.Accessors;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserRegisterDTO {

    private Long id;

    @NotBlank(message = "email là bắt buộc")
    @Email(message = "địa chỉ email không hợp lệ")
    @Size(max = 50, message = "Độ dài của email phải từ 5 đến 50 ký tự")
    private String username;

    @NotBlank(message = "mật khẩu là bắt buộc")
    @Size(max = 30, message = "Độ dài mật khẩu tối đa 30 ký tự")
    private String password;

    @Valid
    private RoleDTO role;

    public UserRegisterDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setUsername(username)
                .setPassword(password)
                .setRole(role.toRole());
    }

}
