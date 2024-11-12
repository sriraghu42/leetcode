class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strArr = path.split("/");
        for(String str : strArr){
            if(str.equals(".") || str.equals("")) continue;
            else if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            } 
            else stack.push(str);
        }
        return "/"+String.join("/",stack);
    }
}