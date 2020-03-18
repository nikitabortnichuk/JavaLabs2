package com.bortnichuk.controller.command;

import com.bortnichuk.view.WindowView;

public class CopyWindowCommand extends Command {

    public CopyWindowCommand(WindowView windowView) {
        super(windowView);
    }

    @Override
    public boolean execute() {
        if(view.getCurrentWindow() == null) return false;

        view.setWindowBackUp(view.getCurrentWindow());
        return false;
    }
}
