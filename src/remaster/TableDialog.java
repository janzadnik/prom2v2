package remaster;

import model.TableModel;

import javax.swing.*;
import java.awt.*;

public class TableDialog extends JDialog {

    public TableDialog(){
        setModal(true);
        setLayout(new BorderLayout());

        JPanel toolbar = new JPanel();
        //TODO pridat tlacitka na pridanvani
        //TODO TextField apod

        JButton finishBtn = new JButton("Dokončit");
        toolbar.add(finishBtn,BorderLayout.EAST);
        add(toolbar, BorderLayout.NORTH);

        TableModel model = new TableModel();
        JTable table = new JTable(model);
        add(new JScrollPane(table),BorderLayout.CENTER);

        finishBtn.addActionListener(e ->  {
            setVisible(false);
        });

        pack();
        setLocationRelativeTo(null);
    }

    public void open(){
        //TODO v budoucnossti navracovat co se provedlo v dialogu
        setVisible(true);
    }
}
