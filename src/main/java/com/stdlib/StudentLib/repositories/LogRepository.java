package com.stdlib.StudentLib.repositories;

import com.stdlib.StudentLib.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    Log findTopByUidOrderByIdDesc(String uid); // Custom finder method
    List<Log> findAllByOrderByIdDesc();
}
