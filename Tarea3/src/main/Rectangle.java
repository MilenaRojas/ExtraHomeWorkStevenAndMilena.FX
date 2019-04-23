package main;

import java.util.Random;

public class Rectangle {

    private int row;
    private int column;
    private int width;
    private int height;
    private double newRow;
    private double newColumn;
    private int aux;

    public Rectangle() {
        this.row = new Random().nextInt(600 - 20);
        this.column = new Random().nextInt(400 - 20);
        this.width = 40;
        this.height = 40;
        this.aux = 0;
        this.newRow = new Random().nextInt(600 - 20);
        this.column = new Random().nextInt(400 - 20);
    } 

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
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

    public double getNewRow() {
        return newRow;
    }

    public void setNewRow(double newRow) {
        this.newRow = newRow;
    }

    public double getNewColumn() {
        return newColumn;
    }

    public void setNewColumn(double newColumn) {
        this.newColumn = newColumn;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

}
