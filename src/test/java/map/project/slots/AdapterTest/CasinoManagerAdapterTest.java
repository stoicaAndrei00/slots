package map.project.slots.AdapterTest;

import map.project.slots.Model.CasinoManager;
import map.project.slots.Model.Dto.Adapter.CasinoManagerAdapter;
import map.project.slots.Model.Dto.CasinoManagerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class CasinoManagerAdapterTest {

    @Test
    public void adaptToDtoTest(){
        CasinoManager manager = new CasinoManager();
        manager.setName("Cata");
        manager.setHireDate(Date.valueOf("2023-11-11"));
        manager.setEmail("Cata@gmail.com");
        manager.setPersonId(1L);
        manager.setSalary(2500);

        CasinoManagerAdapter adapter = new CasinoManagerAdapter();
        CasinoManagerDto casinoManagerDto = adapter.adaptToDto(manager);

        Assertions.assertEquals(casinoManagerDto.getManagerId() , manager.getPersonId());
        Assertions.assertEquals(casinoManagerDto.getEmail() , manager.getEmail());
        Assertions.assertEquals(casinoManagerDto.getName() , manager.getName());
        Assertions.assertEquals(casinoManagerDto.getSalary() , manager.getSalary());
        Assertions.assertEquals(casinoManagerDto.getHireDate() , manager.getHireDate());
    }
}
