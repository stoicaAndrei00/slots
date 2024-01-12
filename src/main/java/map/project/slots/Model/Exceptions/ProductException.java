package map.project.slots.Model.Exceptions;

public class ProductException extends Exception{
    public ProductException(){
        super("there is no product with this id");
    }
}
