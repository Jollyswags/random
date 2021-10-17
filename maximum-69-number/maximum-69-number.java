class Solution {
    public int maximum69Number (int num) {
       int i ;
        char[] c = Integer.toString(num).toCharArray() ;
        for( i = 0 ; i < c.length ; i++ )
        {
            if( c[i] == '6' )
            {
                c[i] = '9' ;
                break ;
            }
        }
        return Integer.parseInt(String.valueOf(c)) ;
        
    }
}