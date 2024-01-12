package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.Bar;
import map.project.slots.Model.Exceptions.BarException;
import map.project.slots.Repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarService {
    @Autowired
    private BarRepository barRepository;

    public List<Bar> findAllBars(){
        return this.barRepository.findAll();
    }

    public Bar findBarById(Long barId) throws BarException {
        Optional<Bar> bar = this.barRepository.findByBarId(barId);
        if(bar.isEmpty()){
            throw new BarException();
        }
        return bar.get();
    }
    @Transactional
    public Bar deleteBarById(Long barId) throws BarException {
        Optional<Bar> bar = this.barRepository.findByBarId(barId);
        if(bar.isEmpty()){
            throw new BarException();
        }
        barRepository.deleteByBarId(barId);
        return bar.get();
    }

    public Bar addBar(Bar bar){
        this.barRepository.save(bar);
        return bar;
    }

    public Bar updateBar(Bar bar) throws BarException {
        Optional<Bar> optionalBar = this.barRepository.findByBarId(bar.getBarId());
        if(optionalBar.isEmpty()){
            throw new BarException();
        }
        this.barRepository.save(bar);
        return bar;
    }
}
