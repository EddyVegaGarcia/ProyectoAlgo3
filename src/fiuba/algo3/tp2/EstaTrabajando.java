package fiuba.algo3.tp2;

public class EstaTrabajando extends EstadoDeAldeano {

    @Override
    public void ganarOro(Aldeano aldeano){

    }

    @Override
    public EstadoDeAldeano cambiar() {
        return new EnReposo();
    }

}
