package test.pak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import test.pak.dao.User;
import test.pak.repository.UserRepository;

/**
 * Created by anamika on 10/7/17.
 */
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public User userAuth(String email_id, String password)
    {
        User pass = userRepository.findByEmail(email_id);//method for getting password for a specified user_id

        if(pass.getPassword().equals(password))
        {
            //User userTmp = new User();
            //userTmp = userRepository.findByUserId(String email_id);

            return pass;
        }
        else return null;

    }
}
