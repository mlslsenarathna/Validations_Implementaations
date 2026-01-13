package icet.mlslsenarathna.repository;

import icet.mlslsenarathna.model.entity.UserEntity;

public interface UserRepository {
    void registerUser(UserEntity userEntity);

    UserEntity getUserByEmail(String trim);
}
