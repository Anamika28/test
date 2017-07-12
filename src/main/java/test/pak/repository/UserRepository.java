package test.pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.pak.dao.User;

import java.util.List;

/**
 * Created by anamika on 8/7/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select u from User u")
    List<User> findAllUsers();

    @Query(value = "select u from User u where email = ?1")
    User findByEmail(String email);

    //User findByUserId(Integer userId);

    //@Query(value = "insert into Messages(sender_email, receiver_email, message)")
    //void sendMessage(String sender_email, String receiver_email, String message);

    /*@Query(value = "update User user_name = userName where email_id = emailId")
    void EditUserName(String userName, String emailId);

    @Query(value = "update User user_addr = userAddress where email_id = emailId")
    public void EditUserAddress(String userAddress, String emailId);

    @Query(value = "update User user_cntct = userCntct where email_id = emailId")
    public void EditUserCntct(Integer userCntct, String emailId);

    @Query(value = "update User password = password where email_id = emailId")
    public void EditUserPassword(String password, String emailId);

    @Query(value = "update User user_age = age where email_id = emailId")
    public void EditUserAge(Integer age, String emailId);*/

    @Query(value = "update User SET user_name = userName, user_addr = userAddress, user_cntct = userCntct, password = password, user_age = userAge, where email_id = emailId")
    void EditUser(String userName, String userAddress, Integer userAge, String password, Integer userCntct, String emailId);

    //userTemp.getEmail_id(), userTemp.getPassword(), userTemp.getUserAddress(), userTemp.getUserAge(), userTemp.getUserCntct(), userTemp.getUserName()
    @Query(value = "insert into User(email_id, password, user_address, user_age, user_cntct, user_name)values('email_id', 'password', 'user_address', 'user_age', 'user_cntct', 'user_name'))";
    void saveUser(String emailId, String password, Integer userAddress, String userAge, Integer userCntct, String userName);
}
