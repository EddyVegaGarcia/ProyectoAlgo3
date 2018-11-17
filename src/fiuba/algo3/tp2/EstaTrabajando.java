package fiuba.algo3.tp2;

public class EstaTrabajando implements EstadoDeAldeano {

    @Override
    public void ganarOro(Aldeano aldeano){

    }

    @Override
    public EstadoDeAldeano cambiar() {
        return new EnReposo();
    }
}
