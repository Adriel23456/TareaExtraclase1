package tarea_extraclase.tarea_extraclase;

//AQUI SE OBSERVA COMO SE DESARROLLARA UNA CLASE LA CUAL VA A HEREDAR SUS ATRIBUTOS Y METODOS A SUS SUB-CLASES (Estudiante_A y Estudiante_B)
//AQUI SE EVIDENCIA LA ABSTRACCION, puesto que se va a desarrollar la clase Estudiante como abstracta para que pueda heredar metodos a las clases Estudiante_A y Estudiante_B
public abstract class Estudiante {
    //Se establecen los atributos de la clase, estos son generalmente siempre privados, para ocultar su valor, pero se haran
    //protected para que la herencia tenga acceso
    protected int carnet;
    protected String nombre_Completo;
    protected String correo;
    protected int telefono;
    protected String nickname;
    protected String tipo_Estudiante;



    //Se crea el constructor-base para la clase Estudiante, esto, para definir los atributos en la clase
    //Este constructor aplica sobrecarga, puesto que, recibe diferentes tipos de argumentos
    public Estudiante(int carnet, String nombre_Completo, String correo, int telefono, String nickname, String tipo_Estudiante) {
        this.carnet = carnet;
        this.nombre_Completo = nombre_Completo;
        this.correo = correo;
        this.telefono = telefono;
        this.nickname = nickname;
        this.tipo_Estudiante = tipo_Estudiante;
    }

    //Se establecen valores predeterminados para la clase Estudiante
    public Estudiante() {
        this.carnet = 0;
        this.nombre_Completo = "";
        this.correo = "correo";
        this.telefono = 0;
        this.nickname = "";
        this.tipo_Estudiante = "";
    }




    //Se generan los metodos basicos (Get's y Set's) para el funcionamiento base de la clase Estudiante
    //--------------------------Estos son los get's--------------------------
    public int getCarnet() {
        return carnet;
    }
    public String getNombre_Completo() {
        return nombre_Completo;
    }
    public String getCorreo() {
        return correo;
    }
    public int getTelefono() {
        return telefono;
    }
    public String getNickname() {
        return nickname;
    }
    public String getTipo_estudiante() {
        return tipo_Estudiante;
    }


    //---------------------Estos son los set's--------------------------
    public void setCarnet(int numero_carnet){
        this.carnet = numero_carnet;
    }
    public void setNombre_Completo(String nombre){
        this.nombre_Completo = nombre;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    public void setTelefono(int telefono){
        this.telefono = telefono;
    }
    public void setNickname(String short_name){
        this.nickname = short_name;
    }
    public void setTipo_Estudiante(String tipo){
        this.tipo_Estudiante = tipo;
    }




    //Se establecen cuatro metodos abstractos para aplicar polimorfismo y herencia en el codigo, ademas de que este metodo es para permitir a la
    //instancia del objeto, que se sienta como un objeto Estudiante, cuando en realidad es un objeto Estudiante_A o Estudiante_B.
    public abstract Estudiante recuperar(String [] stringArray);
    public abstract  String toString();
    public abstract  double calculaPromedio();
    public abstract  double calculaFinal();
}

