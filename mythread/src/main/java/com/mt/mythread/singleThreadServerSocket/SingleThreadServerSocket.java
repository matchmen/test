package com.mt.mythread.singleThreadServerSocket;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * author: liqm
 * 2019-10-16
 */
public class SingleThreadServerSocket {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(80);

        serverSocket.accept();


    }


}
