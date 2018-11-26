package fiuba.algo3.tp2.modelo;

interface Atacante {

    void atacarUnidad(Unidad unaUnidad);

    void atacarEdificio(Edificio unEdificio);

    int obtenerDistanciaAtaque();

    void guardarRangoDeAtaque(RangoDeAtaque rango);

    int obtenerTamanio();

}