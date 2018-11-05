package remaster;

import rss.RssItem;
import rss.RssParser;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class RssFrame extends JFrame {

    private JPanel content;

    public static void main(String[] args) {
        RssFrame frame = new RssFrame();
        frame.init(800, 600);
    }

    private void init(int width, int height) {
        setSize(width, height);
        setTitle("Rss čtečka");
        setLocationRelativeTo(null); //center okna
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel controlPanel = new JPanel(new BorderLayout());
        JButton editButton = new JButton("Edit");

        editButton.addActionListener(e -> {
            new TableDialog().open();
        });

        controlPanel.add(editButton, BorderLayout.WEST);

        add(controlPanel, BorderLayout.NORTH);

        content = new JPanel(new WrapLayout());
        test();

        add(new JScrollPane(content), BorderLayout.CENTER);

        setVisible(true);

    }

    private void test() {

        try {
            //String url = "http://www.eurofotbal.cz/feed/rss/premier-league/";
            //URLConnection connection = new URL(url).openConnection();
            //connection.connect();
            //InputStream stream = connection.getInputStream();

            InputStream is = new FileInputStream(new File("download.xml"));

            List<RssItem> items = new RssParser(is).parseItems();

            for (RssItem item : items) {
                content.add(new CardView(item));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
