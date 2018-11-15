package fiuba.algo3.tp2;

public class Cuartel extends Edificio {

    Cuartel(){
        this.costo = 50;
        this.vida = 0;
        this.tamanio = 4;
        this.estado = new EnConstruccion();
        this.turnosConstruccion = 0;
    }

    @Override
    public void darleVida(){
        this.vida = 250;
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
        return (vida == 250);
    }

    public Unidad crearEspadachin() {
        Espadachin espadachin = new Espadachin("2,3");
        return espadachin;
    }

    public Unidad crearArquero() {
        Arquero arquero = new Arquero("2,5");
        return arquero;
    }
}
