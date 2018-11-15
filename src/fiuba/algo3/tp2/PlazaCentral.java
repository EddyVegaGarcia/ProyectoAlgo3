package fiuba.algo3.tp2;

public class PlazaCentral extends Edificio {

    PlazaCentral(){
        this.costo = 100;
        this.vida = 0;
        this.estado = new EnConstruccion();
        this.tamanio = 4;
        this.turnosConstruccion = 0;
    }

    @Override
    public void darleVida(){
        this.vida = 450;
    }

    @Override
    public boolean estaConstruido(){
        return (turnosConstruccion >=3);
    }

    @Override
    public void reparar(){}

    @Override
    public void recibirDanio(int danio){}

    @Override
    public boolean estaReparado(){
        return (vida == 450);
    }

    public Unidad crearAldeano() {
        /* lo posiciono cerca del edificio*/
        Aldeano aldeano = new Aldeano("2,3");
        return aldeano;
    }
}
