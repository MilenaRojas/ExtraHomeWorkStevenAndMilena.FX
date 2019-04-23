package main;

import java.util.Random;

public class Circle extends Thread {

    private int row;
    private int column;
    private double newRow;
    private double newColumn;
    private int width;
    private int height;
    private int aux;

    public Circle() {
        this.row = new Random().nextInt(600 - 20);
        this.column = new Random().nextInt(400 - 20);
        this.width = 20;
        this.height = 20;
        this.aux = 0;
        this.newRow = new Random().nextInt(600 - 20);
        this.column = new Random().nextInt(400 - 20);

    }

    public void setRow(int laFila) {
        row = laFila;
    }

    public void setColumn(int laColumna) {
        column = laColumna;
    }

    public void setWidth(int elAncho) {
        width = elAncho;
    }

    public void setHeight(int elAlto) {
        height = elAlto;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
