package com.bortnichuk.service.proxy;

import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.service.WindowService;
import com.bortnichuk.service.WindowServiceImpl;

import java.util.List;

public class Proxy implements WindowService {

    WindowService windowService = new WindowServiceImpl();

    @Override
    public List<IWindow> getWindows() {
        System.out.println("Extracting data...");
        List<IWindow> windows =  windowService.getWindows();
        System.out.println(windows.size() + " elements of WindowList extracted.");
        return windows;
    }

    @Override
    public IWindow save(IWindow window) {
        System.out.println("Trying to add new Window...");
        window = windowService.save(window);
        System.out.println("Window was added successfully.");
        return window;
    }

    @Override
    public void deleteLast() {
        System.out.println("Deleting last added Window...");
        windowService.deleteLast();
        System.out.println("Window was deleted successfully.");
    }
}
