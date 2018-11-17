package fiuba.algo3.tp2;

public class Construido extends EstadoDeEdificio {


    @Override
    public EstadoDeEdificio cambiar() {
        return new EnConstruccion();
    }
}
