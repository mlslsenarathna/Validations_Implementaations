package icet.mlslsenarathna.repository.impl;

import icet.mlslsenarathna.model.entity.UserEntity;
import icet.mlslsenarathna.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
}
