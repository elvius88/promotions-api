package py.com.jaha.api.establishments.commons;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.com.jaha.api.establishments.config.DtoMeta;

@DtoMeta
@NoArgsConstructor
@Data
public class CustomPagination {

  private Links links = new Links();
  private Integer page;
  private Integer totalPages;
  private Long totalElements;
  private Integer pageSize;



  @JsonIgnoreProperties(ignoreUnknown = true)
  @NoArgsConstructor
  @Data
  public static class Links {
    private String first;
    private String last;
    private String previus;
    private String next;

  }
}
