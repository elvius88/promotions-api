package py.com.jaha.api.promotions.commons;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import py.com.jaha.api.promotions.config.CustomPageable;
import py.com.jaha.api.promotions.infraestructure.adapters.in.promotions.OffersResource;
import py.com.jaha.api.promotions.infraestructure.adapters.in.promotions.PromotionsResource;

@Component
public class PageableComponent {

    @CustomPageable(OffersResource.class)
    public <T> ApiPageableResponse<T> pageableOffersResource(Page<T> page) {
        return pageableResource(page);
    }

    @CustomPageable(PromotionsResource.class)
    public <T> ApiPageableResponse<T> pageablePromotionsResource(Page<T> page) {
        return pageableResource(page);
    }

    public <T> ApiPageableResponse<T> pageableResource(Page<T> page) {
        var pagination = new CustomPagination();
        pagination.setPage(page.getNumber());
        pagination.setPageSize(page.getSize());
        pagination.setTotalElements(page.getTotalElements());
        pagination.setTotalPages(page.getTotalPages());
        var response = ApiPageableResponse.of(page.getContent());
        response.setPagination(pagination);
        return ApiPageableResponse.of(page.getContent());
    }
}
