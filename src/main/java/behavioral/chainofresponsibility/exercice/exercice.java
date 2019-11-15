package behavioral.chainofresponsibility.exercice;

import java.util.ArrayList;
import java.util.List;

abstract class Creature
{
    public abstract int getAttack();
    public abstract int getDefense();
}

class Goblin extends Creature
{
    protected Game game;
    protected int attack, defense;

    public Goblin(Game game)
    {
        this.game = game;
        attack = 1;
        defense = 1;
    }

    @Override
    public int getAttack()
    {
        int count = (int) game.creatures.stream().filter(c -> c instanceof GoblinKing).count();

        return attack + count;
    }

    @Override
    public int getDefense()
    {
        int count = (int) game.creatures.stream().filter(c -> c instanceof Goblin || c instanceof GoblinKing).count();

        if(count > 0) {
            count = count - 1;
        }

        return defense + count;
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        super(game);
        attack = 3;
        defense = 3;
    }

    @Override
    public int getAttack()
    {
        int count = (int) game.creatures.stream().filter(c -> c instanceof GoblinKing).count();

        if(count > 0) {
            count = count - 3;
        }

        return attack + count;
    }

    @Override
    public int getDefense()
    {
        int count = (int) game.creatures.stream().filter(c -> c instanceof Goblin || c instanceof GoblinKing).count();

        if(count > 0) {
            count = count - 3;
        }

        return defense + count;
    }

}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();
}