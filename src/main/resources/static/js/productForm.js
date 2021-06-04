const productControl = new ProductsController();

var storeImage;

item_form.addEventListener("submit", (event) => {

    //When a user clicks on 'Save Item' button, call API to add items to the database
    //Add an "onsubmit" eventListener for product form to add a product
    event.preventDefault();

    //Select the inputs and store into constants
    const newItemCode = document.querySelector("#item-code");
    const newItemName = document.querySelector("#item-name");
    const newItemPrice = document.querySelector("#item-price");
    const newItemDescription = document.querySelector("#item-description");
    const newItemCategory = document.querySelector("#item-category");
    const newItemImageUrl = document.querySelector("#imagefile");

    //Insert validation code here

    //Get the values of the inputs - variable names to be same as MySQL columns
    const Product_code = newItemCode.value;
    const name = newItemName.value;
    const price = newItemPrice.value;
    const description = newItemDescription.value;
    const category = newItemCategory.value;
    console.log("image path: " + newItemImageUrl.value);
    const imageUrl = "images/" + newItemImageUrl.value.replace("C:\\fakepath\\", "");
    //Removing "C:\\fakepath\\" from URL, instead saves as "images/<filename.filetype>"

    //Clear the form
    resetForm();

    productControl.addItem(Product_code, name, price, description, imageUrl, category, storeImage)

})

//Select file input
const input = document.querySelector("#imagefile");

//Add event listener
input.addEventListener("change", () => {
    storeImage = input.files[0];
    console.log("input: " + storeImage);
});