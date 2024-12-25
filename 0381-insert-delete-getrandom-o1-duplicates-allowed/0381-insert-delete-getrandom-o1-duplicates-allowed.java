class RandomizedCollection {
    List<Integer> values;
    Map<Integer, Set<Integer>> indexMap;
    Random rand;

    public RandomizedCollection() {
        values = new ArrayList<>();
        indexMap = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean isNew = !indexMap.containsKey(val);

        if(isNew){
            indexMap.put(val, new HashSet<>());
        }

        indexMap.get(val).add(values.size());
        values.add(val);

        return isNew;
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }

        int removeIdx = indexMap.get(val).iterator().next();
        int lastVal = values.get(values.size()-1);
        



        indexMap.get(val).remove(removeIdx);
        if(indexMap.get(val).isEmpty()){
            indexMap.remove(val);
        }

        if(values.size()-1 != removeIdx){
            indexMap.get(lastVal).remove(values.size()-1);
            indexMap.get(lastVal).add(removeIdx);
        }
        

        values.set(removeIdx, lastVal);
        values.remove(values.size()-1);



        return true;
    }
    
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */