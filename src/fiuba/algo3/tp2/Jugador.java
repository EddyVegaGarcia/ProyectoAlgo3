package fiuba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private List visitor = new ArrayList();
    int oro = 100;
    private List<Aldeano> aldeanos = new ArrayList<Aldeano>();
    private Castillo castillo = new Castillo();
    private List<PlazaCentral> plazas = new ArrayList<PlazaCentral>();
    private List<Espadachin> espadachines = new ArrayList<Espadachin>();
    private List<Arquero> arqueros = new ArrayList<Arquero>();
    private List<ArmaAsedio> armas = new ArrayList<ArmaAsedio>();
    private int limitePoblacion = 50;
    private String nombre;
    private Juego juego;

<<<<<<< HEAD
    public Jugador(String unNombre, Juego unJuego) {
        aldeanos.add(new Aldeano("0,0"));
        aldeanos.add(new Aldeano("0,0"));
        aldeanos.add(new Aldeano("0,0"));
=======
    public Jugador() {
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
        aldeanos.add(new Aldeano());
>>>>>>> 2db9b09b260ac200b6cc14c0e2ef6bcee31813b6

        plazas.add(new PlazaCentral());

        juego = unJuego;

        nombre = unNombre;
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