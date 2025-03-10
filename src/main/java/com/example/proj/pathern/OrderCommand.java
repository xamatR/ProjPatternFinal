package com.example.proj.pathern;
// Command Pattern: Encapsulates order actions (placing or canceling an order) as command objects, which can be executed by an invoker.

public interface OrderCommand {
    String execute();
}
