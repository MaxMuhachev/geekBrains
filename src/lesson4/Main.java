package lesson4;

// 1. Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
//2. Конструктор класса должен заполнять эти поля при создании объекта;
//3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
//4. Вывести при помощи методов из пункта 3 ФИО и должность.
//5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
//6.  * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
//7.  *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику присваивался личный уникальный идентификационный порядковый номер
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Fio", "Manager", 89655738071L, 28000, 23);
        System.out.println("ФИО: " + employee.getFio() + ", Должность " + employee.getPosition());
        Employee empMass[] = new Employee[5];
        empMass[0] = new Employee("Fio1", "Manager", 89655738070L, 33000, 30);
        empMass[1] = new Employee("Fio2", "Manager", 89655738073L, 38000, 35);
        empMass[2] = new Employee("Fio3", "Manager", 89655738074L, 42000, 43);
        empMass[3] = new Employee("Fio4", "Manager", 89655738045L, 45000, 46);
        empMass[4] = new Employee("Fio5", "Manager", 89655738073L, 50000, 50);

        System.out.println("Cотрудники старше 40 лет:");
        for (Employee empl: empMass) {
            if (empl.getAge() >= 40) {
                empl.print();
            }
        }

    }

    private static void plusFiveSalary(Employee[] employees) {
        for (Employee empl: employees) {
            if (empl.getAge() >= 40) {
                empl.setSalary(empl.getSalary());
            }
        }
    }
}