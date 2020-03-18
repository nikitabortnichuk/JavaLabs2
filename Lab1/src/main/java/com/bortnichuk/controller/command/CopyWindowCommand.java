package com.bortnichuk.controller.command;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.view.WindowView;

public class CopyWindowCommand extends Command {

    public CopyWindowCommand(WindowView windowView) {
        super(windowView);
    }

    @Override
    public boolean execute() {
        if(view.getCurrentWindow() == null) return false;

        IWindow clonedWindow = view.getCurrentWindow().clone();

        view.setWindowBackUp(clonedWindow);
        return false;
    }
}
