package Ejercicio.service;

import Ejercicio.entity.User;

public interface UserService {

  public User findUserByUsername(String username);

  public User findUserByEmail(String email);

  public void saveUser(User user, int roleARegistrar);  // Método para guardar Usuarios ( administradores )

}
