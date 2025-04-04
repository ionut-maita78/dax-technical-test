package org.global.dax.server;

import org.global.dax.commands.Command;
import org.global.dax.commands.CommandFactory;
import org.global.dax.shared.CacheException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

public class ClientHandler extends Thread {
    private Socket socket;
    private Map<String, String> cache;

    public ClientHandler(Socket socket, Map<String, String> cache) {
        this.socket = socket;
        this.cache = cache;
    }

    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                Command command = CommandFactory.createCommand(inputLine);
                command.execute(inputLine, out, cache);
            }
        } catch (IOException e) {
            throw new CacheException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
