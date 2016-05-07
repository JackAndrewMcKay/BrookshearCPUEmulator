package com.jam.brookshearCPU.eventHandlers;

import com.jam.brookshearCPU.BrookshearCPUEmulator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Jack on 02-May-16.
 */
public class MenuFileHandler extends AbstractMenuItemHandler {
    public MenuFileHandler(BrookshearCPUEmulator brookshearCPUEmulator) {
        super(brookshearCPUEmulator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        JMenuItem item = (JMenuItem)e.getSource();

        switch (item.getText()) {
            case "New":
                break;
            case "Open":
                break;
            case "Save":
                break;
            case "Exit":
                break;
        }
    }
}