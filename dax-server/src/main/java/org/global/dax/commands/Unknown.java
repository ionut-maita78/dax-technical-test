package org.global.dax.commands;

import java.io.PrintWriter;
import java.util.Map;

import static org.global.dax.shared.CommandStatus.UNKNOWN;

public class Unknown implements Command {

    @Override
    public void execute(String input, PrintWriter out, Map<String, String> cache) {
        out.println(UNKNOWN);
    }
}
