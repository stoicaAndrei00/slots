package map.project.slots.ProxyTest;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Cashier;
import map.project.slots.Model.CasinoManager;
import map.project.slots.Model.Dto.BarDto;
import map.project.slots.Model.Dto.CashierDto;
import map.project.slots.Model.Dto.CasinoManagerDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class ProxyTest {
    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @Test
    public void adaptToBarDtoTest(){


        Bar bar = new Bar();
        bar.setBarName("Caro");
        bar.setCapacity(200);
        bar.setBarId(1L);

        BarDto barDto = (BarDto) proxyAdapter.adapt(bar);

        Assertions.assertEquals(barDto.getBarName() , bar.getBarName());
        Assertions.assertEquals(barDto.getBarId() , bar.getBarId());
        Assertions.assertEquals(barDto.getCapacity() , bar.getCapacity());
    }

    public void adaptToCashierDtoTest(){
        Cashier cashier = new Cashier();
        cashier.setName("Vasilica");
        cashier.setEmail("distrugatotrul@gmail.com");
        cashier.setSalary(2500);
        cashier.setPersonId(1L);
        CashierDto cashierDto = (CashierDto) proxyAdapter.adapt(cashier);

        Assertions.assertEquals(cashierDto.getCashierId() , cashier.getPersonId());
        Assertions.assertEquals(cashierDto.getEmail() , cashier.getEmail());
        Assertions.assertEquals(cashierDto.getName() , cashier.getName());
        Assertions.assertEquals(cashierDto.getSalary() , cashier.getSalary());
    }

    public void adaptToCasinoManagerDtoTest(){
        CasinoManager manager = new CasinoManager();
        manager.setName("Cata");
        manager.setHireDate(Date.valueOf("2023-11-11"));
        manager.setEmail("Cata@gmail.com");
        manager.setPersonId(1L);
        manager.setSalary(2500);

        CasinoManagerDto casinoManagerDto = (CasinoManagerDto) proxyAdapter.adapt(manager);

        Assertions.assertEquals(casinoManagerDto.getManagerId() , manager.getPersonId());
        Assertions.assertEquals(casinoManagerDto.getEmail() , manager.getEmail());
        Assertions.assertEquals(casinoManagerDto.getName() , manager.getName());
        Assertions.assertEquals(casinoManagerDto.getSalary() , manager.getSalary());
        Assertions.assertEquals(casinoManagerDto.getHireDate() , manager.getHireDate());
    }
}
