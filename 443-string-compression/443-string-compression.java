class Solution {
   public int compress(char[] chars) {
StringBuilder sb = new StringBuilder();
int count = 1;
for(int i = 1 ; i < chars.length ;i++){
if(chars[i] != chars[i-1]){
sb.append(chars[i-1]);
if(count != 1){ sb.append(String.valueOf(count));}
count = 1;
}else{
count++;
}
}
sb.append(chars[chars.length-1]);
if(count != 1){ sb.append(String.valueOf(count));}
//System.out.println(sb.toString().length());

    for(int i = 0;i<sb.toString().length();i++){
        chars[i] = sb.charAt(i);
    }
    
    
    return sb.toString().length();
    
}
}