package solid.lsp.ey.wrong;

import java.util.Objects;

class Person {

    public String name;

    public String getPresentation() {
        return "My name is " + name;
    }

}

class Employee extends Person {

    public String company;

    @Override
    public String getPresentation() {

        if (Objects.isNull(company))
            throw new RuntimeException("Company must be not null");

        return "My name is " + name + " and i am a employee in " + company;
    }
}

class Employer extends Person {

    public String company;

    @Override
    public String getPresentation() {
        return "";
    }

}

class Curriculum {

    public String getPresentation(Person person) {
        return person.getPresentation();
    }
}

class Demo {

    public static void main(String[] args) {

        Curriculum c = new Curriculum();

        Person person = new Person();
        person.name = "Martin";

        Employee employee = new Employee();
        employee.name = "John";

        Employer employer = new Employer();
        employer.name = "Arthur ";
        employer.company = "EY";

        // print "My name is Martin"
        System.out.println(c.getPresentation(person));

        try {
            // throw exception
            System.out.println(c.getPresentation(employee));
        } catch (RuntimeException e) {

        }

        // print ""
        System.out.println(c.getPresentation(employer));
    }
}