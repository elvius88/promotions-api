package py.com.jaha.api.promotions.infraestructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.jaha.api.promotions.domain.ports.in.offers.GetOffersPageablePort;
import py.com.jaha.api.promotions.domain.ports.in.offers.GetOfferPort;
import py.com.jaha.api.promotions.domain.ports.in.offers.GetOffersPort;
import py.com.jaha.api.promotions.domain.ports.out.OffersRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.offers.GetOffersPageableUseCase;
import py.com.jaha.api.promotions.domain.usecases.offers.GetOfferUseCase;
import py.com.jaha.api.promotions.domain.usecases.offers.GetOffersUseCase;

@Configuration
public class GetOffersUseCaseConfig {

    @Bean
    public GetOffersPort getOffersUseCase(OffersRepositoryPort promotionsRepositoryPort){
        return new GetOffersUseCase(promotionsRepositoryPort);
    }

    @Bean
    public GetOfferPort getOfferUseCase(OffersRepositoryPort promotionsRepositoryPort){
        return new GetOfferUseCase(promotionsRepositoryPort);
    }

    @Bean
    public GetOffersPageablePort getOffersPageableUseCase(OffersRepositoryPort promotionsRepositoryPort){
        return new GetOffersPageableUseCase(promotionsRepositoryPort);
    }
}
