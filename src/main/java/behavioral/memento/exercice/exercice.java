package behavioral.memento.exercice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Token {
    public int value = 0;

    public Token(int value) {
        this.value = value;
    }
}

class Memento {
    public List<Token> tokens = new ArrayList<>();
}

class TokenMachine {

    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value) {
        Token token = new Token(value);
        tokens.add(token);

        Memento memento = new Memento();

        memento.tokens =
                tokens.stream().map(t -> new Token(t.value))
                        .collect(Collectors.toList());

        return memento;
    }

    public Memento addToken(Token token) {
        tokens.add(token);

        Memento memento = new Memento();

        memento.tokens =
                tokens.stream().map(t -> new Token(t.value))
                        .collect(Collectors.toList());

        return memento;
    }

    public void revert(Memento m) {
        tokens = m.tokens;
    }
}