package lesson4;

class Employee {
    private String fio;
    private String position;
    private Long phone;
    private Integer salary;
    private Integer age;
    private  int id = 0;

    Employee(String fio, String position, Long phone, Integer salary, Integer age) {
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
        id = id + 1;
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public Long getPhone() {
        return phone;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void print() {
        System.out.println("id: " + id + ", ФИО: " + fio + ", Должность: " + position + ", Телефон: " + phone + ", Зарплата: " + salary + ", Возраст: " + age);
    }
}