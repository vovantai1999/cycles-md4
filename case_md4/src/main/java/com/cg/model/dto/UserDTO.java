package com.cg.model.dto;

import com.cg.model.Role;
import com.cg.model.User;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    @NotBlank(message = "SĐT không được trống")
    @Pattern(regexp = "^[0][1-9][0-9]{8,9}$", message = "Số điện thoại gồm 10 số bắt đầu bằng số 0")
    private String phone;


    @NotBlank(message = "Tên đăng nhập không được trống")
    @Email(message = "Tên đăng nhập yêu cầu nhập đúng định dạng email (ví dụ: abc@gmail.com))")
    private String username;

    @NotBlank(message = "Password không được bỏ trống")
    @Size(min = 8, message = "Mật khẩu có độ dài ít nhất 8 kí tự")
    private String password;

    @Valid
    private RoleDTO role;

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO(Long id, String password, String phone, String username, Role role) {
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.role = role.toRoleDTO();
    }

    public UserDTO(Long id, String phone, String username, Role role) {
        this.id = id;
        this.phone = phone;
        this.username = username;
        this.role = role.toRoleDTO();
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setPhone(phone)
                .setUsername(username)
                .setPassword(password)
                .setRole(role.toRole());
    }

}