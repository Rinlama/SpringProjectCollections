package com.bluelight.artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface ArtistRepository extends CrudRepository<Artist,String>, PagingAndSortingRepository<Artist, String> {
	 Page<Artist> findAll(Pageable pageable);
}
