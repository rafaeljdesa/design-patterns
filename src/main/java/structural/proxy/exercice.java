package structural.proxy;

class PersonB
{
    private int age;

    public PersonB(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String drink() { return "drinking"; }
    public String drive() { return "driving"; }
    public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson extends PersonB
{
    private PersonB person;

    public ResponsiblePerson(PersonB person)
    {
        super(person.getAge());
        this.person = person;
    }

    @Override
    public String drink() {
        if (person.getAge() < 18)
            return "too young";
        return super.drink();
    }

    @Override
    public String drive() {
        if (person.getAge() < 16)
            return "too young";
        return super.drive();
    }

    @Override
    public String drinkAndDrive() {
        return "dead";
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
        this.person.setAge(age);
    }

    @Override
    public int getAge() {
        return person.getAge();
    }
}

class ProxyExerciceDemo {
    public static void main(String[] args) {
        PersonB person = new ResponsiblePerson(new PersonB(16));
        person.setAge(13);
        System.out.println(person.drink());
        System.out.println(person.drive());
        System.out.println(person.drinkAndDrive());
    }
}