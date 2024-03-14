package org.pagination.implmentingpagination.Service;
import org.pagination.implmentingpagination.Model.Product;
import org.springframework.data.domain.Page;
import java.util.List;
public interface ProductService {
    List<Product> getAllProducts();
    Page<Product>getAllProduct(int numberOfProducts, int offset);
}
