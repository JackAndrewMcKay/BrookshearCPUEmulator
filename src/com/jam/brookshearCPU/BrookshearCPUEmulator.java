package com.jam.brookshearCPU;

import com.jam.brookshearCPU.eventHandlers.*;
import com.jam.brookshearCPU.interpreter.BrookshearCPU;
import com.jam.brookshearCPU.ui.UI;

import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 02-May-16.
 */
public class BrookshearCPUEmulator {
    private UI ui;
    private BrookshearCPU cpu;
    private MenuFileHandler menuFileHandler;
    private MenuEditHandler menuEditHandler;
    private MenuProjectHandler menuProjectHandler;
    private DataMemoryCellHandler dataMemoryCellHandler;
    private DataRegisterHandler dataRegisterHandler;
    private DataSpecialHandler dataSpecialHandler;

    public BrookshearCPUEmulator(UI ui, BrookshearCPU cpu) {
        this.ui = ui;
        this.cpu = cpu;
        this.ui.registerListeners(this);
        this.updateView();
    }

    public void updateView() {
        this.enabledDocumentListeners(false);
        this.ui.loadMemory(this.cpu.readMemory());
        this.ui.loadRegisters(this.cpu.readRegisters());
        this.ui.loadIR(this.cpu.readIR());
        this.ui.loadPC(this.cpu.readPC());
        this.enabledDocumentListeners(true);
    }

    public void updateCPURegisters(Integer i) {
        this.cpu.writeRegisters(i, this.ui.getRegister(i));
    }

    public void updateCPUMemoryCells(Integer i) {
        this.cpu.writeMemory(i, this.ui.getMemoryCell(i));
    }

    public void updateSpecialRegisters() {
        this.cpu.writeIR(this.ui.getIR());
        this.cpu.writePC(this.ui.getPC());
    }

    public ActionListener getMenuFileHandler() {
        if (this.menuFileHandler == null) {
            this.menuFileHandler = new MenuFileHandler(this);
        }

        return this.menuFileHandler;
    }

    public ActionListener getMenuEditHandler() {
        if (this.menuEditHandler == null) {
            this.menuEditHandler = new MenuEditHandler(this);
        }

        return this.menuEditHandler;
    }

    public ActionListener getMenuProjectHandler() {
        if (this.menuProjectHandler == null) {
            this.menuProjectHandler = new MenuProjectHandler(this);
        }

        return this.menuProjectHandler;
    }

    public DocumentListener getDataMemoryCellHandler() {
        if (this.dataMemoryCellHandler == null) {
            this.dataMemoryCellHandler = new DataMemoryCellHandler(this);
        }

        return this.dataMemoryCellHandler;
    }

    public DocumentListener getDataRegisterHandler() {
        if (this.dataRegisterHandler == null) {
            this.dataRegisterHandler = new DataRegisterHandler(this);
        }

        return this.dataRegisterHandler;
    }

    public DocumentListener getDataSpecialHandler() {
        if (this.dataSpecialHandler == null) {
            this.dataSpecialHandler = new DataSpecialHandler(this);
        }

        return this.dataSpecialHandler;
    }

    public BrookshearCPU getCPU() {
        return this.cpu;
    }

    public UI getUI() {
        return this.ui;
    }

    public void enabledDocumentListeners(boolean isActive) {
        this.dataMemoryCellHandler.setActive(isActive);
        this.dataRegisterHandler.setActive(isActive);
        this.dataSpecialHandler.setActive(isActive);
    }
}
