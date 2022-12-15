package edu.clevertec.task.model;

import java.time.LocalDateTime;
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
        StringBuilder receipt = new StringBuilder();

        receipt.append("Cash Receipt\n")
                .append("Date:").append(LocalDateTime.now())
                .append("Time:").append(LocalDateTime.now())
                .append("QTY\t").append("Description\t").append("Price\t").append("Sale Price\t").append("Total\n");
        for (Product product : products.keySet()) {
            receipt.append(products.get(product)).append("\t")
                    .append(product.getName()).append("\t")
                    .append(product.getPrice()).append("\t")
                    .append(products.get(product) > 5 ? product.getPrice() * 0.1 : "-").append("\t")
                    .append(products.get(product) * product.getPrice()).append("\n");
        }
        receipt.append("--------------------------------------------------\n");
        if (sale != null) {
            receipt.append("Full price:\t\t\t").append(total).append("\n")
                    .append("Sale:\t\t\t").append(sale).append("\n")
                    .append("TOTAL:\t\t\t").append(totalWithSale);
        } else {
            receipt.append("TOTAL:\t\t\t").append(total);
        }
        return receipt.toString();
    }
}
