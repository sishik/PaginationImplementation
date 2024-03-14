package org.pagination.implmentingpagination.Controller;

import org.pagination.implmentingpagination.Dtos.GetProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.pagination.implmentingpagination.Service.ProductService;
import org.pagination.implmentingpagination.Model.Product;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/")
    public String home(){
        return "Welcome to the product page";
    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    //implementing Pagination
    //http://localhost:8080/products?page=1&size=2 example
    //so In pagination along with when gieven limit and offset all frameworks support
    //along with actual data they return metadata also. In which it says it maintains
    // total number of records and total number of pages. or it has hasnext or hasprevious maintained
    // so that we can easily navigate to next page or previous page. or sometimes for infinite scrolling
    //we show total number of records and total number of pages.
    //In SpringBoot in controller we will pass page and size as query parameter. and service as well
    //so that we can get the data accordingly.
    //but in repository we will pass Pageable object. so that we can get the data accordingly.
    //Pageable is a interface which has implementation of PageRequest.
    //PageRequest is a class which has implementation of Pageable.
    //and when we pass Pageable object to repository method. it will return Page object.
    //Page object has implementation of List and metadata.
    //so we can get the data and metadata as well.
    //In controller we try to get Page object
    @GetMapping("/products/pagination")
    public ResponseEntity<Page<Product>> getAllProduct(@RequestParam int limit, @RequestParam int offset) {
        Page<Product> page = productService.getAllProduct(limit, offset);
        return ResponseEntity.ok(page);
    }
    //In this way we can implement pagination in spring boot.
}
