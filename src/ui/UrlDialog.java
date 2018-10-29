package ui;

import model.ToDoItem;

import javax.swing.*;
import java.awt.*;

public class UrlDialog extends JDialog {

    private String url;

    public UrlDialog() {
        setModal(true);

        setLayout(new GridLayout(2, 2));

        JLabel jLabel = new JLabel("URL");
        add(jLabel);

        JTextField jTextField = new JTextField();
        add(jTextField);

        JButton btnOk = new JButton("OK");
        add(btnOk);

        btnOk.addActionListener(action -> {
            // plnit ToDoItem
            url = jTextField.getText();
            setVisible(false);
        });

        pack(); //shluk dle vnitřních prvků
        setLocationRelativeTo(null); //center
    }

    public String getUrl() {
        setVisible(true); //zmrazí původní vlákno
        return url;
    }
}
