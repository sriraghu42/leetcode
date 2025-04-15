class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        List<double[]> list = new ArrayList<>();
        for(int i=0; i<speed.length; i++){
            list.add(new double[] {position[i],(target-position[i])/(double) speed[i]});
        }
        list.sort((a,b)->Double.compare(b[0],a[0]));
        for(double[] arr : list){
            if(!stack.isEmpty() && stack.peek()>=arr[1]) continue;
            stack.push(arr[1]);
            System.out.println(stack.peek());
        }
        return stack.size();
    }
}