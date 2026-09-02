package org.qfd.command;

import org.qfd.engine.MainStorage;

public class GetCommand implements DatabaseCommand{
    private final String key;
    public GetCommand(String key) {
        this.key = key;
    }
    @Override
    public void execute(MainStorage storage) {
        storage.get(key);
    }
}
