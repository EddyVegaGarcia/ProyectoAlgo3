package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;
import fiuba.algo3.tp2.modelo.*;

import static fiuba.algo3.tp2.modelo.Constantes.*;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    int oro;
    private List<Pieza> piezas;
    private Castillo castillo;

    private int limitePoblacion, poblacion;
    private String nombre;
    private Mapa mapa;


    public Jugador(String unNombre, Mapa mapa) {

        this.castillo = new Castillo();
        this.nombre = unNombre;
        this.oro = CANTIDAD_DE_ORO_INICIAL;
        this.limitePoblacion = LIMITE_POBLACION;
        this.piezas = new ArrayList<>();
        this.poblacion = POBLACION_INICIAL;
        this.mapa = mapa;

    }

    public void ubicarAldeanosPorDefault(Posicion posicion1, Posicion posicion2, Posicion posicion3) {
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();

        this.piezas.add(aldeano1);
        this.piezas.add(aldeano2);
        this.piezas.add(aldeano3);
        this.ubicarEnElMapaPiezaNoAtacante(aldeano1,posicion1);
        this.ubicarEnElMapaPiezaNoAtacante(aldeano2,posicion2);
        this.ubicarEnElMapaPiezaNoAtacante(aldeano3,posicion3);

        this.poblacion = poblacion + CANTIDAD_DE_ALDEANOS_INICIAL;
    }



    public void ubicarEdificiosPorDefault(Posicion posicionCastillo, Posicion posicionPlaza){
        PlazaCentral plaza = new PlazaCentral();
        this.piezas.add(plaza);

        this.ubicarEnElMapaPiezaAtacante(castillo,posicionCastillo);
        mapa.colocarPiezaNoAtacante(plaza,posicionPlaza);

    }

    public void comprarAldeano(PlazaCentral plaza) {
        this.cobrar(COSTO_ALDEANO);
        Unidad aldeano = plaza.crearUnidad(UnidadType.UNIDAD_ALDEANO);
        this.mapa.ubicarUnidadAlrededorDeEdificio(aldeano,plaza);
        this.poblacion = poblacion +1;

    }

    public void comprarPlazaCentral(Posicion posicion) {
        this.cobrar(COSTO_PLAZACENTRAL);
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




    /*METODO PRIVADOS*/

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

    private void cobrar(int costo) {
        if (oro < costo) {
            throw new OroInsuficienteException();
        }
        this.oro = oro - costo;
    }
}