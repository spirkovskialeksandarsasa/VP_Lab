package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface JpaGradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findAllByCourseCourseId(Long courseId);

    Grade findByCourseCourseIdAndStudentUsername(Long courseId, String username);

    List<Grade> findAllByTimestampBetween(LocalDateTime start, LocalDateTime end);

}
