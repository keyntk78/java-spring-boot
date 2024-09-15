package ntk.vn.project_java_spring.controller;

import ntk.vn.project_java_spring.dto.request.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@RequestBody UserRequestDTO user) {
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO user) {
        System.out.println("Update user");
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String updateStatus(@PathVariable int userId,@RequestParam(required = false)  boolean enable) {
        return "User Status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        return new UserRequestDTO("Tuan", "Kiet", "admin@ntk.vn", "0355882728");
    }

    @GetMapping("/")
    public List<UserRequestDTO> getAllUsers(@RequestParam(defaultValue = "0") int pageNo,
                                            @RequestParam(defaultValue = "10") int pageSize) {
        return List.of(new UserRequestDTO("Tuan", "Kiet", "admin@ntk.vn", "0355882728"),
                new UserRequestDTO("Viet", "Trinh", "trinh@ntk.vn", "0355882728"));
    }
}
