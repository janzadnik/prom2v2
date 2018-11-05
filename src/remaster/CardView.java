package remaster;

import com.sun.java.accessibility.util.AWTEventMonitor;
import rss.RssItem;

import javax.swing.*;
import java.awt.*;

public class CardView extends JPanel {

    private final int ITEM_WIDTH = 180;
    private final int COMPONENT_WIDTH = 160;
    private final int HEIGHT = 1;


    final String startHTML = "<html><p style='width: " + COMPONENT_WIDTH +"px'>" ;
    final String endHTML = "</p></html>";

    public CardView(RssItem item) {
        setLayout(new WrapLayout());
        setSize(ITEM_WIDTH, HEIGHT);
        setTitle(item.getTitle());
        setDescription(item.getDescription());
        setInfo(item.getLink());
    }


    private void setTitle(String title) {
        JLabel titleLabel = new JLabel();
        titleLabel.setFont(new Font("Courier",Font.BOLD,12));
        titleLabel.setSize(COMPONENT_WIDTH, HEIGHT);
        titleLabel.setText(String.format("%s%s%s",startHTML, title, endHTML));
        add(titleLabel);
    }

    //description size: 11, Font.PLAIN
    private void setDescription(String description) {
        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setFont(new Font("Courier",Font.PLAIN,11));
        descriptionLabel.setSize(COMPONENT_WIDTH, HEIGHT);
        descriptionLabel.setText(String.format("%s%s%s",startHTML, description, endHTML));
        add(descriptionLabel);
    }

    //info size: 10, Font.ITALIC
    private void setInfo(String info) {
        JLabel infoLabel = new JLabel();
        infoLabel.setFont(new Font("Courier",Font.ITALIC,10));
        infoLabel.setSize(COMPONENT_WIDTH, HEIGHT);
        infoLabel.setText(String.format("%s%s%s",startHTML, info, endHTML));
        add(infoLabel);
    }
}
