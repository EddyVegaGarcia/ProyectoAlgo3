package fiuba.algo3.tp2.modelo.Juego;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Estados.*;

import fiuba.algo3.tp2.modelo.Interfaces.Constructor;

import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;



import java.util.ArrayList;
import java.util.List;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Jugador {

    public int oro;
    private ArrayList<Pieza> piezas;
    private List<Unidad> poblacion;
    private List<Constructor> aldeanos;
    private Castillo castillo;

    private int limitePoblacion;
    private String nombre;
    private Mapa mapa;

    //public EstadoDeJugador estado;


    public Jugador(String unNombre, Mapa mapa) {

        this.castillo = new Castillo();
        this.nombre = unNombre;
        this.oro = CANTIDAD_DE_ORO_INICIAL;
        this.limitePoblacion = LIMITE_POBLACION;
        this.piezas = new ArrayList<>();
        this.poblacion = new ArrayList<>();
        this.aldeanos = new ArrayList<>();
        this.mapa = mapa;
        //this.estado = new NoHabilitadoParaJugar();
    }

    public int vida() {
        return castillo.obtenerVida();
    }

    public String obtenerNombre() {
        return nombre;
    }


    public String stringOro() {
        return Integer.toString(oro);
    }

    public int obtenerOro(){ return  oro;}

    public Castillo obtenerCastillo() {
        return castillo;
    }

    public void ubicarAldeanosPorDefault(Posicion posicionAldeano1, Posicion posicionAldeano2, Posicion posicionAldeano3) {

        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();

        this.piezas.add(aldeano1);
        this.piezas.add(aldeano2);
        this.piezas.add(aldeano3);

        this.poblacion.add(aldeano1);
        this.poblacion.add(aldeano2);
        this.poblacion.add(aldeano3);

        this.aldeanos.add(aldeano1);
        this.aldeanos.add(aldeano2);
        this.aldeanos.add(aldeano3);

        this.mapa.colocarPieza(aldeano1,posicionAldeano1);
        this.mapa.colocarPieza(aldeano2,posicionAldeano2);
        this.mapa.colocarPieza(aldeano3,posicionAldeano3);
        
    }


    public void ubicarEdificiosPorDefault(Posicion posicionCastillo, Posicion posicionPlaza){

        PlazaCentral plaza = new PlazaCentral();
        plaza.finalizarConstruccion();

        this.piezas.add(plaza);
        this.piezas.add(castillo);

        mapa.colocarPieza(castillo,posicionCastillo);
        mapa.colocarPieza(plaza,posicionPlaza);

    }
    /*

           public boolean castilloDestruido() {
               return castillo == null;
           }

           public int cantidadDePoblacion() {
               return poblacion;
           }

           public void cobrarOro(int costo) {
               this.stringOro = stringOro - costo;
           }

           public void asignarEstadoHabilitado() {
               // Esta la necesitamos para comenzar el juego con un jugador habilitado.
               this.estado = new HabilitadoParaJugar();
           }

           public void cambiarEstadoDeJugador() {
               this.estado = estado.cambiarEstado();
           }
       */

    public void agregarPoblacion(Unidad unaUnidad){

        if(unaUnidad.obtenerType() == UNIDAD_ALDEANO)
            this.aldeanos.add((Constructor) unaUnidad);

        this.poblacion.add(unaUnidad);
    }

    public void agregaPieza(Pieza unaPieza) {

        piezas.add(unaPieza);

    }

    public ArrayList<Pieza> getPiezas() {
        return piezas;
    }

    public boolean sosDuenioDe(Pieza pieza) {
        for (Pieza piezaActual : piezas){
            if(piezaActual.equals(pieza))
                return true;
        }
        return false;
    }

    public void recolectarOro() {
        for(Constructor constructorActual : aldeanos){

            oro = oro + constructorActual.oroRecolectado();
        }
    }

    public void refrescarPiezas() {
        for(Pieza piezaActual : piezas){
            piezaActual.refrescar();
        }
    }

    public void pagar(int costo) {

        oro = oro - costo;
    }

    public int poblacion() {
        return poblacion.size();
    }

    public void terminarConstruccion() {

        for(Constructor unConstructor: aldeanos){
            if(unConstructor.estaTrabajando())
                unConstructor.seguirTrabajando();
        }

    }

/*

    private void ubicarEnElMapaPiezaNoAtacante(Pieza pieza, Posicion posicion) {
        this.mapa.colocarPiezaNoAtacante(pieza,posicion);
    }

    private void ubicarEnElMapaPiezaAtacante(Atacante atacante, Posicion posicion){
        this.mapa.colocarPiezaAtacante(atacante,posicion);
    }

    private void agregarPiezaAtacante(Pieza pieza, Posicion posicion){
        this.piezas.add(pieza);
        this.poblacion = poblacion + 1;
        this.mapa.colocarPiezaNoAtacante(pieza,posicion);
    }
    */
}