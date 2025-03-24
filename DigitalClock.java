import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DigitalClock extends JLabel implements Runnable {
    public DigitalClock() {
        setFont(new Font("Arial", Font.BOLD, 40));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void run() {
        while (true) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            setText(sdf.format(calendar.getTime()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jam Digital");
        DigitalClock clock = new DigitalClock();
        frame.add(clock);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        Thread thread = new Thread(clock);
        thread.start();
    }
}
