package org.generation.deployproduct.controller;

import org.generation.deployproduct.Service.ProductService;
import org.generation.deployproduct.controller.DTO.ProductDTO;
import org.generation.deployproduct.repository.Entity.Product;
import org.generation.deployproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@RestController annotation informs the system that we are creating a REST API in this class
//4 REST APIs created in this class to be called by web app
//@RequestMapping provides a path for REST APIs (e.g. http://localhost:8080/product)
@RestController
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;


    //Test - IMPROPER WAY
    /*final ProductRepository productRepository;

    public ProductController(@Autowired ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public Iterable<Product> getProduct() {
        return productRepository.findAll();
    }
     */

    //@Autowired here enables us to use ProductService methods (declared in ProductService class)
    //ProductController is able to use the ProductServices methods to perform the CRUD operations
    public ProductController(@Autowired ProductService productService)
    {
        this.productService = productService;
    }

    //@Mappping - client(browser) makes a http request with the 4 basic methods (i.e. GET, POST, PUT, DELETE)
    //@GetMapping --> if client wants to get all products, it will map to @GetMapping with path "/all"
    //http://localhost:8080/product/all --> if we do this, we want to get all products
    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Product> getProducts()
    {
        return productService.all();
    }

    //Every browser engine will have security to block web app that is not within the same domain
    //(domain meaning servers that are up and running - e.g. tp.edu.sg, generation.org)
    //localhost is a testing environment, it is not a valid domain
    //CORS - Cross Origin Resource Sharing policy
    //We want to disable CORS policy, tell the browser that this (localhost:8080) is a valid domain and run web app
    //@PostMapping handles the POST method from the client
    @CrossOrigin
    @PostMapping("/add")
    public Product save(@RequestParam(name = "Product_code", required = true) int product_code,
                        @RequestParam(name = "name", required = true) String name,
                        @RequestParam(name = "description", required = true) String description,
                        @RequestParam(name = "price", required = true) double price,
                        @RequestParam(name = "image_url", required = true) String image_url,
                        @RequestParam(name = "category", required = true) String category,
                        @RequestParam("imagefile") MultipartFile multipartFile) throws IOException
    {
        String uploadDir1 = "productImages/images";

        System.out.println("Inside");

        System.out.println("aaaa: " + multipartFile.getOriginalFilename());

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        FileUploadUtil.saveFile(uploadDir1, fileName, multipartFile);

        ProductDTO productDTO = new ProductDTO(product_code, name, description, price, image_url, category);
        Product product = new Product(productDTO);
        return productService.save(product);
    }

    //GetMapping handles the GET method from client with path "/{id}"
    @CrossOrigin
    @GetMapping("/{id}")
    public Product findProductById(@PathVariable Integer id)
    {
        return productService.findById(id);
    }

    //PutMapping handles the PUT method from client
    @CrossOrigin
    @PutMapping("/{id}")
    public Product update( @PathVariable Integer id, @RequestBody ProductDTO productDto)
    //public Product update(@PathVariable Integer id
    {
        System.out.println("Hello");
        Product product = productService.findById(id);
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImage_url(productDto.getImage_url());
        product.setPrice(productDto.getPrice());
        return productService.save(product);
    }

    //DeleteMapping handles the DELETE method from client
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        productService.delete(id);
    }

}
