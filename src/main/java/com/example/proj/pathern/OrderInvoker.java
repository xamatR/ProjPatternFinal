package com.example.proj.pathern;

import java.util.ArrayList;
import java.util.List;

// Command Pattern: Encapsulates order actions (placing or canceling an order) as command objects, which can be executed by an invoker.
public class OrderInvoker {
    private List<OrderCommand> commandHistory = new ArrayList<>();

    public String executeCommand(OrderCommand command) {
        String result = command.execute();
        commandHistory.add(command);
        return result;
    }
}

