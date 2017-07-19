package javase02.t02;

import javase02.t02.supplies.*;
import javase02.t03.StationeryProduct;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by daddyingrave on 26/06/2017.
 */
public class OfficeSuppliesAccountingTest {

    private List<StationeryProduct> supplies = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Random random = new Random();

    @Before
    public void fillSupplies() {
        supplies.add(new Calendar(20));
        supplies.add(new Glue(5));
        supplies.add(new Pen(8));
        supplies.add(new Pencil(3));
        supplies.add(new Puncher(15));
        supplies.add(new Scissors(4));
    }

    @Before
    public void fillEmployees() {
        int[] nums = {random.nextInt(6),
                random.nextInt(6),
                random.nextInt(6),
                random.nextInt(6),
                random.nextInt(6)
        };
        System.out.println(Arrays.toString(nums));
        employees.add(new Employee("Adam")
                .addSupply(supplies.get(nums[0]))
                .addSupply(supplies.get(nums[1]))
                .addSupply(supplies.get(nums[2]))
                .addSupply(supplies.get(nums[3]))
                .addSupply(supplies.get(nums[4]))
        );
        int[] nums2 = {random.nextInt(6),
                random.nextInt(6),
                random.nextInt(6),
                random.nextInt(6),
                random.nextInt(6)
        };
        System.out.println(Arrays.toString(nums2));
        employees.add(new Employee("Boris")
                .addSupply(supplies.get(nums2[0]))
                .addSupply(supplies.get(nums2[1]))
                .addSupply(supplies.get(nums2[2]))
                .addSupply(supplies.get(nums2[3]))
                .addSupply(supplies.get(nums2[4]))
        );
        employees.add(new Employee("Anton") //full price is 55
                .addSupply(supplies.get(0))
                .addSupply(supplies.get(1))
                .addSupply(supplies.get(2))
                .addSupply(supplies.get(3))
                .addSupply(supplies.get(4))
                .addSupply(supplies.get(5))
        );
    }

    @Test
    public void getSuppliesPrice() throws Exception {
        OfficeSuppliesAccounting accounting = new OfficeSuppliesAccounting();
        accounting.addEmployee(employees.get(0));
        accounting.addEmployee(employees.get(1));
        accounting.addEmployee(employees.get(2));
        assertThat(accounting.getSuppliesPrice("Anton"), is(55));
        System.out.println(accounting.getSuppliesPrice("Adam"));
        System.out.println(accounting.getSuppliesPrice("Boris"));
    }

}