package com.mt.socket.stringtransfer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: liqm
 * 2019-10-23
 */
public class SocketServer {

    private static void createSocket() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);

        Socket socket = null;

        while ((socket = serverSocket.accept()) != null) {

            InputStream inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String receiveMsg = "";

            String returnMsg = "";

            System.out.println("开始接收报文:");

            while ((receiveMsg = bufferedReader.readLine()) != null) {

                returnMsg += receiveMsg;

                System.out.println(Thread.currentThread().getName() + "-》receiveMsg:" + receiveMsg);
            }

            System.out.println("接收报文信息完成.");

            OutputStream outputStream = socket.getOutputStream();

            PrintWriter printWriter = new PrintWriter(outputStream);

            printWriter.println("已成功收到请求！" + returnMsg);

            printWriter.flush();

            socket.shutdownOutput();

            printWriter.close();

            outputStream.close();

            bufferedReader.close();

            inputStream.close();

            socket.close();
        }

    }

    public static void main(String[] args) throws IOException {
        createSocket();

    }


}
