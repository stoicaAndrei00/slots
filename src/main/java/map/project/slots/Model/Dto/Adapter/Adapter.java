package map.project.slots.Model.Dto.Adapter;

/**
 * interface for the adapter pattern
 * this will create adapter for each of the object to convert them to dtos
 * T - concrete class
 * S - dto class
 */
public interface Adapter<T,S> {

    S adaptToDto(T object);
}
