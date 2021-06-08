//Doing a Product web app, in product page to display the name, description, imageURL, style, price ....

const createHTMLList = (index, code, name, price, description, imageurl, category) =>
    `<div class="card mb-5" style="width:18rem">
        <img src="${imageurl}" class="card-img-top" alt="...">
        <div class="card-body text-center">
            <h5 class="card-title">${name}</h5>
            <p class="card-text"></p>
            <p>${price}</p>
            <a id="${index}" href="#" class="btn btn-primary" data-toggle="modal" data-target="#productModal">More</a>
                      
        </div>
    </div>`;

const createColorDropdown = (colorArray) => {
    console.log(colorArray);
    var colorCode = "";
    for (i = 0; i < colorArray.length; i++) {

        colorCode = colorCode + `<a class="dropdown-item" href="#">${(colorArray[i].oColor.substring(0, 1)).toUpperCase() + colorArray[i].oColor.substring(1)}</a>`;
    }
    return colorCode;

    //document.querySelector("#colorDropdown").innerHTML = ..;
}

function displayProductModal(item) {
    document.querySelector("#modalName").innerText = item.oName;
    document.querySelector("#modalCode").innerText = item.oId;
    document.querySelector("#modalImg").src = item.oImage_url;
    document.querySelector("#modalDescription").innerText = item.oDescription;
    document.querySelector("#modalPrice").innerText = item.oPrice;
    document.querySelector("#colorDropdown").innerHTML = createColorDropdown(item.oColorArray);
}

class ProductsController {
    constructor() {
        this._items = [];   //create an array to store the details of product items
    }

    //method to add the items into the array
    addItem(product_code, name, price, description, image_url, category, imagePath, colorArray) {

        var productController = this;

        const itemObj = {
            product_code: product_code,
            name: name,
            price: price,
            description: description,
            imageUrl: image_url,
            category: category,
            colorArray: colorArray
        };

        console.log(colorArray)

        const formData = new FormData();
        formData.append('product_code', product_code);
        formData.append('name', name);
        formData.append('description', description);
        formData.append('price', price);
        formData.append('image_url', image_url);
        formData.append('category', category);
        formData.append('imagefile', imagePath);

//        fetch('http://localhost:8080/product/add', {
        fetch('https://deployproductl3c.herokuapp.com/product/add', {
            method: 'POST',
            body: formData
        })
            .then(response => response.json())
            .then(data => {
                console.log("Success", data);
                    for (var i=0; i<colorArray.length; i++) {
                        console.log(colorArray[i]);
                        const formColorData = new FormData();
                        formColorData.append('product_Product_code', product_code);
                        formColorData.append('color', colorArray[i]);

//                        fetch('http://localhost:8080/product_color/add', {
                        fetch('https://deployproductl3c.herokuapp.com/product_color/add', {
                            method: 'POST',
                            body: formColorData
                        })
                        .then(resp => resp.json())
                        .then(data => {
                            console.log("Success adding color", data);
                        })
                        .catch((error) => {
                            console.error("Error", error);
                            alert("Error adding item to product")
                        });
                    }
            })
            .catch((error) => {
                console.error("Error", error);
                alert("Error adding item to product")
            });

        //        this._items.push(itemObj);

    }

