package tarea_extraclase.tarea_extraclase;

//Se genera la clase Estudiante_A la cual va a llamar los atributos y metodos de clase Estudiante, para generar Herencia
public class Estudiante_A extends Estudiante {
    //Se establecen los atributos de la clase, estos son generalmente siempre privados, para ocultar su valor
    private double nota_Promedio_Examenes;
    private double nota_Promedio_Quices;
    private double nota_Promedio_Tareas;
    private final double nota_A;
    private final double nota_Final;



    //Se crea el constructor-base para la clase Estudiante_A, esto, para definir los atributos en la clase
    //Este constructor aplica sobrecarga, puesto que, recibe diferentes tipos de argumentos
    public Estudiante_A(int carnet, String nombre_Completo, String correo, int telefono, String nickname, String tipo_Estudiante, double nota_Promedio_Examenes,
                        double nota_Promedio_Quices, double nota_Promedio_Tareas) {
        super(carnet, nombre_Completo, correo, telefono, nickname, tipo_Estudiante);
        this.nota_Promedio_Examenes = nota_Promedio_Examenes;
        this.nota_Promedio_Quices = nota_Promedio_Quices;
        this.nota_Promedio_Tareas = nota_Promedio_Tareas;
        this.nota_A = calculaPromedio();
        this.nota_Final = calculaFinal();
    }

    //Se establecen valores predeterminados para la clase Estudiante_A
    //Este metodo para establecer valores predeterminados aplica sobrecarga
    public Estudiante_A() {
        super();
        this.nota_Promedio_Examenes = 0.00;
        this.nota_Promedio_Quices = 0.00;
        this.nota_Promedio_Tareas = 0.00;
        this.nota_A = 0.00;
        this.nota_Final = 0.00;
    }



    //Se generan los metodos basicos (Get's y Set's) para el funcionamiento base de la clase Estudiante_A
    //--------------------------Estos son los get's--------------------------
    public double getNota_Promedio_Examenes() {
        return nota_Promedio_Examenes;
    }
    public double getNota_Promedio_Quices() {
        return nota_Promedio_Quices;
    }
    public double getNota_Promedio_Tareas() {
        return nota_Promedio_Tareas;
    }
    public double getNota_A() {
        return nota_A;
    }
    public double getNota_Final() {
        return nota_Final;
    }


    //---------------------Estos son los set's--------------------------
    public void setNota_Promedio_Examenes(double promedio){
        this.nota_Promedio_Examenes = promedio;
    }
    public void setNota_Promedio_Quices(double promedio){
        this.nota_Promedio_Quices = promedio;
    }
    public void setNota_Promedio_Tareas(double promedio){
        this.nota_Promedio_Tareas = promedio;
    }



    //Se genera un m??todo p??blico, el cual devuelve un objeto tipo Estudiante.
    //Recibe un array (lista basica) de String's por par??metros (atributos de la clase Estudiante + Estudiante_A)
    //!!Este m??todo aplica polimorfismo!! Esto porque toma el metodo heredado de Estudiante y lo modifica para su propio criterio
    //Este m??todo tambi??n aplica sobrescritura, puesto que, resuelve parte del m??todo durante el tiempo de ejecuci??n y no en el de compilaci??n
    @Override
    public Estudiante recuperar(String [] stringArray){
        //Por orden y para comprender mas claramente el codigo, dividimos los datos recibidos por el string
        //y los almacenamos en variables locales.
        int carne = Integer.parseInt(stringArray[0]);
        String nombre_Completo = stringArray[1];
        String correo = stringArray[2];
        int telefono = Integer.parseInt(stringArray[3]);
        String nickname = stringArray[4];
        String tipo_estudiante = stringArray[5];
        double nota_examenes = Double.parseDouble(stringArray[6]);
        double nota_quices = Double.parseDouble(stringArray[7]);
        double nota_tareas = Double.parseDouble(stringArray[8]);

        //Aqui se establece el nuevo objeto tipo Estudiante, utilizando las variables locales almacenadas
        Estudiante estudiante = new Estudiante_A(carne, nombre_Completo, correo, telefono, nickname, "A",
                nota_examenes, nota_quices, nota_tareas);

        return estudiante;
    }

    //Se necesita un toString para que la lista pueda ser capaz de imprimir los valores
    @Override
    public String toString(){
        return ("");
    }

    @Override
    public double calculaPromedio(){
        return (nota_Promedio_Tareas+nota_Promedio_Quices+nota_Promedio_Examenes);
    }

    @Override
    public double calculaFinal(){
        return (calculaPromedio());
    }

}
