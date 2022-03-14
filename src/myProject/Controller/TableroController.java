package myProject.Controller;

import myProject.Model.Tablero;

/**
 * Modifica el estado del tablero
 */

public class TableroController {
    private Tablero tab;

    public TableroController(Tablero tab) {
        this.tab = tab;
    }

    //Cambia el estado de una casilla a "disparado"
    public void dispararCasilla(int x, int y){
        if(this.estaDisparado(x, y) == false)
            this.tab.dispararCasilla(x, y);
    }

    //Informa si el espacio del tablero esta o no ocupado
    public boolean estaOcupado(int x, int y){
        if(this.tab.getTablero()[x][y] != 0)
            return true;
        else
            return false;
    }

    //Informa si el espacio del tablero ha sido o no disparado
    public boolean estaDisparado(int x, int y){
        if(this.tab.getDisparos()[x][y] == 1)
            return true;
        else
            return false;
    }

    //Informa si un barco con una id en especifico se ha hundido
    public boolean estaHundido(int id){
        boolean hundido = true;
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(this.tab.getTablero()[j][i] == id){
                    if(this.tab.getDisparos()[j][i] == 0)
                        hundido = false;
                }
            }
        }

        return hundido;
    }

    //Getters
    public int getID(int x, int y){
        return this.tab.getTablero()[x][y];
    }

    public Tablero getTab() {
        return tab;
    }


}
