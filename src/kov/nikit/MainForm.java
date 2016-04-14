package kov.nikit;

import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.*;

/**
 * Created by Xonxt on 14.04.2016.
 */
public class MainForm extends JFrame {
    private JPanel rootPanel;
    private JButton clickMeButton;
    private JButton noClickMeButton;
    private JTextArea textArea1;

    int taskNum = 1;

    public MainForm(String formTitle) {
        super(formTitle);

        setContentPane(rootPanel);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainForm.this, "Yay, you clicked the button!");
            }
        });

        noClickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.scheduleWithFixedDelay(new Task("task" + taskNum++, textArea1), 0, 1, TimeUnit.SECONDS);

            }
        });

        setVisible(true);
    }
}
