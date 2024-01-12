package map.project.slots.Model.Exceptions;

import map.project.slots.Model.CustomerSlotRecords;

public class CustomerSlotRecordException extends Exception {
   public CustomerSlotRecordException(){
       super("there is no record with this id");
   }
}
