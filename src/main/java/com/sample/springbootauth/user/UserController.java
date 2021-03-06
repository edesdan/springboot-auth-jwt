package com.sample.springbootauth.user;

import com.sample.springbootauth.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserRepository userRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserController(UserRepository applicationUserRepository,
                        BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = applicationUserRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @PostMapping("/registration")
  public void registration(@RequestBody ApplicationUser user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setUuid(UUID.randomUUID().toString());
    userRepository.save(user);
  }
}
