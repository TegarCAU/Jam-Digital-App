import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends JFrame {
    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public Clock() {
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        timeFormat = new SimpleDateFormat("HH:mm:ss");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 50));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(new Color(255, 215, 0)); // Warna emas
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.BLACK);
        
        add(timeLabel, BorderLayout.CENTER);
        
        new Timer(1000, e -> updateTime()).start();
    }

    private void updateTime() {
        timeLabel.setText(timeFormat.format(new Date()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Clock clock = new Clock();
            clock.setVisible(true);
        });
    }
}
