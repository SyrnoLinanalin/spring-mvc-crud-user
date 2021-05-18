package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {

   @PersistenceContext
   EntityManager entityManager;

    @Override
    public List<User> getAllUser() {

        List<User> allUser = entityManager.createQuery("from User")
                        .getResultList();

        return allUser;
    }

    @Override
    public void saveUser(User user) {

      Session session = entityManager.unwrap(Session.class);
      session.save(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
       entityManager.createQuery("delete from User where id =:userid")
               .setParameter("userid", id)
                .executeUpdate();
    }
}
