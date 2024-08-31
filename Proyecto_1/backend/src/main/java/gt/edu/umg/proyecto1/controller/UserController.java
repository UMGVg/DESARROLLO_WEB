package gt.edu.umg.proyecto1.controller;

import gt.edu.umg.proyecto1.dto.request.UserRequest;
import gt.edu.umg.proyecto1.dto.response.UserResponse;
import gt.edu.umg.proyecto1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

}
