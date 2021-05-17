package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUser();

    public void saveUser(User user);

    public User getUser(int id);

    void updateUser(User user);

    public void deleteUser(int id);

}
