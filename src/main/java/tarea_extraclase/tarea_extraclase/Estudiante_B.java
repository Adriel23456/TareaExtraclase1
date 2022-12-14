package tarea_extraclase.tarea_extraclase;

//Se genera la clase Estudiante_B la cual va a llamar los atributos y metodos de clase Estudiante, para generar Herencia
public class Estudiante_B extends Estudiante {
    //Se establecen los atributos de la clase, estos son generalmente siempre privados, para ocultar su valor
    private double nota_Proyecto1;
    private double nota_Proyecto2;
    private double nota_Proyecto3;
    private final double nota_B;
    private final double nota_Final;



    //Se crea el constructor-base para la clase Estudiante_A, esto, para definir los atributos en la clase
    //Este constructor aplica sobrecarga, puesto que, recibe diferentes tipos de argumentos
    public Estudiante_B(int carnet, String nombre_Completo, String correo, int telefono, String nickname, String tipo_Estudiante, double nota_Proyecto1, double nota_Proyecto2, double nota_Proyecto3) {
        super(carnet, nombre_Completo, correo, telefono, nickname, tipo_Estudiante);
        this.nota_Proyecto1 = nota_Proyecto1;
        this.nota_Proyecto2 = nota_Proyecto2;
        this.nota_Proyecto3 = nota_Proyecto3;
        this.nota_B = calculaPromedio();
        this.nota_Final = calculaFinal();
    }

    //Se establecen valores predeterminados para la clase Estudiante_B
    //Este metodo para establecer valores predeterminados aplica sobrecarga
    public Estudiante_B(){
        super();
        this.nota_Proyecto1 = 0.00;
        this.nota_Proyecto2 = 0.00;
        this.nota_Proyecto3 = 0.00;
        this.nota_B = 0.00;
        this.nota_Final = 0.00;
    }


    //Se generan los metodos basicos (Get's y Set's) para el funcionamiento base de la clase Estudiante_A
    //--------------------------Estos son los get's--------------------------
    public double getNota_Proyecto1() {
        return nota_Proyecto1;
    }
    public double getNota_Proyecto2() {
        return nota_Proyecto2;
    }
    public double getNota_Proyecto3() {
        return nota_Proyecto3;
    }
    public double getNota_B() {
        return nota_B;
    }
    public double getNota_Final() {
        return nota_Final;
    }


    //---------------------Estos son los set's--------------------------
    public void setNota_Proyecto1(double nota){
        this.nota_Proyecto1 = nota;
    }
    public void setNota_Proyecto2(double nota){
        this.nota_Proyecto2 = nota;
    }
    public void setNota_Proyecto3(double nota){
        this.nota_Proyecto3 = nota;
    }



    //Se genera un metodo p??blico, el cual devuelve un objeto tipo Estudiante.
    //Recibe un array (lista basica) de String's y Double's por par??metros (atributos de la clase Estudiante + Estudiante_B)
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
        double nota_Proyecto1 = Double.parseDouble(stringArray[9]);
        double nota_Proyecto2 = Double.parseDouble(stringArray[10]);
        double nota_Proyecto3 = Double.parseDouble(stringArray[11]);

        //Aqui se establece el nuevo objeto tipo Estudiante, utilizando las variables locales almacenadas
        Estudiante estudiante = new Estudiante_B(carne, nombre_Completo, correo, telefono, nickname, tipo_estudiante, nota_Proyecto1, nota_Proyecto2, nota_Proyecto3);

        return estudiante;
    }

    //Se necesita un toString para que la lista pueda ser capaz de imprimir los valores
    @Override
    public String toString(){
        return ("");
    }

    @Override
    public double calculaPromedio(){
        return (nota_Proyecto1+nota_Proyecto2+nota_Proyecto3)/3;
    }

    @Override
    public double calculaFinal(){
        return (calculaPromedio());
    }


}
