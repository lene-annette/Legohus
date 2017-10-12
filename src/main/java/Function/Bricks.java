/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

import java.util.List;

/**
 *
 * @author lene_
 */
public class Bricks {
    private int length;
    private int width;
    private int height;
    private List<Integer> oneLayer;
    private List<Integer> total;
    public Bricks(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
        this.oneLayer = BuildingBricks.simpleBuilder(length, width);
        this.total = BuildingBricks.totalBricks(oneLayer, height);
    }
    
    public int getLengthFours(){
        return oneLayer.get(0);
    }
    public int getLengthTwos(){
        return oneLayer.get(1);
    }
    public int getLengthOnes(){
        return oneLayer.get(2);
    }
    public int getWidthFours(){
        return oneLayer.get(3);
    }
    public int getWidthTwos(){
        return oneLayer.get(4);
    }
    public int getWidthOnes(){
        return oneLayer.get(5);
    }
    
    public int getTotalFours(){
        return total.get(0) + total.get(3);
    }
    public int getTotalTwos(){
        return total.get(1) + total.get(4);
    }
    public int getTotalOnes(){
        return total.get(2) + total.get(5);
    }
    public int getLength() {
        return length;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
}
