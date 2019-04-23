package Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import main.Circle;

public class DisplayFrame extends Application {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private int windowWidth;
    private int windowHeight;
    private Image image;
    private Scene scene;
    private Pane pane;
    private Circle circle;    

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new Pane();
        
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        
        primaryStage.setTitle("Bouncing figures");
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
        circle = new Circle();
    }
    
    /**
     * ********************* metodos accesores *************************
     */
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getHeight() {
        return windowHeight;
    }

    public void setHeight(int windowHeight) {
        this.windowHeight = windowHeight;
    }

    public int getWidth() {
        return windowWidth;
    }

    public void setWidth(int windowWidth) {
        this.windowWidth = windowWidth;
    }
    
    public void draw(GraphicsContext gc) {
        gc.drawImage(image, 0, 0);
    }
    
    //inicializa la image

    public GraphicsContext getGraphicsImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void initImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
