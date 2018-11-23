package fiuba.algo3.tp2;

import fiuba.algo3.tp2.modelo.*;
import static fiuba.algo3.tp2.modelo.Constantes.*;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    int oro;
    private List<Unidad> unidades;
    private Castillo castillo;
    private List<Edificio> edificios;
    private int limitePoblacion, poblacion;
    private String nombre;
    private Mapa mapa;


    public Jugador(String unNombre, Mapa mapa) {

        this.castillo = new Castillo();
        this.nombre = unNombre;
        this.oro = CANTIDAD_DE_ORO_INICIAL;
        this.limitePoblacion = LIMITE_POBLACION;
        this.unidades = new ArrayList<>();
        this.edificios = new ArrayList<>();
        this.poblacion = POBLACION_INICIAL;
        this.mapa = mapa;

    }

    public void ubicarAldeanos(Posicion posicion1, Posicion posicion2, Posicion posicion3) {
        Aldeano aldeano1 = new Aldeano();
        Aldeano aldeano2 = new Aldeano();
        Aldeano aldeano3 = new Aldeano();
        PlazaCentral plaza = new PlazaCentral();
        this.unidades.add(aldeano1);
        this.unidades.add(aldeano2);
        this.unidades.add(aldeano3);
        this.poblacion = poblacion + CANTIDAD_DE_ALDEANOS_INICIAL;

        this.mapa.colocarUnidad(aldeano1,posicion1);
        this.mapa.colocarUnidad(aldeano2,posicion2);
        this.mapa.colocarUnidad(aldeano3,posicion3);

    }

    public void ubicarEdificios(Posicion posicionCastillo, Posicion posicionPlaza){
        PlazaCentral plaza = new PlazaCentral();
        this.edificios.add(plaza);

        this.mapa.colocarEdificio(plaza, posicionPlaza);
        this.mapa.ColocarCastilo(castillo, posicionCastillo);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int obtenerOro() {
        return oro;
    }

    public boolean castilloDestruido() {
        return castillo != null;
    }

    public int cantidadDePoblacion() {
        return poblacion;
    }

    public void comprarAldeano(Posicion posicion) {
        this.cobrar(COSTO_ALDEANO);
        Aldeano aldeano = new Aldeano();
        this.agregarUnidad(aldeano,posicion);
    }

    public void construirCuartel(Posicion posicion) {
        this.cobrar(COSTO_CUARTEL);
        Cuartel cuartel = new Cuartel();
        this.agregarEdificio(cuartel,posicion);
    }

    public void construirPlazaCentral(Posicion posicion){
        this.cobrar(COSTO_PLAZACENTRAL);
        PlazaCentral plaza = new PlazaCentral();
        this.agregarEdificio(plaza, posicion);
    }

    public boolean tenesCastillo() {
        return castillo != null;
    }

    /*METODO PRIVADOS*/

    private void agregarEdificio(Edificio edificio, Posicion posicion){
        this.edificios.add(edificio);
        this.mapa.colocarEdificio(edificio,posicion);
    }

    private void agregarUnidad(Unidad unidad, Posicion posicion){
        this.unidades.add(unidad);
        this.poblacion = poblacion + 1;
        this.mapa.colocarUnidad(unidad,posicion);
    }

    private void cobrar(int costo) {
        if (oro < costo) {
            throw new NoHaySuficienteOroException();
        }
        this.oro = oro - costo;
    }


}