package com.mypack.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class Consumer implements MessageListener {

    Logger logger= LoggerFactory.getLogger(Consumer.class);

    @Override
    public void onMessage(Message message, byte[] pattern) {
        logger.info("consume event {}",message);
    }
}
