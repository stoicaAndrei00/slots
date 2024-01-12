package map.project.slots.Model.Exceptions;

public class CashierException extends Exception{
    public CashierException(){
        super("There is no cashier with this id");
    }
}
