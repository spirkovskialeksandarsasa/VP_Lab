package mk.ukim.finki.wp.lab.service.impl;

import lombok.Builder;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.repository.jpa.JpaGradeRepository;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {
    private final JpaGradeRepository gradeRepository;

    public GradeServiceImpl(JpaGradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<Grade> findByCourseId(Long courseId){
        return gradeRepository.findAllByCourseCourseId(courseId);
    }

    @Override
   public Grade findByCourseIdAndStudentUsername(Long courseId, String username){
        return gradeRepository.findByCourseCourseIdAndStudentUsername(courseId, username);
    }

    @Override
    public void save(Grade g){
        gradeRepository.save(g);
    }

    @Override
    public void deleteAll(Iterable<Grade> grades){
        gradeRepository.deleteAll(grades);
    }

    public List<Grade> listAll(){
        return gradeRepository.findAll();
    }
}
