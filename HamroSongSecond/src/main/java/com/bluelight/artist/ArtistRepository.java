package com.bluelight.artist;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface ArtistRepository extends CrudRepository<Artist,String>, PagingAndSortingRepository<Artist, String> {
	
	 Page<Artist> findAll(Pageable pageable);
	
	 @Query(value="(SELECT * FROM `artist` where LEFT(name,1) IN ('0','1','2','3','4','5','6','7','8','9') order by name)", nativeQuery = true)
	 public List<Artist> GetZeroToNine();
	 
	 @Query(value="(SELECT *  FROM `artist` where name like 'A%' or name like 'B%' or name like 'C%' or name like 'D%' or name like 'E%'or name like 'F%'or name like 'G%'  order by name)", nativeQuery = true)
	 public List<Artist> GetAToG();
	 
	 @Query(value="(SELECT * FROM `artist` where name like 'H%' or name like 'I%' or name like 'J%' or name like 'K%' or name like 'L%'or name like 'M%'or name like 'N%'  order by name)", nativeQuery = true)
	 public List<Artist> GetHToN();
	 
	 @Query(value="(SELECT *  FROM `artist` where name like 'O%' or name like 'P%' or name like 'Q%' or name like 'R%' or name like 'S%'or name like 'T%'or name like 'U%'  order by name)", nativeQuery = true)
	 public List<Artist> GetOToU();
	 
	 @Query(value="(SELECT *   FROM `artist` where name like 'V%' or name like 'W%' or name like 'X%' or name like 'Y%' or name like 'Z%'  order by name)", nativeQuery = true)
	 public List<Artist> GetVToZ();
}
