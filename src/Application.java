class Product {
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private String supplierEmail;

    public Product(String name, String category, double price, int stockQuantity, String supplierEmail) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.supplierEmail = supplierEmail;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public void restock(int amount) {
        stockQuantity += amount;
        System.out.println("Restocked " + amount + " units of " + name + ".");
    }

    public void sell(int amount) {
        if (amount <= stockQuantity) {
            stockQuantity -= amount;
            System.out.println("Sold " + amount + " units of " + name + ".");
        } else {
            System.out.println("Not enough stock to sell " + amount + " units of " + name + ".");
        }
    }
}

class InventoryManager extends Product {
    private String department;
    private int managedProductsCount;
    private boolean isLoggedIn;

    public InventoryManager(String name, String category, double price, int stockQuantity, String supplierEmail, String department) {
        super(name, category, price, stockQuantity, supplierEmail);
        this.department = department;
        this.managedProductsCount = 0;
        this.isLoggedIn = false;
    }

    public void logIn() {
        isLoggedIn = true;
        System.out.println("Manager logged in.");
    }

    public void logOut() {
        isLoggedIn = false;
        System.out.println("Manager logged out.");
    }

    public void assignProduct() {
        managedProductsCount++;
        System.out.println("Assigned a new product. Total managed products: " + managedProductsCount);
    }

    public void viewReports() {
        System.out.println("Viewing reports for department: " + department);

    }

    public void displayManagerData() {
        System.out.println("Manager Department: " + department);
        System.out.println("Managed Products Count: " + managedProductsCount);
        System.out.println("Is Logged In: " + isLoggedIn);
    }
}



public class Application {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager("Laptop", "Electronics", 1500.00, 10, "supplier@example.com", "IT Department");
        manager.logIn();
        manager.assignProduct();
        manager.displayManagerData();
        manager.sell(2);
        manager.restock(5);
        manager.displayManagerData();
        manager.logOut();
    }
}
