/* Ashton Chavez
 * Project 4
 * March 5, 2024
 * 
 * The Project4 class implements a GUI for comparing time intervals
 * and checking if a given time is within the intervals.
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project4 {
    private static JTextField interval1StartField, interval1EndField, interval2StartField, interval2EndField;
    private static JTextField timeToCheckField;
    private static JTextArea outputArea;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Time Interval Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Start Time Label
        JLabel startTimeLabel = new JLabel("Start Time");
        startTimeLabel.setBounds(100, 10, 80, 15);
        panel.add(startTimeLabel);

        // End Time Label
        JLabel endTimeLabel = new JLabel("End Time");
        endTimeLabel.setBounds(190, 10, 80, 15);
        panel.add(endTimeLabel);

        // Time Interval 1
        JLabel interval1Label = new JLabel("Time Interval 1 ");
        interval1Label.setBounds(10, 30, 100, 25);
        panel.add(interval1Label);

        interval1StartField = new JTextField(10);
        interval1StartField.setBounds(100, 30, 80, 25);
        panel.add(interval1StartField);

        interval1EndField = new JTextField(10);
        interval1EndField.setBounds(190, 30, 80, 25);
        panel.add(interval1EndField);

        // Time Interval 2
        JLabel interval2Label = new JLabel("Time Interval 2 ");
        interval2Label.setBounds(10, 60, 100, 25);
        panel.add(interval2Label);

        interval2StartField = new JTextField(10);
        interval2StartField.setBounds(100, 60, 80, 25);
        panel.add(interval2StartField);

        interval2EndField = new JTextField(10);
        interval2EndField.setBounds(190, 60, 80, 25);
        panel.add(interval2EndField);

        // Compare Intervals Button
        JButton compareIntervalsButton = new JButton("Compare Intervals");
        compareIntervalsButton.setBounds(10, 90, 160, 25);
        panel.add(compareIntervalsButton);

        // Time to Check Label
        JLabel timeToCheckLabel = new JLabel("Time to Check ");
        timeToCheckLabel.setBounds(10, 120, 120, 25);
        panel.add(timeToCheckLabel);

        timeToCheckField = new JTextField(10);
        timeToCheckField.setBounds(140, 120, 80, 25);
        panel.add(timeToCheckField);

        // Check Time Button
        JButton checkTimeButton = new JButton("Check Time");
        checkTimeButton.setBounds(10, 150, 120, 25);
        panel.add(checkTimeButton);

        // Output Area
        outputArea = new JTextArea();
        outputArea.setBounds(10, 180, 360, 80);
        outputArea.setEditable(false);
        panel.add(outputArea);

        // Add action listeners
        compareIntervalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                compareIntervalsButtonClicked();
            }
        });

        checkTimeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkTimeButtonClicked();
            }
        });
    }

    //Handle Compare Intervals button click
    private static void compareIntervalsButtonClicked() {
        try {
            //Extract input values from text fields
            Time interval1Start = new Time(interval1StartField.getText());
            Time interval1End = new Time(interval1EndField.getText());
            Time interval2Start = new Time(interval2StartField.getText());
            Time interval2End = new Time(interval2EndField.getText());
    
            //Create Interval objects for comparison
            Interval<Time> interval1 = new Interval<>(interval1Start, interval1End);
            Interval<Time> interval2 = new Interval<>(interval2Start, interval2End);

            // Determine the relationship between intervals and update the output area
            if (interval1.overlaps(interval2) || interval2.overlaps(interval1)){
                outputArea.setText("The intervals overlap");
            } else if (interval1.subinterval(interval2)) {
                outputArea.setText("Interval 1 is a sub-interval of interval 2");
            } else if (interval2.subinterval(interval1)) {
                outputArea.setText("Interval 2 is a sub-interval of interval 1");
            } else {
                outputArea.setText("The intervals are disjoint");
            }
        } catch (InvalidTime ex) {
            outputArea.setText("Invalid time input: " + ex.getMessage());
        }
    }            

    //Handle Check Time button click
    private static void checkTimeButtonClicked() {
        try {
            //Extract input values from text fields
            Time interval1Start = new Time(interval1StartField.getText());
            Time interval1End = new Time(interval1EndField.getText());
            Time interval2Start = new Time(interval2StartField.getText());
            Time interval2End = new Time(interval2EndField.getText());
            Time timeToCheck = new Time(timeToCheckField.getText());
    
            //Create Interval objects for comparison
            Interval<Time> interval1 = new Interval<>(interval1Start, interval1End);
            Interval<Time> interval2 = new Interval<>(interval2Start, interval2End);

            boolean inInterval1 = interval1.within(timeToCheck);
            boolean inInterval2 = interval2.within(timeToCheck);
    
            if (inInterval1 && inInterval2) {
                outputArea.setText("Both intervals contain the time " + timeToCheck);
            } else if (inInterval1) {
                outputArea.setText("Only interval 1 contains the time " + timeToCheck);
            } else if (inInterval2) {
                outputArea.setText("Only interval 2 contains the time " + timeToCheck);
            } else {
                outputArea.setText("Neither interval contains the time " + timeToCheck);
            }
        } catch (InvalidTime ex) {
            outputArea.setText("Invalid time input: " + ex.getMessage());
        }
    }
    
}