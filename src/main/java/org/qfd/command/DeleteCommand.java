package org.qfd.command;

import org.qfd.engine.MainStorage;

public class DeleteCommand implements DatabaseCommand{
    private final String key;
    public DeleteCommand(String key) {
        this.key = key;
    }
    @Override
    public void execute(MainStorage storage) {
        storage.delete(key);
    }
}
