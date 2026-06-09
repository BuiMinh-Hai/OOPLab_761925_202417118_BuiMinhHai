package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.exception.PlayerException;
import java.util.Scanner;

public class Aims {
    
    // Khởi tạo các đối tượng dùng chung
    public static Store store = new Store(); 
    public static Cart cart = new Cart();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // --- Thêm dữ liệu mẫu vào Store ---
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ ký tự Enter

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }

    // ==================== CÁC MENU GIAO DIỆN ====================

    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    // ==================== CÁC HÀM XỬ LÝ LOGIC ====================

    // 1. CHỨC NĂNG: VIEW STORE
    public static void viewStore() {
        int choice;
        do {
            System.out.println("\n--- STORE INVENTORY ---");
            store.print(); // Gọi hàm in danh sách cửa hàng
            
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // Xem chi tiết Media (Từ Store Menu)
    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        // Giả sử Store có hàm searchByTitle trả về Media hoặc null
        Media media = store.searchByTitle(title);
        
        if (media != null) {
            System.out.println("Media Details: " + media.toString());
            int detailChoice;
            do {
                mediaDetailsMenu();
                detailChoice = scanner.nextInt();
                scanner.nextLine();
                
                switch (detailChoice) {
                    case 1:
                        try {
                            cart.addMedia(media);
                        } catch (hust.soict.globalict.aims.exception.LimitExceededException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            try {
                                ((Playable) media).play();
                            } catch (PlayerException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (detailChoice != 0);
        } else {
            System.out.println("Media not found in store.");
        }
    }

    // Thêm Media vào Cart (Từ Store Menu)
    public static void addMediaToCart() {
        System.out.print("Enter the title of the media to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        

        if (media != null) {
            try {
                cart.addMedia(media);
                System.out.println("The media has been added. Current cart size: " + cart.getItemsOrdered().size());
            } catch (hust.soict.globalict.aims.exception.LimitExceededException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Media not found in store.");
        }
    }

    // Play Media (Từ Store Menu)
    public static void playMedia() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        

        if (media == null) {
            System.out.println("Media not found in store.");
        } else if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    // 2. CHỨC NĂNG: UPDATE STORE
    public static void updateStore() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.print("Choose option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println(">> (Feature to input new Media details and add to store...)");
            // Logic tạo Media mới và store.addMedia(...)
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if(m != null) store.removeMedia(m);
        }
    }

    // 3. CHỨC NĂNG: SEE CURRENT CART
    public static void seeCurrentCart() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    System.out.print("Enter title to remove from cart: ");
                    String titleToRemove = scanner.nextLine();
                    // Viết hàm lấy Media từ Cart theo Title, sau đó cart.removeMedia(m);
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = cart.searchByTitleReturn(titleToPlay);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            try {
                                ((Playable) mediaToPlay).play();
                            } catch (PlayerException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("An order has been created successfully!");
                    // Làm rỗng giỏ hàng. Bạn cần viết hàm empty() trong lớp Cart:
                    // cart = new Cart(); // Hoặc gọi cart.empty();
                    choice = 0; // Đặt bằng 0 để thoát menu Cart sau khi Order
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // Các hàm hỗ trợ Filter và Sort trong Cart
    public static void filterCart() {
        System.out.println("Filter by: 1. ID | 2. Title");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            cart.searchById(id);
        } else if (option == 2) {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            cart.searchByTitle(title);
        }
    }

    public static void sortCart() {
        System.out.println("Sort by: 1. Title | 2. Cost");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == 1) {
            cart.sortByTitle();
            System.out.println("Cart sorted by Title.");
        } else if (option == 2) {
            cart.sortByCost();
            System.out.println("Cart sorted by Cost.");
        }
    }
}