package company.fb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import common.types.NestedInteger;

public class FlattenNestedListIterator_341 {

}

class NestedIterator implements Iterator<Integer> {

    private List<Integer> elements;
    private int curt = 0;

    // TODO use stack to NOT interate the whole list in constructor
    public NestedIterator(List<NestedInteger> nestedList) {
        elements = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            elements.addAll(getInteger(nestedInteger));
        }
    }

    private List<Integer> getInteger(NestedInteger nestedInteger) {
        List<Integer> ele = new ArrayList<>();
        if (nestedInteger.isInteger()) {
            ele.add(nestedInteger.getInteger());
        } else {
            for (NestedInteger nestedInteger1 : nestedInteger.getList()) {
                ele.addAll(getInteger(nestedInteger1));
            }
        }
        return ele;
    }

    @Override
    public boolean hasNext() {
        return curt < elements.size();
    }

    @Override
    public Integer next() {
        return elements.get(curt++);
    }
}
