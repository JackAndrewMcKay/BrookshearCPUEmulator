package com.jam.brookshearCPU.interpreter;

/**
 * Created by Jack on 29-Apr-16.
 */
public enum InterpreterMode {
    ASM("Brookshear Assembly"), MC("Machine Code");

    private String name;

    InterpreterMode(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
