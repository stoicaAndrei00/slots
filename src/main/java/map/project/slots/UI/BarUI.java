package map.project.slots.UI;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Dto.BarDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class BarUI {
    @Autowired
    private BarService barService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();
    @ShellMethod(key = "bars")
    public String findAllBars(){
        List<Bar> bars = this.barService.findAllBars();
        List<BarDto> barDtos = new ArrayList<>();
        for(Bar bar : bars){
            barDtos.add((BarDto) proxyAdapter.adapt(bar));
        }
        return barDtos.toString();
    }

    @ShellMethod(key = "find bar")
    public String findBarById(@ShellOption(value = {"barId"} , help = "bar id") Long barId){
        try{
            return  proxyAdapter.adapt(this.barService.findBarById(barId)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete bar")
    public String deleteBarById(@ShellOption(value = {"barId"} , help = "bar id") Long barId){
        try {
            return proxyAdapter.adapt(this.barService.deleteBarById(barId)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add bar")
    public String addBar(@ShellOption(value = {"barname"} , help = "name of the bar") String barName,
                         @ShellOption(value = {"capacity"} , help = "amount of people that can go in the bar") int capacity
    ){
        Bar bar = new Bar();
        bar.setBarName(barName);
        bar.setCapacity(capacity);
        return proxyAdapter.adapt(this.barService.addBar(bar)).toString();
    }

    @ShellMethod(key = "update bar")
    public String updateBar(@ShellOption(value = {"barId"} , help = "bar id") Long barId,
                            @ShellOption(value = {"barname"} , help ="name of the bar") String barName,
                            @ShellOption(value = {"capacity"} , help = "capacity of the bar") int capacity){

        Bar bar = new Bar();
        bar.setBarId(barId);
        bar.setBarName(barName);
        bar.setCapacity(capacity);
        try{
            return proxyAdapter.adapt(this.barService.updateBar(bar)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
 }
