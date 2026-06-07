package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
        JMenuItem addCDMenu = new JMenuItem("Add CD");
        JMenuItem addDVDMenu = new JMenuItem("Add DVD");

        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addCDMenu);
        smUpdateStore.add(addDVDMenu);
        menu.add(smUpdateStore);

        addDVDMenu.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store);
            dispose();
        });

        addBookMenu.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            dispose();
        });

        addCDMenu.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store);
            dispose();
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(scrollPane, BorderLayout.CENTER);

        return wrapper;
    }

    public static void main(String[] args) {
        // Tạo một store giả lập
        Store testStore = new Store();

        
        for (int i = 1; i <= 9; i++) {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    "Test Movie " + i,
                    "Category " + i,
                    "Director",
                    90 + i,
                    15.5f + i);
            testStore.addMedia(dvd);
        }

        // Khởi tạo giao diện
        new StoreManagerScreen(testStore);
    }
}