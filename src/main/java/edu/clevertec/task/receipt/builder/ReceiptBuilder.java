package edu.clevertec.task.receipt.builder;

import edu.clevertec.task.model.Receipt;

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
     * Возвращает полученный чек
     *
     * @return Receipt
     */
    public Receipt getReceipt() {
        return receipt;
    }

}
