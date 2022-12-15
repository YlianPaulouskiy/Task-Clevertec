package edu.clevertec.task.model;

import edu.clevertec.task.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class Receipt {

    private Map<Product, Integer> products;
    private Double sale;
    private Double total;
    private Double totalWithSale;

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTotalWithSale() {
        return totalWithSale;
    }

    public void setTotalWithSale(Double totalWithSale) {
        this.totalWithSale = totalWithSale;
    }


    @Override
    public String toString() {
//        StringBuilder receipt = new StringBuilder();
//
//        receipt.append("Cash Receipt\n")
//                .append("QTY\t").append("Description\t").append("Price\t").append("Sale Price\t").append("Total\n");
//        for (Long id : products.keySet()) {
//            receipt.append(products.get(id)).append("\t");
//            receipt.append(productRepository.getReferenceById(id))
//        }
        return "Receipt{" +
                "products=" + products +
                ", sale=" + sale +
                ", total=" + total +
                ", totalWithSale=" + totalWithSale +
                '}';
    }
}
