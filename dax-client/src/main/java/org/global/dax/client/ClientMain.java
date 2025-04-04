package org.global.dax.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;

import static org.global.dax.shared.Properties.PORT;
import static org.global.dax.shared.Properties.SERVER_ADDRESS;

public final class ClientMain {

    private static final Logger LOG = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) {

        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            String userCommand;
            String response;
            System.out.println("Enter commands (ADD key value OR GET key):");
            while ((userCommand = userInput.readLine()) != null) {
                out.println(userCommand);
                response = in.readLine();
                System.out.println(response);
            }
        } catch (IOException e) {
            LOG.info("An error occured: {}", e.getMessage());
        }
    }
}
