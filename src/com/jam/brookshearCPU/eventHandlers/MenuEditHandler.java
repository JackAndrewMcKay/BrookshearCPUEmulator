package com.jam.brookshearCPU.eventHandlers;

import com.jam.brookshearCPU.BrookshearCPUEmulator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Jack on 02-May-16.
 */
public class MenuEditHandler extends AbstractMenuItemHandler {
    public MenuEditHandler(BrookshearCPUEmulator brookshearCPUEmulator) {
        super(brookshearCPUEmulator);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        JMenuItem item = (JMenuItem)e.getSource();

        switch (item.getText()) {
            case "Cut":
                break;
            case "Copy":
                break;
            case "Paste":
                break;
        }
    }
}
