public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean isName;
    private boolean isSurname;
    private boolean isAge;
    private boolean isAddress;

    public Person build() {
        if (!isName || !isSurname) {
            throw new IllegalArgumentException("Не хватает обяхательных полей");
        }

        if (!isAge && !isAddress) {
            return new Person(name, surname);
        } else if (!isAddress) {
            return new Person(name, surname, age);
        } else if (!isAge) {
            return new Person(name, surname, address);
        } else {
            return new Person(name, surname, age, address);
        }
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        isName = true;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        isSurname = true;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(age + " - Возраст недопустимыйт");
        } else {
            this.age = age;
            isAge = true;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        isAddress = true;
        return this;
    }
}