package icet.mlslsenarathna.repository;

import icet.mlslsenarathna.model.entity.AuthenticationEntity;

public interface AuthenticationRepository {

    void newRegistration(AuthenticationEntity authenticationEntity);

    AuthenticationEntity getAuthenticationByEmail(String email);
}
