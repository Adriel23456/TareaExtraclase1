package tarea_extraclase.tarea_extraclase;

//Se genera la clase Estudiante_B la cual va a llamar los atributos y metodos de clase Estudiante, para generar Herencia
public class Estudiante_B extends Estudiante {
    //Se establecen los atributos de la clase, estos son generalmente siempre privados, para ocultar su valor
    private double nota_Proyecto1;
    private double nota_Proyecto2;
    private double nota_Proyecto3;



    //Se crea el constructor-base para la clase Estudiante_A, esto, para definir los atributos en la clase
    //Este constructor aplica sobrecarga, puesto que, recibe diferentes tipos de argumentos
    public Estudiante_B(int carnet, String nombre_Completo, String correo, int telefono, String nickname, String tipo_Estudiante, double nota_Proyecto1, double nota_Proyecto2, double nota_Proyecto3) {
        super(carnet, nombre_Completo, correo, telefono, nickname, tipo_Estudiante);
        this.nota_Proyecto1 = nota_Proyecto1;
        this.nota_Proyecto2 = nota_Proyecto2;
        this.nota_Proyecto3 = nota_Proyecto3;
    }

    //Se establecen valores predeterminados para la clase Estudiante_B
    //Este metodo para establecer valores predeterminados aplica sobrecarga
    public Estudiante_B(){
        super();
        this.nota_Proyecto1 = 0.00;
        this.nota_Proyecto2 = 0.00;
        this.nota_Proyecto3 = 0.00;
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



    //Se genera un metodo público, el cual devuelve un objeto tipo Estudiante.
    //Recibe un array (lista basica) de String's y Double's por parámetros (atributos de la clase Estudiante + Estudiante_B)
    //!!Este método aplica polimorfismo!! Esto porque toma el metodo heredado de Estudiante y lo modifica para su propio criterio
    //Este método también aplica sobrescritura, puesto que, resuelve parte del método durante el tiempo de ejecución y no en el de compilación
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
        return ("\n"+"Carnet: "+carnet+"\n"+"Nombre y apellidos: "+nombre_Completo+"\n"+"Correo: "+this.correo+"\n"+"Telefono: "+this.telefono+"\n"
                +"Nickname: "+this.nickname+"\n"+"Tipo estudiante: "+this.tipo_Estudiante+"\n"+"Nota promedio (examenes): "+null+
                "\n"+"Nota promedio (quices): "+null+"\n"+ "Nota promedio (tareas): "+null+"\n"+ "Nota Proyecto #1: "+nota_Proyecto1+"\n"+
                "Nota Proyecto #2: "+nota_Proyecto2+"\n"+"Nota Proyecto #3: "+nota_Proyecto3+"\n"+ "Nota Promedio (proyectos): "+calculaPromedio()+"\n"+
                "Nota Promedio (Examenes, Quices, Tareas): "+null+"\n"+ "Nota Final: "+calculaFinal());
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
