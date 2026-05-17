package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 5, 5));

        center.add(new JLabel("Title: "));
        JTextField tfTitle = new JTextField(10);
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        JTextField tfCategory = new JTextField(10);
        center.add(tfCategory);

        center.add(new JLabel("Director: "));
        JTextField tfDirector = new JTextField(10);
        center.add(tfDirector);

        center.add(new JLabel("Length: "));
        JTextField tfLength = new JTextField(10);
        center.add(tfLength);

        center.add(new JLabel("Cost: "));
        JTextField tfCost = new JTextField(10);
        center.add(tfCost);

        JButton btnAdd = new JButton("Add");
        center.add(btnAdd);

        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                String director = tfDirector.getText();
                int length = Integer.parseInt(tfLength.getText());
                float cost = Float.parseFloat(tfCost.getText());

                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                store.addMedia(dvd);
                JOptionPane.showMessageDialog(null, "DVD added successfully!");

                tfTitle.setText("");
                tfCategory.setText("");
                tfDirector.setText("");
                tfLength.setText("");
                tfCost.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check again.");
            }
        });

        JPanel wrapper = new JPanel();
        wrapper.add(center);
        return wrapper;
    }
}