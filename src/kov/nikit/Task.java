package kov.nikit;

import javax.swing.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xonxt on 14.04.2016.
 */
public class Task implements Runnable {

    private String name;
    private JTextArea textArea;

    public Task(String name, JTextArea textArea) {
        this.name = name;
        this.textArea = textArea;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            textArea.append(name + ": " + i + "\n");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
}
