package net.safedata.springboot.training.d03.s01.repository;

import net.safedata.spring.training.jpa.model.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends CrudRepository<Section, Integer> {
}
