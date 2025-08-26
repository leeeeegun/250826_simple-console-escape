package com.codingrecipe.simpleconsoleescape.view;

import com.codingrecipe.simpleconsoleescape.model.Item;
import com.codingrecipe.simpleconsoleescape.model.Monster;
import com.codingrecipe.simpleconsoleescape.model.Player;
import com.codingrecipe.simpleconsoleescape.model.Room;

public class ConsoleView {

    public void showWelcomeMessage() {
        System.out.println("소환사의 협곡에 오신 걸 환영합니다!");
    }

    public void showRoomInfo(Room currentRoom) {
        System.out.println("\n------------------------------");
        System.out.println("현재 위치: " + currentRoom.getDescription());
        if (currentRoom.getMonster() != null) {
            System.out.println("으악!! " + currentRoom.getMonster().getName() + "이(가) 나타났습니다!");
        }
        if (currentRoom.getItem() != null) {
            System.out.println(currentRoom.getItem().getName() + "이(가) 바닥에 떨어져 있습니다.");
        }
        System.out.print("출구: ");
        for (String direction : currentRoom.getExits().keySet()) {
            System.out.print(direction + " ");
        }
        System.out.println("\n------------------------------");
    }

    public void showInventory(Player player) {
        System.out.println("--- 인벤토리 ---");
        if(player.getInventory().isEmpty()) {
            System.out.println("비어있음");
        } else {
            for (Item item : player.getInventory()) {
                System.out.println(item.toString());
            }
        }
        System.out.println("----------------");
    }

    public void showBattleStatus(Player player, Monster monster) {
        System.out.println("Player HP: " + player.getHp() + " | Monster HP: " + monster.getHp());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showPrompt() {
        System.out.print("> ");
    }
}
