package gso.ai.trafficsimulation.repository;

import gso.ai.trafficsimulation.model.Simulation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SimulationRepository extends ReactiveMongoRepository<Simulation, ObjectId> {

}
