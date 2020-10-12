package gso.ai.trafficsimulation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarStatus {

    private Integer x;
    private Integer y;

    private Float speed;
    private Float acceleration;
    private Float angle;
}
