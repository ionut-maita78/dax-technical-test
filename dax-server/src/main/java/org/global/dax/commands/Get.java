package org.global.dax.commands;

import java.io.PrintWriter;
import java.util.Map;

import static org.global.dax.shared.CommandStatus.NOT_FOUND;

public class Get implements Command {

    @Override
    public void execute(String input, PrintWriter out, Map<String, String> cache) {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            if (cache.isEmpty()) {
                out.println(NOT_FOUND);
            } else {
                out.println("FIRST LINE");
                out.println("SECOND LINE");
                cache.forEach((key, value) -> out.println(key + ": " + value));
            }
            return;
        }
        String key = parts[1];
        out.println(cache.getOrDefault(key, NOT_FOUND.label));
    }
}
