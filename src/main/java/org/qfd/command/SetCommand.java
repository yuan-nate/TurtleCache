package org.qfd.command;

import org.qfd.engine.MainStorage;

public class SetCommand implements DatabaseCommand {
    private MainStorage storage;
    private final String firstToken;
    private final String secondToken;
    public SetCommand(String firstToken, String secondToken) {
        this.firstToken = firstToken;
        this.secondToken = secondToken;
    }

    @Override
    public void execute(MainStorage storage) {
        storage.set(firstToken, secondToken);
    }
}
