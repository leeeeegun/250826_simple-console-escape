package com.codingrecipe.simpleconsoleescape.service;

import com.codingrecipe.simpleconsoleescape.model.Item;
import com.codingrecipe.simpleconsoleescape.model.Monster;
import com.codingrecipe.simpleconsoleescape.model.Player;
import com.codingrecipe.simpleconsoleescape.model.Room;
import com.codingrecipe.simpleconsoleescape.view.ConsoleView;

public class GameService {

    private ConsoleView view;

    public GameService(ConsoleView view) {
        this.view = view;
    }

    //  이동 처리 로직
    public Room processMove(Room currentRoom, String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            return nextRoom;
        } else {
            view.showMessage("그 방향으로 갈 수 없습니다.");
            return currentRoom; // 이동 실패 시 현재 방 그대로 반환
        }
    }

    // 전투 처리 로직
    public void processAttack(Player player, Room currentRoom) {
        Monster monster = currentRoom.getMonster();
        if (monster == null) {
            view.showMessage("공격할 대상이 없습니다.");
            return;
        }

        // 몬스터의 공격
        player.takeDamage(monster.getAttackPower());
        view.showMessage(monster.getName() + "에게 " + monster.getAttackPower() + "의 피해를 입었습니다.");

        // 플레이어의 공격
        monster.takeDamage(player.getAttackPower());
        view.showMessage(monster.getName() + "에게" + player.getAttackPower() + "의 피해를 입었습니다.");

        view.showBattleStatus(player, monster);

        if (!monster.isAlive()) {
            view.showMessage(monster.getName() + "을(를) 물리쳤습니다!");
            currentRoom.removeMonster();
        }
    }

    // 아이템 줍기 처리 로직
    public void processTakeItem(Player player, Room currentRoom, String itemName) {
        Item item = currentRoom.getItem();
        if (item != null && item.getName().equalsIgnoreCase(itemName)) {
            player.addItem(item);
            view.showMessage(item.getName() + "을(를) 주웠습니다.");
            currentRoom.removeItem();
        } else {
            view.showMessage("그런 아이템이 없거나 주울 수 없습니다.");
        }
    }

    // 승리 조건 체크 로직
    public boolean checkWinCondition(Player player, Room currentRoom) {
        return currentRoom.getDescription().contains("거대한 포털") && player.hasItem("귀환");
    }
}
