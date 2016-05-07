package com.jam.brookshearCPU.eventHandlers;

import com.jam.brookshearCPU.BrookshearCPUEmulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 02-May-16.
 */
public class AbstractMenuItemHandler implements ActionListener {
    protected BrookshearCPUEmulator brookshearCPUEmulator;

    public AbstractMenuItemHandler(BrookshearCPUEmulator brookshearCPUEmulator) {
        this.brookshearCPUEmulator = brookshearCPUEmulator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!(e.getSource() instanceof JMenuItem)) {
            throw new UnsupportedOperationException("Type AbstractMenuItemHandler can only handle action events from JMenuItem sources.");
        }
    }
}
