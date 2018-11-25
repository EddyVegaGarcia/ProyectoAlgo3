package fiuba.algo3.tp2.vista;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    public BarraDeMenu(Stage stage){
        Menu menuPrueba = new Menu("menuPrueba");

        MenuItem itemPrueba =  new MenuItem("itemPrueba");

        menuPrueba.getItems().addAll(itemPrueba);

        this.getMenus().addAll(menuPrueba);
    }
}
