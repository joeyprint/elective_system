package me.wasin.ElectiveService.Elective;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectiveRepository extends JpaRepository<Elective, Integer> {

    Elective findById(int id);

}
