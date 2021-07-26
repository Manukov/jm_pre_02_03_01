package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
//        entityManager.persist(new User("Name1", "Email1"));
//        entityManager.persist(new User("Name2", "Email2"));
//        entityManager.persist(new User("Name3", "Email3"));
//        entityManager.persist(new User("Name4", "Email4"));
//        entityManager.persist(new User("Name5", "Email5"));

        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {

        User u = findById(user.getId());
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        entityManager.persist(u);
    }

    @Override
    public User findById(long id) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.id=:id", User.class);
        User user = query.setParameter("id", id).getSingleResult();
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public void deleteUser(long id) {

        entityManager.createQuery("DELETE FROM User WHERE id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
