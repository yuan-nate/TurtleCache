package org.qfd;

import org.qfd.command.CommandParser;
import org.qfd.command.DatabaseCommand;
import org.qfd.engine.MainStorage;
import org.qfd.exception.InvalidInputException;

import java.util.Scanner;

public class ConsoleRunner {
    private final MainStorage storage;
    private final CommandParser parser;;

    public ConsoleRunner(MainStorage mainStorage, CommandParser commandParser) {
        this.storage = mainStorage;
        this.parser = commandParser;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- QFD In-Memory Database Server Initialized ---");
        System.out.println("Available commands: SET <key> <value>, GET <key>, exit");

        while (true) {
            System.out.print("qfd-db> ");
            String input = scanner.nextLine();

            // Handle clean application exit early
            if (input == null || "exit".equalsIgnoreCase(input.trim())) {
                System.out.println("Shutting down database engine. Goodbye.");
                break;
            }

            // Skip processing empty keystrokes or raw spaces cleanly
            if (input.trim().isEmpty()) {
                continue;
            }

            try {
                // 1. Translate raw console string to a Command Object via Parser Dependency
                DatabaseCommand command = parser.parse(input);

                // 2. Execute the polymorphic command object using the Storage Dependency
                command.execute(this.storage);

                // 3. Render the exact output message back to the terminal screen
                //System.out.println(response);

            } catch (IllegalArgumentException e) {
                // Catches missing command arguments or bad parser syntax
                System.out.println(e.getMessage());
            } catch (Exception e) {
                if(e instanceof InvalidInputException) {
                  System.out.println(e.getMessage());
                }
                // Safe catch-all fallback to keep the terminal loop from crashing
                System.out.println("ERR: Internal system error: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
