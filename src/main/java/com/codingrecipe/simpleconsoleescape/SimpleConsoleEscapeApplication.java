package com.codingrecipe.simpleconsoleescape;

import com.codingrecipe.simpleconsoleescape.controller.GameController;
import com.codingrecipe.simpleconsoleescape.model.Player;
import com.codingrecipe.simpleconsoleescape.model.Room;
import com.codingrecipe.simpleconsoleescape.service.GameService;
import com.codingrecipe.simpleconsoleescape.setup.MapSetup;
import com.codingrecipe.simpleconsoleescape.view.ConsoleView;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class SimpleConsoleEscapeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleConsoleEscapeApplication.class, args);

        MapSetup mapSetup = new MapSetup();
        Player player = new Player(100, 35);
        Room startRoom = mapSetup.getStartRoom();

        ConsoleView view = new ConsoleView();
        GameService gameService = new GameService(view);
        GameController controller = new GameController(player, startRoom, gameService, view);

        controller.run();
    }

}
