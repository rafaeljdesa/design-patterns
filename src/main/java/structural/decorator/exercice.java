package structural.decorator;

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{
    protected Bird bird;
    protected Lizard lizard;
    private int age;

    public Dragon() {
        this.bird = new Bird();
        this.lizard = new Lizard();
    }

    public Dragon(Bird bird, Lizard lizard, int age) {
        this.bird = bird;
        this.lizard = lizard;
        this.age = age;
    }

    public void setAge(int age)
    {
        if(this.bird != null) {
            this.bird.age = age;
        }
        if(this.lizard != null) {
            this.lizard.age = age;
        }
    }
    public String fly()
    {
        return bird.fly();
    }
    public String crawl()
    {
        return lizard.crawl();
    }
}

class DecoratorDemo {
    public static void main(String[] args) {
        Dragon d = new Dragon(new Bird(), new Lizard(), 5);
        d.setAge(5);
        System.out.println(d.fly());
        System.out.println(d.crawl());
    }
}