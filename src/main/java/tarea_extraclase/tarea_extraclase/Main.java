package tarea_extraclase.tarea_extraclase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tarea Extraclase - Adriel Chaves Salazar");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //--------------------------------------------------------------------
        //--------------------------------------------------------------------
        //Se establece el lugar desde el cual se va a leer el archivo CSV

        String path = "Ejemplo.csv";

        //--------------------------------------------------------------------
        //--------------------------------------------------------------------

        //Se crea un objeto tipo lista, para guradar la informacion del CSV en el. Se tiene que especificar el tipo de dato, en este caso sera un dato Estudiante
        DoubleLinkedList<Estudiante> estudianteDoubleLinkedList = new DoubleLinkedList<>();

        //Se crean objetos comodin para llamar a sus respectivos metodos recuperar() y se establecen con sus valores predeterminados
        Estudiante_A comodin_A = new Estudiante_A();
        Estudiante_B comodin_B = new Estudiante_B();

        //Esta variable va a contener temporalmente los datos ingresados, o sea, el objeto actual
        Estudiante estudiante = null;

        //Se crea una linea vacia, para rellenar esta variable mas tarde con los elementos del csv por linea
        String line = "";

        //Se establece un objeto el cual va a intentar leer el archivo CSV, solamente 1 vez
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));


            //Método para leer todos los elementos del CSV y acomodarlos como objetos Estudiante
            //ESTE MéTODO APLICA ENCAPSULAMIENTO, PUESTO QUE, VA A ENCAPSULAR UNA GRAN CANTIDAD DE DATOS EN UN SOLO NODO DE LA LISTA estudianteDoubleLinkedList
            //Este método va a generar objetos desde la perspectiva de estudiantes, por lo cual estos objetos serán INSTANCIAS de esa clase
            line = br.readLine();
            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                if (values[5].equals("A")){
                    estudiante = comodin_A.recuperar(values);
                }
                else {
                    estudiante = comodin_B.recuperar(values);
                }
                estudianteDoubleLinkedList.add(estudiante);
            }
            //Se imprime con el toString() los valores de los objetos creados, en orden
            System.out.println(estudianteDoubleLinkedList.toString());


            //AQUI TRABAJO HOY, DESPUÉS DE CREAR LA LISTA "estudianteDoubleLinkedList", la cual contiene en sus nodos todas los objetos estudiante


        }
        //Para imprimir errores comunes que podria desarrollar el BufferedReader
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        launch();
    }
}