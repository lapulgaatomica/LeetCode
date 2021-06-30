package easy1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisits {

    public static void main(String[] args) {
        //https://leetcode.com/problems/subdomain-visit-count/solution/
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com",
                "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String cpdomain: cpdomains){
            String[] split = cpdomain.split(" ");
            int number = Integer.parseInt(split[0]);
            String[] domains = split[1].split("\\.");
            int numberOfDots = domains.length - 1;

            if(counts.containsKey(split[1])){
                counts.put(split[1], counts.get(split[1]) + number);
            }else{
                counts.put(split[1], number);
            }

            if(numberOfDots == 2){
                if(counts.containsKey(domains[1]+"."+domains[2])){
                    counts.put(domains[1]+"."+domains[2], counts.get(domains[1]+"."+domains[2]) + number);
                }else{
                    counts.put(domains[1]+"."+domains[2], number);
                }
                if(counts.containsKey(domains[2])){
                    counts.put(domains[2], counts.get(domains[2]) + number);
                }else{
                    counts.put(domains[2], number);
                }
            }else{
                if(counts.containsKey(domains[1])){
                    counts.put(domains[1], counts.get(domains[1]) + number);
                }else{
                    counts.put(domains[1], number);
                }
            }
        }

        for(String string : counts.keySet()){
            result.add(counts.get(string) + " " + string);
        }

        return result;
    }
}
