//For checkbox and quantity input validation
document.querySelector("#checkBlack").onchange = function () {
    document.querySelector("#qtyBlack").disabled = !this.checked;
    document.querySelector("#qtyBlack").value = "";
    document.querySelector("#qtyBlack").required = this.checked;
};

document.querySelector("#checkBlue").onchange = function () {
    document.querySelector("#qtyBlue").disabled = !this.checked;
    document.querySelector("#qtyBlue").value = "";
    document.querySelector("#qtyBlue").required = this.checked;
};

document.querySelector("#checkBrown").onchange = function () {
    document.querySelector("#qtyBrown").disabled = !this.checked;
    document.querySelector("#qtyBrown").value = "";
    document.querySelector("#qtyBrown").required = this.checked;
};

document.querySelector("#checkPink").onchange = function () {
    document.querySelector("#qtyPink").disabled = !this.checked;
    document.querySelector("#qtyPink").value = "";
    document.querySelector("#qtyPink").required = this.checked;
};

document.querySelector("#checkRed").onchange = function () {
    document.querySelector("#qtyRed").disabled = !this.checked;
    document.querySelector("#qtyRed").value = "";
    document.querySelector("#qtyRed").required = this.checked;
};

document.querySelector("#checkWhite").onchange = function () {
    document.querySelector("#qtyWhite").disabled = !this.checked;
    document.querySelector("#qtyWhite").value = "";
    document.querySelector("#qtyWhite").required = this.checked;
};




//For saving of user input form data
const productControl = new ProductsController();

var storeImage;

var formList = [];

function resetError() {
    document.querySelector("#checkboxErrorMsg").innerHTML = "";
    document.querySelector("#itemCodeErrorMsg").innerHTML = "";
    document.querySelector("#itemNameErrorMsg").innerHTML = "";
    document.querySelector("#itemDescriptionErrorMsg").innerHTML = "";
}

function resetForm() {
    document.querySelector("#item_form").reset();

    var qtyInput = document.querySelectorAll('.qty-input');
    for (let i = 0; i < qtyInput.length; i++) {
        qtyInput[i].setAttribute("disabled", "disabled");
    };
}

function submitForm() {

    resetError();

    var itemCode = document.querySelector("#item-code").value;
    var itemName = document.querySelector("#item-name").value;
    var itemCategory = document.querySelector("#item-category").value;
    var itemPrice = document.querySelector("#item-price").value;
    var itemDescript = document.querySelector("#item-description").value;

    var newItemImageUrl = document.querySelector("#imagefile");
    var imageUrl = "images/" + newItemImageUrl.value.replace("C:\\fakepath\\", "");

    var colorArray = [];
    if (document.querySelector("#checkBlack").checked == true) {
        colorArray.push(document.querySelector("#checkBlack").value);
    }

    if (document.querySelector("#checkBlue").checked == true) {
        colorArray.push(document.querySelector("#checkBlue").value);
    }

    if (document.querySelector("#checkBrown").checked == true) {
        colorArray.push(document.querySelector("#checkBrown").value);
    }

    if (document.querySelector("#checkPink").checked == true) {
        colorArray.push(document.querySelector("#checkPink").value);
    }

    if (document.querySelector("#checkRed").checked == true) {
        colorArray.push(document.querySelector("#checkRed").value);
    }

    if (document.querySelector("#checkWhite").checked == true) {
        colorArray.push(document.querySelector("#checkWhite").value);
    }

    var checkboxArray = [];
    checkboxArray.push(document.querySelector("#checkBlack").checked);
    checkboxArray.push(document.querySelector("#checkBlue").checked);
    checkboxArray.push(document.querySelector("#checkBrown").checked);
    checkboxArray.push(document.querySelector("#checkPink").checked);
    checkboxArray.push(document.querySelector("#checkRed").checked);
    checkboxArray.push(document.querySelector("#checkWhite").checked);

    var foundColor = false;
    checkboxArray.forEach(item => {
        if (item) {
            foundColor = true;
        }
    });

    if (!foundColor) {
        document.querySelector("#checkboxErrorMsg").innerHTML = "Please select at least one color";
        document.querySelector("#checkboxErrorMsg").style.color = "#ff0000";
    }

    var foundCode = false;
    if (itemCode.length > 8) {
        document.querySelector("#itemCodeErrorMsg").innerHTML = "Item code should not be more than 8 characters";
    } else if (itemCode.indexOf(" ") > -1) {
        document.querySelector("#itemCodeErrorMsg").innerHTML = "Item code should not contain spaces";
    } else if (/[^a-zA-Z0-9\-\/]/.test(itemCode)) {
        document.querySelector("#itemCodeErrorMsg").innerHTML = "Item code should not contain special characters";
    } else {
        foundCode = true;
    }

    var foundName = false;
    if (itemName.length > 30) {
        document.querySelector("#itemNameErrorMsg").innerHTML = "Item name should be less than 30 characters";
    } else {
        foundName = true;
    }

    var foundDescript = false;
    if (itemDescript.length > 80) {
        document.querySelector("#itemDescriptionErrorMsg").innerHTML = "Item description should be less than 80 characters";
    } else {
        foundDescript = true;
    }

    if (foundColor && foundCode && foundName && foundDescript) {
        addToList(itemCode, itemName, itemCategory, colorArray, itemPrice, itemDescript);

        //Add the task to the task manager
        productControl.addItem(itemCode, itemName, itemPrice, itemDescript, imageUrl, itemCategory, storeImage);

        resetForm();
        $("#formModal").modal("show");
    }
}

//Select file input
const input = document.querySelector("#imagefile");

//Add event listener
input.addEventListener("change", () => {
    storeImage = input.files[0];
    console.log("input: " + storeImage);
    //uploadFile(input.files[0]);
});

function addToList(itemCode, itemName, itemCategory, colorArray, itemPrice, itemDescript) {
    const item = {
        iCode: itemCode,
        iName: itemName,
        iCategory: itemCategory,
        iColorArray: colorArray,
        iPrice: itemPrice,
        iDescript: itemDescript,
    }
    formList.push(item);
    listForm();
}

function listForm() {
    console.log(`Total items: ${formList.length}`);
    console.log(formList);
}


// function displaySuccessModal() {
//     document.querySelector("#submitFormButton").setAttribute(data - toggle, "modal");
//     document.querySelector("#submitFormButton").setAttribute(data - target, "#formModal");
// }