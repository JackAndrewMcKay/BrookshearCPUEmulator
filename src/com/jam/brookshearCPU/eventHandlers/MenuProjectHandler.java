package com.jam.brookshearCPU.eventHandlers;

import com.jam.brookshearCPU.BrookshearCPUEmulator;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by Jack on 02-May-16.
 */
public class MenuProjectHandler extends AbstractMenuItemHandler {
    public MenuProjectHandler(BrookshearCPUEmulator brookshearCPUEmulator) {
        super(brookshearCPUEmulator);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        JMenuItem item = (JMenuItem)e.getSource();

        switch (item.getText()) {
            case "Load":
                break;
            case "Run":
                super.brookshearCPUEmulator.getCPU().run();

                while (super.brookshearCPUEmulator.getCPU().isRunning()) {
                    super.brookshearCPUEmulator.getCPU().executeInstruction();
                    super.brookshearCPUEmulator.updateView();
                }
                break;
        }
    }
}
