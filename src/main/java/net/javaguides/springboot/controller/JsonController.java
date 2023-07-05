package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.JsonKafkaProducer;
import net.javaguides.springboot.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonController {

    private JsonKafkaProducer KafkaProducer;

    public JsonController(JsonKafkaProducer KafkaProducer) {
        this.KafkaProducer = KafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        KafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
