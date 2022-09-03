package tarea_extraclase.tarea_extraclase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaController implements Initializable{
    //--------------------------------------------------------------------
    //Se establece el lugar desde el cual se va a leer el archivo CSV
    String path = "Ejemplo.csv";
    //--------------------------------------------------------------------
    //--------------------------------------------------------------------
    //Se crea un objeto tipo lista, para guradar la informacion del CSV en el. Se tiene que especificar el tipo de dato, en este caso sera un dato Estudiante
    DoubleLinkedList<Estudiante> estudianteDoubleLinkedList = new DoubleLinkedList<>();
    //Se establecer los valores inciales del FXML
    @FXML
    private TableView<Estudiante> tableview;
    @FXML
    private TableColumn<Estudiante, Integer> idcarnet;
    @FXML
    private TableColumn<Estudiante, String> idcorreo;
    @FXML
    private TableColumn<Estudiante, String> idnickname;
    @FXML
    private TableColumn<Estudiante, String> idnombre;
    @FXML
    private TableColumn<Estudiante, Double> idnotaexamen;
    @FXML
    private TableColumn<Estudiante, Double> idnotafinal;
    @FXML
    private TableColumn<Estudiante, Double> idnotapromedioexamen;
    @FXML
    private TableColumn<Estudiante, Double> idnotapromedioproyecto;
    @FXML
    private TableColumn<Estudiante, Double> idnotaproyecto1;
    @FXML
    private TableColumn<Estudiante, Double> idnotaproyecto2;
    @FXML
    private TableColumn<Estudiante, Double> idnotaproyecto3;
    @FXML
    private TableColumn<Estudiante, Double> idnotaquiz;
    @FXML
    private TableColumn<Estudiante, Double> idnotatarea;
    @FXML
    private TableColumn<Estudiante, Integer> idtelefono;
    @FXML
    private TableColumn<Estudiante, String> idtipo;
    ObservableList<Estudiante> list = FXCollections.observableArrayList();
    public void llenar(){
                Plan_De_Contingencia();
                for (int i=0;i<estudianteDoubleLinkedList.getNumberOfElements();i++){
                    list.add(estudianteDoubleLinkedList.getElement(i));
                }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) throws IllegalStateException{
        llenar();
        try{
            for (Estudiante estudiante: list){
                idcarnet.setCellValueFactory(new PropertyValueFactory<Estudiante,Integer>("carnet"));
                idnombre.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("nombre_Completo"));
                idcorreo.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("correo"));
                idtelefono.setCellValueFactory(new PropertyValueFactory<Estudiante,Integer>("telefono"));
                idnickname.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("nickname"));
                idtipo.setCellValueFactory(new PropertyValueFactory<Estudiante,String>("tipo_estudiante"));
                if (estudiante instanceof Estudiante_A){
                    System.out.println(estudiante instanceof Estudiante_A);
                    idnotaexamen.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_Promedio_Examenes"));
                    idnotaquiz.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_Promedio_Quices"));
                    idnotatarea.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_Promedio_Tareas"));
                    idnotapromedioexamen.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_A"));
                } else {
                    System.out.println(estudiante instanceof Estudiante_B);
                    idnotaproyecto1.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_Proyecto1"));
                    idnotaproyecto2.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_Proyecto2"));
                    idnotaproyecto3.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_Proyecto3"));
                    idnotapromedioproyecto.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_B"));
                }
                idnotafinal.setCellValueFactory(new PropertyValueFactory<Estudiante,Double>("nota_Final"));
                tableview.setItems(list);
            }
        }
        catch (IllegalStateException x){
            System.out.println("PINGA MAMA");
        }
    }

    public void Plan_De_Contingencia(){
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
        }
        //Para imprimir errores comunes que podria desarrollar el BufferedReader
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
