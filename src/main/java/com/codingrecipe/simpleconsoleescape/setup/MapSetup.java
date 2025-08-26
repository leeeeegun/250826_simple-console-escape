package com.codingrecipe.simpleconsoleescape.setup;

import com.codingrecipe.simpleconsoleescape.model.Item;
import com.codingrecipe.simpleconsoleescape.model.Monster;
import com.codingrecipe.simpleconsoleescape.model.Room;

public class MapSetup {

    private Room startRoom;

    public MapSetup() {
        createMap();
    }

    public void createMap() {

        // 1. 맵/방 생성
        Room startRoom = new Room("이 곳은 많은 소환사가 거쳐간 협곡입니다.");
        Room corridor = new Room("바위 게가 있는 골목입니다. 북쪽과 남쪽으로 길이 나 있습니다.");
        Room baronRoom = new Room("바론이 지키고 있는 방입니다. 바론을 잡으면 버프가 생깁니다.");
        Room portalRoom = new Room("협곡으로 귀환할 수 있는 곳입니다. 포털이 막혀 있습니다.");
        Room exitRoom = new Room("거대환 포털이 있는 방입니다. 귀환할 수 있는 출구인 것 같습니다.");

        // 2. 방의 출구 설정 (지도 그리기)
        startRoom.setExits(corridor, null, null, null);
        corridor.setExits(baronRoom, null, startRoom, null);
        baronRoom.setExits(null, portalRoom, corridor, null);
        portalRoom.setExits(null, null, null, baronRoom);
        portalRoom.setExits(exitRoom, null, null, baronRoom);

        // 3. 아이템 및 몬스터 배치
        baronRoom.setMonster(new Monster("바론", 100, 20));
        baronRoom.setItem(new Item("바론 버프", "초고속 귀환"));

        // 4. 시작 위치 설정
        this.startRoom = startRoom;
    }

    public Room getStartRoom() {
        return startRoom;
    }
}
