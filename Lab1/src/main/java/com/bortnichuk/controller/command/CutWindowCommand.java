package com.bortnichuk.controller.command;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.view.WindowView;

public class CutWindowCommand extends Command {

    public CutWindowCommand(WindowView windowView) {
        super(windowView);
    }

    @Override
    public boolean execute() {
        if(view.getCurrentWindow() == null) return false;

        backup();

        IWindow clonedWindow = view.getCurrentWindow().clone();
        view.setWindowBackUp(clonedWindow);

        view.deleteLastWindow();

        return true;
    }
}
