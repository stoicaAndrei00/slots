package map.project.slots.UI;

import map.project.slots.Model.Dto.ProviderDto;
import map.project.slots.Model.Dto.Proxy.ProxyAdapter;
import map.project.slots.Model.Provider;
import map.project.slots.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.ArrayList;
import java.util.List;

@ShellComponent
public class ProviderUI {
    @Autowired
    private ProviderService providerService;

    private final ProxyAdapter proxyAdapter = ProxyAdapter.getInstance();

    @ShellMethod(key = "providers")
    public String findAllProviders() {
        List<ProviderDto> providerDtoList = new ArrayList<>();
        for (Provider provider : this.providerService.findAllProviders()) {
            providerDtoList.add((ProviderDto) proxyAdapter.adapt(provider));
        }
        return providerDtoList.toString();
    }

    @ShellMethod(key = "find provider")
    public String findProviderById(@ShellOption(value = {"provider id"}, help = "id of the provider") Long providerId) {
        try {
            return proxyAdapter.adapt(this.providerService.findProviderById(providerId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "delete provider")
    public String deleteProviderById(@ShellOption(value = {"provider id"}, help = "id of the provder") Long providerId) {
        try {
            return proxyAdapter.adapt(this.providerService.deleteProviderById(providerId)).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @ShellMethod(key = "add provider")
    public String addProvider(@ShellOption(value = {"name"}, help = "name of the provider") String name) {
        Provider provider = new Provider();
        provider.setName(name);
        return proxyAdapter.adapt(this.providerService.addProvider(provider)).toString();
    }

    @ShellMethod(key = "update provider")
    public String updateProvider(@ShellOption(value = {"provider id"}, help = "id of the provider") Long providerId,
                                 @ShellOption(value = {"name"}, help = "name of the provider") String name) {
        try {
            Provider provider = new Provider();
            provider.setProviderId(providerId);
            provider.setName(name);
            return  proxyAdapter.adapt(this.providerService.updateProvider(provider)).toString();
        }
        catch (Exception e){
            return e.getMessage();
        }
    }
}
