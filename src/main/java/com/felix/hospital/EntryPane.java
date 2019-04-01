package com.felix.hospital;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

class EntryPane extends JPanel {

    private static final long serialVersionUID = 2333432343L;

    private final JTextField fldSymptoms;
    private final JRadioButton rdoYes, rdoNo, rdoUnknown;
    private final JTextArea fldResults;

    EntryPane() {
        super(new BorderLayout(10, 10));

        // initialize instance variables
        fldSymptoms = new JTextField();
        rdoNo = new JRadioButton("No");
        rdoYes = new JRadioButton("Yes");
        rdoUnknown = new JRadioButton("Unspecified");
        fldResults = new JTextArea();

        // initialize everything
        clear();

        fldSymptoms.setEditable(false);
        JButton btnNext = new JButton("NEXT");
        btnNext.addActionListener(l -> {});
        
        // add the question and symptoms
        JPanel top = new JPanel(new BorderLayout(10, 10));

        top.add(fldSymptoms, BorderLayout.NORTH);

        // add the radio buttons to the group and panel
        final ButtonGroup radioGroup = new ButtonGroup();
        final JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        for (JRadioButton rdoButton : Arrays.asList(rdoNo, rdoYes, rdoUnknown)) {
            radioGroup.add(rdoButton);
            radioPanel.add(rdoButton);
        }
        top.add(radioPanel, BorderLayout.CENTER);

        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttonPanel.add(btnNext);
        buttonPanel.add(new JSeparator(SwingConstants.VERTICAL));
        
        JButton btnConsult = new JButton("CONSULT");
        btnConsult.addActionListener(l -> this.generateResults());
        buttonPanel.add(btnConsult);

        // add the button panel last
        top.add(buttonPanel, BorderLayout.SOUTH);

        fldResults.setSize(400, 250);

        this.add(top, BorderLayout.NORTH);
        this.add(fldResults, BorderLayout.CENTER);
    }

    private void clear() {
        // todo: clear the screen
        fldSymptoms.setText("");
        rdoNo.setSelected(true);
        fldResults.setText("");
    }

    private void generateResults() {
        // todo: generate results
        fldResults.setText("RESULTS:");
    }

    public static void main(String[] args) {
        // run the application in its own thread
        SwingUtilities.invokeLater(() -> {
            // set up the frame
            final JFrame window = new JFrame("Expert Hospital System");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // set a bordered layout with a padding of 10 all round
            final JPanel contentPane = new JPanel(new BorderLayout());
            contentPane.setBorder(new EmptyBorder(10, 10, 0, 10));
            window.setContentPane(contentPane);

            // place instructions at the top
            final JLabel lblInstructions = new JLabel("Does the patient have the following symptoms?", JLabel.LEFT);
            contentPane.add(lblInstructions, BorderLayout.NORTH);

            // add the entry pane
            final EntryPane pane = new EntryPane();
            contentPane.add(pane, BorderLayout.CENTER);

            // add the close and clear buttons
            final JButton btnClose = new JButton("Close");
            btnClose.addActionListener(l -> window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING)));

            final JButton btnClear = new JButton("Clear");
            btnClear.addActionListener(l -> pane.clear());

            JPanel buttonBar = new JPanel(new FlowLayout(FlowLayout.TRAILING, 10, 10));
            buttonBar.add(btnClear);
            buttonBar.add(btnClose);
            contentPane.add(buttonBar, BorderLayout.SOUTH);

            // set size and location
            window.setSize(500, 300);
            window.setLocationRelativeTo(null);
            // display the window
            window.setVisible(true);
        });
    }
}