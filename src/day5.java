import java.util.*;

public class day5 {

    //Problem No 01 => Split With Minimum Sum
    //https://leetcode.com/problems/split-with-minimum-sum/
    public int splitNum(int num) {
        char arr[] = String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        String n1 = "", n2 = "";
        for(int i=0; i<arr.length; i+=2){
            if(i<arr.length)    n1 += arr[i]+"";
            if(i+1<arr.length)  n2 += arr[i+1]+"";
        }
        return Integer.parseInt(n1)+Integer.parseInt(n2);
    }

    //Problem No 02 => Integer to Roman
    //https://leetcode.com/problems/integer-to-roman/
    public String intToRoman(int num) {
        String ones[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hrns[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String ths[]={"","M","MM","MMM"};

        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }
}
