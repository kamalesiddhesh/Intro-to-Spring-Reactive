package in.api.flux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.api.service.FluxLearnService;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@SpringBootTest
public class FluxLearnTest {
	
	@Autowired
	private FluxLearnService fluxLearnService;
	
	
	// Consuming Flux 
	@Test
	public void simpleFluxTest() {
//		 fluxLearnService.getFlux().subscribe(data ->{
//			 System.out.println(data);
//			 System.out.println("done with flux data");
//		 });
		
//		fluxLearnService.fruitsFlux().subscribe(data->{			
//			 System.out.println(data);
//		});
		
//		fluxLearnService.getBlankFlux().subscribe(
//				data -> System.out.println("Received data: " + data),
//	            error -> System.err.println("Error: " + error),
//	            () -> System.out.println("Completed!")
//		);
	}

	@Test
	public void mapTest() {
		
//		fluxLearnService.mapExample().subscribe(data -> {
//			System.out.println(data);
//		});
		
		Flux<String> capFlux = fluxLearnService.mapExample();
		
		
//		StepVerifier.create(capFlux)
//					.expectNext("Ankit".toUpperCase(),"Siddhesh".toUpperCase(),"Darshan".toUpperCase(),"Ravi".toUpperCase())
//					.verifyComplete();
		
	}
	
	@Test
	public void filterExampleFlux() {
		
//		Flux<String> filterFlux = fluxLearnService.filterExampleFlux().log();
//		
//		StepVerifier.create(filterFlux)
//					.expectNextCount(3)
//					.verifyComplete();
		
	}
	
	@Test
	public void flatMapExample() {
//		Flux<String> stringFlux = fluxLearnService.flatMapFlux();
//		StepVerifier.create(stringFlux)
//					.expectNextCount(24)
//					.verifyComplete();
	}
	
	@Test
	public void flatMapManyExample() {
//		StepVerifier.create(fluxLearnService.flatMapManyFlux().log())
//					.expectNextCount(8)
//					.verifyComplete();
	}
	
	@Test
	public void transformExample() {
//		Flux<String> tranformFlux = fluxLearnService.transformExample();
//		StepVerifier.create(tranformFlux)
//					.expectNextCount(4)
//					.verifyComplete();
	}
	
	@Test
	public void ifExampleTest() {
//		Flux<String> stringFlux = fluxLearnService.ifExample(4);
//		StepVerifier.create(stringFlux)
//					.expectNextCount(3)
//					.verifyComplete();
	}
	
	@Test
	public void concatExample() {
		
//		Flux<String> strFlux = fluxLearnService.concatExample().log();
//		StepVerifier.create(strFlux)
//					.expectNextCount(8)
//					.verifyComplete();
	}
	
	@Test
	public void mergeExample() {
//		Flux<String> log = fluxLearnService.mergeExample().log();
//		StepVerifier.create(log)
//					.expectNextCount(8)
//					.verifyComplete();				
	}
	@Test
	public void zipExample() {
//		Flux<String> tuple2Flux = 
//							fluxLearnService.zipExample().log();
//		
//		StepVerifier.create(tuple2Flux)
//					.expectNextCount(4)
//					.verifyComplete();
	}
	
	@Test
	public void sideEffectFlux() {
		/* Flux<String> sideEffecFlux = */ 
//		fluxLearnService.sideEffectFlux().log().subscribe(data ->{
//			System.out.println(data);
//		});
	}
	
	

}
