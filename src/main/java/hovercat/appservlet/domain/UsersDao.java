
package hovercat.appservlet.domain;

import java.util.List;

public interface UsersDao {

    Integer addUser(String login, String name, String password, String email, String role);

    void deleteUser(Integer id);

    void updateUser(Users user);

    List<Users> getAllUsers();

    Users getUserById(Integer id);

    Users loadByLogin(String login);
}
