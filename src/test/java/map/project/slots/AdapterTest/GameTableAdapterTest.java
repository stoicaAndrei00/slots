package map.project.slots.AdapterTest;

import map.project.slots.Model.Dto.Adapter.GameTableAdapter;
import map.project.slots.Model.Dto.GameTableDto;
import map.project.slots.Model.GameTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTableAdapterTest {
    @Test
    public void adaptToDtoTest(){
        GameTable gameTable = new GameTable();
        gameTable.setGameTableId(1L);
        gameTable.setCapacity(15);
        gameTable.setTitle("number 1");
        gameTable.setType("black jack");

        GameTableDto gameTableDto = new GameTableAdapter().adaptToDto(gameTable);

        Assertions.assertEquals(gameTableDto.getGameTableId() , gameTable.getGameTableId());
        Assertions.assertEquals(gameTableDto.getTitle() , gameTable.getTitle());
        Assertions.assertEquals(gameTableDto.getCapacity() , gameTable.getCapacity());
        Assertions.assertEquals(gameTableDto.getType() , gameTable.getType());
    }
}
