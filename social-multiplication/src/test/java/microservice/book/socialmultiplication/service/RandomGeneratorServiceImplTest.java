package microservice.book.socialmultiplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class RandomGeneratorServiceImplTest {

	private RandomGeneratorService randomGeneratorService;
	@Before
	public void setUp() throws Exception {
		randomGeneratorService = new RandomGeneratorServiceImpl();
	}

	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() throws Exception {
		// when a good sample of randomly generated factors is generated 
		List<Integer> randomFactors = IntStream.range(0, 1000)
											   .map(i -> randomGeneratorService.generateRandomFactor())
											   .boxed().collect(Collectors.toList());
		
		// All of them shoud be between 11 and 100
		assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11, 100).boxed().collect(Collectors.toList()));
		
	}

}
