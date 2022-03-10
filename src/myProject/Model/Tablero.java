package myProject.Model;

public class Tablero {
    /*
        Arreglos para la disposicion de los barcos y el identificador de casillas disparadas
    */
    private int[][] tablero; //0: Espacio disponible, Otro numero: espacio ocupado
    private int[][] disparos; // 1: Disparado, 0: No disparado

    //Constructor
    public Tablero() {
        this.tablero = new int[10][10];
        this.disparos = new int[10][10];
        for(int i=0; i<10; i++){
            for(int j=0; j<0; j++){
                this.tablero[i][j] = 0;
            }
        }
        for(int i=0; i<10; i++){
            for(int j=0; j<0; j++){
                this.disparos[i][j] = 0;
            }
        }
    }

    //Cambia el estado de una casilla a "disparado"
    public void dispararCasilla(int x, int y){
        this.disparos[x][y] = 1;
    }

    //Getters
    public int[][] getTablero() {
        return tablero;
    }

    public int[][] getDisparos() {
        return disparos;
    }

    //Setter de la disposicion del tablero
    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }
}
