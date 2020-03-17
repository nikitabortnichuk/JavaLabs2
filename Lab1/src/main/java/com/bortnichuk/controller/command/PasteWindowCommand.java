package com.bortnichuk.controller.command;

import com.bortnichuk.view.WindowView;

public class PasteWindowCommand extends Command {

    public PasteWindowCommand(WindowView windowView) {
        super(windowView);
    }

    @Override
    public boolean execute() {
        if(view.getWindowBackUp() == null) return false;

        backup();
        view.saveWindow(view.getWindowBackUp());

        return true;
    }
}
