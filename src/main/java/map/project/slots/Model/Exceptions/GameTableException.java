package map.project.slots.Model.Exceptions;

public class GameTableException extends Exception{
    public GameTableException(){
        super("There is no game table with this id");
    }
}
