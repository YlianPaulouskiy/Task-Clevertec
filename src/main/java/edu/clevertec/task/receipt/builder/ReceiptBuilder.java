package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;

import java.time.LocalDateTime;

/**
 * Класс-строитель для создания разных экземпляров класса Receipt
 */
public abstract class ReceiptBuilder {

    protected Receipt receipt;

    /**
     * Создает пустой чек
     */
    public void createReceipt() {
        receipt = new Receipt();
    }

    public void buildMarket() {
        receipt.setMarket("Super My Market");
    }

    /**
     * Устанавливает продукты в чек
     *
     * @param args входные аргументы
     */
    abstract void buildProducts(String[] args);

    /**
     * Устанавливает скидку по дисконтной карте в чек
     *
     * @param args входные аргументы
     */
    abstract void buildSale(String[] args);

    /**
     * Устанавливает в чек полную стоимость без скидки
     *
     * @param args входные аргументы
     */
    abstract void buildTotal(String[] args);

    /**
     * Устанавливает в чек стоимость со скидкой
     *
     * @param args входные аргументы
     */
    abstract void buildTotalWithSale(String[] args);

    /**
     * Устанавливает дату создания чека
     */
    public void buildDate() {
        receipt.setDate(LocalDateTime.now().toString().substring(0, 10));
    }

    /**
     * Устанавливает время создания чека
     */
    public void buildTime() {
        receipt.setTime(LocalDateTime.now().toString().substring(11,19));
    }

    /**
     * Возвращает полученный чек
     *
     * @return Receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }

}
