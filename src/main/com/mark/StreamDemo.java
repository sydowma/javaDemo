package main.com.mark;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author magaofei
 * @date 2021/10/12
 */
public class StreamDemo {

    static class Person {
        private Integer value1;
        private BigDecimal value2;

        public Integer getValue1() {
            return value1;
        }

        public void setValue1(Integer value1) {
            this.value1 = value1;
        }

        public BigDecimal getValue2() {
            return value2;
        }

        public void setValue2(BigDecimal value2) {
            this.value2 = value2;
        }
    }
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setValue1(1);
        person1.setValue2(BigDecimal.valueOf(1));

        Person person2 = new Person();
        person2.setValue1(2);
        person2.setValue2(BigDecimal.valueOf(2));

        personList.add(person1);
        personList.add(person2);

//        personList.stream().map(Person::getValue2).map(BigDecimal::plus).;
    }
}
