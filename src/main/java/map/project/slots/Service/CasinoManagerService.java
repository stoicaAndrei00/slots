package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.CasinoManager;
import map.project.slots.Model.Exceptions.CashierException;
import map.project.slots.Model.Exceptions.CasinoManagerException;
import map.project.slots.Model.Exceptions.GameTableException;
import map.project.slots.Model.GameTable;
import map.project.slots.Repository.CasinoManagerRepository;
import map.project.slots.Repository.GameTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasinoManagerService {

    @Autowired
    private CasinoManagerRepository casinoManagerRepository;

    @Autowired
    private GameTableRepository gameTableRepository;

    public List<CasinoManager> findAllManagers(){
        return this.casinoManagerRepository.findAll();
    }

    public CasinoManager findManagerById(Long managerId) throws CasinoManagerException {
        Optional<CasinoManager> casinoManager = this.casinoManagerRepository.findByPersonId(managerId);
        if(casinoManager.isEmpty()){
            throw new CasinoManagerException();
        }
        return casinoManager.get();
    }
    @Transactional
    public CasinoManager deleteManagerById(Long managerId) throws  CasinoManagerException {
        Optional<CasinoManager> casinoManager = this.casinoManagerRepository.findByPersonId(managerId);

        if(casinoManager.isEmpty()){
            throw new CasinoManagerException();
        }
        this.casinoManagerRepository.deleteByPersonId(managerId);
        return casinoManager.get();
    }

    public CasinoManager addCasinoManager(CasinoManager manager) {
        this.casinoManagerRepository.save(manager);
        return manager;
    }

    public CasinoManager updateCasinoManager(CasinoManager manager) throws CasinoManagerException {
        Optional<CasinoManager> casinoManager = this.casinoManagerRepository.deleteByPersonId(manager.getPersonId());
        if(casinoManager.isEmpty()){
            throw new CasinoManagerException();
        }
        this.casinoManagerRepository.save(manager);
        return manager;
    }

    public CasinoManager assignToGameTable(CasinoManager manager , GameTable gameTable) throws CasinoManagerException, GameTableException {
        Optional<CasinoManager> casinoManager = this.casinoManagerRepository.findByPersonId(manager.getPersonId());
        if(casinoManager.isEmpty()){
            throw new CasinoManagerException();
        }
        Optional<GameTable> optionalGameTable = this.gameTableRepository.findByGameTableId(gameTable.getGameTableId());
        if(optionalGameTable.isEmpty()){
            throw new GameTableException();
        }
        List<GameTable> gameTables = casinoManager.get().getGameTables();
        List<CasinoManager> casinoManagers = optionalGameTable.get().getCasinoManagers();
        gameTables.add(gameTable);
        casinoManagers.add(manager);
        manager.setGameTables(gameTables);
        gameTable.setCasinoManagers(casinoManagers);
        this.gameTableRepository.save(gameTable);
        this.casinoManagerRepository.save(manager);
        return casinoManager.get();
    }
}
