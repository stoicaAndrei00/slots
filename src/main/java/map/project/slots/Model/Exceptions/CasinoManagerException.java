package map.project.slots.Model.Exceptions;

public class CasinoManagerException extends Exception{
    public CasinoManagerException(){
        super("There is no manager with this id");
    }
}
