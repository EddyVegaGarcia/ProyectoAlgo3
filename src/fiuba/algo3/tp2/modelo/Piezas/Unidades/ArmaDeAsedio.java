package fiuba.algo3.tp2.modelo.Piezas.Unidades;

import fiuba.algo3.tp2.modelo.Campo.Posicion;
import fiuba.algo3.tp2.modelo.Estados.*;
import fiuba.algo3.tp2.modelo.Exception.*;
import fiuba.algo3.tp2.modelo.Interfaces.*;
import fiuba.algo3.tp2.modelo.Piezas.*;
import fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType;

import java.util.ArrayList;

import static fiuba.algo3.tp2.modelo.Constantes.*;
import static fiuba.algo3.tp2.modelo.UnidadFactory.PiezaType.*;

public class ArmaDeAsedio extends Unidad implements Atacante, Montable, Creable {

    int distanciaDeAtaque, tiempoEsperadoDeMontura;
    EstadoDeArmaDeAsedio estado;

    public ArmaDeAsedio(){

        this.tamanio = TAMANIO_UNIDAD;
        this.vida = VIDA_MAXIMA_ARMADEASEDIO;
        this.costo = COSTO_ARMADEASEDIO;
        this.distanciaDeAtaque = DISTANCIA_ATAQUE_ARMADEASEDIO;
        this.tiempoEsperadoDeMontura = TIEMPO_INICIAL_DE_MONTURA;
        this.estado = new Desmontado();

    }

    private void validarAtaqueMontura() {

        if(!estado.estaMontado())
            throw new ArmaDeAsedioDesmontadaSinAtaqueException();


    }

    public void activarMontura(){

        tiempoEsperadoDeMontura = TIEMPO_ESPERADO_DE_MONTURA;

    }

    public  void desactivarMontura(){

        tiempoEsperadoDeMontura = TIEMPO_INICIAL_DE_MONTURA;

    }

    public void movimientoPosible() {

        if(!estado.validacionMovimiento())
            throw new ArmaDeAsedioMontadaSinMovimientoException();

    }

    @Override
    public int obtenerDistanciaAtaque() {
        return distanciaDeAtaque;
    }

    public int obtenerTiempoEsperado(){

        return tiempoEsperadoDeMontura;

    }

    @Override
    public void montar() {

        this.validarAcciones();
        this.montarIncogruencia();
        this.accionRealizada();
        this.estado = estado.montar(this);

    }

    @Override
    public void desmontar() {

        this.validarAcciones();
        this.desmontarIncogruencia();
        this.accionRealizada();
        this.estado = estado.desmontar(this);

    }

    @Override
    public void cambiarPosicion(Posicion nuevaPosicion) {

        this.validarAcciones();
        this.movimientoPosible();
        super.cambiarPosicion(nuevaPosicion);

    }

    @Override
    public PiezaType obtenerType() {
        return UNIDAD_ARMADEASEDIO;
    }

    @Override
    public double getTamanio() {
        return tamanio;
    }

    @Override
    public void montarIncogruencia() {
        if(this.estado.estaMontado())
            throw new MontarIncogruenciaException();
    }

    @Override
    public void desmontarIncogruencia() {
        if(!this.estado.estaMontado())
            throw new DesmontarIncogruenciaException();
    }

    @Override
    public void atacarPieza(Pieza unaPieza) {
        this.validarAcciones();
        this.validarAtaqueMontura();
        this.validarRangoDeAtaque(unaPieza.obtenerPosiciones(), this.obtenerDistanciaAtaque());
        unaPieza.recibirDanio(ATAQUE_ARMADEASEDIO);
        this.accionRealizada();
    }

    @Override
    public void validarOroSuficiente(int oro) {
        if( oro < COSTO_ARMADEASEDIO )
            throw new OroInsuficienteException();
    }

    @Override
    public int costo() {
        return costo;
    }

}
