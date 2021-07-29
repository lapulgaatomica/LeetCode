package easy2;

public class DefangIPaddr {
    public static void main(String[] args) {
        //https://leetcode.com/problems/defanging-an-ip-address/
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
    }

    public static String defangIPaddr(String address) {
        address = address.replaceAll("\\.", "[.]");
        return address;
    }
}
