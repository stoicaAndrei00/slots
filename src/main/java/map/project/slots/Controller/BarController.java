package map.project.slots.Controller;

import map.project.slots.Model.Bar;
import map.project.slots.Model.Dto.BarDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Service.BarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bar")
public class BarController {
    @Autowired
    private BarService barService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();
    @GetMapping("/all-bars")
    public List<BarDto> findAllBars(){
        List<BarDto> barDtos = new ArrayList<>();
        for(Bar bar : this.barService.findAllBars()){
            barDtos.add((BarDto) proxyAdapter.adapt(bar));
        }
        return barDtos;
    }

    @GetMapping("/find-bar")
    public BarDto findBarById(@RequestParam Long barId){
        try{
            return (BarDto) proxyAdapter.adapt(this.barService.findBarById(barId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @PostMapping("/delete-bar")
    public BarDto deleteBarById(@RequestParam Long barId){
        try {
            return (BarDto) proxyAdapter.adapt(this.barService.deleteBarById(barId));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-bar")
    public BarDto addBar(@RequestParam String barName,
                         @RequestParam int capacity){
        Bar bar = new Bar();
        bar.setBarName(barName);
        bar.setCapacity(capacity);
        return (BarDto) proxyAdapter.adapt(this.barService.addBar(bar));
    }

    @PostMapping("/update-bar")
    public BarDto updateBar(@RequestParam Long barId,
                            @RequestParam String barName,
                            @RequestParam int capacity){
        Bar bar = new Bar();
        bar.setBarId(barId);
        bar.setBarName(barName);
        bar.setCapacity(capacity);
        try {
            return (BarDto) proxyAdapter.adapt(this.barService.updateBar(bar));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
