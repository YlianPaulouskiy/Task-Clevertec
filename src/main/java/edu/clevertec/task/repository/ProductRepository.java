package edu.clevertec.task.repository;

import edu.clevertec.task.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
