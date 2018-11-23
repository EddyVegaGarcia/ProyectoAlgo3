package fiuba.algo3.tp2.modelo;

public class Aldeano extends Unidad {
    int oro;
    private EstadoDeAldeano estado;


    public Aldeano() {
        this.vida = 50;
        this.costo = 25;
        this.oro = 0;
        this.estado = new EnReposo();
    }

    public void construir(Edificio edificio)  {
        this.estado = estado.trabajando();
        edificio.construir();
    }


    public void reparar(Edificio edificio) {
        this.estado = estado.trabajando();
        edificio.reparar();

    }

    public int obtenerOroTotal() {
        return oro;
    }

    public void sumarOro(){
        this.oro = oro + 20;
    }

    public void ganarMonedas(){
       estado.ganarOro(this);
    }

    @Override
    public void atacar(Edificio edificio){
    }

    public EstaTrabajando obtenerEstado() {
        return estado;
    }
}
