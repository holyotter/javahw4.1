package ru.netology.repository;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];


    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() { // возвращает массив продуктов

        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) { //берем из переменной item продукт, с помощью неё запросим у рассматриваемого
                return item;            // на данном этапе цикла продукта id и сравним с id  в параметере метода)
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}




