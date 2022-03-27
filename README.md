마인크래프트 플러그인 공부(JAVA)
======================
## 클론 에센셜 플러그인
각종 필수 플러그인들을 한글로 바꾸어 제작

## 이코노미 플러그인
DB를 마인크래프트 서버를 실행한  채로 SQLite 프로그램에서 Delete 등 DB를 변경하는 작업을 할 시 Lock이 걸리는 문제 발생
economy DB와 User DB를 따로 두어서 작업 수행

## PlayerInteractEvent
PlayerInteractEvent에 관하여 RIGHT_CLICK 에는 일반 HAND 와 OFFHAND 가 2번 들어가게 되어 함수가 두 번 실행되는 문제가 발생
e.getHand().equals(EquipmentSlot.HAND)를 통해 OFFHAND의 작동을 방지


## 클론 월드에딧 플러그인
Material.WOODEN_AXE를 사용하려 하면 api-version을 plugin.yml에 기재하여 달라는 문제 발생
plugin.yml에 api-version : 1.18 을 기재하여 해결 (당시 버전 : 1.18.1은 최신버전이라 api-version이 1.18과 동일하다고 예상)
월드에딧의 채우기 명령어(CloneWorldEditFill) 에서 WorldEdit 객체의 메소드를 호출(Null 값 리턴)했으나 값이 제대로 안 들어와짐
객체 자체를 넘겨주는 형식으로 해야함. 자바에 대한 이해 필요 ㅁㅁㅁ
