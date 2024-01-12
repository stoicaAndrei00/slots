package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.CustomerSlotRecords;
import map.project.slots.Model.Exceptions.CustomerException;
import map.project.slots.Model.Exceptions.CustomerSlotRecordException;
import map.project.slots.Repository.CustomerSlotRecordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerSlotRecordsService {

    private CustomerSlotRecordsRepository customerSlotRecordsRepository;

    public List<CustomerSlotRecords> findAllRecords(){
        return this.customerSlotRecordsRepository.findAll();
    }

    public CustomerSlotRecords findRecordById(Long recordId) throws CustomerSlotRecordException {
        Optional<CustomerSlotRecords> customerSlotRecords = this.customerSlotRecordsRepository.deleteByRecordId(recordId);
        if(customerSlotRecords.isEmpty()){
            throw new CustomerSlotRecordException();
        }
        return customerSlotRecords.get();
    }
    @Transactional
    public CustomerSlotRecords deleteRecordById(Long recordId) throws CustomerException, CustomerSlotRecordException {
        Optional<CustomerSlotRecords> customerSlotRecords = this .customerSlotRecordsRepository.findByRecordId(recordId);
        if(customerSlotRecords.isEmpty()){
            throw new CustomerSlotRecordException();
        }
        this.customerSlotRecordsRepository.deleteByRecordId(recordId);
        return customerSlotRecords.get();
    }

    public CustomerSlotRecords addRecord(CustomerSlotRecords records){
        this.customerSlotRecordsRepository.save(records);
        return records;
    }

    public CustomerSlotRecords updateRecord(CustomerSlotRecords records) throws CustomerSlotRecordException{
        Optional<CustomerSlotRecords> customerSlotRecords = this.customerSlotRecordsRepository.findByRecordId(records.getRecordId());

        if(customerSlotRecords.isEmpty()){
            throw new CustomerSlotRecordException();
        }
        this.customerSlotRecordsRepository.save(records);
        return records;
    }

}
