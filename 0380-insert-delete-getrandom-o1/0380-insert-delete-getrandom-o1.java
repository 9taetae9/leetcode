class RandomizedSet {
    HashMap<Integer,Integer> valueToIndex;
    ArrayList<Integer> values;
    Random rand;

    public RandomizedSet() {
        valueToIndex = new HashMap<>();
        values = new ArrayList<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(valueToIndex.containsKey(val)){ 
            return false;
        }

        //val이 없을경우 삽입
        valueToIndex.put(val, values.size());
        values.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if(!valueToIndex.containsKey(val)){
            return false;
        }

        //present
        int removeIndex = valueToIndex.get(val);  //지울 인덱스
        int lastVal = values.get(values.size()-1); //마지막 원소 값

        values.set(removeIndex, lastVal); // 지울 인덱스 자리에 마지막 원소 대입
        
        
        values.remove(values.size()-1); // 마지막 원소 삭제
        valueToIndex.remove(val); // map에서 val 지우기
        
        if(lastVal != val){
            valueToIndex.put(lastVal, removeIndex); 
        }
        return true;
    }
    
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */