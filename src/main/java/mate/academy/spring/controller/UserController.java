package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;
    private DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper;

    public UserController(UserService userService,
                          DtoResponseMapper<UserResponseDto, User>
                                  userDtoResponseMapper,
                          DtoRequestMapper<UserRequestDto, User>
                                  userDtoRequestMapper) {
        this.userService = userService;
        this.userDtoResponseMapper = userDtoResponseMapper;
        this.userDtoRequestMapper = userDtoRequestMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        System.out.println(email);
        return userDtoResponseMapper.toDto(userService.findByEmail(email).get());
    }
}
