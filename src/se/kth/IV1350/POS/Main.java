package se.kth.IV1350.POS;

import se.kth.IV1350.Model.*;
import se.kth.IV1350.Controller.*;
import se.kth.IV1350.Intergration.*;
import se.kth.IV1350.View.*;

import java.io.IOException;

/**
 *  this is the main method of the program
 *  this where the system should start the
 *  program
 *
 *  contains <code>Main</code>
 */

public class Main {

    public static void main(String[] args) {
        try {
            SystemStartUp systemStartUp = new SystemStartUp();
            Printer printer = new Printer();
            ItemRegister itemRegister = new ItemRegister();
            Controller controller = new Controller(systemStartUp, itemRegister, printer);
            View view = new View(controller);
            view.pseudoImplementation();

        }catch (Exception exception){
            System.out.println("System failed to start.");
        }

    }
}
