class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> ip_addresses = new ArrayList<>();
        
        helper(s, 0, 3, ip_addresses, new StringBuilder()); 
        return ip_addresses;
    }
    
    public void helper(String s, int idx, int d, List<String> ip_addresses, StringBuilder ipAddr)
    {
        if(d == 0)        
        {
            String num_str = s.substring(idx, s.length());
            if((num_str.length() > 1 && num_str.charAt(0) == '0') || num_str.length() > 3)
                return;
            
            int num = Integer.valueOf(num_str);
            if(isValidIP(num))
            {
                ipAddr.append(num);
                ip_addresses.add(ipAddr.toString());
            }
            
            return;
        }
        
        for(int end = idx + 1; end <= idx + 3 && end < s.length(); end++)
        {
            String num_str = s.substring(idx, end);
            int num = Integer.valueOf(num_str);
            
            if(isValidIP(num))
            {
                StringBuilder partial = new StringBuilder(ipAddr);
                
                partial.append(num);
                partial.append(".");
                
                helper(s, end, d - 1, ip_addresses, partial);
                
                if(num_str.charAt(0) == '0')
                    break;
            }
            
            else 
                break;
        }
        
    }
    
    public boolean isValidIP(int ip)
    {
        if(0 <= ip && ip <= 255)
            return true;
        return false;
    }
    
}