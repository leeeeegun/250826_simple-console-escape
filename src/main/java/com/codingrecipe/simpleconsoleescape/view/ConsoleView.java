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

        // 출구 정보 출력
        System.out.print("출구: ");
        String exits = String.join(" ", currentRoom.getExits().keySet());
        System.out.println(exits.isEmpty() ? "없음" : exits);
        System.out.println("------------------------------");

        System.out.println("사용 가능한 명령어:");
        // 이동: 출구가 있을 때만 예시를 보여줌
        if (!currentRoom.getExits().isEmpty()) {
            String exampleDirection = currentRoom.getExits().keySet().iterator().next();
            System.out.println("- 이동 [방향] (예: 이동 " + exampleDirection + ")");
        }
        // 공격: 몬스터가 있을 때만 보여줌
        if (currentRoom.getMonster() != null) {
            System.out.println("- 공격");
        }
        // 줍기: 아이템이 있을 때만 예시를 보여줌
        if (currentRoom.getItem() != null) {
            System.out.println("- 줍기 [아이템] (예: 줍기 " + currentRoom.getItem().getName() + ")");
        }
        // 항상 가능한 명령어
        System.out.println("- 인벤토리");
        System.out.println("- 종료");
        System.out.println("------------------------------");
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
