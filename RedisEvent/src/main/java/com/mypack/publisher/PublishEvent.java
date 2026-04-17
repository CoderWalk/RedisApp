package com.mypack.publisher;

import com.mypack.DTO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishEvent {

    @Autowired
    RedisTemplate<String ,Object> template;

    @Autowired
    ChannelTopic topic;


    @PostMapping("/publish")
    public String send(@RequestBody Product product){
        template.convertAndSend(topic.getTopic(),product.toString());
        return "Event published...!";
    }
}
