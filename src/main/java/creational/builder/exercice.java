package creational.builder;

import java.util.HashMap;
import java.util.Map;

class CodeBuilder
{
    private String className;
    private Map<String, String> attributes = new HashMap<>();

    public CodeBuilder(String className)
    {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        attributes.put(name, type);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("public class " + className);
        sb.append(System.lineSeparator());
        sb.append("{");
        sb.append(System.lineSeparator());
        attributes.forEach((name, type) -> {
            sb.append("  public " + type + " " + name + ";");
            sb.append(System.lineSeparator());
        });
        sb.append("}");

        return sb.toString();
    }
}

class DemoBuilderExercice {
    public static void main(String[] args) {
        CodeBuilder codeBuilder = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        System.out.println(codeBuilder);
    }
}