package solid.lsp.ey.right;

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
        return "My name is " + name + " and i am a employee in " + company;
    }
}

class Employer extends Person {

    public String company;

    @Override
    public String getPresentation() {
        return "My name is " + name + " and i am a employer in " + company;
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
        employee.company = "EY";

        Employer employer = new Employer();
        employer.name = "Arthur ";
        employer.company = "EY";

        // print "My name is Martin"
        System.out.println(c.getPresentation(person));

        // print "My name is John and i am a employee in EY"
        System.out.println(c.getPresentation(employee));

        // print "My name is Arthur and i am a employer in EY"
        System.out.println(c.getPresentation(employer));
    }
}