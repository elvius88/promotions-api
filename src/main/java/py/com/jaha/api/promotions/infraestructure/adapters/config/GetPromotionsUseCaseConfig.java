package py.com.jaha.api.promotions.infraestructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionsPageablePort;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionPort;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionsPort;
import py.com.jaha.api.promotions.domain.ports.out.PromotionsRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.promotions.GetPromotionsPageableUseCase;
import py.com.jaha.api.promotions.domain.usecases.promotions.GetPromotionUseCase;
import py.com.jaha.api.promotions.domain.usecases.promotions.GetPromotionsUseCase;

@Configuration
public class GetPromotionsUseCaseConfig {

    @Bean
    public GetPromotionsPort getPromotionsUseCase(PromotionsRepositoryPort promotionsRepositoryPort){
        return new GetPromotionsUseCase(promotionsRepositoryPort);
    }

    @Bean
    public GetPromotionPort getPromotionUseCase(PromotionsRepositoryPort promotionsRepositoryPort){
        return new GetPromotionUseCase(promotionsRepositoryPort);
    }

    @Bean
    public GetPromotionsPageablePort getPageablePromotionsUseCase(PromotionsRepositoryPort promotionsRepositoryPort){
        return new GetPromotionsPageableUseCase(promotionsRepositoryPort);
    }
}
