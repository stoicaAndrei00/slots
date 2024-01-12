package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.Cashier;
import map.project.slots.Model.Exceptions.CashierException;
import map.project.slots.Repository.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashierService {
    @Autowired
    private CashierRepository cashierRepository;

    public List<Cashier> findAllCashiers(){
        return this.cashierRepository.findAll();
    }

    public Cashier findCashierById(Long cashierId) throws CashierException{
        Optional<Cashier> cashier = this.cashierRepository.findByPersonId(cashierId);
        if(cashier.isEmpty()){
            throw new CashierException();
        }
        return cashier.get();
    }
    @Transactional
    public Cashier deleteCashierById(Long cashierId) throws CashierException{
        Optional<Cashier> cashier = this.cashierRepository.findByPersonId(cashierId);
        if(cashier.isEmpty()){
            throw new CashierException();
        }
        this.cashierRepository.deleteByPersonId(cashierId);
        return cashier.get();
    }

    public Cashier addCashier(Cashier cashier){
        this.cashierRepository.save(cashier);
        return cashier;
    }

    public Cashier updateCashier(Cashier cashier) throws CashierException{
        Optional<Cashier> optionalCashier = this.cashierRepository.findByPersonId(cashier.getPersonId());
        if(optionalCashier.isEmpty()){
            throw new CashierException();
        }
        this.cashierRepository.save(cashier);
        return cashier;
    }
}
