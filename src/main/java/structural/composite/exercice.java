package structural.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    public int total = 0;

    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        this.total = 0;
        this.forEach(v -> {
            int total = 0;
            Iterator iterator = v.iterator();
            while (iterator.hasNext()) {
                this.total += (int) iterator.next();
            }
        });
        return this.total;
    }
}

class ExerciceCompositeDemo {
    public static void main(String[] args) {
        SingleValue value = new SingleValue(1);
        SingleValue value1 = new SingleValue(2);
        SingleValue value2 = new SingleValue(3);
        SingleValue value3 = new SingleValue(4);
        ArrayList<SingleValue> values = new ArrayList<>();
        values.add(value);
        values.add(value1);
        values.add(value2);
        values.add(value3);
        MyList list = new MyList(values);

        System.out.println(list.sum());
    }
}