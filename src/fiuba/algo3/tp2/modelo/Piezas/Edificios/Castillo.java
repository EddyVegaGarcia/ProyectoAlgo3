package fiuba.algo3.tp2.modelo.Piezas.Edificios;

import fiuba.algo3.tp2.modelo.Campo.Mapa;
import fiuba.algo3.tp2.modelo.Campo.Posicion;
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

public class Castillo extends Edificio implements Diseñador {

    public Castillo() {

        this.vida = VIDA_MAXIMA_CASTILLO;
        this.tamanio = TAMANIO_CASTILLO;
        this.estado = new Construido();
        this.estadoVida =  new Reparado();
    }

    @Override
    public void recibirDanio(int unDanio) {
        estadoVida = new Daniado();
        super.recibirDanio(unDanio);
    }

    private int obtenerDistanciaAtaque() { return DISTANCIA_ATAQUE_CASTILLO; }

    @Override
    public void validarOroSufiente(int cantidadOroActual, int costo) {
        if(cantidadOroActual < costo)
            throw new OroInsuficienteException();
    }

    @Override
    public Unidad colocarPieza(PiezaType piezaType, Jugador jugador) {

        if (piezaType == PiezaType.UNIDAD_ARMADEASEDIO) {

            this.validarOroSufiente(jugador.obtenerOro(), COSTO_ARMADEASEDIO);
            this.validarAcciones();
            this.accionRealizada();

            jugador.pagar(COSTO_ARMADEASEDIO);
            return (Unidad) PiezaFactory.crearPieza(piezaType);

        }
        else
            throw new InvalidUnidadTypeException();

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

        if(vida + VIDA_REPARACION_A_CUARTEL > VIDA_MAXIMA_CASTILLO)
            vida = VIDA_MAXIMA_CASTILLO;
        else
            this.vida = vida + VIDA_REPARACION_A_CASTILLO;
    }

    @Override
    public String obtenerNombre() {
        return "Castillo";
    }

    @Override
    public void verificarProcesoEnReparacion() {
        if(estadoVida.estaEnReparacion())
            throw new EdificioEnReparacionException();
    }

    @Override
    public void finalizarReparacion() {

        this.estadoVida = this.estadoVida.finalizarReparacion();

    }

    @Override
    public void iniciarReparacion() {

        this.estadoVida =  this.estadoVida.reparar();

    }

    public void atacarA(Pieza victima) {

        victima.recibirDanio(ATAQUE_CASTILLO);

    }

    public void ataqueMasivo(Jugador unJugador, Mapa unMapa, Juego unJuego) {

        ArrayList<Pieza> victimas = unMapa.obtenerPiezasQueEstanEnRango(obtenerPosicion() ,this.obtenerTamanio(), this.obtenerDistanciaAtaque());

        for(Pieza victima : victimas){
            if( !unJugador.sosDuenioDe(victima) )
                try {
                    this.atacarA(victima);
                }catch (PiezaDestruidaException e){
                    unJuego.actualizarPiezas();
                    unMapa.actualizarPiezas();
                }
        }

    }

}
