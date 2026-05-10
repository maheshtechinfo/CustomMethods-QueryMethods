package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.nt.BootJpaP08CustomMethodsQueryMethodsApplication;
import com.nt.entity.Actor;
import com.nt.repository.IActorRepository;

@Component
public class CustomQueryMethodTestRunner implements CommandLineRunner {

    private final BootJpaP08CustomMethodsQueryMethodsApplication bootJpaP08CustomMethodsQueryMethodsApplication;

	@Autowired
	private IActorRepository actorRepo;

    CustomQueryMethodTestRunner(BootJpaP08CustomMethodsQueryMethodsApplication bootJpaP08CustomMethodsQueryMethodsApplication) {
        this.bootJpaP08CustomMethodsQueryMethodsApplication = bootJpaP08CustomMethodsQueryMethodsApplication;
    }

	@Override
	public void run(String... args) throws Exception {

		/*		List<Actor> list = actorRepo.showAllActors();
				list.forEach(System.out::println);*/

		/*		List<Actor> list = actorRepo.showAllActorsByCategory("Comedian", "Heroine");
				list.forEach(actor->System.out.println(actor));*/

		/*System.out.println("Bulk Entity Query");
		actorRepo.showActorsByFee(5000.0, 8000.0).forEach(System.out::println);
		
		System.out.println("*******************************");
		System.out.println("Bulk Scalar Query(multiple column)");
		actorRepo.showActorsDataByCategory("Director", "Heroine").forEach(row -> {
			for (Object obj : row) {
				System.out.print(obj+" ");
		
			}
			System.out.println();
		});
		
		System.out.println("*******************************");
		System.out.println("Bulk Scalar Query(only 1 column) ");
		actorRepo.showActorsNameByAddress("Ranchi").forEach(System.out::println);*/

		
		// single row entity query
		/*	Actor actor = actorRepo.showActorDetailsByName("Mahesh1");
			if (actor == null)
				System.out.println("Record not found");
			else
				System.out.println("Actor Details: " + actor);
		
			// single row Scalar Query(specific multiple columns values)
			Object data = actorRepo.showActorDataByName("Mahesh1");
			if (data == null)
				System.out.println("Record not available");
			else {
				Object row[] = (Object[]) data;
				System.out.println("Actor Data:" + Arrays.toString(row));
			}
		
			// single Row Scalar Query (Specific single col values)
			Double fee = actorRepo.showActorFeeByName("Mahesh1");
			if (fee == null)
				System.out.println("Record not found");
			else
				System.out.println("Fee: " + fee);*/
		
		/*		long count = actorRepo.showUniqueActorsCount();
				System.out.println("Unique Actor Count: "+count);*/
		
		/*		Object data = actorRepo.showActorAggregateData();
				Object row[] = (Object[])data;
				System.out.println("Records count: "+row[0]);
				System.out.println("Max fee: "+row[1]);
				System.out.println("Min count: "+row[2]);
				System.out.println("Sum of All Fees: "+row[3]);
				System.out.println("Avg of All Fees: "+row[4]);*/
		
		/*		int count = actorRepo.updateActorsFeeByCategory("Director", "Comedian", 10.0);
				System.out.println("Modified Actors Count: "+count);*/
		
		/*	int count = actorRepo.removeActorsByFeeRange(8000.0, 10000.0);
			System.out.println(count+" no. of Actors found and deleted");*/
		
		System.out.println("System Date and Time is: "+actorRepo.showSystemDateAndTime());
		
	}

}
