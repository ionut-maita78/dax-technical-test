package org.global.dax.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.global.dax.shared.Properties.PORT;

public class CacheServer {

    private static final Logger LOG = LoggerFactory.getLogger(CacheServer.class);

    private final Map<String, String> cache = new ConcurrentHashMap<>();

    public CacheServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            LOG.info("Cache Server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket, cache).start();
            }
        } catch (IOException e) {
            LOG.error("An error occurred with the message {}", e.getMessage());
        }
    }

    public static void main(String[] args) {
        new CacheServer();
    }
}