package fiuba.algo3.tp2;

public class Libre extends EstadoParcela {


    Boolean ocupado;

    Libre() {

        this.ocupado = false;

    }

    @Override
    public Boolean estaOcupado() {
        return ocupado;
    }

    @Override
    public EstadoParcela Ocupar() {
        return new Ocupado();
    }



}
