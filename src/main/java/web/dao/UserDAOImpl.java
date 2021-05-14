package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {

   @PersistenceContext
   EntityManager entityManager;

    @Override
    public List<User> getAllUser() {

        List<User> allUser = entityManager.createQuery("from User", User.class)
                        .getResultList();

        return allUser;
    }
}
