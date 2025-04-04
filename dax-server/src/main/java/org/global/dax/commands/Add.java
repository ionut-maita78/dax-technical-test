package org.global.dax.commands;

import java.io.PrintWriter;
import java.util.Map;

import static org.global.dax.shared.CommandStatus.OK;

public class Add implements Command {

    @Override
    public void execute(String input, PrintWriter out, Map<String, String> cache) {
        String[] parts = input.split(" ");
        if (parts.length < 3) {
            out.println("ADD command requires key and value");
            return;
        }
        String key = parts[1];
        String value = parts[2];
        cache.put(key, value);
        out.println(OK);
    }
}
