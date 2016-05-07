package com.jam.brookshearCPU.ui;

import com.jam.brookshearCPU.BrookshearCPUEmulator;
import com.jam.brookshearCPU.interpreter.InterpreterMode;
import com.jam.brookshearCPU.util.Hex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Jack on 29-Apr-16.
 */
public class UI {
    //public static variables
    public static final String APP_TITLE = "Brookshear CPU Emulator";
    public static final Dimension APP_SIZE = new Dimension(1000, 600);

    //file handling
    private final JFileChooser fileSelector = new JFileChooser();

    //window specific components
    private JFrame window;
    private JPanel container;

    //menu bar specific components
    private JMenuBar menu;

    private JMenu menuFile;
    private JMenuItem menuItemNew;
    private JMenuItem menuItemOpen;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemExit;

    private JMenu menuEdit;
    private JMenuItem menuItemCut;
    private JMenuItem menuItemCopy;
    private JMenuItem menuItemPaste;

    private JMenu menuProject;
    private JMenuItem menuItemLoad;
    private JMenuItem menuItemRun;

    //option panel specific components
    private JPanel panelOptions;
    private JLabel lblMode;
    private JComboBox<InterpreterMode> comboMode;

    //editor panel specific components
    private JPanel panelEditor;
    private JTextArea txtEditor;
    private JScrollPane scrollEditor;

    //data panel specific components
    private JPanel panelData;
    private MemoryDisplayPanel panelMem;
    private MemoryDisplayPanel panelReg;
    private JScrollPane scrollMem;
    private JScrollPane scrollReg;

    private JLabel lblIR;
    private JTextField fieldIR;
    private JLabel lblPC;
    private JTextField fieldPC;

    public UI() {
        this.init();
        this.addComponents();
        this.window.setVisible(true);
    }

    private void init() {
        this.window = new JFrame();
        this.window.setSize(UI.APP_SIZE);
        this.window.setMinimumSize((UI.APP_SIZE));
        this.window.setResizable(true);
        this.window.setLocationRelativeTo(null);
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setTitle(UI.APP_TITLE);
    }

    private void addComponents() {
        this.container = new JPanel();
        this.container.setLayout(new BoxLayout(this.container, BoxLayout.Y_AXIS));
        this.container.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        this.addMenu();
        this.addOptionsPanel();
        this.addEditorPanel();
        this.addDataPanel();

        this.window.setContentPane(this.container);
    }

    private void addMenu() {
        this.menu = new JMenuBar();

        this.menuFile = new JMenu("File");
        this.menuFile.setMnemonic(KeyEvent.VK_F);
        this.menu.add(this.menuFile);

        this.menuItemNew = new JMenuItem("New", KeyEvent.VK_N);
        this.menuItemOpen = new JMenuItem("Open", KeyEvent.VK_O);
        this.menuItemSave = new JMenuItem("Save", KeyEvent.VK_S);
        this.menuItemExit = new JMenuItem("Exit", KeyEvent.VK_ESCAPE);

        this.menuFile.add(this.menuItemNew);
        this.menuFile.add(this.menuItemOpen);
        this.menuFile.add(this.menuItemSave);
        this.menuFile.add(this.menuItemExit);

        this.menuEdit = new JMenu("Edit");
        this.menuEdit.setMnemonic(KeyEvent.VK_E);
        this.menu.add(this.menuEdit);

        this.menuItemCut = new JMenuItem("Cut", KeyEvent.VK_X);
        this.menuItemCopy = new JMenuItem("Copy", KeyEvent.VK_C);
        this.menuItemPaste = new JMenuItem("Paste", KeyEvent.VK_V);

        this.menuEdit.add(this.menuItemCut);
        this.menuEdit.add(this.menuItemCopy);
        this.menuEdit.add(this.menuItemPaste);

        this.menuProject = new JMenu("Project");
        this.menuProject.setMnemonic(KeyEvent.VK_P);
        this.menu.add(this.menuProject);

        this.menuItemLoad = new JMenuItem("Load", KeyEvent.VK_L);
        this.menuItemRun = new JMenuItem("Run", KeyEvent.VK_R);

        this.menuProject.add(this.menuItemLoad);
        this.menuProject.add(this.menuItemRun);

        this.window.setJMenuBar(this.menu);
    }

