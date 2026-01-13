package icet.mlslsenarathna.repository.impl;

import icet.mlslsenarathna.controller.HibernateUtil;
import icet.mlslsenarathna.model.entity.AuthenticationEntity;
import icet.mlslsenarathna.model.entity.UserEntity;
import icet.mlslsenarathna.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public void registerUser(UserEntity userEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(icet.mlslsenarathna.model.entity.UserEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(userEntity);
        transaction.commit();
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        UserEntity user=null;
        try {
            session.beginTransaction();
            String hql = "FROM UserEntity u WHERE u.email = :email";
            Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
            query.setParameter("email", email);

            user= query.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;
    }
}
