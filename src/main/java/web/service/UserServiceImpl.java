package web.service;

import web.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserDAOImpl userDAOImpl;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAOImpl.getAllUser();
    }
}
