import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class BirthdayPredictor extends JFrame implements ActionListener {

    JTextField dayField, monthField;
    JButton checkButton, thankButton;
    JLabel result;

    public BirthdayPredictor() {

        setTitle("🎂 Birthday Predictor 🎂");
        setSize(450, 350);
        setLayout(new FlowLayout());

        add(new JLabel("Enter Birth Day (1-31):"));
        dayField = new JTextField(5);
        add(dayField);

        add(new JLabel("Enter Birth Month (1-12):"));
        monthField = new JTextField(5);
        add(monthField);

        checkButton = new JButton("Check Birthday");
        checkButton.addActionListener(this);
        add(checkButton);

        result = new JLabel(" ");
        result.setFont(new Font("Arial", Font.BOLD, 15));
        add(result);

        thankButton = new JButton("Thank You 💖");
        thankButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    " /\\_/\\\\\n" +
                    "( ^.^ )  😽💋💋💋\n" +
                    " > ❤️ <\n\n" +
                    "You're Welcome! 🌸\nHave a wonderful day! 💕✨");
        });

        thankButton.setVisible(false);
        add(thankButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());

        LocalDate today = LocalDate.now();
        int year = today.getYear();

        LocalDate birthday = LocalDate.of(year, month, day);

        if (birthday.equals(today)) {
            result.setText("🎉🎂 Happy Birthday!! 🎂🎉 🥳🎈🎁🌸❤️");
        } else if (birthday.isAfter(today)) {
            long days = ChronoUnit.DAYS.between(today, birthday);
            result.setText("🎂 " + days + " days left for your birthday! 🎉");
        } else {
            LocalDate nextBirthday = birthday.plusYears(1);
            long passed = ChronoUnit.DAYS.between(birthday, today);
            long left = ChronoUnit.DAYS.between(today, nextBirthday);

            result.setText("😊 Your birthday passed " + passed +
                    " days ago.\n🎂 " + left + " days left for next birthday!");
        }

        thankButton.setVisible(true);
    }

    public static void main(String[] args) {
        new BirthdayPredictor();
    }
}