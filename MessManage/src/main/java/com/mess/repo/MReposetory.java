package com.mess.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mess.model.MModel;

@Repository
public interface MReposetory extends JpaRepository<MModel, String> {
	
	@Query(value  = "SELECT * FROM messdb.mess_data where create_at BETWEEN :fromDate AND :toDate ORDER BY inv_name", nativeQuery=true)
	public List<MModel> getByDate(@Param("fromDate") String fromDate ,@Param("toDate") String toDate);	
	
	@Query(value  = "SELECT * FROM messdb.mess_data where create_at BETWEEN :fromDate AND :toDate and inv_name = :name", nativeQuery=true)
	public List<MModel> getByDate(@Param("fromDate") String fromDate ,@Param("toDate") String toDate, @Param("name") String name);	

}
