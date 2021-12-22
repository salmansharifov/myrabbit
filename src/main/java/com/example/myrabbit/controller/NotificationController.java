package com.example.myrabbit.controller;

import com.example.myrabbit.produce.NotificationProducer;
import com.example.myrabbit.rabbit.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationProducer producer;

    @PostMapping("/")
    public void send(@RequestBody Notification text){
        for (int i = 0; i < 5; i++) {
            Notification notification = new Notification(
                    UUID.randomUUID().toString(),
                    text.getText() + ":" + i ,
                    LocalDate.now(),
                    false);
            producer.sendToMq(notification);
        //    log.info("message : " + notification.getText());
        }
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllMessages(){
        return ResponseEntity.ok("");
    }

}
