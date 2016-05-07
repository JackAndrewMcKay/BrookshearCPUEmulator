package com.jam.brookshearCPU;

import com.jam.brookshearCPU.interpreter.BrookshearCPU;
import com.jam.brookshearCPU.ui.UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jack on 29-Apr-16.
 */
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.err.println("Error selecting UI look and feel.");
        }

        Runnable graphicsThread = new Runnable() {
            public void run() {
                UI ui = new UI();
                BrookshearCPU cpu = new BrookshearCPU();
                BrookshearCPUEmulator emulator = new BrookshearCPUEmulator(ui, cpu);
            }
        };

        EventQueue.invokeLater(graphicsThread);
    }
}
