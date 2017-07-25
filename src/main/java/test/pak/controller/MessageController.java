package test.pak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.pak.dao.Messages;
import test.pak.service.MainService;
import test.pak.service.MessageService;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import static com.sun.org.apache.xml.internal.serializer.utils.Utils.messages;
import static test.pak.service.MessageService.*;

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
