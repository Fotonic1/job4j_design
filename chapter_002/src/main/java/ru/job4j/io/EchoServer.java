package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean ex = false;
            while (!ex) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String msg = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        if (str.contains("msg=")) {
                            msg = str.split("msg=")[1].split(" ")[0];
                        }
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    switch (msg) {
                        case "Hello": out.write("Hello, dear friend.".getBytes());
                        break;
                        case "Exit": ex = true;
                        break;
                        default: out.write(msg.getBytes());
                        break;
                    }
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
