package map.project.slots.Service;

import jakarta.transaction.Transactional;
import map.project.slots.Model.Exceptions.ProviderException;
import map.project.slots.Model.Provider;
import map.project.slots.Repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> findAllProviders() {
        return this.providerRepository.findAll();
    }

    public Provider findProviderById(Long providerId) throws ProviderException {
        Optional<Provider> provider = this.providerRepository.findByProviderId(providerId);
        if (provider.isEmpty()) {
            throw new ProviderException();
        }
        return provider.get();
    }
    @Transactional
    public Provider deleteProviderById(Long providerId) throws ProviderException {
        Optional<Provider> provider = this.providerRepository.findByProviderId(providerId);
        if (provider.isEmpty()) {
            throw new ProviderException();
        }

        this.providerRepository.deleteByProviderId(providerId);
        return provider.get();
    }

    public Provider addProvider(Provider provider) {
        this.providerRepository.save(provider);
        return provider;
    }

    public Provider updateProvider(Provider provider) throws ProviderException {
        Optional<Provider> optionalProvider = this.providerRepository.findByProviderId(provider.getProviderId());
        if (optionalProvider.isEmpty()) {
            throw new ProviderException();
        }
        this.providerRepository.save(provider);
        return provider;
    }
}
