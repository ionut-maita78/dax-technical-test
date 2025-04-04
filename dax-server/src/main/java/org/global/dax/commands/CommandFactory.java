package org.global.dax.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static final Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("GET", new Get());
        commands.put("ADD", new Add());
        commands.put("DELETE", new Delete());
        commands.put("HEARTBEAT", new Heartbeat());
        commands.put("UNKNOWN", new Unknown());
    }

    public static Command createCommand(String input) {
        String[] parts = input.split(" ");
        String commandName = parts[0].toUpperCase();
        return commands.getOrDefault(commandName, commands.get("UNKNOWN"));
    }
}