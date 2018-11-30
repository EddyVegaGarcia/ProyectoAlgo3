package fiuba.algo3.tp2.modelo;

import fiuba.algo3.tp2.modelo.Exception.EdificioConstruidoException;

public class EnReposo extends EstadoDeAldeano {

    @Override
    public void ganarOro(Aldeano aldeano){
        aldeano.sumarOro();
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

    @Override
    public void reparar(EstadoDeAldeano unEstado) {
        unEstado = new EstaTrabajando();
    }
}

