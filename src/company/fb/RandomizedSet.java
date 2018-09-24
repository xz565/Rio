package company.fb;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    private HashMap<Integer, Integer> idxToVal;
    private HashMap<Integer, Integer> valToIdx;

    public RandomizedSet() {
        // do initialize if necessary
        idxToVal = new HashMap<>();
        valToIdx = new HashMap<>();
    }

    // Inserts a value to the set
    // Returns true if the set did not already contain the specified element or false
    public boolean insert(int val) {
        // Write your code here
        if (valToIdx.containsKey(val)) {
            return false;
        }
        int idx = idxToVal.size();
        idxToVal.put(idx, val);
        valToIdx.put(val, idx);
        return true;
    }

    // Removes a value from the set
    // Return true if the set contained the specified element or false
    public boolean remove(int val) {
        // Write your code here
        if (!valToIdx.containsKey(val)) {
            return false;
        }
        int idx = valToIdx.get(val);
        int lastIdx = idxToVal.size() - 1;
        int lastVal = idxToVal.get(lastIdx);

        idxToVal.put(idx, lastVal);
        valToIdx.put(lastVal, idx);

        idxToVal.remove(lastIdx);
        valToIdx.remove(val);
        return true;
    }

    // Get a random element from the set
    public int getRandom() {
        if(idxToVal.size() == 0) {
            return 0;
        }
        return idxToVal.get(new Random().nextInt(idxToVal.size()));
        // Write your code here
    }

    @Override
    public String toString() {
        return valToIdx.toString() + idxToVal.toString();
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(1);
        set.insert(2);
        set.insert(3);
        System.out.println(set);
        System.out.println(set.getRandom());
        set.remove(1);
        System.out.println(set);
        set.remove(2);
        System.out.println(set);
        set.insert(2);
        System.out.println(set);
        set.insert(1);
        System.out.println(set);
        System.out.println(set.getRandom());
    }
}
