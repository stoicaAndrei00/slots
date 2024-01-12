package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.Cashier;
import map.project.slots.Model.Dto.CashierDto;

public class CashierAdapter implements Adapter<Cashier, CashierDto> {
    @Override
    public CashierDto adaptToDto(Cashier object) {
        return new CashierDto(object.getPersonId()
                , object.getName(),
                object.getEmail(),
                object.getSalary());
    }
}
