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

    public void crearEdificio(int costo) {
        if (oro < costo) throw new NoHaySuficienteOroException();
        oro = oro - costo;
    }

    public void crearUnidad(int costo){
        int poblacion = aldeanos.size() + espadachines.size() + arqueros.size() + armas.size();
        if( poblacion == limitePoblacion ) throw new ExcedeElLimiteDePoblacionPosibleException();
        crearEdificio(costo);
    }

    public int oro() {
        return oro;
    }

    public int cantidadDeAdeanos() {
        return aldeanos.size();
    }

    public int cantidadDePlazas() {
        return plazas.size();
    }

    public void recaudarOro() {
        oro = oro + (aldeanos.size() * 20);
    }

    public void agregarAldeano(Aldeano unAldeano) {
        aldeanos.add(unAldeano);
    }

    public void agregarEspadachin(Espadachin espadachin) {
        espadachines.add(espadachin);
    }

    public int cantidadEspadachin() {
        return espadachines.size();
    }

    public void agregarArquero(Arquero arquero) {
        arqueros.add(arquero);
    }

    public int cantidadArqueros() {
        return arqueros.size();
    }

    public void agregarArmaAsedio(ArmaAsedio armaAsedio) {
        armas.add(armaAsedio);
    }

    public int cantidadArmaAsedio() { return armas.size(); }

    public boolean tenesCastillo() {
        return castillo != null;
    }

    public void castilloDestruido() {
        castillo = null;
        juego.perdi(this);
    }

    public String nombre() {
        return nombre;
    }
}