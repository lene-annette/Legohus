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
    
    public static List<Integer> simpleForbandtBuilder(int length, int width){
        List<Integer> odds = odd(length, width);
        List<Integer> evens = even(length, width);
        
        List<Integer> bricks = new ArrayList<>();
        //side 1 ulige lag
        bricks.add(odds.get(0));bricks.add(odds.get(1));bricks.add(odds.get(2));
        //side2 ulige lag
        bricks.add(odds.get(3));bricks.add(odds.get(4));bricks.add(odds.get(5)); 
        //side 3 ulige lag
        bricks.add(odds.get(6));bricks.add(odds.get(7));bricks.add(odds.get(8));
        //side 4 ulige lag
        bricks.add(odds.get(9));bricks.add(odds.get(10));bricks.add(odds.get(11));
        
        //side 1 lige lag
        bricks.add(evens.get(0));bricks.add(evens.get(1));bricks.add(evens.get(2));
        //side2 lige lag
        bricks.add(evens.get(3));bricks.add(evens.get(4));bricks.add(evens.get(5)); 
        //side 3 lige lag
        bricks.add(evens.get(6));bricks.add(evens.get(7));bricks.add(evens.get(8));
        //side 4 lige lag
        bricks.add(evens.get(9));bricks.add(evens.get(10));bricks.add(evens.get(11));
        
        
        return bricks;
    }
    
    private static List<Integer> odd(int length, int width){
        List<Integer> odds = new ArrayList<>();
        int side1fours = length/4;
        int side1twos = (length % 4) / 2;
        int side1ones = length - (4*side1fours) - (2*side1twos);
        odds.add(side1fours); odds.add(side1twos); odds.add(side1ones);
        
        int side2 = width - 2;
        int side2fours = side2/4;
        int side2twos = (side2 % 4)/2;
        int side2ones = side2 - (4*side2fours) - (2*side2twos);
        odds.add(side2fours); odds.add(side2twos); odds.add(side2ones);
        
        int side3 = length - 2;
        int side3fours = side3/4;
        int side3twos = (side3 % 4)/2;
        int side3ones = side3 - (4*side3fours) - (2*side3twos);
        odds.add(side3fours); odds.add(side3twos); odds.add(side3ones);
        
        int side4 = width - 4;
        int side4fours = side4/4;
        int side4twos = (side4 % 4)/2;
        int side4ones = side4 - (4*side4fours) - (2*side4twos);
        odds.add(side4fours); odds.add(side4twos); odds.add(side4ones);
        
        return odds;
    }
    
    private static List<Integer> even(int length, int width){
        List<Integer> evens = new ArrayList<>();
        int side1 = length - 4;
        int side1fours = side1/4;
        int side1twos = (side1 % 4) / 2;
        int side1ones = side1 - (4*side1fours) - (2*side1twos);
        evens.add(side1fours); evens.add(side1twos); evens.add(side1ones);
        
        int side2 = width - 2;
        int side2fours = side2/4;
        int side2twos = (side2 % 4)/2;
        int side2ones = side2 - (4*side2fours) - (2*side2twos);
        evens.add(side2fours); evens.add(side2twos); evens.add(side2ones);
        
        int side3 = length - 2;
        int side3fours = side3/4;
        int side3twos = (side3 % 4)/2;
        int side3ones = side3 - (4*side3fours) - (2*side3twos);
        evens.add(side3fours); evens.add(side3twos); evens.add(side3ones);
        
        int side4 = width;
        int side4fours = side4/4;
        int side4twos = (side4 % 4)/2;
        int side4ones = side4 - (4*side4fours) - (2*side4twos);
        evens.add(side4fours); evens.add(side4twos); evens.add(side4ones);
        
        return evens;
    }
    
    public static List<Integer> totalBricks(List<Integer> bricks, int height){
        List<Integer> result = new ArrayList<Integer>();
        for(int brick : bricks){
            //result.add(brick*height*2); //for simplebuilder()
            result.add(brick*height); //for simpleForbandtBuilder()
        }
        return result;
    }
    
}
