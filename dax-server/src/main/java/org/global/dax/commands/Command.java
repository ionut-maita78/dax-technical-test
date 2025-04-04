package org.global.dax.commands;

import java.io.PrintWriter;
import java.util.Map;

public interface Command {
    void execute(String input, PrintWriter out, Map<String, String> cache);
}
