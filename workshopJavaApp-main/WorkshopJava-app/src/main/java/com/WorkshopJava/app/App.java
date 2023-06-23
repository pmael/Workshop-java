package com.WorkshopJava.app;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.KeyCode;

public class App extends GameApplication {
    private Entity player;
    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Workshop Java");
    }

    @Override
    protected void initInput() {
        FXGL.onKeyDown(KeyCode.RIGHT , () -> {
            player.translateX(5);
        });
        FXGL.onKeyDown(KeyCode.LEFT , () -> {
            player.translateX(-5);
        });
        FXGL.onKeyDown(KeyCode.UP , () -> {
            player.translateY(-5);
        });
        FXGL.onKeyDown(KeyCode.DOWN , () -> {
            player.translateY(5);
        });
    }

    private Entity enemy;
    @Override
    protected void initGame() {
        var pos_x = 0;
        var pos_y = 0;
        FXGL.getGameWorld().addEntityFactory(new Factory());
        player = FXGL.entityBuilder()
                .at(pos_x, pos_y)
                .view(new Rectangle(25, 25, Color.BLUE))
                .buildAndAttach();
        enemy = FXGL.spawn("enemy", 5, 5);
    }


    public static void main(String[] args) {
        launch(args);
    }

}
