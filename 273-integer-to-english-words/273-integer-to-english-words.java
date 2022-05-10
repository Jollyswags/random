class Solution {
    public String ones(int num)
    {
        switch(num)
        {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
    
    public String lessThanTwenty(int num)
    {
        switch(num)
        {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    
    public String tens(int num)
    {
        switch(num)
        {
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
        }
        return "";
    }
    
    public String twoDigits(int num)
    {        
        if(num < 10)
            return ones(num);
        
        else if(num < 20)
            return lessThanTwenty(num);
        
        else
        {
            StringBuilder sb = new StringBuilder();

            int tensNum = num / 10 * 10;
            int remaining = num % 10;

            if(remaining == 0)
                return tens(tensNum);

            sb.append(tens(tensNum));
            sb.append(" ");
            sb.append(ones(remaining));

            return sb.toString();
        }
    }
    
    public String threeDigit(int num)
    {
        StringBuilder sb = new StringBuilder();
        
        int hundred = num / 100;
        int remaining = num % 100;
        
        if(hundred != 0 && remaining != 0)
        {
            sb.append(ones(hundred));
            sb.append(" Hundred ");
            sb.append(twoDigits(remaining));
        }
        
        else if(hundred == 0 && remaining != 0)
        {
            sb.append(twoDigits(remaining));
        }
        
        else if(hundred != 0 && remaining == 0)
        {
            sb.append(ones(hundred));
            sb.append(" Hundred");
        }
        
        return sb.toString();
    }
    
    public String numberToWords(int num) {
        
        if(num == 0)
            return "Zero";
        
        StringBuilder sb = new StringBuilder();
        
        int billion = num / 1000000000;
        num = num % 1000000000;
        
        int million = num / 1000000;
        num = num % 1000000;
        
        int thousand = num / 1000;
        num = num % 1000;
        
        if(billion != 0)
        {
            sb.append(threeDigit(billion)); 
            sb.append(" Billion");
        }
        
        if(million != 0)
        {
            if(sb.length() > 0)
                sb.append(" ");
            
            sb.append(threeDigit(million));
            sb.append(" Million");
        }
        
        if(thousand != 0)
        {
            if(sb.length() > 0)
                sb.append(" ");
            
            sb.append(threeDigit(thousand));
            sb.append(" Thousand");
        }
        
        if(num != 0)
        {
            if(sb.length() > 0)
                sb.append(" ");
            
            sb.append(threeDigit(num));
        }   
        
        return sb.toString();
    }
}
//1
//1