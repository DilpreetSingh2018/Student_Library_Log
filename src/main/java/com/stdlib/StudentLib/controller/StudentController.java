package com.stdlib.StudentLib.controller;

import com.stdlib.StudentLib.model.Log;
import com.stdlib.StudentLib.model.Student;
import com.stdlib.StudentLib.repositories.LogRepository;
import com.stdlib.StudentLib.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private LogRepository logRepo;

    @PostMapping("/student/check")
    public String checkStudent(@RequestParam String uid, Model model) {
        Student student = studentRepo.findById(uid).orElse(null);
        if (student == null) {
//            model.addAttribute("error", "Student not found");
//            model.addAttribute("showAddStudentLink", true);
            model.addAttribute("studentNotFound", true);
            return "student";
        }

        Log lastLog = logRepo.findTopByUidOrderByIdDesc(uid);
        boolean isInLibrary = (lastLog != null && lastLog.getExitTime() == null);

        if (isInLibrary) {
            // ✅ Update existing log with exitTime
            lastLog.setExitTime(LocalDateTime.now());
            logRepo.save(lastLog);
        } else {
            // ✅ Create new entry log
            Log newLog = new Log();
            newLog.setUid(uid);
            newLog.setEntryTime(LocalDateTime.now());
            logRepo.save(newLog);
        }

        model.addAttribute("student", student);
        model.addAttribute("status", isInLibrary ? "Exit Time Marked" : "Entry Time Marked");
        return "studentDetails";
    }
}
