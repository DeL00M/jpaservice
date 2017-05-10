package ru.deloom.jpaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.deloom.jpaservice.entities.PageRankId;
import ru.deloom.jpaservice.entities.PersonPageRank;

public interface PersonPageRankRepository extends JpaRepository<PersonPageRank, PageRankId>{
	List<PersonPageRank> findByPersonId(Integer personId);
	List<PersonPageRank> findByPageId(Integer pageId);
}
