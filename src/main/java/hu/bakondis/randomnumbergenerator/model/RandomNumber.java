package hu.bakondis.randomnumbergenerator.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

/**
 * RandomNumber
 */
@Validated
public class RandomNumber   {
  @JsonProperty("minNumber")
  private Long minNumber = null;

  @JsonProperty("maxNumber")
  private Long maxNumber = null;

  @JsonProperty("randomNumber")
  private Integer randomNumber = null;

  public RandomNumber minNumber(Long minNumber) {
    this.minNumber = minNumber;
    return this;
  }

  /**
   * Get minNumber
   * @return minNumber
   **/
  @Schema(example = "10", description = "")
  
    public Long getMinNumber() {
    return minNumber;
  }

  public void setMinNumber(Long minNumber) {
    this.minNumber = minNumber;
  }

  public RandomNumber maxNumber(Long maxNumber) {
    this.maxNumber = maxNumber;
    return this;
  }

  /**
   * Get maxNumber
   * @return maxNumber
   **/
  @Schema(example = "198772", description = "")
  
    public Long getMaxNumber() {
    return maxNumber;
  }

  public void setMaxNumber(Long maxNumber) {
    this.maxNumber = maxNumber;
  }

  public RandomNumber randomNumber(Integer randomNumber) {
    this.randomNumber = randomNumber;
    return this;
  }

  /**
   * Get randomNumber
   * @return randomNumber
   **/
  @Schema(example = "7", description = "")
  
    public Integer getRandomNumber() {
    return randomNumber;
  }

  public void setRandomNumber(Integer randomNumber) {
    this.randomNumber = randomNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RandomNumber randomNumber = (RandomNumber) o;
    return Objects.equals(this.minNumber, randomNumber.minNumber) &&
        Objects.equals(this.maxNumber, randomNumber.maxNumber) &&
        Objects.equals(this.randomNumber, randomNumber.randomNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(minNumber, maxNumber, randomNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RandomNumber {\n");
    
    sb.append("    minNumber: ").append(toIndentedString(minNumber)).append("\n");
    sb.append("    maxNumber: ").append(toIndentedString(maxNumber)).append("\n");
    sb.append("    randomNumber: ").append(toIndentedString(randomNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
