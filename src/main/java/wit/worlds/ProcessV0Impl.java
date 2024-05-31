package wit.worlds;

import wit.imports.kinode.process.Standard;

public class ProcessV0Impl {
    public static void init(String our) {
        byte verbosityLevel = 0;
        String message = "Hello, world from init!";
        Standard.printToTerminal(verbosityLevel, message);
        //System.out.println("Hello, World!");
    }
}
