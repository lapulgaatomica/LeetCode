package easy3;

public class IsLongPressedName {
    //https://leetcode.com/problems/long-pressed-name/
    public static void main(String[] args) {
        System.out.println(isLongPressedName("alex", "aaleex") == true);
        System.out.println(isLongPressedName("alex", "aaleexa") == false);
        System.out.println(isLongPressedName("saeed", "ssaaedd") == false);
        System.out.println(isLongPressedName("s", "ss") == true);
        System.out.println(isLongPressedName("s", "a") == false);
        System.out.println(isLongPressedName("alexd", "ale") == false);
    }

    public static boolean isLongPressedName(String name, String typed) {
        int namePointer = 0;
        int typedPointer = 0;
        char previousNameChar = name.charAt(0);

        while (namePointer < name.length() || typedPointer < typed.length()){
            char currentNameChar = namePointer >= name.length() - 1 ? name.charAt(name.length() - 1) : name.charAt(namePointer);
            char currentTypedChar = typedPointer >= typed.length() - 1 ? typed.charAt(typed.length() - 1) : typed.charAt(typedPointer);
            if(currentNameChar != currentTypedChar){
                if(currentTypedChar == previousNameChar && typedPointer < typed.length())
                    typedPointer++;
                else
                    return false;
            }else{
                namePointer++;
                typedPointer++;
                previousNameChar = currentNameChar;
            }
        }
        return true;
    }
}
