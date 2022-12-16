package edu.clevertec.task.repository;

import edu.clevertec.task.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для выполнения запросов к таблице product
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
