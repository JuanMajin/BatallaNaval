package myProject.Controller;

/**
 *Clase main que llama a los metodos del EditorTableroJugador para comenzar con el juego
 *
 *  @autor Juan-J Majin-M juan.majin@correounivalle.edu.co
 *  @author Diana Cadena diana.marcela.cadena@correounivalle
 *  @version v.1.0.0 date:14/03/2022
 */

public class BatallaNaval {
    public static void main(String[] args) {
        EditorTableroJugador tab = new EditorTableroJugador();  //Inicia el controlador
        tab.mostrarView();  //Inicia la interfaz grafica asociada al controlador
    }
}
