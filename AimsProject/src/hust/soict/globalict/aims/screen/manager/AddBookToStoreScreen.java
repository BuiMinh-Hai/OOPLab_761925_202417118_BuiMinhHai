package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.Book;
import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 5, 5));

        center.add(new JLabel("Title: "));
        JTextField tfTitle = new JTextField(10);
        center.add(tfTitle);

        center.add(new JLabel("Category: "));
        JTextField tfCategory = new JTextField(10);
        center.add(tfCategory);

        center.add(new JLabel("Cost: "));
        JTextField tfCost = new JTextField(10);
        center.add(tfCost);

        center.add(new JLabel("Authors (comma separated): "));
        JTextField tfAuthors = new JTextField(10);
        center.add(tfAuthors);

        JButton btnAdd = new JButton("Add");
        center.add(btnAdd);

        btnAdd.addActionListener(e -> {
            try {
                String title = tfTitle.getText();
                String category = tfCategory.getText();
                float cost = Float.parseFloat(tfCost.getText());

                Book book = new Book(title, category, cost);
                String[] authors = tfAuthors.getText().split(",");
                for (String author : authors) {
                    book.addAuthor(author.trim());
                }

                store.addMedia(book);
                JOptionPane.showMessageDialog(null, "Book added successfully!");

                tfTitle.setText("");
                tfCategory.setText("");
                tfCost.setText("");
                tfAuthors.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check again.");
            }
        });

        JPanel wrapper = new JPanel();
        wrapper.add(center);
        return wrapper;
    }
}