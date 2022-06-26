public class Person {

    String code_meli,name,sex;
    int age;
    double wallet;

    public Person(String code_meli, String name, String sex, int age, double wallet) {
        this.code_meli = code_meli;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "code_meli='" + code_meli + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", wallet=" + wallet +
                '}';
    }
}
