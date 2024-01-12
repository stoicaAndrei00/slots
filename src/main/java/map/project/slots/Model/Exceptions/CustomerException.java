package map.project.slots.Model.Exceptions;

public class CustomerException extends Exception{
    public CustomerException(){
        super("There is no customer with this id");
    }
}
