class StockPrice {
    Map<Integer,Integer> map;
    int currentTime;
    TreeMap<Integer,Integer> priceMap;
    public StockPrice() {
        map = new HashMap<>();
        priceMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int old = map.get(timestamp);
            priceMap.put(old,priceMap.get(old)-1);
            if(priceMap.get(old)==0) priceMap.remove(old);
        }
        map.put(timestamp,price);
        priceMap.put(price,priceMap.getOrDefault(price,0)+1);
        currentTime = Math.max(timestamp,currentTime);
    }
    
    public int current() {
        return map.get(currentTime);
    }
    
    public int maximum() {
        return priceMap.lastKey();
    }
    
    public int minimum() {
        return priceMap.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */