package me.wasin.SubjectService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Subject findById(int id);
    List<Subject> findBySubjectId(String id);
    Subject findBySubjectName(String name);

}
