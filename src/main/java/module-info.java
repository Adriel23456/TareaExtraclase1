module tarea_extraclase.tarea_extraclase {
    requires javafx.controls;
    requires javafx.fxml;


    opens tarea_extraclase.tarea_extraclase to javafx.fxml;
    exports tarea_extraclase.tarea_extraclase;
}