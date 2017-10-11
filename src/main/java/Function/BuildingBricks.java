/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lene_
 */
public class BuildingBricks {
    
    public static List<Integer> simpleBuilder(int length, int width){
        int lFours = length/4;
        int lTwos = (length % 4)/2;
        int lOnes = length - (4*lFours) - (2*lTwos);
        
        int newWidth = width - 4;
        int wFours = newWidth/4;
        int wTwos = (newWidth % 4)/2;
        int wOnes = newWidth - (4*wFours) - (2*wTwos);
        
        List<Integer> bricks = new ArrayList<>();
        bricks.add(lFours); bricks.add(lTwos); bricks.add(lOnes);
        bricks.add(wFours); bricks.add(wTwos); bricks.add(wOnes);
        
        return bricks;
    }
    
    public static List<Integer> totalBricks(List<Integer> bricks, int height){
        List<Integer> result = new ArrayList<Integer>();
        for(int brick : bricks){
            result.add(brick*height*2);
        }
        return result;
    }
    
}
