package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

class Person {

    public String name;
    public ChatRoom room;
    private List<String> chatLog = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public void receive(String sender, String message) {
        String s = sender + ": '" + message + "'";
        System.out.println("[" + name + "'s chat session] " + s);
        chatLog.add(s);
    }

    public void say(String message) {
        room.broadcast(name, message);
    }

    public void privateMessage(String who, String message) {
        room.message(name, who, message);
    }
}

class ChatRoom {

    private List<Person> people = new ArrayList<>();

    public void join(Person person){
        String joinMsg = person.name + " joins the chat";
        broadcast("room", joinMsg);

        person.room = this;
        people.add(person);
    }

    public void broadcast(String source, String message) {
        for(Person p : people)
            if(!p.name.equals(source))
                p.receive(source, message);
    }

    public void message(String source, String destination, String message) {
        people.stream()
                .filter(p -> p.name.equals(destination))
                .findFirst()
                .ifPresent(person -> person.receive(source, message));
    }
}

class ChatRoomDemo
{
    public static void main(String[] args)
    {
        ChatRoom room = new ChatRoom();

        Person john = new Person("John");
        Person jane = new Person("Jane");

        room.join(john); // no message here
        room.join(jane);

        john.say("hi room");
        jane.say("oh, hey john");

        Person simon = new Person("Simon");
        room.join(simon);
        simon.say("hi everyone!");

        jane.privateMessage("Simon", "glad you could join us!");
    }
}