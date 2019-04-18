package org.learing.rabbitmq;

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * The producer endpoint that writes to the queue
 */
public class Producer extends EndPoint{
    public Producer(String endPoint) throws IOException{
        super(endPoint);
    }
    public void sendMessage(Serializable object) throws IOException{
        channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));
    }
}
