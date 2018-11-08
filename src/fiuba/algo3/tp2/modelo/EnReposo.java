package fiuba.algo3.tp2.modelo;

public class EnReposo extends EstadoDeAldeano {

    @Override
    public void ganarOro(Aldeano aldeano){
        aldeano.sumarOro();
    }

    @Override
    public EstadoDeAldeano cambiar() {
        return new EstaTrabajando();
    }

    @Override
    public boolean estaTrabajando() {
        return false;
    }

    @Override
    public EstadoDeAldeano construir(Edificio edificio, int turnosConstruccion) {
        if(!edificio.estaConstruido()) {
            edificio.iniciarConstruccion();
            return new EstaTrabajando();
        }
        throw new EdificioConstruidoException();
    }
}

