package com.example;

import wit.worlds.ProcessV0;
import wit.worlds.ProcessV0Impl;
import wit.imports.kinode.process.Standard;

public class HelloWorld {
    public static void main(String[] args) {
        byte verbosityLevel = 0;
        String message = "Hello, world from main!";
        Standard.printToTerminal(verbosityLevel, message);

        ProcessV0.wasmExportInit(0, 0);
        //System.out.println("Hello, World!");
    }
}
