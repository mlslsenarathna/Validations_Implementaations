package icet.mlslsenarathna.service;
import org.mindrot.jbcrypt.BCrypt;


public class HashingService {

    public static String hashPassword(String plainPassword) {

        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(plainPassword, salt);
    }
    public static boolean checkPassword(String plainPassword, String storedHash) {

        return BCrypt.checkpw(plainPassword, storedHash);
    }



}
