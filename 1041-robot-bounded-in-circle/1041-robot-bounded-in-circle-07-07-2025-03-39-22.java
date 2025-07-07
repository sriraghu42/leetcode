class Solution {
    public boolean isRobotBounded(String instructions) {
        char[] dirs = new char[] {'N','W','S','E'};
        int x= 0;
        int y = 0;
        int len = instructions.length();
        int dir = 0;
        for(int i=0; i<len; i++){
            char ch = instructions.charAt(i);
            if(ch=='G'){
                if(dirs[dir]=='N') y+=1;
                else if(dirs[dir]=='W') x-=1;
                else if(dirs[dir]=='S') y-=1;
                else if(dirs[dir]=='E') x+=1;
            }
            else if(ch=='L'){
                dir++;
                if(dir==4) dir=0;
            }
            else{
                dir--;
                if(dir<0) dir=3;
            }
        }
        if(dir==0 && (x!=0 || y!=0)) return false;
        return true;
    }
}