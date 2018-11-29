package fiuba.algo3.tp2.modelo;

public abstract class EstadoDeAldeano {

    public abstract void ganarOro(Aldeano aldeano);

    public abstract EstadoDeAldeano cambiar();

    public EstadoDeAldeano trabajando(){
        return new EstaTrabajando();
    }

    public abstract String getEstado();
}


