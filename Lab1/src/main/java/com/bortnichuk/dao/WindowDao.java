package com.bortnichuk.dao;

import com.bortnichuk.model.entity.IWindow;

import java.util.ArrayList;
import java.util.List;

public class WindowDao {

    private List<IWindow> windowList = new ArrayList<>();

    public List<IWindow> getWindowList(){
        return windowList;
    }

    public void addWindow(IWindow window){
        windowList.add(window);
    }

    public void deleteWindow(IWindow window){
        windowList.remove(window);
    }

}
