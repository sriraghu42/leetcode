class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        int i=0;
        while(i<len){
            int asteroid = asteroids[i];
            if(asteroid>0) stack.push(asteroid);
            else{
                boolean popped = false;
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroid)) stack.pop();
                if(!stack.isEmpty() && stack.peek()>0 && stack.peek()==Math.abs(asteroid)){
                    stack.pop();
                    popped = true;
                }
                else if(!stack.isEmpty() && stack.peek()>0 && stack.peek()>Math.abs(asteroid)) popped=true;
                if(!popped) stack.push(asteroid);
            }
            i++;
        }
        int[] ans = new int[stack.size()];
        int counter=0;
        for(int num : stack){
            ans[counter] = num;
            counter++;
        }
        return ans;
    }
}