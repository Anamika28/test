package test.pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.pak.dao.Messages;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by anamika on 11/7/17.
 */
public interface MessageRepos extends JpaRepository<Messages, String> {

  @Query(value = "insert into Messages(sender_email, receiver_email,message) values (('test', (select email_id from users where status = true)),('test', (select email_id from users where status = true)),('hi'))")
  void sendMessage(String email_id, String sender_email, String receiver_email, String message);
}