    displayItem() {
        //fetch data from database using REST API endpoint from Spring Boot
        var productController = this;
        productController._items = [];
        //var colorArray = [];
        //console.log(colorArray);

        fetch('http://localhost:8080/product/all')
        //fetch('https://deployproductl3c.herokuapp.com/product/all')
            .then((resp) => resp.json())
            .then(function (data) {
                console.log("1. receive product data");
                console.log(data);

                data.forEach(function (product, index1) {
                    var colorArray = [];

                    fetch('http://localhost:8080/product_color/all')
                    //fetch('https://deployproductl3c.herokuapp.com/product_color/all')
                    .then((resp) => resp.json())
                    .then(function (dataColor) {
                        dataColor.forEach(function (product_color, index2) {
                            if (product_color.product_Product_code == product.product_code)
                            {
                                const productColorObj =
                                {
                                    oId: product_color.product_Color_id,
                                    oCode: product_color.product_Product_code,
                                    oColor: product_color.color
                                };
                                colorArray.push(productColorObj);
                                //console.log(colorArray);
                            }
                        });

                        //console.log(colorArray);
                    })
                    .catch(function (error) {
                        console.log(error);
                    });

                    const productObj = {
                        oId: product.product_code,
                        oName: product.name,
                        oDescription: product.description,
                        oImage_url: product.imageUrl,
                        oCategory: product.category,
                        oPrice: product.price,
                        oColorArray: colorArray
                    };
                    //console.log(colorArray);
                    productController._items.push(productObj);

                    //console.log(productController._items);
                });

                productController.render();

            })
            .catch(function (error) {
                console.log(error);
            });

    }

    render() {
        var productController = this;
        var productHTMLList = [];

        //for men
        productHTMLList.push('<div style="width:100%; text-align: center"><h2 class="display-4" style="font-size: 40px;">For Men</h2></div>');
        productHTMLList.push('<div style="width:100%; text-align: center"><h3 class="display-4 mb-4" style="font-size: 25px;">Ready for the workplace or recreational events</h3></div>');

        for (var i = 0; i < productController._items.length; i++) {

            if (this._items[i].oCategory == "men") {
                const item = productController._items[i];    //this is to assign the individual items to the variable

                const productHTML = createHTMLList(i, item.oId, item.oName, item.oPrice, item.oDescription, item.oImage_url, item.oCategory);

                productHTMLList.push(productHTML);
            }
        }
        //add empty child div to ensure cards aligns to left side, all cards have width:18rem
        for (i = 0; i <= 3 - (this._items.length % 3); i++) {
            productHTMLList.push('<div style="width:18rem">\n</div>');
        }



        //for Ladies
        productHTMLList.push('<div style="width:100%; text-align: center"><h2 class="display-4" style="font-size: 40px;">For Ladies</h2></div>');
        productHTMLList.push('<div style="width:100%; text-align: center"><h3 class="display-4 mb-4" style="font-size: 25px;">Look chic and stylish for the office or gatherings</h3></div>');

        for (var i = 0; i < this._items.length; i++) {
            if (this._items[i].oCategory == "ladies") {
                const item = this._items[i];    //this is to assign the individual items to the variable

                const productHTML = createHTMLList(i, item.oId, item.oName, item.oPrice, item.oDescription, item.oImage_url, item.oCategory);

                productHTMLList.push(productHTML);
            }
        }
        //add empty child div to ensure cards aligns to left side, all cards have width:18rem
        for (i = 0; i <= 3 - (this._items.length % 3); i++) {
            productHTMLList.push('<div style="width:18rem">\n</div>');
        }



        //for Kids
        productHTMLList.push('<div style="width:100%; text-align: center"><h2 class="display-4" style="font-size: 40px;">For Kids</h2></div>');
        productHTMLList.push('<div style="width:100%; text-align: center"><h3 class="display-4 mb-4" style="font-size: 25px;">Suitable for school or the playground</h3></div>');

        for (var i = 0; i < this._items.length; i++) {
            if (this._items[i].oCategory == "kids") {
                const item = this._items[i];    //this is to assign the individual items to the variable

                const productHTML = createHTMLList(i, item.oId, item.oName, item.oPrice, item.oDescription, item.oImage_url, item.oCategory);

                productHTMLList.push(productHTML);
            }
        }
        //add empty child div to ensure cards aligns to left side, all cards have width:18rem
        for (i = 0; i <= 3 - (this._items.length % 3); i++) {
            productHTMLList.push('<div style="width:18rem">\n</div>');
        }


        //join all the elements/items in my productHTMLList array into one string, and seperate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;

        //addEventListener - click event
        for (let i = 0; i < this._items.length; i++) {
            const item = this._items[i];
            document.getElementById(i).addEventListener("click", function () { displayProductModal(item); });
        }

    }

}   //End of ProductsController class