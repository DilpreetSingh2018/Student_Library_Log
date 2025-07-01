package com.stdlib.StudentLib.repositories;

import com.stdlib.StudentLib.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
