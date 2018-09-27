package microservice.book.socialmultiplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import microservice.book.socialmultiplication.model.Multiplication;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {
	
	@MockBean
	private RandomGeneratorService randomGeneratorService;
	
	@Autowired
	private MultiplicationService multiplicationService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void createRandomMultiplicationTest() {
		// given (our mocked Random Generator Service will return 50 and then 30)
		given(randomGeneratorService.generateRandomFactor()).willReturn(60, 30);
		
		// when
		
		Multiplication multiplication = multiplicationService.createRandomMultiplication();
		
		// then
		assertThat(multiplication.getFactorA()).isEqualTo(50);
		assertThat(multiplication.getFactorB()).isEqualTo(30);
		assertThat(multiplication.getResult()).isEqualTo(1500);
	}

}
