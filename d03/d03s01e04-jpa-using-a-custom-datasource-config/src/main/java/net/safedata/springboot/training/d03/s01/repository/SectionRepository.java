package net.safedata.springboot.training.d03.s01.repository;

import net.safedata.spring.training.jpa.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Integer> {
}
