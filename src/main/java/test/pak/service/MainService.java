package test.pak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import test.pak.dao.User;
import test.pak.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anamika on 10/7/17.
 */

@Service
public class MainService {

    @Autowired
    private UserRepository userRepository;

    public List<test.pak.dao.User> findAllData()
    {
        List<test.pak.dao.User> userList =  userRepository.findAllUsers();
        return userList;
    }

    public void saveUsers(test.pak.dao.User userTemp) {
        userRepository.save(userTemp);
    }

    public void editUser(User user) {
//        String userName, String userAddress, String userAge, String password, String userCntct, String emailId
        userRepository.EditUser(user.getUserName(), user.getUserAddress(), user.getUserAge(), user.getPassword(),
                user.getUserCntct(),user.getEmail_id());
    }
    public void deleteUser(User user)
    {
        userRepository.deleteUser(user.getEmail_id());
    }


}
