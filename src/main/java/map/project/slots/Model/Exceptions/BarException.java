package map.project.slots.Model.Exceptions;

public class BarException extends Exception{
    public BarException(){
        super("there is no bar with this id");
    }
}
