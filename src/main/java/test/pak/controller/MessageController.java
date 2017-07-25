package test.pak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.pak.dao.Messages;
import test.pak.service.MessageService;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by anamika on 11/7/17.
 */

@RestController
@RequestMapping("/api1")
public class MessageController implements Serializable {

    //ArrayList<Messages> msg = new ArrayList<Messages>();

    @Autowired
    public MessageService messageService;

    @RequestMapping(value ="/send_message", method = RequestMethod.POST)
    public ResponseEntity sendMessage(@RequestBody ArrayList<Messages> msg)
    {
        ResponseEntity<String> obj;
        obj = messageService.saveMessage(msg);
        return obj;
    }

}
