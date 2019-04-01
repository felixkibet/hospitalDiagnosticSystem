package com.felix.hospital;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class EntryPane extends JPanel {

    private final JLabel lblQuestion, lblSuggestion;
    private final JRadioButton rdoYes, rdoNo, rdoUnknown;
    EntryPane() {
        super(new BorderLayout(10, 10));

        // initialize instance variables
        lblQuestion     = new JLabel();
        lblSuggestion   = new JLabel();
        rdoNo           = new JRadioButton("No");
        rdoYes          = new JRadioButton("Yes");
        rdoUnknown      = new JRadioButton("Unspecified");

        // add the radio buttons to the group and panel
        final ButtonGroup radioGroup = new ButtonGroup();
        final JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        for (JRadioButton rdoButton: Arrays.asList(rdoNo, rdoYes, rdoUnknown)) {
            radioGroup.add(rdoButton);
            radioPanel.add(rdoButton);
        }

        // place instructions at the top
        JLabel lblInstructions = new JLabel("Please enter your queries below and they will be answered.", JLabel.LEFT);
        
        final int ROWS = 2, COLS = 3;
        JPanel form = new JPanel(new GridLayout(2, 3, 10, 15));
        // populate the form
        JComponent[][] components = {
            // first row
            {lblQuestion, fld}
        };
    }
}