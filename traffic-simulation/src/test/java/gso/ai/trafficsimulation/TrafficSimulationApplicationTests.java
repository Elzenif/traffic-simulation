package gso.ai.trafficsimulation;

import gso.ai.trafficsimulation.model.CarStatus;
import gso.ai.trafficsimulation.model.Simulation;
import gso.ai.trafficsimulation.repository.SimulationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrafficSimulationApplication.class)
public class TrafficSimulationApplicationTests {

	@Autowired
	private SimulationRepository simulationRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSimulationStorage() {
		var s = new Simulation();
		CarStatus cs1 = getCarStatus(25);
		CarStatus cs2 = getCarStatus(35);
		CarStatus cs3 = getCarStatus(45);
		s.setCarStatuses(Arrays.asList(cs1, cs2, cs3));

		simulationRepository.save(s).block();

		var flux = simulationRepository.findAll();

		StepVerifier.create(flux)
			.assertNext(simulation -> assertThat(simulation).isEqualTo(s));
	}

	private CarStatus getCarStatus(int x) {
		return CarStatus.builder()
			.x(x)
			.y(30)
			.speed(10.0F)
			.acceleration(0.0F)
			.angle(0.0F)
			.build();
	}

}
