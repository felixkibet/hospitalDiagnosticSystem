package com.felix.hospital;

/**
 * @author Felix Kibet
 */
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
public class MainWindow implements ActionListener {
    private static final JFrame frame = new JFrame("Hospital...");
    private final JLabel title, date, question;
    private final JRadioButton yes,no,unknown;
    private final JButton cancel, next, consult;
    private final ButtonGroup option;
    private static JTextArea textArea;
    private  static JScrollPane scrollPane;
    
    private static MainWindow mainWindow;
    private App app = new App();
    private MainWindow() {
        title = new JLabel("Hospital Expert System");
        date = new JLabel("Date: " + getDate());
        question = new JLabel("Questions");
        
        yes = new JRadioButton("Yes");
        no = new JRadioButton("No");
        unknown = new JRadioButton("Unknown");
        
        cancel = new JButton("Cancel");
        next = new JButton("Next");
        consult = new JButton("Consult");
        
        textArea = new JTextArea(5, 20);
        textArea.setText("go.");
        //textArea.setEditable(false);
        //scrollPane = new JScrollPane(textArea);
        
                
        option = new ButtonGroup();
        option.add(yes);
        option.add(no);
        option.add(unknown);
        
        this.cancel.addActionListener(this);
        this.next.addActionListener(this);
        
        title.setSize(400, 40);
        //Define panel
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        
        
        Component component[] = {title, date, question, yes, no, unknown, textArea, cancel, next, consult};
        for(Component c : component) {
            panel.add(c);
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * 
     * @return date in the format yyy-MM-dd
     */
    private String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        return formatter.format(LocalDate.now());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cancel) {
            MainWindow.frame.dispose();
        }
        if(e.getSource() == next) {
            JOptionPane.showMessageDialog(MainWindow.frame, "Code coming here shortly");
        }
        if(e.getSource() == consult) {
            app.init();
        }
    }
    
    public static MainWindow getInstance() {
        if(mainWindow == null) {
            mainWindow = new MainWindow();
        }
        return mainWindow;
    }
    
    public void printQuestions() {
        Query q2 = new Query("hypothesis", new Term[]{new Variable("X")});
        for (Map<String, Term> question1 : app.getQuestions(q2)) {
            textArea.append(question1.get("X").toString());
        }
    }
    
    public static void main(String[] args) {
        Query q1 = new Query("consult", new Term[]{new Atom("disease.pl")});
        q1.hasSolution();
        
        getInstance();
        Query q2 = new Query(textArea.getText());
        q2.hasSolution();
    }
}
