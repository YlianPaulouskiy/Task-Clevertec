package edu.clevertec.task.repository;

import edu.clevertec.task.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс для выполнения запросов к таблице product
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
