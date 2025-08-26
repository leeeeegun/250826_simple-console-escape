package com.codingrecipe.simpleconsoleescape.controller;

import com.codingrecipe.simpleconsoleescape.model.Player;
import com.codingrecipe.simpleconsoleescape.model.Room;
import com.codingrecipe.simpleconsoleescape.service.GameService;
import com.codingrecipe.simpleconsoleescape.view.ConsoleView;

import java.util.Scanner;

public class GameController {

    private Player player;
    private Room currentRoom;
    private GameService gameService;
    private ConsoleView view;

    public GameController(Player player, Room startRoom, GameService gameService, ConsoleView view) {
        this.player = player;
        this.currentRoom = startRoom;
        this.gameService = gameService;
        this.view = view;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        view.showWelcomeMessage();

        while (player.isAlive()) {
            view.showRoomInfo(currentRoom);
            view.showPrompt();

            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0];
            String target = parts.length > 1 ? parts[1] : "";

            // 사용자 입력을 받아 서비스 호출
            switch (command) {
                case "이동":
                    currentRoom = gameService.processMove(currentRoom, target);
                case "공격":
                    gameService.processAttack(player, currentRoom);
                    break;
                case "줍기":
                    gameService.processTakeItem(player, currentRoom, target);
                case "인벤토리":
                    view.showInventory(player);
                case "종료":
                    view.showMessage("게임을 종료합니다.");
                    scanner.close();
                    return;
                default:
                    view.showMessage("알 수 없는 명령어입니다.");
            }

            // 승리 조건 체크
            if (gameService.checkWinCondition(player, currentRoom)) {
                view.showMessage("바론의 버프로 거대한 포털을 탔습니다.. 당신은 협곡을 탈출했습니다!.");
                break;
            }
        }
        if (!player.isAlive()) {
            view.showMessage("당신은 브론즈아이언이 딱입니다... GAME OVER!");
        }
        scanner.close();
    }
}
