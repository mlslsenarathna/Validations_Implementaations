package icet.mlslsenarathna.service;

import icet.mlslsenarathna.repository.AuthenticationRepository;
import icet.mlslsenarathna.repository.impl.AuthenticationRepositoryImpl;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
;


public class AuthenticationService {
    AuthenticationRepository authenticationRepository=new AuthenticationRepositoryImpl();
    HashingService hashingService=new HashingService();
    private  final String GMAIL_REGEX = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
    public  boolean isValidGmail(String email) {
        if (email == null) return false;

        Pattern pattern = Pattern.compile(GMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean checkEmailAndPassword(String userMail, String pword) {
        return true;
    }
}