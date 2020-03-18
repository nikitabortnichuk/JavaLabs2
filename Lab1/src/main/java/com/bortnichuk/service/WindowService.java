package com.bortnichuk.service;

import com.bortnichuk.model.entity.IWindow;

import java.util.List;

public interface WindowService {

    List<IWindow> getWindows();

    IWindow save(IWindow window);

    void deleteLast();

}
