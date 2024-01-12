package map.project.slots.Model.Dto.Adapter;

import map.project.slots.Model.CasinoManager;
import map.project.slots.Model.Dto.CasinoManagerDto;

public class CasinoManagerAdapter implements Adapter<CasinoManager , CasinoManagerDto> {
    @Override
    public CasinoManagerDto adaptToDto(CasinoManager object) {
        return new CasinoManagerDto(
                object.getPersonId(),
                object.getName(),
                object.getEmail(),
                object.getSalary(),
                object.getHireDate()
        );
    }
}
