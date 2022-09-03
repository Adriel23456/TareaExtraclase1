package tarea_extraclase.tarea_extraclase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


//Aqui se desarrolla la clase main la cual va a permitir el funcionamiento de la aplicacion
public class Main extends Application {
    //Se añade el codigo base para abrir la escena del codigo
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tarea Extraclase - Adriel Chaves Salazar");
        stage.setScene(scene);
        stage.show();
    }
    //Se añade el metodo main el cual interactua con la clase VentanaController directamente
    public static void main(String[] args) {
        //Metodo el cual va a permitirle al metodo Plan_De_Contingencia() actuar y empezar el codigo
        launch();
    }
}