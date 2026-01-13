package icet.mlslsenarathna.repository.impl;

import icet.mlslsenarathna.controller.HibernateUtil;
import icet.mlslsenarathna.model.entity.AuthenticationEntity;
import icet.mlslsenarathna.repository.AuthenticationRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class AuthenticationRepositoryImpl implements AuthenticationRepository {
    @Override
    public void newRegistration(AuthenticationEntity authenticationEntity) {
        Configuration configuration=new Configuration();
        configuration.addAnnotatedClass(icet.mlslsenarathna.model.entity.AuthenticationEntity.class);
        configuration.configure("hibernate.cfg.xml");
        SessionFactory factory=configuration.buildSessionFactory();
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        session.merge(authenticationEntity);
        transaction.commit();
    }

    @Override
    public AuthenticationEntity getAuthenticationByEmail(String email) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        AuthenticationEntity auth=null;
        try {
            session.beginTransaction();
            String hql = "FROM AuthenticationEntity a WHERE a.email = :email";
            Query<AuthenticationEntity> query = session.createQuery(hql, AuthenticationEntity.class);
            query.setParameter("email", email);

            auth = query.uniqueResult();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return auth;
    }

}