    private void addOptionsPanel() {
        this.panelOptions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        this.panelOptions.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));

        this.lblMode = new JLabel("Compilation Mode");
        this.comboMode = new JComboBox<>(InterpreterMode.values());
        this.lblIR = new JLabel("Instruction Register");
        this.fieldIR = new JTextField(6);
        this.lblPC = new JLabel("Program Counter");
        this.fieldPC = new JTextField(6);

        this.panelOptions.add(this.lblIR);
        this.panelOptions.add(this.fieldIR);
        this.panelOptions.add(Box.createHorizontalStrut(30));
        this.panelOptions.add(this.lblPC);
        this.panelOptions.add(this.fieldPC);
        this.panelOptions.add(Box.createHorizontalStrut(30));
        this.panelOptions.add(this.lblMode);
        this.panelOptions.add(this.comboMode);

        this.container.add(this.panelOptions);
    }

    private void addEditorPanel() {
        this.panelEditor = new JPanel();
        this.panelEditor.setLayout(new BorderLayout());
        this.panelEditor.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        this.txtEditor = new JTextArea();
        this.txtEditor.setLineWrap(true);
        this.scrollEditor = new JScrollPane(this.txtEditor);
        this.scrollEditor.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.scrollEditor.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.panelEditor.add(this.scrollEditor);

        this.container.add(this.panelEditor);
    }

    private void addDataPanel() {
        this.panelData = new JPanel();
        this.panelData.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));
        this.panelData.setLayout(new BoxLayout(this.panelData, BoxLayout.X_AXIS));
        this.panelData.setPreferredSize(new Dimension(Integer.MAX_VALUE, 200));

        this.panelReg = new MemoryDisplayPanel("Register", 16);
        this.scrollReg = new JScrollPane(this.panelReg);

        this.panelMem = new MemoryDisplayPanel("Cell", 256);
        this.scrollMem = new JScrollPane(this.panelMem);

        this.panelData.add(this.scrollReg, BorderLayout.WEST);
        this.panelData.add(Box.createHorizontalStrut(24));
        this.panelData.add(this.scrollMem, BorderLayout.EAST);

        this.container.add(this.panelData);
    }

    public void registerListeners(BrookshearCPUEmulator brookshearCPUEmulator) {
        ActionListener menuFileHandler = brookshearCPUEmulator.getMenuFileHandler();
        ActionListener menuEditHandler = brookshearCPUEmulator.getMenuEditHandler();
        ActionListener menuProjectHandler = brookshearCPUEmulator.getMenuProjectHandler();

        this.menuItemNew.addActionListener(menuFileHandler);
        this.menuItemOpen.addActionListener(menuFileHandler);
        this.menuItemSave.addActionListener(menuFileHandler);
        this.menuItemExit.addActionListener(menuFileHandler);

        this.menuItemCut.addActionListener(menuEditHandler);
        this.menuItemCopy.addActionListener(menuEditHandler);
        this.menuItemPaste.addActionListener(menuEditHandler);

        this.menuItemLoad.addActionListener(menuProjectHandler);
        this.menuItemRun.addActionListener(menuProjectHandler);

        this.fieldIR.getDocument().addDocumentListener(brookshearCPUEmulator.getDataSpecialHandler());
        this.fieldPC.getDocument().addDocumentListener(brookshearCPUEmulator.getDataSpecialHandler());

        JTextField[] memList = this.panelMem.getFields();
        JTextField[] regList = this.panelReg.getFields();

        for (int i = 0; i < memList.length; i++) {
            memList[i].getDocument().addDocumentListener(brookshearCPUEmulator.getDataMemoryCellHandler());
            memList[i].getDocument().putProperty("ID", new Integer(i));
        }

        for (int i = 0; i < regList.length; i++) {
            regList[i].getDocument().addDocumentListener(brookshearCPUEmulator.getDataRegisterHandler());
            regList[i].getDocument().putProperty("ID", new Integer(i));
        }
    }

    public void loadMemory(byte[] memoryCells) {
        this.panelMem.set(memoryCells);
    }

    public void loadRegisters(byte[] registers) {
        this.panelReg.set(registers);
    }

    public void loadPC(byte programCounter) {
        this.fieldPC.setText(Hex.toHex(programCounter));
    }

    public void loadIR(short instructionRegister) {
        this.fieldIR.setText(Hex.toHex(instructionRegister));
    }

    public byte getMemoryCell(int index) {
        String txt = this.panelMem.getFields()[index].getText();

        if (txt.equals("") || !txt.matches("[0-9a-fA-F]{2}")) {
            return 0;
        }
        else {
            return (byte) (Integer.parseInt(txt, 16) & 0xFF);
        }
    }

    public byte getRegister(int index) {
        String txt = this.panelReg.getFields()[index].getText();

        if (txt.equals("") || !txt.matches("[0-9a-fA-F]{2}")) {
            return 0;
        }
        else {
            return (byte) (Integer.parseInt(txt, 16) & 0xFF);
        }
    }

    public short getIR() {
        String txt = this.fieldIR.getText();

        if (txt.equals("") || !txt.matches("[0-9a-fA-F]{4}")) {
            return 0;
        }
        else {
            return (short) (Integer.parseInt(txt, 16) & 0xFF);
        }
    }

    public byte getPC() {
        String txt = this.fieldPC.getText();

        if (txt.equals("") || !txt.matches("[0-9a-fA-F]{2}")) {
            return 0;
        }
        else {
            return (byte) (Integer.parseInt(txt, 16) & 0xFF);
        }
    }
}
