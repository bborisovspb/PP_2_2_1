package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public User getUserByCar (String model, int series) throws NoResultException {
      TypedQuery<User> tq = sessionFactory.getCurrentSession().createQuery
              ("from User u where u.car.model = :model and u.car.series = :series");
      tq.setParameter("model", model).setParameter("series", series);
      return tq.setMaxResults(1).getSingleResult();
   }
   public List<Car> listCars(String model){
      TypedQuery<Car> tq = sessionFactory.getCurrentSession().createQuery(
      "from Car u where model = :model");
      tq.setParameter("model", model);
      return tq.getResultList();
   }

}
