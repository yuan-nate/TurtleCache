package org.qfd;

import org.qfd.command.CommandParser;
import org.qfd.engine.MainStorage;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting QFD In-Memory Database Server ---");

        // 1. Initialize the core singletons/dependencies
        MainStorage storage = new MainStorage();
        CommandParser parser = new CommandParser();

        // 2. Inject the dependencies into your application orchestrator (the runner)
        ConsoleRunner runner = new ConsoleRunner(storage, parser);

        // 3. Hand control over to the runner to start the infinite lifecycle loop
        runner.start();
    }
}