package fiuba.algo3.tp2.modelo;

public class UnidadesFactory {

    public static Unidad crearUnidad(UnidadType type) throws InvalidUnidadTypeException {
        if (type.equals(UnidadType.UNIDAD_ALDEANO))
            return new Aldeano();
        else if (type.equals(UnidadType.UNIDAD_ESPADACHIN))
            return new Espadachin();
        else if (type.equals(UnidadType.UNIDAD_ARMADEASEDIO))
            return new ArmaDeAsedio();
        else if (type.equals(UnidadType.UNIDAD_ARQUERO))
            return new Arquero();

        throw new InvalidUnidadTypeException();
    }

}
