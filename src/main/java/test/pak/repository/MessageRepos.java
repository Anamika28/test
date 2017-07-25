package test.pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import test.pak.dao.Messages;
import test.pak.dao.User;

/**
 * Created by anamika on 11/7/17.
 */

public interface MessageRepos extends JpaRepository<Messages, String> {

  //@Query(value = "insert into Messages(sender_email, receiver_email,message) values (('sender_email', (select email_id from users where status = true)),('receiver_email', (select email_id from users where status = true)),(':message'))")
  //void sendMessage(String sender_email, String receiver_email, String message);

    @Query(value = "select u.status from User u where u.email_id = :email_id")
    Boolean findStatus(@Param("email_id") String email);

}
