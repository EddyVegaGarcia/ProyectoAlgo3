package fiuba.algo3.tp2.modelo.Interfaces;

public interface EstadoVidaEdificio {

    EstadoVidaEdificio finalizarReparacion();

    EstadoVidaEdificio reparar();

    Boolean estaReparado();

    Boolean estaEnReparacion();

}
