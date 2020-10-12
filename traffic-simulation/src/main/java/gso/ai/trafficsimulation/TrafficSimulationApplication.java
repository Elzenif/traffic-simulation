package gso.ai.trafficsimulation;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class TrafficSimulationApplication
extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(TrafficSimulationApplication.class, args);
	}

	@Override
	protected String getDatabaseName() {
		return "simulation";
	}

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create();
	}
}
