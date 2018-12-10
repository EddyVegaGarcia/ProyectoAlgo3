package fiuba.algo3.tp2.modelo.Campo;


public class Constantes {

    public static int FILA_DEFAULT_MAPA = 32;
    public static int COLUMNA_DEFAULT_MAPA = 40;
    public static int LIMITE_POBLACION = 50;
    public static int CANTIDAD_DE_ORO_INICIAL = 100;
    public static int POBLACION_INICIAL = 0;
    public static int CANTIDAD_DE_ALDEANOS_INICIAL = 3;
    public static int TIEMPO_INICIAL_DE_MONTURA = 0;
    public static int TIEMPO_ESPERADO_DE_MONTURA =1;

    /*TAMAÑO DE LAS PIEZAS*/
    public static int TAMANIO_PLAZA = 4;
    public static int TAMANIO_CUARTEL = 4;
    public static int TAMANIO_CASTILLO = 16;
    public static int TAMANIO_UNIDAD = 1;


    /*POSICIONES POR DEAFULT DE CASTILLOS, PLAZAS Y ALDEANOS INICIALES*/

        /*Castillo1*/
    public static Posicion POSICION_DEFAULT_CASTILLO1 = new Posicion(0,17);

        /*Castillo2*/
    public static Posicion POSICION_DEFAULT_CASTILLO2 = new Posicion(28,17);

        /*Plaza1*/
    public static Posicion POSICION_DEFAULT_PLAZA1 = new Posicion(0,24);

        /*Plaza2*/
    public static Posicion POSICION_DEFAULT_PLAZA2 = new Posicion(28,12);

        /*Aldeano 1 Jugador*/
    public static Posicion POSICION_DEFAULT_ALDEANO1_1 = new Posicion(2,15);
    public static Posicion POSICION_DEFAULT_ALDEANO1_2= new Posicion(5,19);
    public static Posicion POSICION_DEFAULT_ALDEANO1_3= new Posicion(2,22);

        /*Aldeano 2 Jugador*/
    public static Posicion POSICION_DEFAULT_ALDEANO2_1 = new Posicion(29,15);
    public static Posicion POSICION_DEFAULT_ALDEANO2_2= new Posicion(26,19);
    public static Posicion POSICION_DEFAULT_ALDEANO2_3= new Posicion(29,22);

    /* PRECIOS DE LAS UNIDADES Y EDIFCIOS*/
    public static int COSTO_ALDEANO = 25;
    public static int COSTO_ARQUERO = 75;
    public static int COSTO_ESPADACHIN = 50;
    public static int COSTO_ARMADEASEDIO = 200;
    public static int COSTO_CUARTEL = 50;
    public static int COSTO_PLAZACENTRAL = 100;

    /*VIDAS MAXIMAS*/
    public static int VIDA_MAXIMA_ALDEANO = 50;
    public static int VIDA_MAXIMA_ESPADACHIN = 100;
    public static int VIDA_MAXIMA_ARQUERO = 75;
    public static int VIDA_MAXIMA_ARMADEASEDIO = 150;
    public static int VIDA_MAXIMA_PLAZACENTRAL = 450;
    public static int VIDA_MAXIMA_CUARTEL = 250;
    public static int VIDA_MAXIMA_CASTILLO = 1000;

    /*TURNOS*/
    public static int TURNOS_CONSTRUCCION_MAXIMO = 3;
    public static final int VIDA_REPARACION = 15;


    /*ATAQUES DE LAS UNIDADES Y CASTILLO*/
    public static int ATAQUE_ESPADACHIN_A_UNIDAD = 25;
    public static int ATAQUE_ESPADACHIN_A_EDIFICIO = 15;
    public static int ATAQUE_ARQUERO_A_UNIDAD = 15;
    public static int ATAQUE_ARQUERO_A_EDIFICIO = 10;
    public static int ATAQUE_ARMADEASEDIO = 75;
    public static int ATAQUE_CASTILLO = 20;

    /*DISTANCIAS DE ATAQUES */
    public static int DISTANCIA_ATAQUE_CASTILLO = 3;
    public static int DISTANCIA_ATAQUE_ARQUERO = 3;
    public static int DISTANCIA_ATAQUE_ESPADACHIN = 1;
    public static int DISTANCIA_ATAQUE_ARMADEASEDIO = 5;

}
