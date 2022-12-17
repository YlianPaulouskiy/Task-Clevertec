package edu.clevertec.task.model;

import java.time.LocalDateTime;
import java.util.Map;

import static org.apache.commons.math3.util.Precision.round;

/**
 * Модель чека
 */
public class Receipt {

    private String market;
    private Map<Product, Integer> products;
    private Double sale;
    private Double total;
    private Double totalWithSale;
    private String date;
    private String time;

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("\n\nCash Receipt\n")
                .append("Date:").append(LocalDateTime.now().toString(), 0, 10)
                .append("\nTime:").append(LocalDateTime.now().toString(), 11, 19)
                .append("\nQTY\t").append("Description\t").append("Price\t").append("Sale Price\t").append("Total\n");
        for (Product product : products.keySet()) {
            double salePrice = products.get(product) > 5
                    ? round((product.getPrice() - product.getPrice() * 0.1), 2)
                    : 0.0;
            receipt.append(products.get(product)).append("\t")
                    .append(product.getName()).append("\t\t")
                    .append(round(product.getPrice(), 2)).append("\t")
                    .append(salePrice == 0.0 ? "-" : salePrice).append("\t\t")
                    .append(salePrice == 0.0
                            ? round(products.get(product) * product.getPrice(), 2)
                            : round(products.get(product) * salePrice, 2)).append("\n");
        }
        receipt.append("--------------------------------------------------\n");
        if (sale != null) {
            receipt.append("Full price:\t\t").append(round(total, 2)).append("\n")
                    .append("Card Sale:\t\t").append(round(sale, 2)).append("\n")
                    .append("TOTAL:\t\t\t").append(round(totalWithSale, 2));
        } else {
            receipt.append("TOTAL:\t\t\t").append(round(total, 2)).append("\n\n");
        }
        return receipt.toString();
    }
}
