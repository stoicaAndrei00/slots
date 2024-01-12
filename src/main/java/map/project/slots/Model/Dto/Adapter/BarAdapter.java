package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Dto.BarDto;

public class BarAdapter implements Adapter<Bar, BarDto> {
    @Override
    public BarDto adaptToDto(Bar object) {
        return new BarDto(object.getBarId()
                , object.getBarName()
                , object.getCapacity());
    }
}
