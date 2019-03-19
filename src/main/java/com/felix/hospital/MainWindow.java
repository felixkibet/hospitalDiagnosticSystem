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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MainWindow implements ActionListener {
    private final JFrame frame = new JFrame("Hospital...");
    private final JLabel title, date, question;
    private final JRadioButton yes,no,unknown;
    private final JButton cancel, next;
    private final ButtonGroup option;
    
    public MainWindow() {
        title = new JLabel("Hospital Expert System");
        date = new JLabel("Date: " + getDate());
        question = new JLabel("Questions");
        
        yes = new JRadioButton("Yes");
        no = new JRadioButton("No");
        unknown = new JRadioButton("Unknown");
        
        cancel = new JButton("Cancel");
        next = new JButton("Next");
        
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
        
        
        Component component[] = {title, date, question, yes, no, unknown, cancel, next};
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
        if(e.getSource() == "cancel") {
            frame.dispose();
        }
        if(e.getSource() == next) {
            JOptionPane.showMessageDialog(this.frame, "Code coming here shortly");
        }
    }
}
