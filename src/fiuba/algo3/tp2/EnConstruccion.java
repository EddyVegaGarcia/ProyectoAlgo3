package fiuba.algo3.tp2;

public class EnConstruccion extends EstadoDeEdificio {

    public EstadoDeEdificio cambiar(){

        return new Construido();
    }
}
