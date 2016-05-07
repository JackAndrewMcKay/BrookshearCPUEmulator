package com.jam.brookshearCPU.eventHandlers;

import com.jam.brookshearCPU.BrookshearCPUEmulator;

import javax.swing.event.DocumentEvent;

/**
 * Created by Jack on 07-May-16.
 */
public class DataSpecialHandler extends AbstractDataHandler {
    public DataSpecialHandler(BrookshearCPUEmulator brookshearCPUEmulator) {
        super(brookshearCPUEmulator);
    }

    @Override
    public void update(DocumentEvent e) {
        if (super.isActive) {
            super.brookshearCPUEmulator.updateSpecialRegisters();
        }
    }
}

