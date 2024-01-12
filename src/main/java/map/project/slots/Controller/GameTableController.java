package map.project.slots.Controller;

import map.project.slots.Model.Dto.GameTableDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.GameTable;
import map.project.slots.Model.Provider;
import map.project.slots.Service.GameTableService;
import map.project.slots.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/game-table")
public class GameTableController {
    @Autowired
    private GameTableService gameTableService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @Autowired
    private ProviderService providerService;

    @GetMapping("/all-tables")
    public List<GameTableDto> findAllTables(){
        List<GameTableDto> gameTableDtoList = new ArrayList<>();
        for(GameTable gameTable : this.gameTableService.findAllTables()){
            gameTableDtoList.add((GameTableDto) proxyAdapter.adapt(gameTable));
        }
        return gameTableDtoList;
    }

    @GetMapping("/find-table")
    public GameTableDto findTableById(@RequestParam Long tableId){
        try {
            return (GameTableDto) proxyAdapter.adapt(this.gameTableService.findTableById(tableId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-table")
    public GameTableDto deleteTableById(@RequestParam Long tableId){
        try {
            return (GameTableDto) proxyAdapter.adapt(this.gameTableService.deleteTableById(tableId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-table")
    public GameTableDto addGametable(@RequestParam String title,
                                     @RequestParam String type,
                                     @RequestParam int capacity,
                                     @RequestParam Long providerId){
        try {
            Provider provider = this.providerService.findProviderById(providerId);
            GameTable gameTable = new GameTable();
            gameTable.setType(type);
            gameTable.setTitle(title);
            gameTable.setCapacity(capacity);
            gameTable.setProvider(provider);
            return (GameTableDto) proxyAdapter.adapt(this.gameTableService.addGameTable(gameTable));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/update-title")
    public GameTableDto updateGameTable(@RequestParam Long tableId,
                                        @RequestParam String title,
                                        @RequestParam String type,
                                        @RequestParam int capacity,
                                        @RequestParam Long providerId){
        try {
            Provider provider = this.providerService.findProviderById(providerId);
            GameTable gameTable = new GameTable();
            gameTable.setGameTableId(tableId);
            gameTable.setType(type);
            gameTable.setTitle(title);
            gameTable.setCapacity(capacity);
            gameTable.setProvider(provider);
            return (GameTableDto) proxyAdapter.adapt(this.gameTableService.updateGameTable(gameTable));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
