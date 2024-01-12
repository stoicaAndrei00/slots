package map.project.slots.AdapterTest;

import map.project.slots.Model.Cashier;
import map.project.slots.Model.Dto.Adapter.CashierAdapter;
import map.project.slots.Model.Dto.CashierDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CashierAdapterTest {

    @Test
    public void testAdaptToDto(){
        Cashier cashier = new Cashier();
        cashier.setName("Vasilica");
        cashier.setEmail("distrugatotrul@gmail.com");
        cashier.setSalary(2500);
        cashier.setPersonId(1L);
        CashierAdapter cashierAdapter = new CashierAdapter();
        CashierDto cashierDto = cashierAdapter.adaptToDto(cashier);

        Assertions.assertEquals(cashierDto.getCashierId() , cashier.getPersonId());
        Assertions.assertEquals(cashierDto.getEmail() , cashier.getEmail());
        Assertions.assertEquals(cashierDto.getName() , cashier.getName());
        Assertions.assertEquals(cashierDto.getSalary() , cashier.getSalary());
    }
}
