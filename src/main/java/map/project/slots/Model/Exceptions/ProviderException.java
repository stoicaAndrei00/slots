package map.project.slots.Model.Exceptions;

public class ProviderException extends Exception{
    public ProviderException(){
        super("There is no provider with this id");
    }
}
