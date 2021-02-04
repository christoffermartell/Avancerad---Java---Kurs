import javax.swing.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import java.awt.GridLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {


    public static void main(String[] args) {

        JFrame window = new JFrame("Window");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(5, 5, 10, 10);

        JPanel panel1 = new JPanel(gridLayout);
        JTextArea textArea1 = new JTextArea("output");
        JTextField textField1 = new JTextField("Namn");
        JTextField textField3 = new JTextField("TelefonNummer");
        JTextField textField2 = new JTextField("E-Post");
        textField1.setColumns(20);
        textField2.setColumns(20);

        JButton button1 = new JButton("Click!");


        panel1.add(textField1);
        panel1.add(textField2);
        panel1.add(textField3);
        panel1.add(textArea1);

        panel1.add(button1);

        // actionlistener
        ActionListener buttonListener = e -> {
            String regexName = "^[A-Za-z]{2,}\\s?[A-Za-z]{0,}$";
            String regexEmail = "([\\w]%?-?\\.?){2,}@([\\w]\\.?-?)+\\.[A-Za-z]{2,3}$";
            String regexPhoneNumber = "^[0-9]{0,3}[\\s-]?[0-9]{6,}$";

            String name = textField1.getText();
            String email = textField2.getText();
            String phoneNumber = textField3.getText();

            if (finder(name, regexName) && finder(email, regexEmail) && finder(phoneNumber, regexPhoneNumber)) {
                String a = String.format("%s\n%s\n%s", name, email, phoneNumber);
                textArea1.setText(a);
            } else {
                textArea1.setText("Please enter valid values.");
            }

        };


        // actionlistener till knappen..
        button1.addActionListener(buttonListener);
        textField2.addActionListener(buttonListener);


        window.add(panel1);
        window.setVisible(true);


        String pattern = " ";


    }

    public static boolean finder(String myString, String pattern) {

        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(myString);
        boolean match = false;



        while (matcher.find()) {
            if (matcher.group().length() != 0) {
                match = true;
            }
        }

        return match;

    }


}


