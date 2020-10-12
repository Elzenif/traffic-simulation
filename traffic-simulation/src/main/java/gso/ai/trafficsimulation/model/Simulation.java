package gso.ai.trafficsimulation.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Simulation {

    @Id
    private ObjectId id;

    private List<CarStatus> carStatuses;

}
