package fiuba.algo3.tp2;

public interface EstadoDeAldeano {

    public abstract void ganarOro(Aldeano aldeano);
    public abstract EstadoDeAldeano cambiar();

    public EstadoDeAldeano trabajando(){
        return new EstaTrabajando();
    }
}


