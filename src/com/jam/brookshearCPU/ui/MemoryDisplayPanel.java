package com.jam.brookshearCPU.ui;

import com.jam.brookshearCPU.util.Hex;

import javax.swing.*;
import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;

/**
 * Created by Jack on 29-Apr-16.
 */
public class MemoryDisplayPanel extends JPanel {
    private String labelPrefix;
    private JTextField[] fieldList;

    public MemoryDisplayPanel(String label, int nFields) {
        this.labelPrefix = label + " ";
        this.fieldList = new JTextField[nFields];
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (int i = 0; i < nFields; i++) {
            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(6, 3, 3, 3));
            panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

            JLabel lblField = new JLabel(this.labelPrefix + "0x" + Hex.toHex((byte) i));
            this.fieldList[i] = new JTextField(6);
            panel.add(lblField);
            panel.add(Box.createHorizontalStrut(6));
            panel.add(this.fieldList[i]);
            this.add(panel);
        }
    }

    public void clear(String str) {
        for (JTextField field : fieldList) {
            field.setText(str);
        }
    }

    public void set(int index, String str) {
        this.fieldList[index].setText(str);
    }

    public void set(byte[] byteArray) {
        byte[] b = new byte[1];
        for (int i = 0; i < byteArray.length && i < this.fieldList.length; i++) {
            this.set(i, Hex.toHex(byteArray[i]));
        }
    }

    public JTextField[] getFields() {
        return this.fieldList;
    }
}
