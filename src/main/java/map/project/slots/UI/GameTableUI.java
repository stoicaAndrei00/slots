package map.project.slots.UI;

import map.project.slots.Model.Dto.GameTableDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.GameTable;
import map.project.slots.Model.Provider;
import map.project.slots.Service.GameTableService;
import map.project.slots.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class GameTableUI {
    @Autowired
    private GameTableService gameTableService;

    @Autowired
    private ProviderService providerService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @ShellMethod(key = "game tables")
    public String findAllTables() {
        List<GameTableDto> gameTableDtoList = new ArrayList<>();
        for (GameTable table : gameTableService.findAllTables()) {
            gameTableDtoList.add((GameTableDto) proxyAdapter.adapt(table));
        }
        return gameTableDtoList.toString();
    }

    @ShellMethod(key = "find table")
    public String findGameTableById(@ShellOption(value = {"table id"}, help = "game table id") Long tableId) {
        try {
            return proxyAdapter.adapt(this.gameTableService.findTableById(tableId)).toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete table")
    public String deleteGameTableById(@ShellOption(value = {"table id"}, help = "game table id") Long tableId) {
        try {
            return proxyAdapter.adapt(this.gameTableService.deleteTableById(tableId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add table")
    public String addTable(@ShellOption(value = {"title"}, help = " table title") String title,
                           @ShellOption(value = {"type"}, help = "table type") String type,
                           @ShellOption(value = {"capacity"}, help = "table capacity") int capacity,
                           @ShellOption(value = {"provider id"}, help = " id o fht provider") Long proverId) {
        try {
            Provider provider = this.providerService.findProviderById(proverId);
            GameTable gameTable = new GameTable();
            gameTable.setCapacity(capacity);
            gameTable.setType(type);
            gameTable.setTitle(title);
            gameTable.setProvider(provider);
            return proxyAdapter.adapt(this.gameTableService.addGameTable(gameTable)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "update table")
    public String updateTable(@ShellOption(value = {"table id"}, help = "id of the table") Long tableId,
                              @ShellOption(value = {"title"}, help = " table title") String title,
                              @ShellOption(value = {"type"}, help = "table type") String type,
                              @ShellOption(value = {"capacity"}, help = "table capacity") int capacity,
                              @ShellOption(value = {"provider id"}, help = " id o fht provider") Long proverId){
        try {
            GameTable gameTable = this.gameTableService.findTableById(tableId);
            Provider provider = this.providerService.findProviderById(proverId);
            gameTable.setType(type);
            gameTable.setCapacity(capacity);
            gameTable.setTitle(title);
            gameTable.setProvider(provider);
            return proxyAdapter.adapt(this.gameTableService.updateGameTable(gameTable)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
