package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Juego.Juego;
import fiuba.algo3.tp2.modelo.Juego.Jugador;
import fiuba.algo3.tp2.modelo.Piezas.Pieza;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.*;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class Castillo extends Edificio implements Diseñador, Atacante {

    public Castillo() {
        this.vida = VIDA_MAXIMA_CASTILLO;
        this.tamanio = TAMANIO_CASTILLO;
        this.estado = new Construido();
        this.estadoVida =  new Reparado();
        vidaMaxima = VIDA_MAXIMA_CASTILLO;
    }

    public int obtenerDistanciaAtaque() { return DISTANCIA_ATAQUE_CASTILLO; }

    @Override
    public void atacarPieza(Pieza victima) {
        victima.recibirDanioDe(this);
    }

    @Override
    public int danioParaUnidad() {
        return ATAQUE_CASTILLO;
    }

    @Override
    public int danioParaEdificio() {
        return ATAQUE_CASTILLO;
    }

    @Override
    public Unidad colocarPieza(PiezaType piezaType, Jugador jugador) {

        if (piezaType != PiezaType.UNIDAD_ARMADEASEDIO)
            throw new InvalidUnidadTypeException();

        Creable unidad = (Creable)PiezaFactory.crearPieza(piezaType);
        unidad.validarOroSuficiente(jugador.obtenerOro());
        this.validarAcciones();
        this.accionRealizada();

        return (Unidad)unidad;
    }

    @Override
    public PiezaType obtenerType() {
        return EDIFICIO_CASTILLO;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public void darVidaPorReparacion() {

        if(vida + VIDA_REPARACION_A_CASTILLO > VIDA_MAXIMA_CASTILLO)
            vida = VIDA_MAXIMA_CASTILLO;
        else
            this.vida = vida + VIDA_REPARACION_A_CASTILLO;
    }

    public void ataqueMasivo(Jugador unJugador, Mapa unMapa, Juego unJuego) {

        ArrayList<Pieza> victimas = unMapa.obtenerPiezasQueEstanEnRango(obtenerPrimeraPosicion() ,this.obtenerTamanio(), this.obtenerDistanciaAtaque());

        for(Pieza victima : victimas){
            if( !unJugador.sosDuenioDe(victima) )
                try {
                    this.atacarPieza(victima);
                }catch (PiezaDestruidaException e){
                    unJuego.actualizarPiezas();
                    unMapa.actualizarPiezas();
                }
        }

    }

    @Override
    public void verificarPosibleConstruccion() {
        throw new ConstruccionCastilloException();
    }

    @Override
    public void verificarPosibleReparacion() {
        this.verificarProcesoEnReparacion();
    }

    @Override
    public void recibirDanioDe(Atacante atacante) {
        estadoVida = new Daniado();
        int danio = atacante.danioParaEdificio();
        if (vida - danio <= 0) {
            vida = 0;
            throw new PiezaDestruidaException();
        }
        vida-=danio;
    }
}
