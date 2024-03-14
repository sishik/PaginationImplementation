package org.pagination.implmentingpagination.Service;

import org.pagination.implmentingpagination.Model.Product;
import org.pagination.implmentingpagination.Repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> getAllProduct(int numberOfProducts, int offset) {
        // Validate numberOfProducts to prevent division by zero
        if (numberOfProducts <= 0) {
            throw new IllegalArgumentException("Number of products per page must be greater than zero");
        }

        int pageNumber = offset / numberOfProducts;
        Page<Product> products = productRepository.findAll(PageRequest.of(pageNumber, numberOfProducts));
        return products;
    }

}
