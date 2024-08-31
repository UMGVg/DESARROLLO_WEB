package gt.edu.umg.proyecto1.service;

import gt.edu.umg.proyecto1.dto.request.UserRequest;
import gt.edu.umg.proyecto1.dto.response.UserResponse;
import gt.edu.umg.proyecto1.mapper.UserMapper;
import gt.edu.umg.proyecto1.model.UserModel;
import gt.edu.umg.proyecto1.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        List<UserModel> users = userRepository.findAll();

        return users.stream().map(userMapper::toDto).toList();
    }

    public String createUser(UserRequest userRequest) {
        try {
            userRepository.save(userMapper.toEntity(userRequest));
            return "Usuarios creado correctamente";
        }catch (Exception e) {
            return "Error al crear usuario";
        }
    }

}
