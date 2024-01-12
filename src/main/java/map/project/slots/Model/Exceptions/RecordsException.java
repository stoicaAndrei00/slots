package map.project.slots.Model.Exceptions;

public class RecordsException extends Exception{
    public RecordsException(){
        super("there is no record with this id");
    }
}
