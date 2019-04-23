package main;

import Interface.DisplayFrame;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Simulator {

    private DisplayFrame myDisplayer;  //Canva
    private Circle myCircle;
    private Rectangle myRectangle;
    private long wait;
    private int FPS = 30;
    private long time = 1000 / FPS;
    private int row;
    private int column;
    private int rowR;
    private int columnR;

//    int x=0,y=0,angleX=1,angleY=1;
//    int i=400,j=600, angleI=1,angleJ=1;
    private int aux;
    private int newRow;
    private int newColumn;
    private int newRowR;
    private int newColumnR;

    //constructor
    public Simulator(DisplayFrame myDisplayer_) throws InterruptedException {
        
        this.setMyDisplayer(myDisplayer_);
        this.setMyCircle(new Circle());

        this.setMyRectangle(new Rectangle());

        //valores de las figuras
        myCircle.setHeight(80);
        myCircle.setWidth(80);
        myRectangle.setHeight(75);
        myRectangle.setWidth(100);
        row = new Random().nextInt(600 - 20);
        column = new Random().nextInt(400 - 20);
        newRow = new Random().nextInt(600 - 20);
        newColumn = new Random().nextInt(400 - 20);
        rowR = new Random().nextInt(600 - 20);
        columnR = new Random().nextInt(400 - 20);
        newRowR = new Random().nextInt(600 - 20);
        newColumnR = new Random().nextInt(400 - 20);
    }

    //ciclo infinito para mover las figuras
    public void startSimulation(int waitingTime) throws InterruptedException {
        //ciclo infinito
        while (true) {

            this.createImages(30);

            //pone en espera el flujo del programa
            Thread.sleep(waitingTime);
        }
    }//end method

    //cambio los valores de las variables de las figuras que tengo
    public void moveShapes() {
        int x = (int) (Math.random() * (myDisplayer.getWidth() - 100));
        int y = (int) (Math.random() * (myDisplayer.getHeight() - 100));
        getMyCircle().setRow(y);
        getMyCircle().setColumn(x);

        x = (int) (Math.random() * (myDisplayer.getWidth() - 100));
        y = (int) (Math.random() * (myDisplayer.getHeight() - 100));
        getMyRectangle().setRow(y);
        getMyRectangle().setColumn(x);
    }

    //coloca nuevos valores aleatorios en las figuras
    public void createImages(int waitingTime) throws InterruptedException {
        myDisplayer.initImage();
        GraphicsContext graphic = myDisplayer.getGraphicsImage();

        while (true) {
            try {
                createImagesPruebaCircle();
            } catch (Exception ex) {
                Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
            }
            createImagesPruebaRentangle();
            // Prueba12();

//            myDisplayer.paintAgain();
            Thread.sleep(waitingTime);
        }

    }

    public void createImagesPruebaCircle() throws InterruptedException, Exception {
        myDisplayer.init();
        GraphicsContext graphic = myDisplayer.init();
        double path = Math.sqrt(Math.pow(this.newRow - this.row, 2) + Math.pow(this.newColumn - this.column, 2));
        this.row += (this.newRow - this.row) / path;
        this.column += (this.newColumn - this.column) / path;

//        aux=0;
        if (column > newColumn) {
            aux = 1;
        }
        if (aux == 1 && this.column <= this.newColumn) {

            this.newRow = new Random().nextInt(600 - 40);
            this.newColumn = new Random().nextInt(400 - 40);
            aux = 0;
            System.out.println("Primer if");

        } else if (aux == 0 && this.column >= this.newColumn) {
            graphic.setFill(Color.WHITE);
            this.newRow = new Random().nextInt(600 - 40);
            this.newColumn = new Random().nextInt(400 - 40);
            aux = 0;
            System.out.println("Segundo if");
        } else if (this.row == 0) {
            graphic.setFill(Color.WHITE);
            this.newRow = new Random().nextInt(600 - 40);
            this.newColumn = new Random().nextInt(400 - 40);
            graphic.fillOval(row, column, 40, 40);

            System.out.println("Tercer if");

            aux = 0;
        }

        graphic.setFill(Color.WHITE);
        graphic.fillOval(row, column, 40, 40);
    }

    public void createImagesPruebaRentangle() throws InterruptedException {
        // myDisplayer.initImage();
        GraphicsContext graphic = myDisplayer.getGraphicsImage();
        double path = Math.sqrt(Math.pow(this.newRow - this.row, 2) + Math.pow(this.newColumn - this.column, 2));
        this.rowR += (this.newRowR - this.rowR) / path;
        this.columnR += (this.newColumnR - this.columnR) / path;

        if (columnR > newColumnR) {
            aux = 1;
        }
        if (aux == 0 && this.columnR <= this.newColumnR) {

            this.newRowR = new Random().nextInt(600 - 40);
            this.newColumnR = new Random().nextInt(400 - 40);

            aux = 0;
        } else if (aux == 0 && this.columnR >= this.newColumnR) {
            this.newRowR = new Random().nextInt(600 - 40);
            this.newColumnR = new Random().nextInt(400 - 40);
            graphic.setFill(Color.PINK);

            aux = 0;
        } else if (this.rowR == 0) {
            graphic.setFill(Color.PINK);
            this.newRowR = new Random().nextInt(600 - 40);
            this.newColumnR = new Random().nextInt(400 - 40);

            aux = 1;
        }

        graphic.setFill(Color.PINK);
        graphic.fillRect(rowR, columnR, 40, 40);
    }

//    public void Prueba12() throws InterruptedException {
//        myDisplayer.initImage();
//        Graphics graphic = myDisplayer.getGraphicsImage();
//        double path = Math.sqrt(Math.pow(this.newRow - this.row, 2) + Math.pow(this.newColumn - this.column, 2));
//        this.row += (this.newRow - this.row) / path;
//        this.column += (this.newColumn - this.column) / path;
//
//        if (column > newColumn) {
//
//            aux = 1;
//        }
//        if (aux == 1 && this.column <= this.newColumn) {
//
//            this.newRow = new Random().nextInt(600 - 40);
//            this.newColumn = new Random().nextInt(400 - 40);
//
//            aux = 0;
//        } else if (aux == 0 && this.column >= this.newColumn) {
//            graphic.setColor(Color.PINK);
//            this.newRow = new Random().nextInt(600 - 40);
//            this.newColumn = new Random().nextInt(400 - 40);
//
//            aux = 0;
//        } else if (this.row == 0) {
//            graphic.setColor(Color.PINK);
//            this.newRow = new Random().nextInt(600 - 40);
//            this.newColumn = new Random().nextInt(400 - 40);
//            graphic.fillRect(row, column, 40, 40);
//
//            aux = 0;
//        }
//        graphic.setColor(Color.PINK);
//        graphic.fillRect(row, column, 40, 40);
//    }

    //**************************************************************************
    /*     metodos accesores      */
    public Circle getMyCircle() {
        return myCircle;
    }

    public void setMyCircle(Circle myCircle) {
        this.myCircle = myCircle;
    }

    public DisplayFrame getMyDisplayer() {
        return myDisplayer;
    }

    public void setMyDisplayer(DisplayFrame myDisplayer) {
        this.myDisplayer = myDisplayer;
    }

    public Rectangle getMyRectangle() {
        return myRectangle;
    }

    public void setMyRectangle(Rectangle myRectangle) {
        this.myRectangle = myRectangle;
    }

}
