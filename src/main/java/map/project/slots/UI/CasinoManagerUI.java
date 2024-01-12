package map.project.slots.UI;

import map.project.slots.Model.CasinoManager;
import map.project.slots.Model.Dto.CasinoManagerDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.GameTable;
import map.project.slots.Service.CasinoManagerService;
import map.project.slots.Service.GameTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class CasinoManagerUI {

    @Autowired
    private CasinoManagerService casinoManagerService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @Autowired
    private GameTableService gameTableService;

    @ShellMethod(key = "managers")
    public String findAllManagers() {
        List<CasinoManagerDto> managerDtoList = new ArrayList<>();
        for (CasinoManager manager : this.casinoManagerService.findAllManagers()) {
            managerDtoList.add((CasinoManagerDto) proxyAdapter.adapt(manager));
        }
        return managerDtoList.toString();
    }

    @ShellMethod(key = "find manager")
    public String findManagerById(@ShellOption(value = {"mananger id"}, help = "manager id") Long managerId) {
        try {
            return proxyAdapter.adapt(this.casinoManagerService.findManagerById(managerId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete manager")
    public String deleteManagerById(@ShellOption(value = {"manager id"}, help = "manger id") Long managerId) {
        try {
            return proxyAdapter.adapt(this.casinoManagerService.deleteManagerById(managerId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add manager")
    public String addManager(@ShellOption(value = {"name"}, help = "manager name") String name,
                             @ShellOption(value = {"email"}, help = "manager email") String email,
                             @ShellOption(value = {"hire date"}, help = "date of hire yyyy-mm-dd") String dateOfHire,
                             @ShellOption(value = {"salary"}, help = "manager salary") float salary) {
        CasinoManager manager = new CasinoManager();
        manager.setName(name);
        manager.setEmail(email);
        manager.setSalary(salary);
        manager.setHireDate(Date.valueOf(dateOfHire));
        return proxyAdapter.adapt(this.casinoManagerService.addCasinoManager(manager)).toString();
    }

    @ShellMethod(key = "update manager")
    public String updateManager(@ShellOption(value = {"manager id"}, help = "id of manager") Long managerId,
                                @ShellOption(value = {"name"}, help = "manager name") String name,
                                @ShellOption(value = {"email"}, help = "manager email") String email,
                                @ShellOption(value = {"hire date"}, help = "date of hire yyyy-mm-dd") String dateOfHire,
                                @ShellOption(value = {"salary"}, help = "manager salary") float salary){
        try{
            CasinoManager manager = new CasinoManager();
            manager.setPersonId(managerId);
            manager.setName(name);
            manager.setEmail(email);
            manager.setSalary(salary);
            manager.setHireDate(Date.valueOf(dateOfHire));
            return proxyAdapter.adapt(this.casinoManagerService.updateCasinoManager(manager)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "assign to table")
    public String assignManagerToTable(@ShellOption(value = {"manager id"} , help = "id of the manager") Long managerId,
                                       @ShellOption(value = {"game table id"} , help = "id of the game table") Long gameTableId){
        try{
            CasinoManager casinoManager = this.casinoManagerService.findManagerById(managerId);
            GameTable gameTable = this.gameTableService.findTableById(gameTableId);
            return proxyAdapter.adapt(this.casinoManagerService.assignToGameTable(casinoManager , gameTable)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
