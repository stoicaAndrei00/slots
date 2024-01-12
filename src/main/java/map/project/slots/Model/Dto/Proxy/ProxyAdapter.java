package map.project.slots.Model.Dto.Proxy;

import map.project.slots.Model.*;
import map.project.slots.Model.Dto.Adapter.*;

public class ProxyAdapter {

    private static ProxyAdapter instance = null;

    private ProxyAdapter(){

    }
    public static ProxyAdapter getInstance(){
        if(instance == null){
            instance = new ProxyAdapter();
        }
        return instance;
    }
    public Object adapt(Object concreteObject){
        if(concreteObject.getClass() == Bar.class){
            return new BarAdapter().adaptToDto((Bar) concreteObject);
        }
        else{
            if(concreteObject.getClass() == Cashier.class){
                return new CashierAdapter().adaptToDto((Cashier) concreteObject);
            }
            else{
                if(concreteObject.getClass() == CasinoManager.class){
                    return new CasinoManagerAdapter().adaptToDto((CasinoManager) concreteObject);
                }
                else{
                    if(concreteObject.getClass() == Customer.class){
                        return new CustomerAdapter().adaptToDto((Customer) concreteObject);
                    }
                    else{
                        if(concreteObject.getClass() == CustomerSlotRecords.class){
                            return new CustomerSlotRecordsAdapter().adaptToDto((CustomerSlotRecords) concreteObject);
                        }
                        else{
                            if(concreteObject.getClass() == GameTable.class){
                                return new GameTableAdapter().adaptToDto((GameTable) concreteObject);
                            }
                            else{
                                if(concreteObject.getClass() == Product.class){
                                    return new ProductAdapter().adaptToDto((Product) concreteObject);
                                }
                                else{
                                    if(concreteObject.getClass() == Provider.class){
                                        return new ProviderAdapter().adaptToDto((Provider) concreteObject);
                                    }
                                    else{
                                        return new SlotAdapter().adaptToDto((Slot) concreteObject);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
