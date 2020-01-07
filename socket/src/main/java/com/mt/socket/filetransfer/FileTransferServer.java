package com.mt.socket.filetransfer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: liqm
 * 2019-10-23
 */
public class FileTransferServer {

    private static String path = "/Users/ktjr/Desktop/text.txt";

    private static void createSocket() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);

        Socket socket = null;

        while ((socket = serverSocket.accept()) != null) {

            OutputStream outputStream = socket.getOutputStream();

            File file = new File(path);

            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] b = new byte[1024];

            int length = 0;

            while ((length = fileInputStream.read(b)) != -1) {
                outputStream.write(b,0,length);
            }

            outputStream.flush();

            fileInputStream.close();

            outputStream.close();

            socket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        createSocket();
    }



}
