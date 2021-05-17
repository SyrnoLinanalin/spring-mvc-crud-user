package web.service;

import web.dao.UserDAO;
import web.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User reuser) {
        User updateUser = getUser(id);
        updateUser.setName(reuser.getName());
        updateUser.setSurname(reuser.getSurname());
        updateUser.setDepartment(reuser.getDepartment());
        updateUser.setSalary(reuser.getSalary());
        userDAO.updateUser(updateUser);
    }


    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }


}
