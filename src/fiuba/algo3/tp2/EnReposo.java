package fiuba.algo3.tp2;

public class EnReposo implements EstadoDeAldeano {

    @Override
    public void ganarOro(Aldeano aldeano){
        aldeano.sumarOro();
    }

    @Override
    public EstadoDeAldeano cambiar() {
        return new EstaTrabajando();
    }
}

