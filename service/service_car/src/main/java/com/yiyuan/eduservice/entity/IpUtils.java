package com.yiyuan.eduservice.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class IpUtils {

    @Value("${server.port}")
    private int serverPort;


    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return "http://"+address.getHostAddress() +":"+this.serverPort;
    }
}
