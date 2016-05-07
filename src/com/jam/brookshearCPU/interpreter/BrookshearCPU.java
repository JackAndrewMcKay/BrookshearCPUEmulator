package com.jam.brookshearCPU.interpreter;

import com.jam.brookshearCPU.util.Hex;

/**
 *
 */
public class BrookshearCPU {
    public static final short N_MEMORY_CELLS = 256;
    public static final byte N_REGISTERS = 16;

    private byte[] memoryCells;
    private byte[] registers;
    private short instructionRegister;
    private byte programCounter;
    private volatile boolean isRunning = false;

    public BrookshearCPU() {
        this.memoryCells = new byte[BrookshearCPU.N_MEMORY_CELLS];
        this.registers = new byte[BrookshearCPU.N_REGISTERS];
        this.instructionRegister = 0x0000;
        this.programCounter = 0x00;
    }

    public byte[] readMemory() {
        return this.memoryCells;
    }

    public void writeMemory(int index, byte data) {
        this.memoryCells[index] = data;
    }

    public byte[] readRegisters() {
        return this.registers;
    }

    public void writeRegisters(int index, byte data) {
        this.registers[index] = data;
    }

    public short readIR() {
        return this.instructionRegister;
    }

    public void writeIR(short data) {
        this.instructionRegister = data;
    }

    public byte readPC() {
        return this.programCounter;
    }

    public void writePC(byte data) {
        this.programCounter = data;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void run() {
        this.isRunning = true;
        this.programCounter = 0x00;
    }

    public void executeInstruction() {
        System.out.println("Address: 0x" + Hex.toHex(this.programCounter));

        int wordA = 0x000000FF & this.memoryCells[this.programCounter++];
        int wordB = 0x000000FF & this.memoryCells[this.programCounter++];
        int longWord = (wordA << 8) | wordB;
        this.instructionRegister = (short) longWord;

        System.out.println("Instruction: 0x" + Hex.toHex(this.instructionRegister));

        decode(Hex.toHex(this.instructionRegister));
    }

    private void decode(String instruction) {
        if (instruction.matches("0F{3}")) {
            return;
        }
        else if (instruction.matches("1[0-9a-fA-F]{3}")) {
            
        }
        else if (instruction.matches("2[0-9a-fA-F]{3}")) {
            
        }
        else if (instruction.matches("3[0-9a-fA-F]{3}")) {
            
        }
        else if (instruction.matches("40[0-9a-fA-F]{2}")) {
            
        }
        else if (instruction.matches("5[0-9a-fA-F]{3}")) {
            
        }
        else if (instruction.matches("6[0-9a-fA-F]{3}")) {
            
        }
        else if (instruction.matches("7[0-9a-fA-F]{3}")) {
            
        }
        else if (instruction.matches("8[0-9a-fA-F]{3}")) {

        }
        else if (instruction.matches("9[0-9a-fA-F]{3}")) {

        }
        else if (instruction.matches("[aA][0-9a-fA-F]0[0-9a-fA-F]")) {

        }
        else if (instruction.matches("[bB][0-9a-fA-F]{3}")) {

        }
        else if (instruction.matches("[cC][0]{3}")) {
            this.isRunning = false;
        }
        else {
            throw new IllegalArgumentException("Invalid instruction has been passed to decoder!");
        }
    }
}
