package behavioral.observer;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Game
{
    private List<Rat> ratsObserver = new ArrayList<>();

    public void subscribe(Rat rat) {
        ratsObserver.add(rat);
        updateAttack();
    }

    public void unsubsCribe(Rat rat) {
        ratsObserver.remove(rat);
        updateAttack();
    }

    private void updateAttack() {

        int newAttack = ratsObserver.size();

        ratsObserver.forEach(r -> r.attack = newAttack);
    }
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        this.game.subscribe(this);
    }

    @Override
    public void close() throws IOException
    {
        game.unsubsCribe(this);
    }
}