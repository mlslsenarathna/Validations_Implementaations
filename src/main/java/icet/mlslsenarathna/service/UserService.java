package icet.mlslsenarathna.service;

import icet.mlslsenarathna.model.dto.AuthenticationDTO;
import icet.mlslsenarathna.model.dto.UserDTO;
import icet.mlslsenarathna.model.dto.UserDataDTO;
import icet.mlslsenarathna.model.entity.UserEntity;
import icet.mlslsenarathna.repository.UserRepository;
import icet.mlslsenarathna.repository.impl.UserRepositoryImpl;

public class UserService {
    AuthenticationService authenticationService=new AuthenticationService();
    UserRepository userRepository=new UserRepositoryImpl();
    HashingService hashingService=new HashingService();
    public boolean registerNewUser(UserDTO newUser) {
        UserEntity userEntity=new UserEntity(
                newUser.getFirstName(),
                newUser.getLastName(),
                newUser.getEmail()
        );
        AuthenticationDTO authenticationDTO=new AuthenticationDTO(
                newUser.getEmail(),
                hashingService.hashPassword(newUser.getPassword())
        );
        userRepository.registerUser(userEntity);
        authenticationService.registerAuthentication(authenticationDTO);
        return true;
    }

    public UserDataDTO getUserDetailsFromEmail(String trim) {
        UserEntity userEntity=userRepository.getUserByEmail(trim);

        return new UserDataDTO(
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail()

        );
    }
}
