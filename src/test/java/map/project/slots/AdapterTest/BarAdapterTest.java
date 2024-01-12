package map.project.slots.AdapterTest;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Dto.Adapter.BarAdapter;
import map.project.slots.Model.Dto.BarDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BarAdapterTest {

    @Test
    public void testAdaptToDto(){
        Bar bar = new Bar();
        bar.setBarName("Caro");
        bar.setCapacity(200);
        bar.setBarId(1L);

        BarAdapter adapter = new BarAdapter();

        BarDto barDto = adapter.adaptToDto(bar);

        Assertions.assertEquals(barDto.getBarName() , bar.getBarName());
        Assertions.assertEquals(barDto.getBarId() , bar.getBarId());
        Assertions.assertEquals(barDto.getCapacity() , bar.getCapacity());
    }
}
