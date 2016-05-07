package com.jam.brookshearCPU.eventHandlers;

import com.jam.brookshearCPU.BrookshearCPUEmulator;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


/**
 * Created by Jack on 02-May-16.
 */
public abstract class AbstractDataHandler implements DocumentListener {
    protected BrookshearCPUEmulator brookshearCPUEmulator;

    public void setActive(boolean active) {
        this.isActive = active;
    }

    protected boolean isActive;

    public AbstractDataHandler(BrookshearCPUEmulator brookshearCPUEmulator) {
        this.brookshearCPUEmulator = brookshearCPUEmulator;
        this.isActive = true;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.update(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.update(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.update(e);

    }

    public abstract void update(DocumentEvent e);
}
