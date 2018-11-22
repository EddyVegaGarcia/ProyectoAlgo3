package fiuba.algo3.tp2.modelo;

public class Construido extends EstadoDeEdificio {


    @Override
    public EstadoDeEdificio cambiar() {
        return new EnConstruccion();
    }
}
