package com.jam.brookshearCPU.eventHandlers;

import com.jam.brookshearCPU.BrookshearCPUEmulator;

import javax.swing.event.DocumentEvent;

/**
 * Created by Jack on 02-May-16.
 */
public class DataMemoryCellHandler extends AbstractDataHandler {
    public DataMemoryCellHandler(BrookshearCPUEmulator brookshearCPUEmulator) {
        super(brookshearCPUEmulator);
    }

    @Override
    public void update(DocumentEvent e) {
        if (super.isActive) {
            super.brookshearCPUEmulator.updateCPUMemoryCells((Integer) e.getDocument().getProperty("ID"));
        }
    }
}
