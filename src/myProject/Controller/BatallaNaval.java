package myProject.Controller;

public class BatallaNaval {

    /*
    Clase main que llama a los metodos del EditorTableroJugador para comenzar con el juego
    */
    public static void main(String[] args) {
        EditorTableroJugador tab = new EditorTableroJugador();  //Inicia el controlador
        tab.mostrarView();  //Inicia la interfaz grafica asociada al controlador
    }
}
