package javase02.t02;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Created by daddyingrave on 25/06/2017.
 * <p>
 * Задание 2. Классы и объекты Напишите приложение, позволяющее вести учет
 * канцелярских товаров на рабочем месте сотрудника. Определите полную стоимость
 * канцтоваров у определенного сотрудника.
 */
public class OfficeSuppliesAccounting {

    private HashMap<String, Employee> staff;

    public OfficeSuppliesAccounting() {
        this.staff = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        staff.put(employee.getName(), employee);
    }

    /**
     * Calculate total price of supplies for employee with given name
     * Suggests name is unique
     */
    public int getSuppliesPrice(String name) {
        if (!staff.containsKey(name)) throw new NoSuchElementException();
        return staff.get(name).getWorkplace().stream()
                .reduce(0, (sum, supply) -> sum += supply.getPrice(),
                        (sum1, sum2) -> sum1 + sum2);
    }

}
