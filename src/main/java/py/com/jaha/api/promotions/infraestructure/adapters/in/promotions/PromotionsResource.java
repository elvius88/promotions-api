package py.com.jaha.api.promotions.infraestructure.adapters.in.promotions;

import static py.com.jaha.api.promotions.commons.ApiVersions.API_VERSION_V1;
import static py.com.jaha.api.promotions.constants.GlobalConstants.API_BASE;
import static py.com.jaha.api.promotions.domain.usecases.utils.LogUtil.buildErrorCommon;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.vavr.control.Try;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import py.com.jaha.api.promotions.commons.ApiPageableResponse;
import py.com.jaha.api.promotions.commons.ApiResponse;
import py.com.jaha.api.promotions.commons.Filterable;
import py.com.jaha.api.promotions.commons.PageableComponent;
import py.com.jaha.api.promotions.config.exception.ApiError;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionPageableResponse;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionResponse;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsResponse;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionPort;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionsPageablePort;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionsPort;
import py.com.jaha.api.promotions.infraestructure.adapters.mappers.PromotionsCommandMapper;

@RestController
@RequestMapping(value = "/" + API_BASE + "/promotions/" + API_VERSION_V1)
@Tag(name = "PromotionsResource")
@RequiredArgsConstructor
@Slf4j
public class PromotionsResource {

    private final GetPromotionPort getPromotionUseCase;
    private final GetPromotionsPort getPromotionsUseCase;
    private final GetPromotionsPageablePort getPromotionsPageableUseCase;
    private final PageableComponent pageableComponent;

    @Operation(summary = "Promotion", description = "Get promotion data by ID")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetPromotionResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @Filterable
    @GetMapping("/promotions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetPromotionResponse> getPromotion(@PathVariable String id) {
        return ApiResponse.of(getPromotionUseCase.execute(PromotionsCommandMapper.INSTANCE.toCommand(id, null, null, null, null, null, null)));
    }

    @Operation(summary = "Promotions", description = "Get promotions data by parameters filters")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetPromotionsResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @Filterable
    @GetMapping("/promotions")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<GetPromotionsResponse> getPromotions(@RequestParam(required = false) String name,
                                                            @RequestParam(required = false) String description,
                                                            @RequestParam(required = false) LocalDate startDate,
                                                            @RequestParam(required = false) LocalDate endDate,
                                                            @RequestParam(required = false) String establishmentId) {
        return ApiResponse.of(
            getPromotionsUseCase.execute(PromotionsCommandMapper.INSTANCE.toCommand(null, name, description, startDate, endDate, establishmentId, null)));
    }

    @Operation(summary = "Pageable Promotions", description = "Get pageable promotions data by parameters filters")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Ok", content = @Content(mediaType = "application/json", schema = @Schema(implementation = GetPromotionPageableResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ApiError.class))) })
    @Filterable
    @GetMapping("/promotions-search")
    @ResponseStatus(HttpStatus.OK)
    public ApiPageableResponse<GetPromotionPageableResponse> getOffersBy(@RequestParam(required = false) String name,
                                                                      @RequestParam(required = false) String description,
                                                                      @RequestParam(required = false) LocalDate startDate,
                                                                      @RequestParam(required = false) LocalDate endDate,
                                                                      @RequestParam(required = false) String establishmentId,
                                                                      @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                      @RequestParam(name = "page_size", defaultValue = "10") Integer pageSize) {
        return Try.of(() -> getPromotionsPageableUseCase.execute(
                PromotionsCommandMapper.INSTANCE.toCommand(null, name, description, startDate, endDate, establishmentId, PageRequest.of(page, pageSize))))
            .map(pageableComponent::pageablePromotionsResource)
            .getOrElseThrow(ex -> buildErrorCommon(log, ex));
    }
}
