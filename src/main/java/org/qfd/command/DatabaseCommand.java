package org.qfd.command;

import org.qfd.engine.MainStorage;

public interface DatabaseCommand {
    void execute(MainStorage storage);
}
