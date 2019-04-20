package org.learing.rabbitmq;

import java.io.IOException;
import java.net.ServerSocket;

public class SimpleHTTPServer{
    public static void main(String[] args)  throws IOException {
        final ServerSocket server = new ServerSocket(5672);
        System.out.println("listening for port 5672 ....");
        while(true){
            // alwasy
        }
    }
}
