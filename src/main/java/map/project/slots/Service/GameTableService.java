package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.Exceptions.GameTableException;
import map.project.slots.Model.GameTable;
import map.project.slots.Repository.GameTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameTableService {
    @Autowired
    private GameTableRepository gameTableRepository;

    public List<GameTable> findAllTables(){
        return this.gameTableRepository.findAll();
    }

    public GameTable findTableById(Long tableId) throws GameTableException {
        Optional<GameTable> table = this.gameTableRepository.findByGameTableId(tableId);
        if(table.isEmpty()){
            throw new GameTableException();
        }
        return table.get();
    }
    @Transactional
    public GameTable deleteTableById(Long tableId) throws GameTableException{
        Optional<GameTable> table = this.gameTableRepository.findByGameTableId(tableId);
        if(table.isEmpty()){
            throw new GameTableException();
        }
        this.gameTableRepository.deleteByGameTableId(tableId);
        return table.get();
    }

    public GameTable addGameTable(GameTable table){
        this.gameTableRepository.save(table);
        return table;
    }

    public GameTable updateGameTable(GameTable table) throws GameTableException {
        Optional<GameTable> gameTable = this.gameTableRepository.findByGameTableId(table.getGameTableId());
        if(gameTable.isEmpty()){
            throw new GameTableException();
        }
        this.gameTableRepository.save(table);
        return table;
    }

}
