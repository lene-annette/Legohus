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

    public Bricks(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.oneLayer = BuildingBricks.simpleForbandtBuilder(length, width);
        this.total = BuildingBricks.totalBricks(oneLayer, height);
    }

    public int getSide1OFours() {
        return oneLayer.get(0);
    }

    public int getSide1EFours() {
        return oneLayer.get(12);
    }

    public int getSide1OTwos() {
        return oneLayer.get(1);
    }

    public int getSide1ETwos() {
        return oneLayer.get(13);
    }

    public int getSide1OOnes() {
        return oneLayer.get(2);
    }

    public int getSide1EOnes() {
        return oneLayer.get(14);
    }

    public int getSide2OFours() {
        return oneLayer.get(3);
    }

    public int getSide2EFours() {
        return oneLayer.get(15);
    }

    public int getSide2OTwos() {
        return oneLayer.get(4);
    }

    public int getSide2ETwos() {
        return oneLayer.get(16);
    }

    public int getSide2OOnes() {
        return oneLayer.get(5);
    }

    public int getSide2EOnes() {
        return oneLayer.get(17);
    }

    public int getSide3OFours() {
        return oneLayer.get(6);
    }

    public int getSide3EFours() {
        return oneLayer.get(18);
    }

    public int getSide3OTwos() {
        return oneLayer.get(7);
    }

    public int getSide3ETwos() {
        return oneLayer.get(19);
    }

    public int getSide3OOnes() {
        return oneLayer.get(8);
    }

    public int getSide3EOnes() {
        return oneLayer.get(20);
    }

    public int getSide4OFours() {
        return oneLayer.get(9);
    }

    public int getSide4EFours() {
        return oneLayer.get(21);
    }

    public int getSide4OTwos() {
        return oneLayer.get(10);
    }

    public int getSide4ETwos() {
        return oneLayer.get(22);
    }

    public int getSide4OOnes() {
        return oneLayer.get(11);
    }

    public int getSide4EOnes() {
        return oneLayer.get(23);
    }

    public int getTotalFours() {
        return total.get(0) + total.get(3) + total.get(6) + total.get(9);
    }

    public int getTotalTwos() {
        return total.get(1) + total.get(4) + total.get(7) + total.get(10);
    }

    public int getTotalOnes() {
        return total.get(2) + total.get(5) + total.get(8) + total.get(11);
    }

//    public int getLengthFours(){
//        return oneLayer.get(0);
//    }
//    public int getLengthTwos(){
//        return oneLayer.get(1);
//    }
//    public int getLengthOnes(){
//        return oneLayer.get(2);
//    }
//    public int getWidthFours(){
//        return oneLayer.get(3);
//    }
//    public int getWidthTwos(){
//        return oneLayer.get(4);
//    }
//    public int getWidthOnes(){
//        return oneLayer.get(5);
//    }
//    
//    public int getTotalFours(){
//        return total.get(0) + total.get(3);
//    }
//    public int getTotalTwos(){
//        return total.get(1) + total.get(4);
//    }
//    public int getTotalOnes(){
//        return total.get(2) + total.get(5);
//    }
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
