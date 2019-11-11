package creational.builder;

class PersonB {

    // address
    public String streetAddress, postcode, city;

    // employment
    public String companyName, position;
    public int annualIncome;

    @Override
    public String toString() {
        return "PersonB{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncome=" + annualIncome +
                '}';
    }
}

// builder facade
class PersonBBuilder {

    protected PersonB person = new PersonB();

    public PersonB build() {
        return person;
    }

    public PersonBAddressBuilder lives() {
        return new PersonBAddressBuilder(person);
    }

    public PersonBJobBuilder works() {
        return new PersonBJobBuilder(person);
    }

}

class PersonBAddressBuilder extends PersonBBuilder {

    public PersonBAddressBuilder(PersonB person) {
        this.person = person;
    }

    public PersonBAddressBuilder at(String streetAddress) {
        person.streetAddress = streetAddress;
        return this;
    }

    public PersonBAddressBuilder in(String city) {
        person.city = city;
        return this;
    }

    public PersonBAddressBuilder withPostCode(String postCode) {
        person.postcode = postCode;
        return this;
    }

}

class PersonBJobBuilder extends PersonBBuilder {

    public PersonBJobBuilder(PersonB person) {
        this.person = person;
    }

    public PersonBJobBuilder at(String companyName) {
        person.companyName = companyName;
        return this;
    }
    public PersonBJobBuilder asA(String position) {
        person.position = position;
        return this;
    }
    public PersonBJobBuilder earning(int annualIncome) {
        person.annualIncome = annualIncome;
        return this;
    }

}

class DemoFacatedBuilder {
    public static void main(String[] args) {
        PersonBBuilder pb = new PersonBBuilder();
        PersonB person = pb
            .lives()
                .at("Praia de botafogo")
                .in("Rio de Janeiro")
                .withPostCode("RJ")
            .works()
                .at("EY")
                .asA("Developer")
                .earning(10000)
            .build();
        System.out.println(person);
    }
}