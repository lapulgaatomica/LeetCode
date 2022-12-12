package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class ClassPhotos {
    //https://www.algoexpert.io/questions/class-photos
    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int last = redShirtHeights.get(0) - blueShirtHeights.get(0);
        if(last == 0)
            return false;
        for(int i = 1; i < redShirtHeights.size(); i++){
            int curr = redShirtHeights.get(i) - blueShirtHeights.get(i);
            if((last < 0 && curr >= 0) || (last > 0 && curr <= 0))
                return false;
            last = curr;
        }
        return true;
    }
}
