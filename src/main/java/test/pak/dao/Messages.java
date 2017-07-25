package test.pak.dao;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by anamika on 11/7/17.
 */

@Component
@Entity
@Table(name = "messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @JoinColumn(name = "")
    @Column(name = "sender_email")
    private String senderEmail;

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    @Column(name = "receiver_email")
    private String receiverEmail;

    public String getReceiverEemail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiver_email) {
        this.receiverEmail = receiverEmail;
    }
    @Column(name = "message")
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
