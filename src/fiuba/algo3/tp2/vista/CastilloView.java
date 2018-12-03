package fiuba.algo3.tp2.vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CastilloView {
    private final ContenedorPrincipal root;
    private final double positionX;
    private final double positionY;
    private final double playerScale = 0.1;
    private final ImageView castilloImage;

    public CastilloView(ContenedorPrincipal contenedorPrincipal, int a, int b) {
        this.root = contenedorPrincipal;
        positionX = contenedorPrincipal.width/a;
        positionY = contenedorPrincipal.height-600;

        castilloImage = new ImageView();
        castilloImage.setTranslateX(positionX);
        castilloImage.setTranslateY(positionY);
        castilloImage.setScaleX(playerScale);
        castilloImage.setScaleY(playerScale);

        castilloImage.setImage(new Image("file:src/fiuba/algo3/tp2/vista/imagenes/castillo.png"));
        root.getChildren().add(castilloImage);
    }
}
