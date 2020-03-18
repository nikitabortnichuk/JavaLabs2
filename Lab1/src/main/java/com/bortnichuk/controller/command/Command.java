package com.bortnichuk.controller.command;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.view.WindowView;

public abstract class Command {

    public WindowView view;

    private IWindow backup;

    public Command(WindowView windowView){
        this.view = windowView;
    }

    void backup(){
        backup = view.getWindowBackUp();
    }

    public void undo(){
        view.setWindowBackUp(backup);
    }

    public abstract boolean execute();

}
