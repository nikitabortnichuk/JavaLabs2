package com.bortnichuk.controller.command;

import com.bortnichuk.view.WindowView;

public class CutWindowCommand extends Command {

    public CutWindowCommand(WindowView windowView) {
        super(windowView);
    }

    @Override
    public boolean execute() {
        if(view.getCurrentWindow() == null) return false;

        backup();
        view.setWindowBackUp(view.getCurrentWindow());
        view.deleteLastWindow();

        return true;
    }
}
