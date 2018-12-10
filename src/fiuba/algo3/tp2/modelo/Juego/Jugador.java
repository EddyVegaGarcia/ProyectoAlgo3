package fiuba.algo3.tp2.modelo.Juego;

import fiuba.algo3.tp2.modelo.Campo.*;
import fiuba.algo3.tp2.modelo.Estados.*;

import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.Castillo;
import fiuba.algo3.tp2.modelo.Piezas.Edificios.PlazaCentral;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Piezas.Unidad;
import fiuba.algo3.tp2.modelo.Piezas.Unidades.Aldeano;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

import java.util.ArrayList;
import java.util.List;

import static fiuba.algo3.tp2.modelo.Campo.Constantes.*;

public class Jugador {

    int oro;
    private List<Pieza> piezas;
    private List<Unidad> poblacion;
    private Castillo castillo;

    private int limitePoblacion;
    private String nombre;
    private Mapa mapa;

    public EstadoDeJugador estado;


    public Jugador(String unNombre, Mapa mapa) {

        this.castillo = new Castillo();
        this.nombre = unNombre;
        this.oro = CANTIDAD_DE_ORO_INICIAL;
        this.limitePoblacion = LIMITE_POBLACION;
        this.piezas = new ArrayList<>();
        this.poblacion = new ArrayList<>();
        this.mapa = mapa;
        this.estado = new NoHabilitadoParaJugar();

    }

    public int vida() {
        return castillo.obtenerVida();
    }

    public String obtenerNombre() {
        return nombre;
    }


    public String oro() {
        return Integer.toString(oro);
    }

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

        this.mapa.colocarPieza(aldeano1,posicionAldeano1);
        this.mapa.colocarPieza(aldeano2,posicionAldeano2);
        this.mapa.colocarPieza(aldeano3,posicionAldeano3);
        
    }


    public void ubicarEdificiosPorDefault(Posicion posicionCastillo, Posicion posicionPlaza){

        PlazaCentral plaza = new PlazaCentral();
        this.piezas.add(plaza);
        this.piezas.add(castillo);

        mapa.colocarPieza(castillo,posicionCastillo);
        mapa.colocarPieza(plaza,posicionPlaza);

    }
    /*
       public void comprarPieza(Edificio unEdificio) {

           Unidad aldeano = unEdificio.crearUnidad(UnidadType.UNIDAD_ALDEANO);
           this.mapa.ubicarUnidadAlrededorDeEdificio(aldeano,plaza);
           this.poblacion = poblacion +1;

       }

           public void comprarPlazaCentral(Posicion posicion) {
               Pieza plaza = new PlazaCentral();
               this.mapa.colocarPiezaNoAtacante(plaza,posicion);
           }

           public String obtenerNombre() {
               return nombre;
           }

           public int obtenerOro() {
               return oro;
           }

           public boolean castilloDestruido() {
               return castillo == null;
           }

           public int cantidadDePoblacion() {
               return poblacion;
           }

           public void cobrarOro(int costo) {
               this.oro = oro - costo;
           }

           public void asignarEstadoHabilitado() {
               // Esta la necesitamos para comenzar el juego con un jugador habilitado.
               this.estado = new HabilitadoParaJugar();
           }

           public void cambiarEstadoDeJugador() {
               this.estado = estado.cambiarEstado();
           }
       */
    public void jugar() {

    }

    public ArrayList<PlazaCentral> getPlazas() {

        ArrayList<PlazaCentral> plazas = new ArrayList<>();
        for(Pieza pieza : piezas){
            if( pieza.sosPlazaCentral() ){
                plazas.add((PlazaCentral) pieza);
            }
        }
        return plazas;
    }

    public ArrayList<Aldeano> getAldeanos() {
        ArrayList<Aldeano> aldeanos = new ArrayList<Aldeano>();
        for(Pieza pieza : piezas){
            if( pieza.sosAldeano() ){
                aldeanos.add((Aldeano)pieza);
            }
        }
        return aldeanos;
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