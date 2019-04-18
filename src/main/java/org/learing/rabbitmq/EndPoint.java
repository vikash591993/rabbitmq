package org.learing.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
/**
 * Represents a connection with queue
 * this will be common with both Producer and Consumer
 */
public abstract class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endPointName) throws IOException{
        this.endPointName = endPointName;
        //Create connection factory
        ConnectionFactory factory = new ConnectionFactory();
        // hostname of your rabbit mq server
        factory.setHost("127.0.0.1");
        factory.setPort(17001);

        // getting a connection
        connection = factory.newConnection();

        // creating a channel
        channel = connection.createChannel();
        // declaring a queue for this channel. If queue does not exist, It will be created on the server.
        channel.queueDeclare(endPointName, false, false, false,null);
    }

    /**
     * Close channel and connection. Not necessary as it happens implicitly.
     * @throws IOException
     */
    public void close() throws IOException{
        this.channel.close();
        this.connection.close();
    }

}