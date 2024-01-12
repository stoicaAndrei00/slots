package map.project.slots.Model.Exceptions;

public class SlotException extends Exception{
    public SlotException(){
        super("There is no slot with this id");
    }
}
