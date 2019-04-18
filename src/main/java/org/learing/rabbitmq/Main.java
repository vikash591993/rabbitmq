package org.learing.rabbitmq;

import java.util.HashMap;

public class Main {
    public Main() throws Exception{
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThred = new Thread(consumer);
        consumerThred.start();

        Producer producer = new Producer("queue");
        for(int i=0;i<100000;i++){
            HashMap message = new HashMap();
            message.put("message numeber", i);
            producer.sendMessage(message);
            System.out.println(" Message Number " + i + " sent.");
        }

    }

    public static void main(String[] args) throws Exception{
        new Main();
    }
}
