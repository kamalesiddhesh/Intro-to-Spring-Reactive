package in.api.service;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class FluxLearnService {
	
	// all operators example goes here
	
	// Creating Flux
	
	public Flux<String> getFlux(){
		
		Flux<String> nameFlux = Flux.just("Ankit","Siddhesh","Darshan","Ravi");
		return nameFlux;
		
	}
	
	public Flux<String> fruitsFlux(){
		List<String> fruitsNames = List.of("Mango","Apple","Grapes","Berry");
		return Flux.fromIterable(fruitsNames);
	}
	
	public Flux<Void> getBlankFlux(){
		
		return Flux.empty();
	}
	
	//map
	
	public Flux<String> mapExample(){
		Flux<String> capFlux = getFlux().map(name->name.toUpperCase());
		return capFlux;
	}
	
	//filter
	
	public Flux<String> filterExampleFlux(){
		return getFlux().filter(name->name.length()>4);
	}
	
	//flatMap
	
	public Flux<String> flatMapFlux(){
//		return getFlux().flatMap(name->Flux.just(name.split("")));
		
//		return getFlux().flatMap(name -> Flux.just("Test Flux")).delayElements(Duration.ofSeconds(2)).log();
		
		return getFlux().flatMap(name -> Flux.just(name.split(""))).delayElements(Duration.ofSeconds(2)).log();
	}
	
	
	//flatMapMany
	public Flux<String> flatMapManyFlux(){
		
		return Mono.just("Siddhesh").flatMapMany(value->Flux.just(value.split("")));
		
	}
	
	// transform example	
	
	
	public Flux transformExample() {
		Function<Flux<String>,Flux<String>> funInterface = (name) -> name.map(String :: toUpperCase);
		return getFlux().transform(funInterface).log();
				
	}
	
	// defaultIfEmpty
	// switchIfEmpty
	public Flux<String> ifExample(int length){
		return getFlux().filter(name -> name.length() > length)
//						.defaultIfEmpty("Not Found")
						.switchIfEmpty(fruitsFlux())
						.log();
	}
	
	// concat(static) / concatWith(instance)
	
	public Flux<String> concatExample(){
		return Flux.concat(getFlux().delayElements(Duration.ofSeconds(1)),fruitsFlux().delayElements(Duration.ofSeconds(2)));
		
//		return getFlux().concatWith(fruitsFlux());
	}
	
	// merge / mergeWith
	
	public Flux<String> mergeExample(){
//		return Flux.merge(getFlux().delayElements(Duration.ofSeconds(1)),fruitsFlux().delayElements(Duration.ofSeconds(2)));
		
		return getFlux().delayElements(Duration.ofSeconds(1)).mergeWith(fruitsFlux().delayElements(Duration.ofSeconds(2)));
	}
	
	// zip and zipWith
	public Flux<String> zipExample(){
//		return Flux.zip(getFlux(),Flux.just(1,2,3));
		
		return Flux.zip(getFlux(),Flux.just(1,2,3,4),(first,second)->{
			return first +" : "+ second;
		});
	}
	
//  
	public Flux<String> sideEffectFlux(){
//		return getFlux().doOnNext(data -> {
//			System.out.println(data + " on Next");
//		});
		
		return getFlux().doOnNext(data -> {
			System.out.println(data + " on Next");
		}).doOnSubscribe(data->{
			System.out.println(data + "on subscribe");
		}).doOnEach(data->{
			System.out.println(data + "on each");
		}).doOnComplete(() ->{
			System.out.println("completed");
		});
		
	}

}
