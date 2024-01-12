package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.Dto.GameTableDto;
import map.project.slots.Model.GameTable;

public class GameTableAdapter implements Adapter<GameTable , GameTableDto> {
    @Override
    public GameTableDto adaptToDto(GameTable object) {
        return new GameTableDto(object.getGameTableId(),
                object.getTitle(),
                object.getType(),
                object.getCapacity());
    }
}
