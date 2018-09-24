package company.fb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.types.NestedInteger;

public class FlattenNestedListIterator_341 {

}

class NestedIterator implements Iterator<Iterator> {

    public NestedIterator() {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Iterator next() {
        return null;
    }
}

class NestedIterator_2 implements Iterator<Integer> {

    private List<Integer> list;
    private Iterator<Integer> it;

    public NestedIterator_2(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        createList(nestedList);
        it = list.iterator();
    }

    private void createList(List<NestedInteger> nestedList) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                createList(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

}
