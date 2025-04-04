package org.global.dax.commands;

import java.io.PrintWriter;
import java.util.Map;

import static org.global.dax.shared.CommandStatus.OK;

public class Delete implements Command {

    @Override
    public void execute(String input, PrintWriter out, Map<String, String> cache) {
        String[] parts = input.split(" ");
        if (parts.length < 2) {
            out.println("DELETE command requires key");
            return;
        }
        String key = parts[1];
        cache.remove(key);
        out.println(OK);
    }
}
