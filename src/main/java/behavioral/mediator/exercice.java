package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

class Participant
{
    int value = 0;
    Mediator mediator;

    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        this.mediator.participants.add(this);
    }

    public void say(int n)
    {
        mediator.broadcast(this, n);
    }
}

class Mediator
{
    List<Participant> participants = new ArrayList<>();

    public void broadcast(Participant participant, int value) {
        participants.forEach(p -> {
            if(!p.equals(participant)) {
                p.value += value;
            }
        });
    }

}