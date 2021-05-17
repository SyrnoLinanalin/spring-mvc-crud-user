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
    private UserDAOImpl userDAOimp;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAOimp.getAllUser();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAOimp.saveUser(user);

    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDAOimp.getUser(id);
    }

    @Override
    @Transactional
    public void updateUser(int id, User reuser) {
        User updateUser = getUser(id);
        updateUser.setName(reuser.getName());
        updateUser.setSurname(reuser.getSurname());
        updateUser.setDepartment(reuser.getDepartment());
        updateUser.setSalary(reuser.getSalary());
        userDAOimp.updateUser(updateUser);
    }


    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAOimp.deleteUser(id);
    }


}
