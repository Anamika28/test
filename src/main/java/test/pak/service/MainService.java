package test.pak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import test.pak.dao.User;
import test.pak.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anamika on 10/7/17.
 */
@Component
public class MainService {

    @Autowired
    private UserRepository userRepository;

    public List<test.pak.dao.User> findAllData()
    {
        List<test.pak.dao.User> userList =  userRepository.findAllUsers();
        return userList;
    }

    public void saveUsers(User userTemp) {
        userRepository.saveUser(userTemp.getEmail_id(), userTemp.getPassword(), userTemp.getUserAddress(), userTemp.getUserAge(), userTemp.getUserCntct(), userTemp.getUserName());
    }

    public void editUser(User user) {
//        String userName, String userAddress, String userAge, String password, String userCntct, String emailId
        userRepository.EditUser(user.getUserName(), user.getUserAddress(), user.getUserAge(), user.getPassword(),
                user.getUserCntct(),user.getEmail_id());
    }

}
