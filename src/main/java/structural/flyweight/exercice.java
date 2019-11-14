package structural.flyweight;

import java.util.ArrayList;
import java.util.List;

class Sentence
{

    private String plainText;
    private List<WordToken> wordTokens = new ArrayList<>();

    public Sentence(String plainText)
    {
        this.plainText = plainText;
    }

    public WordToken getWord(int index)
    {
        WordToken wt = new WordToken();
        wt.wordIndex = index;
        wordTokens.add(wt);
        return wt;
    }

    @Override
    public String toString()
    {
        String[] words = this.plainText.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            for(WordToken wt : wordTokens) {
                if(word == words[wt.wordIndex])
                    if (wt.capitalize) word = word.toUpperCase();
            }
            sb.append(word);
            if(i < words.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    class WordToken
    {
        public int wordIndex;
        public boolean capitalize;
    }
}

class FlyWeightDemo {
    public static void main(String[] args) {
        Sentence s = new Sentence("hello world");
        s.getWord(1).capitalize = true;
        System.out.println(s);
    }
}