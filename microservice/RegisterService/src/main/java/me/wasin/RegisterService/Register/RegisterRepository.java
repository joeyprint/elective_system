package me.wasin.RegisterService.Register;

import me.wasin.RegisterService.Elective.Elective;
import me.wasin.RegisterService.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {

    List<Register> findByStudentId(int id);
    List<Register> findByElectiveId(int id);

}
