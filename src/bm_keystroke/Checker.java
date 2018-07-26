

package bm_keystroke;

import java.util.ArrayList;

public class Checker {
    public Integer test(Integer[] tempPres, Integer[] tempDif, Integer[] storePress, Integer[] storeDiff,int i) {
        int pass = 0;
        for(int j = 0; j < storePress.length; j++) {
            
            if ((tempPres[j] - storePress[j] < 200) && (tempPres[j] - storePress[j] > -200)) {
                
                pass++;
            }
        }
       if(pass==storePress.length){
           pass = 0;
           for(int j = 0; j < storeDiff.length; j++) {
            if ((tempDif[j] - storeDiff[j] < 200) && (tempDif[j] - storeDiff[j] >-200)) {
                pass++;
            }
        }if(pass==storeDiff.length){
            return i;
        }else{
            return i+1;
        }
       
       }else{
           return i+1;
       }
    }
}

    

