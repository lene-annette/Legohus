/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author lene_
 */
public class Order {
    
    private int id;
    private int length;
    private int width;
    private int height;
    private String orderDate;
    private String dispatchDate;
    private int userId;

    public Order() {
    }

    public Order(int id, int length, int width, int height, String orderDate, String dispatchDate, int userId) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.height = height;
        this.orderDate = orderDate;
        this.dispatchDate = dispatchDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", length=" + length + ", width=" + width + ", height=" + height + ", orderDate=" + orderDate + ", dispatchDate=" + dispatchDate + ", userId=" + userId + '}';
    }
    
    
    
}
