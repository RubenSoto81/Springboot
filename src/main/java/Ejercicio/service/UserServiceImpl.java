package Ejercicio.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Ejercicio.entity.Role;
import Ejercicio.entity.User;
import Ejercicio.repository.RoleRepository;
import Ejercicio.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private RoleRepository roleRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public User findUserByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public void saveUser(User user, int roleARegistrar) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));  // password
    user.setEnabled(true);  // pone propiedad enabled a true
    Role userAdminRole;
    if (roleARegistrar == 3) {
      userAdminRole = roleRepository.findByRole("ADMIN");  // Busca rol "ADMIN"
    } else {
      userAdminRole = roleRepository.findByRole("USER");  // Busca rol "ADMIN"
    }
    user.setRoles(new HashSet<Role>(Arrays.asList(userAdminRole)));  // Cargo un nuevo "ADMIN" en la lista 

    System.out.println("User is ready: " + user);
    userRepository.save(user);  // guardo el usuario ( nuevo ADMIN )
  }
}
