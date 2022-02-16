package question5;

import javax.swing.*;
import java.awt.*;

public class StarvationDemo {
    private static Object sharedObj = new Object();

    public static void main (String[] args) {
        JFrame frame = createFrame();
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT));

        for (int i = 0; i < 4; i++) {
            ProgressThread progressThread = new ProgressThread();
            frame.add(progressThread.getProgressComponent());
            progressThread.start();
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JFrame createFrame () {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return frame;
    }

    private static class ProgressThread extends Thread {
        JProgressBar progressBar;

        ProgressThread () {
            progressBar = new JProgressBar();
            progressBar.setString(this.getName());
            progressBar.setStringPainted(false);
            progressBar.setBackground(Color.black);
        }

        JComponent getProgressComponent () {
            return progressBar;
        }

        @Override
        public void run () {
            int c = 0;
            while (true) {
                synchronized (sharedObj) {
//                    if (c == 100) {
//                        c = 0;
//                    }
                    progressBar.setValue(++c);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
