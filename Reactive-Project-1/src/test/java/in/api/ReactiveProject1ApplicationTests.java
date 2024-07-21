package in.api;

import java.time.Duration;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

@SpringBootTest
class ReactiveProject1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void workingWithMono() throws InterruptedException {
		
		// Mono -> publisher that have 0 or 1 items
		//Created Mono (publisher)
		
//		Mono<String> errorMono = Mono.error(new RuntimeException("Error !!"));
//		
//		Mono<String> m1 = Mono.just("Learn code with Siddhesh")
//							  .log()
//							  .then(errorMono)
//							  .log();
//		
//		
//		
//		//consume the Mono by Subscribing 
//		m1.subscribe(data -> 
//						{System.out.println("data is : "+data);
//						
//		});
		
//		errorMono.subscribe(error -> 
//						{System.out.println(error);
//		});
//-----------------------------------------------------------------------------------------------------------------
		
		Mono<String> m1 = Mono.just("Siddhesh is new joinee");
		Mono<String> m2 = Mono.just("Kamale");
		Mono<Integer> m3 = Mono.just(5555);
		
		Mono<Tuple3<String,String,Integer>> combinedMono = Mono.zip(m1,m2,m3);
		
//		combinedMono.subscribe(data -> {
//			
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//			System.out.println(data.getT3());
////			System.out.println(data);
//		});
//		
//		Mono<Tuple2<String,String>> zipWithMono = m1.zipWith(m2);
//		
//		System.out.println("------------------------------------------------------------------");
//		zipWithMono.subscribe(data -> {
//			
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//			
//		});
		
		
// ------------------------- Map Function (used For transformation of data in Mono)------------------------------------------------------------------
		
//		Function<String,String> f = str -> str.toUpperCase();
//		Mono<String> resultMapMono = m1.map(data -> f.apply(data));
		
	
//		Mono<String> resultMapMono = m1.map(value -> value.toUpperCase());
		// You can also used Method reference here 
//		Mono<String> resultMapMono = m1.map(String::toUpperCase);
		
//		resultMapMono.subscribe(System.out :: println);
		
		
//		Mono<String[]> resultFlatMapMono = m1.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
		
//		resultFlatMapMono.subscribe(data -> {
//			for (String str : data) {
//				System.out.print(str + ",");
//			}
//		});
		
//		System.out.println();
//		System.out.println("------------ FlatMapMany----------------------");
//		Flux<String> stringFlux = m1.flatMapMany(value -> Flux.just(value.split(" "))).log();
//		
//		stringFlux.subscribe(data ->
//				System.out.println(data)
//		);
		
// ---------------------------- concatWith --------------------------------------------------------
		
//		System.out.println(Thread.currentThread().getName());
//		
//		Flux<String> concatFLux = m1.concatWith(m2).log().delayElements(Duration.ofMillis(2000));
//		
//		
//		concatFLux.subscribe(data ->{
//			System.out.println(Thread.currentThread().getName());
//			System.out.println(data);
//			
//		});
//		
//		
//		Thread.sleep(4000);
//		System.out.println(Thread.currentThread().getName());
//		System.out.println("Terminated Main Thread");
		
	}

}
