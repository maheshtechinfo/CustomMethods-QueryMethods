package com.nt.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
	//@Query("FROM Actor") //or
	//@Query("FROM Actor act") //or
	//@Query("FROM Actor as act") 
	//@Query("SELECT * FROM Actor") //Error
	@Query("SELECT act FROM Actor as act") 
	public List<Actor> showAllActors();
	
	
	/*	@Query("from Actor where category in(?1,?2)order by category desc") //ordinal positional params
		public List<Actor> showAllActorsByCategory(String category1,String category2);*/
	
	//or with named parameters
	/*	@Query("from Actor where category in(:category1,:category2)order by category desc")
		public List<Actor> showAllActorsByCategory(String category1,String category2);*/
	
	//or (if property name is different then use @Param to match with named Parameters)
	/*@Query("from Actor where category in(:cat1,:cat2)order by category desc")
	public List<Actor> showAllActorsByCategory(@Param("cat1") String category1,
			                                   @Param("cat2") String category2);
	*/
	//or combination with ordinal positional params and named Parameters 
	/*	@Query("from Actor where category in(?1,:category2)order by category desc")
			public List<Actor> showAllActorsByCategory(String category1,
					                                   String category2);*/
	
	//error/invalid if we write named params first followed by ordinary positional params
	/*	@Query("from Actor where category in(:category1,?2)order by category desc")
		public List<Actor> showAllActorsByCategory(String category1,
				                                   String category2);*/
	
	
	//Bulk entity query
	@Query("from Actor where fee>=:startRange and fee<=:endRange order by fee desc")
	public List<Actor> showActorsByFee(double startRange, double endRange);
	
	
	//Bulk scalar / pojection query selecting specific multiple columns values
	@Query("Select id, name, address from Actor where category in(:category1,:category2)")
	public List<Object[]> showActorsDataByCategory(String category1, String category2);
	
	
	//Bulk scalar / projection query giving single column value
	@Query("Select name from Actor where address=:add")
	public List<String> showActorsNameByAddress(String add);
	
	
	
	//Single Row Entity Query
	@Query("from Actor where name=:name")
	public Actor showActorDetailsByName(String name);
	
	//Single Row Scalar Query (Specific multiple col values)
	@Query("select id,name,fee from Actor where name=:name")
	public Object showActorDataByName(String name);
	
	//Single Row Scalar Query (Specific single col values)
	@Query("select fee from Actor where name =:name")
	public Double showActorFeeByName(String name);
	
	
	
	//aggregate operation
	@Query("select distinct count(name) from Actor")
	public long showUniqueActorsCount();
	
	@Query("select count(*), max(fee), min(fee), sum(fee), avg(fee) from Actor")
	public Object showActorAggregateData();
	
	//=================Non select operation===================
	
	@Query("update Actor set fee = fee+(fee*:hikePercentage/100.0) where category in(:category1,:category2)")
	@Modifying
	@Transactional
	public int updateActorsFeeByCategory(String category1,String category2,double hikePercentage);


	@Query("delete from Actor where fee>=:startRange and fee<=:endRange")
	@Modifying
	@Transactional
	public int removeActorsByFeeRange(double startRange, double endRange);
	
	//=========Native Sql Queries================
	
	@Query(value="SELECT now() from dual", nativeQuery=true)
	public LocalDateTime showSystemDateAndTime();
}
