package org.pagination.implmentingpagination.Repository;

import org.pagination.implmentingpagination.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findAll();
    Page<Product> findAll(Pageable pageable);
}
