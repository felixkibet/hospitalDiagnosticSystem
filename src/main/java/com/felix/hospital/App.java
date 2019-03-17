package com.felix.hospital;
import org.jpl7.*;

public class App {
    public static void main(String[] args) {
        // Consult prolog database
        Query q1 = new Query("consult", new Term[]{new Atom("disease.pl")});
        
        System.out.println("Consult: " + (q1.hasSolution() ? "Sucess" : "Failed"));
    }
}
