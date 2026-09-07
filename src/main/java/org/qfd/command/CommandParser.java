package org.qfd.command;

import org.qfd.exception.InvalidInputException;

public class CommandParser {

    public DatabaseCommand parse(String rawInput) throws InvalidInputException {
        if (rawInput == null || rawInput.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }

        // Split input by spaces (e.g., "SET name bob" becomes ["SET", "name", "bob"])
        String[] tokens = rawInput.trim().split("\\s+");
        String action = tokens[0].toUpperCase();
        return switch (action) {
            case "SET" -> {
                if (tokens.length < 3) {
                    throw new IllegalArgumentException("ERR: SET requires a key and a value.");
                }
                // Return a new instance of the specific subclass
                yield new SetCommand(tokens[1], tokens[2]);
                // Return a new instance of the specific subclass
            }
            case "GET" -> {
                if (tokens.length < 2) {
                    throw new IllegalArgumentException("ERR: GET requires a key.");
                }
                yield new GetCommand(tokens[1]);
            }
            case "DELETE" -> {
                if (tokens.length < 2) {
                    throw new IllegalArgumentException("ERR: DELETE requires a key.");
                }
                yield new DeleteCommand(tokens[1]);
            }
            default -> throw new InvalidInputException();
        };
    }

}
