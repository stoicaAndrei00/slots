package map.project.slots.Controller;

import map.project.slots.Model.Dto.ProviderDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Exceptions.ProviderException;
import map.project.slots.Model.Provider;
import map.project.slots.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @GetMapping("/providers")
    public List<ProviderDto> providers() {
        List<ProviderDto> providerDtoList = new ArrayList<>();
        for (Provider provider : this.providerService.findAllProviders()) {
            providerDtoList.add((ProviderDto) proxyAdapter.adapt(provider));
        }
        return providerDtoList;
    }

    @GetMapping("/find-provider")
    public ProviderDto findProvider(@RequestParam Long providerId) {
        try {
            return (ProviderDto) proxyAdapter.adapt(this.providerService.findProviderById(providerId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/delete-provider")
    public ProviderDto deleteProvider(@RequestParam Long providerId) {
        try {
            return (ProviderDto) proxyAdapter.adapt(this.providerService.deleteProviderById(providerId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping("/add-provider")
    public ProviderDto addProvider(@RequestParam String name) {
        Provider provider = new Provider();
        provider.setName(name);
        return (ProviderDto) proxyAdapter.adapt(this.providerService.addProvider(provider));
    }

    @PostMapping("/update-provider")
    public ProviderDto updateProvider(@RequestParam Long providerId,
                                      @RequestParam String name) {
        Provider provider = new Provider();
        provider.setName(name);
        provider.setProviderId(providerId);
        try {
            return (ProviderDto) proxyAdapter.adapt(this.providerService.updateProvider(provider));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
