package com.cg.controller.rest;

import com.cg.model.User;
import com.cg.model.dto.UserDTO;
import com.cg.service.user.IUserService;
import com.cg.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private AppUtils appUtils;
    @Autowired
    private IUserService userService;


    @GetMapping
    public ResponseEntity<?> showListUser() {

        Iterable<UserDTO> users = userService.findAllUserDTOByDeletedIsFailse();

        if (users == null) {
            return new ResponseEntity<>("Danh sách trống!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody UserDTO userDTO) {

        try {
            User user = userDTO.toUser();
            user.setId(0L);
            user.setDeleted(false);
            user = userService.save(user);

            return new ResponseEntity<>(user.toUserDTO(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Server ko xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<UserDTO> user = userService.findUserById(id);

        if (!user.isPresent()) {
            return new ResponseEntity<>("Không tìm thấy user có id là:" + id + "!", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> doEdit(@PathVariable Long id, @Validated @RequestBody UserDTO userDTO,
                                    BindingResult bindingResult) {
        Optional<User> u = userService.findById(id);

        if (!u.isPresent()) {
            return new ResponseEntity<>("Không tồn tại người dùng", HttpStatus.NOT_FOUND);
        }


        if (bindingResult.hasErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }

        try {
            User user = userDTO.toUser();

            user.setId(u.get().getId());
            user.setDeleted(u.get().isDeleted());

            userDTO = user.toUserDTO();

            userService.save(user);

            return new ResponseEntity<>(userDTO, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Server ko xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
