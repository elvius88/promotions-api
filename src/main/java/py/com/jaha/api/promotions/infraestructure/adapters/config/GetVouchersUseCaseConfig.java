package py.com.jaha.api.establishments.infraestructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import py.com.jaha.api.establishments.domain.ports.in.GetVoucherPort;
import py.com.jaha.api.establishments.domain.ports.in.GetVouchersPort;
import py.com.jaha.api.establishments.domain.ports.out.VouchersRepositoryPort;
import py.com.jaha.api.establishments.domain.usecases.promotions.GetVoucherUseCase;
import py.com.jaha.api.establishments.domain.usecases.promotions.GetVouchersUseCase;

@Configuration
public class GetVouchersUseCaseConfig {

    @Bean
    public GetVouchersPort getVouchersUseCase(VouchersRepositoryPort vouchersRepositoryPort){
        return new GetVouchersUseCase(vouchersRepositoryPort);
    }

    @Bean
    public GetVoucherPort getVoucherUseCase(VouchersRepositoryPort vouchersRepositoryPort){
        return new GetVoucherUseCase(vouchersRepositoryPort);
    }
}
