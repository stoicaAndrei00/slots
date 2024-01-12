package map.project.slots.Controller;

import map.project.slots.Model.CasinoManager;
import map.project.slots.Model.Dto.CasinoManagerDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.GameTable;
import map.project.slots.Service.CasinoManagerService;
import map.project.slots.Service.GameTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/casino-manager")
public class CasinoManagerController {
    @Autowired
    private CasinoManagerService casinoManagerService;
    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();
    @Autowired
    private GameTableService gameTableService;

    @GetMapping("/managers")
    public List<CasinoManagerDto> findAllManagers() {
        List<CasinoManagerDto> casinoManagerDtos = new ArrayList<>();
        for(CasinoManager casinoManager : this.casinoManagerService.findAllManagers()){
            casinoManagerDtos.add((CasinoManagerDto) proxyAdapter.adapt(casinoManager));
        }
        return casinoManagerDtos;
    }

    @GetMapping("/find-manager")
    public CasinoManagerDto findManagerById(@RequestParam Long managerId){
        try {
            return (CasinoManagerDto) proxyAdapter.adapt(this.casinoManagerService.findManagerById(managerId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("delete-manager")
    public CasinoManagerDto deleteManagerById(@RequestParam Long managerId){
        try {
            return (CasinoManagerDto) proxyAdapter.adapt(this.casinoManagerService.deleteManagerById(managerId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-manager")
    public CasinoManagerDto addManager(@RequestParam String name,
                                       @RequestParam String email,
                                       @RequestParam Date hireDate,
                                       @RequestParam float salary){
        CasinoManager casinoManager = new CasinoManager();
        casinoManager.setName(name);
        casinoManager.setEmail(email);
        casinoManager.setHireDate(hireDate);
        casinoManager.setSalary(salary);
        return (CasinoManagerDto) proxyAdapter.adapt( this.casinoManagerService.addCasinoManager(casinoManager));
    }

    @PostMapping("/update-manager")
    public CasinoManagerDto updateManager(@RequestParam Long managerId,
                                          @RequestParam String name,
                                          @RequestParam String email,
                                          @RequestParam Date hireDate,
                                          @RequestParam float salary) {
        CasinoManager casinoManager = new CasinoManager();
        casinoManager.setSalary(salary);
        casinoManager.setPersonId(managerId);
        casinoManager.setName(name);
        casinoManager.setEmail(email);
        casinoManager.setHireDate(hireDate);
        try {
            return (CasinoManagerDto) proxyAdapter.adapt(this.casinoManagerService.updateCasinoManager(casinoManager));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    @PostMapping("/assign-to-table")
    public CasinoManagerDto assignToTable(@RequestParam Long managerId,
                                          @RequestParam Long gameTableId){
        try {
            CasinoManager casinoManager = this.casinoManagerService.findManagerById(managerId);
            GameTable gameTable = this.gameTableService.findTableById(gameTableId);
            return (CasinoManagerDto) proxyAdapter.adapt(this.casinoManagerService.assignToGameTable(casinoManager , gameTable));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
