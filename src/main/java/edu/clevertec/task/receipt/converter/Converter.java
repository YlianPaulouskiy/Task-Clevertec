package edu.clevertec.task.receipt.converter;

import edu.clevertec.task.model.Product;
import edu.clevertec.task.receipt.exception.IncorrectInputSourceException;
import edu.clevertec.task.receipt.exception.ProductNotFoundException;
import edu.clevertec.task.receipt.lines.LineCheck;
import edu.clevertec.task.receipt.lines.LineParsing;
import edu.clevertec.task.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для преобразования входных аргументов
 * в нужные для расчетов элементы
 */
@Component
@AllArgsConstructor
public class Converter {

    private final ProductRepository productRepository;

    /**
     * Метод для получения id товаров и их кол-ва
     *
     * @param args входные аргументы
     * @return Карта(id, кол - во)
     */
    public Map<Long, Integer> getProductIds(String[] args) {
        Map<Long, Integer> products = new HashMap<>();
        for (String element : args) {
            if (!LineCheck.isCardSource(element)) { //откидываем элемент с дисконтной картой
                products.put(
                        Long.valueOf(LineParsing.getLeftPart(element)),
                        Integer.valueOf(LineParsing.getRightPart(element))
                );
            }
        }
        return products;
    }

    /**
     * Метод возвращающий номер скидочной карты, если такая имеется
     *
     * @param args входные аргументы
     * @return номер скидочной карты
     */
    public Integer getDiscountCard(String[] args) {
        for (String element : args) {
            if (LineCheck.isCardSource(element)) { //находим элемент с дисконтной картой
                return Integer.valueOf(LineParsing.getRightPart(element));
            }
        }
        return null;
    }

    /**
     * Метод для получения Продуктов и их кол-ва
     *
     * @param args входные аргументы
     * @return Карта(Product, кол - во)
     */
    public Map<Product, Integer> getProducts(String[] args) {
        Map<Long, Integer> productsIds = getProductIds(args);
        Map<Product, Integer> products = new HashMap<>();
        for (Long productId : productsIds.keySet()) {
            if (productRepository.existsById(productId)) {
                products.put(
                        productRepository.getReferenceById(productId),
                        productsIds.get(productId)
                );
            } else {
                throw new ProductNotFoundException("Product " + productId + " not founded.");
            }
        }
        return products;
    }

    /**
     * Преобразует строку в аргументы (товар-кол-во и карта-номер)
     *
     * @param source Аргументы, передающиеся в виде строки
     * @return массив аргументов
     */
    public String[] getArgs(String source) {
        if (LineCheck.isCorrectSource(source)) {
            return LineParsing.parse(source);
        } else {
            throw new IncorrectInputSourceException();
        }
    }

}
