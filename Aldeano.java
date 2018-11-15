package fiuba.algo3.tp2;

public class Aldeano extends Unidad {
    int oro;
    EstadoDeAldeano estado;


    Aldeano(String pos) {
        this.posicion = new Posicion(pos);
        this.vida = 50;
        this.costo = 25;
        this.oro = 0;
        this.estado = new EnReposo();
    }

    public void construir(Edificio edificio)  {
        if(edificio.estaConstruido()) {
            throw new RuntimeException();
        }
        edificio.construir();
        this.cambiarEstado(edificio);
    }

    public int obtenerOroTotal() {
        return oro;
    }

    private void cambiarEstado(Edificio edificio){
        if(edificio.estaConstruido()){
            this.estado = new EnReposo();
        }else{
            this.estado = new EstaTrabajando();
        }
    }

    public void reparar(Edificio edificio) {
        if(edificio.estaReparado()) {
            throw new RuntimeException();
        }
        edificio.reparar();
        this.cambiarEstado(edificio);
    }

    public void ganarMonedas(){
        if(estado.estaEnReposo()){
            this.oro = oro + 20;
        }
    }

    @Override
    public void atacar(Edificio edificio){
    }

}
