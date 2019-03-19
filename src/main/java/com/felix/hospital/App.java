package com.felix.hospital;
/**
 * @author Felix Kibet
 */

import org.jpl7.*;

public class App {
    public static void main(String[] args) {
        // Consult prolog database
        Query q1 = new Query("consult", new Term[]{new Atom("disease.pl")});
        
        System.out.println("Consult: " + (q1.hasSolution() ? "Sucess" : "Failed"));
        
        // Start system
        Query q2 = new Query("go");
        System.out.println((q2.hasSolution()));
        
        //Variable X = new Variable("Question");
        //Query q3 = new Query("askQuestion", new Term[]{new Atom("Question")});
        
        MainWindow window = new MainWindow();
        
    }
}
