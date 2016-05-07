package com.jam.brookshearCPU.interpreter;

/**
 * Created by Jack on 29-Apr-16.
 */
public class BrookshearInterpreter {
    public BrookshearInterpreter() {

    }

    public String toMachineCode(String asm) {
        StringBuilder mc = new StringBuilder("");
        String str = asm.trim();
        String[] tokens;

        if (str.equals("NON")) {
            mc.append("0FFF");
        } else if (str.matches("LOD\\s+C[A-F0-9]{2}\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("1").append(tokens[2].charAt(1)).append(tokens[1].charAt(1)).append(tokens[1].charAt(2));
        } else if (str.matches("LOD\\s+B[A-F0-9]{2}\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("2").append(tokens[2].charAt(1)).append(tokens[1].charAt(1)).append(tokens[1].charAt(2));
        } else if (str.matches("STR\\s+R[A-F0-9]\\s+C[A-F0-9]{2}")) {
            tokens = str.split("\\s+");
            mc.append("3").append(tokens[1].charAt(1)).append(tokens[2].charAt(1)).append(tokens[2].charAt(2));
        } else if (str.matches("MOV\\s+R[A-F0-9]\\s+R[A-F0-0]")) {
            tokens = str.split("\\s+");
            mc.append("40").append(tokens[1].charAt(1)).append(tokens[2].charAt(1));
        } else if (str.matches("ADI\\s+R[A-F0-9]\\s+R[A-F0-9]\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("5").append(tokens[3].charAt(1)).append(tokens[1].charAt(1)).append(tokens[2].charAt(1));
        } else if (str.matches("ADF\\s+R[A-F0-9]\\s+R[A-F0-9]\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("6").append(tokens[3].charAt(1)).append(tokens[1].charAt(1)).append(tokens[2].charAt(1));
        } else if (str.matches("OR\\s+R[A-F0-9]\\s+R[A-F0-9]\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("7").append(tokens[3].charAt(1)).append(tokens[1].charAt(1)).append(tokens[2].charAt(1));
        } else if (str.matches("AND\\s+R[A-F0-9]\\s+R[A-F0-9]\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("8").append(tokens[3].charAt(1)).append(tokens[1].charAt(1)).append(tokens[2].charAt(1));
        } else if (str.matches("XOR\\s+R[A-F0-9]\\s+R[A-F0-9]\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("9").append(tokens[3].charAt(1)).append(tokens[1].charAt(1)).append(tokens[2].charAt(1));
        } else if (str.matches("ROT\\s+R[A-F0-9]\\s+[0-9]")) {
            tokens = str.split("\\s+");
            mc.append("A").append(tokens[1].charAt(1)).append("0").append(tokens[2].charAt(0));
        } else if (str.matches("JMP\\s+C[A-F0-9]{2}\\s+R[A-F0-9]")) {
            tokens = str.split("\\s+");
            mc.append("B").append(tokens[2].charAt(1)).append(tokens[1].charAt(1)).append(tokens[1].charAt(2));
        } else if (str.equals("HLT")) {
            mc.append("C000");
        }

        return ((mc.toString() == "")? null : mc.toString());
    }
}
