package com.neosave.userservice.userservice.external.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PinCodeResponseEntity {

  @JsonProperty("Message")
  private String message;

  @JsonProperty("Status")
  private String status;

  @JsonProperty("PostOffice")
  private List<PostOfficeEntity> postOfficeEntityList;

}
