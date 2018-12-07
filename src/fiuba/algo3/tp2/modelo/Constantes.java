package fiuba.algo3.tp2.modelo;



import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.ArrayList;

public class Constantes {

    public static int FILA_DEFAULT_MAPA = 35;
    public static int COLUMNA_DEFAULT_MAPA = 40;
    public static int LIMITE_POBLACION = 50;
    public static int CANTIDAD_DE_ORO_INICIAL = 100;
    public static int POBLACION_INICIAL = 0;
    public static int CANTIDAD_DE_ALDEANOS_INICIAL = 3;

    /*TAMAÑO DE LAS PIEZAS*/
    public static int TAMANIO_PLAZA = 4;
    public static int TAMANIO_CUARTEL = 4;
    public static int TAMANIO_CASTILLO = 16;
    public static int TAMANIO_UNIDAD = 1;



    /*POSICIONES POR DEAFULT DE CASTILLOS, PLAZAS Y ALDEANOS INICIALES*/
        /*Castillo1*/
    public static Posicion POSICION_DEFAULT_CASTILLO1_1 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_2 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_3 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_4 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_5 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_6 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_7 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_8 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_9 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_10 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_11 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_12 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_13 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_14 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_15 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO1_16 = new Posicion(1,1);
        /*Castillo2*/
    public static Posicion POSICION_DEFAULT_CASTILLO2_1 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_2 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_3 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_4 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_5 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_6 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_7 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_8 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_9 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_10 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_11 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_12 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_13 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_14 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_15 = new Posicion(1,1);
    public static Posicion POSICION_DEFAULT_CASTILLO2_16 = new Posicion(1,1);
        /*Plaza1*/
    public static Posicion POSICION_DEFAULT_PLAZA1_1 = new Posicion(10,1);
    public static Posicion POSICION_DEFAULT_PLAZA1_2 = new Posicion(10,1);
    public static Posicion POSICION_DEFAULT_PLAZA1_3 = new Posicion(10,1);
    public static Posicion POSICION_DEFAULT_PLAZA1_4 = new Posicion(10,1);
        /*Plaza2*/
    public static Posicion POSICION_DEFAULT_PLAZA2_1 = new Posicion(10,1);
    public static Posicion POSICION_DEFAULT_PLAZA2_2 = new Posicion(10,1);
    public static Posicion POSICION_DEFAULT_PLAZA2_3 = new Posicion(10,1);
    public static Posicion POSICION_DEFAULT_PLAZA2_4 = new Posicion(10,1);

    public static Posicion POSICION_DEFAULT_ALDEANO1_1 = new Posicion(1,9);
    public static Posicion POSICION_DEFAULT_ALDEANO1_2= new Posicion(2,9);
    public static Posicion POSICION_DEFAULT_ALDEANO1_3= new Posicion(3,9);

    public static Posicion POSICION_DEFAULT_ALDEANO2_1 = new Posicion(1,34);
    public static Posicion POSICION_DEFAULT_ALDEANO2_2= new Posicion(2,34);
    public static Posicion POSICION_DEFAULT_ALDEANO2_3= new Posicion(3,34);

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
    static final int VIDA_REPARACION = 15;


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
