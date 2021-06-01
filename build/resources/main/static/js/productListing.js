// to create an instance of ProductsController Class
const productsControl = new ProductsController();

function loadData() {
    //add items to the ProductsController Class - items currently are hard coded into the class

    productsControl.addItem("31263", "Rugged Backpack", ["black", "red", "blue", "white"], "$69.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/featured-bag3.jpg", "men");

    productsControl.addItem("12312", "Stylish Backpack", ["black", "white", "pink"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag1.jpg", "ladies");

    productsControl.addItem("54567", "Playful Backpack", ["black", "pink"], "$25.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag2.jpg", "kids");

    productsControl.addItem("21314", "Social Backpack", ["black", "blue", "brown", "white"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag2.jpg", "ladies");

    productsControl.addItem("65743", "After-work Backpack", ["black"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/featured-bag2.jpg", "men");

    productsControl.addItem("54587", "Fun Backpack", ["black", "pink"], "$25.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag3.jpg", "kids");

    productsControl.addItem("21314", "Fashionable Backpack", ["black", "blue", "brown", "white"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag3.jpg", "ladies");

    productsControl.addItem("65743", "Outdoor Backpack", ["black"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag1.jpg", "men");

    productsControl.addItem("54587", "School Backpack", ["black", "pink"], "$25.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/featured-bag3.jpg", "kids");
    
    productsControl.addItem("21314", "Gym Backpack", ["black", "blue", "brown", "white"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/featured-bag1.jpg", "ladies");

    productsControl.addItem("65743", "Ball games Backpack", ["black", "blue"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag3.jpg", "men");

    productsControl.addItem("54587", "Sports day Backpack", ["black", "pink", "red"], "$25.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag1.jpg", "kids");
    
    productsControl.addItem("31263", "Hiking Backpack", ["black", "red", "blue", "white"], "$69.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/featured-bag3.jpg", "men");
    
    productsControl.addItem("12312", "Meet-up Backpack", ["black", "white", "pink"], "$59.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag1.jpg", "ladies");
    
    productsControl.addItem("54567", "Friends Backpack", ["black", "pink"], "$25.90", "Lorem ipsum dolor sit, amet consectetur adipisicing elit.", "images/bag2.jpg", "kids");
    
    productsControl.displayItem();
}

loadData();