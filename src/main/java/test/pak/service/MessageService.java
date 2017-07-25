package test.pak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import test.pak.dao.Messages;
import test.pak.repository.MessageRepos;
import test.pak.repository.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;


@Service
public class MessageService {

    @Autowired
    private MessageRepos messageRepos;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity saveMessage(ArrayList<Messages> msg)
    {
        Iterator itr = msg.iterator();

        while(itr.hasNext())
        {
            Messages m = (Messages)itr.next();
            Boolean sStatus = messageRepos.findStatus(m.getSenderEmail());
            Boolean rStatus = messageRepos.findStatus(m.getReceiverEemail());

            if(sStatus== null)
                return new ResponseEntity<java.lang.String>("sender does not exist", HttpStatus.BAD_REQUEST);

            else if(rStatus==null)
                return new ResponseEntity("receiver does not exist", HttpStatus.BAD_REQUEST);

            else if(sStatus==false || rStatus==false)
            {
                return new ResponseEntity("sender or receiver does not exist", HttpStatus.BAD_REQUEST);
            }
            messageRepos.save(m);
        }
        return new ResponseEntity("successfully saved", HttpStatus.OK);
    }

}
