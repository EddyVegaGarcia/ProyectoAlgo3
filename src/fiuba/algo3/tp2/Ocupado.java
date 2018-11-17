package fiuba.algo3.tp2;

public class Ocupado extends EstadoParcela {


    Boolean ocupado;

    Ocupado() {

        this.ocupado = true;
    }

    @Override
    public Boolean estaOcupado() {
        return ocupado;
    }

    @Override
    public EstadoParcela Ocupar() {
        throw new UbicacionOcupadaException();
    }


}
