package br.com.carstock.main.features.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseUserDTO> create(@RequestBody CreateUserDTO dto) {
        return ResponseEntity.ok(ResponseUserDTO.fromEntity(userService.create(dto)));
    }
}
