package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("boutique")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping ("/check")
    public String check(){
        return "Working...!";
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Product>> getProductsByUserID(@PathVariable Integer userID) {
        List<Product> products = productService.getProductsByUserID(userID);
        return ResponseEntity.ok(products);
    }


    @GetMapping("/getproduct/{pid}")
    public ResponseEntity<Product> getById(@PathVariable Long pid) {
        return new ResponseEntity<Product>(productService.getProductById(pid), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    // @PostMapping("/add")
    // public ResponseEntity<?> createProduct(@RequestBody Product product, HttpServletRequest request) {
    //     String jwtToken = request.getHeader("Authorization").substring(7); // Récupère le token JWT du header (en supposant que le header est "Authorization: Bearer <token>")
    //     productService.addProduct(product, jwtToken);
    //     return ResponseEntity.ok("Product created successfully.");
    // }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)  throws IOException {
        Product user=productService.addProduct(product);
        return new ResponseEntity<Product>(user, HttpStatus.OK);
    }


    @DeleteMapping("delete/{pid}")
    public void deleteProduct(@PathVariable Long pid) {
        productService.deleteProduct(pid);
    }
}
