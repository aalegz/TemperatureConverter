import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter {

    JLabel tempLabel, outLabel;
    JTextField jTextField;
    JButton jButton;
    String[] temps;
    JList jList;
    int tempIndex;

    static double convert(int temp, String scale) {
        if (scale.equals("Celsius")) {
            return (temp - 32.0) * (5.0 / 9.0);
        } else {
            return temp * (9.0 / 5.0) + 32.0;
        }
    }

    public TemperatureConverter() {
        tempLabel = new JLabel("Temperature: ");
        outLabel = new JLabel("");
        jTextField = new JTextField(5);
        jButton = new JButton("Convert");
        temps = new String[]{"Celsius", "Fahrenheit"};
        jList = new JList(temps);
        JFrame frame = new JFrame("Temperature Converter:");
        frame.setLayout(new GridLayout(3, 2));
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tempIndex = jList.getSelectedIndex();
            }
        });

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp = Integer.parseInt(jTextField.getText());
                String scale = temps[tempIndex];
                outLabel.setText(Double.toString(convert(temp, scale)));
            }
        });

        frame.add(tempLabel);
        frame.add(jTextField);
        frame.add(jList);
        frame.add(jButton);
        frame.add(outLabel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverter();
            }
        });
    }
}