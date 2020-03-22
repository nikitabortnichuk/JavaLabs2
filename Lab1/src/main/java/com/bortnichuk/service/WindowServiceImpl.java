package com.bortnichuk.service;

import com.bortnichuk.controller.WindowController;
import com.bortnichuk.dao.WindowDao;
import com.bortnichuk.model.entity.IWindow;
import com.bortnichuk.model.entity.TextWindow;
import lombok.Setter;

import java.util.List;

public class WindowServiceImpl implements WindowService {

    private WindowDao windowDao;

    public WindowServiceImpl() {
        windowDao = new WindowDao();
    }

    public WindowServiceImpl(WindowDao windowDao) {
        this.windowDao = windowDao;
    }

    public List<IWindow> getWindows() {
        return windowDao.getWindowList();
    }

    public IWindow save(IWindow window) {
        windowDao.addWindow(window);
        return window;
    }

    public void deleteLast() {
        List<IWindow> windowList = windowDao.getWindowList();
        if (windowList.isEmpty()) {
            throw new RuntimeException("There is no windows");
        } else {
            windowList.remove(windowList.size() - 1);
        }
    }
}
