package fiuba.algo3.tp2.modelo.Juego;


import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Interfaces.Constructor;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Arquero;

import java.util.ArrayList;
import java.util.List;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Jugador {

    public int oro;
    private List<Pieza> piezas;
    private List<Unidad> poblacion;
    private List<Constructor> aldeanos;
    private Castillo castillo;

    private int limitePoblacion;
    private String nombre;
    private Mapa mapa;

    public Jugador(String unNombre, Mapa mapa) {

        this.castillo = new Castillo();
        this.nombre = unNombre;
        this.oro = CANTIDAD_DE_ORO_INICIAL;
        this.limitePoblacion = LIMITE_POBLACION;
        this.piezas = new ArrayList<>();
        this.poblacion = new ArrayList<>();
        this.aldeanos = new ArrayList<>();
        this.mapa = mapa;

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
        Arquero aldeano3 = new Arquero();

        this.piezas.add(aldeano1);
        this.piezas.add(aldeano2);
        this.piezas.add(aldeano3);

        this.poblacion.add(aldeano1);
        this.poblacion.add(aldeano2);
        this.poblacion.add(aldeano3);

        this.aldeanos.add(aldeano1);
        this.aldeanos.add(aldeano2);
        //this.aldeanos.add(aldeano3);

        this.mapa.colocarPieza(aldeano1,posicionAldeano1);
        this.mapa.colocarPieza(aldeano2,posicionAldeano2);
        this.mapa.colocarPieza(aldeano3,posicionAldeano3);
    }


    public void ubicarEdificiosPorDefault(Posicion posicionCastillo, Posicion posicionPlaza){

        PlazaCentral plaza = new PlazaCentral();
        plaza.iniciarConstruccion();
        plaza.finalizarConstruccion();

        this.piezas.add(plaza);
        this.piezas.add(castillo);

        mapa.colocarPieza(castillo,posicionCastillo);
        mapa.colocarPieza(plaza,posicionPlaza);

    }

    public void agregarPoblacion(Unidad unaUnidad){

        if(unaUnidad.obtenerType() == UNIDAD_ALDEANO)
            this.aldeanos.add((Constructor) unaUnidad);

        this.poblacion.add(unaUnidad);
    }

    public void agregaPieza(Pieza unaPieza) {

        piezas.add(unaPieza);

    }

    public ArrayList<Pieza> getPiezas() {
        return (ArrayList<Pieza>) piezas;
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

    public void actualizarPiezas() {

        List<Pieza> nuevaLista = new ArrayList<>();

        for(Pieza unaPieza : piezas){
            if(unaPieza.obtenerVida() == 0) {
                nuevaLista.add(unaPieza);
            }
        }
        piezas.removeAll(nuevaLista);

        List<Unidad> nuevaLista2 = new ArrayList<>();

        for(Unidad unaPoblacion: poblacion){
            if(unaPoblacion.obtenerVida() == 0) {
                nuevaLista2.add(unaPoblacion);
            }
        }
        poblacion.removeAll(nuevaLista2);

        List<Constructor> nuevaLista3 = new ArrayList<>();

        for(Constructor unAldeano: aldeanos){
            if(((Pieza)unAldeano).obtenerVida() == 0) {
                nuevaLista3.add(unAldeano);
            }
        }
        aldeanos.removeAll(nuevaLista3);

    }

    public void terminoTuTurno() {
    }
}