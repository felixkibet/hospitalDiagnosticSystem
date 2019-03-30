package com.felix.hospital;
/**
 * @author Felix Kibet
 */

import java.util.Map;
import javax.swing.JOptionPane;
import org.jpl7.*;

public class App {
    public static void main(String[] args) {
        MainWindow window = MainWindow.getInstance();
        
    }
    
    public boolean init() {
        // Consult prolog database
        Query q1 = new Query("consult", new Term[]{new Atom("diseases.pl")});
        if(!q1.hasSolution()) {
            JOptionPane.showMessageDialog(null, "Error connecting to knowledge database", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    public void destroy() {
        Query haltQuery = new Query("halt");
        if(!haltQuery.hasSolution()) {
            System.out.println("Closed system: successfully");
        }
        haltQuery.close();
    }
    
    public Map<String, Term>[] getQuestions(Query query) {
        Map<String, Term>[] solutions = query.allSolutions();
        return solutions;
    }
}
