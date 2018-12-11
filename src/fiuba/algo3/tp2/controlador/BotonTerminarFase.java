package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.Juego.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BotonTerminarFase extends Button {

    private Jugador jugador1;
    private Jugador jugador2;
    private JuegoView juegoView;
    private Juego juego;
    private HBox contenedor;
    private String nombreDelJugadorDeTurno;

    public BotonTerminarFase(HBox contenedor, Juego juego, JuegoView juegoView){

        this.contenedor = contenedor;
        this.juego = juego;
        this.juegoView = juegoView;
        this.jugador1 = juego.jugador1();
        this.jugador2 = juego.jugador2();

        this.actualizarContenedor();
    }

    private void actualizarContenedor() {
        contenedor.getChildren().clear();
        colocarDatosDelJugador(juego.jugadorDeTurno());
        //colocarBoton(contenedorVertical);
        agregarEtiquetasDeVidasDeJugadores();

    }

    private void agregarEtiquetasDeVidasDeJugadores() {
        VBox contenedorJugador1 = new VBox();
        contenedorJugador1.setPadding(new Insets(10));
        contenedorJugador1.setSpacing(10);

        VBox contenedorJugador2 = new VBox();
        contenedorJugador2.setPadding(new Insets(10));
        contenedorJugador2.setSpacing(10);

        //etiqueta para la vida de los jugadores
        Label etiquetaVidaCastilloJugador1 = crearEtiquetaConTexto("vida : " + jugador1.vida());
        Label etiquetaVidaCastilloJugador2 = crearEtiquetaConTexto("vida : " + jugador2.vida());

        //etiqueta para los nombres de los jugadores
        Label nombreJugador1 = crearEtiquetaConTexto(jugador1.obtenerNombre());
        Label nombreJugador2 = crearEtiquetaConTexto(jugador2.obtenerNombre());

        contenedorJugador1.getChildren().addAll(nombreJugador1, etiquetaVidaCastilloJugador1);
        contenedorJugador2.getChildren().addAll(nombreJugador2, etiquetaVidaCastilloJugador2);

        /*HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(10);
        contenedorHorizontal.getChildren().addAll(contenedorJugador1, contenedorJugador2);*/
        contenedor.getChildren().addAll(contenedorJugador1, contenedorJugador2);

        //contenedorVertical.getChildren().addAll(contenedorHorizontal);
    }

    private Label crearEtiquetaConTexto(String nombre) {
        Label etiqueta = new Label();
        etiqueta.setText(nombre);
        return etiqueta;
    }

    private void colocarDatosDelJugador(Jugador jugadorDeTuno) {

        VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(10));

        colocarBoton(contenedorVertical);

        Label etiqueta = new Label();
        etiqueta.setText("Oro : " + jugadorDeTuno.oro());

        nombreDelJugadorDeTurno = juego.jugadorDeTurno().obtenerNombre();

        Label etiquetaTurno = new Label();
        etiquetaTurno.setText("Turno del Jugador : " + nombreDelJugadorDeTurno);

        contenedorVertical.getChildren().addAll(etiquetaTurno, etiqueta);
        contenedor.getChildren().add(contenedorVertical);
    }

    private void colocarBoton(VBox contenedorVertical) {

        Button boton = new Button();
        boton.setText("Terminar turno");
        boton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                juego.terminarTurno();
                actualizarContenedor();
            }
        });

        contenedorVertical.getChildren().addAll(boton);
    }
}
