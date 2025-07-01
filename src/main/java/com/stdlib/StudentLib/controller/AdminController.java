package com.stdlib.StudentLib.controller;

import com.stdlib.StudentLib.model.Log;
import com.stdlib.StudentLib.model.Student;
import com.stdlib.StudentLib.repositories.LogRepository;
import com.stdlib.StudentLib.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @Controller
    public class AdminController {

        @Autowired
        private LogRepository logRepo;

        @Autowired
        private StudentRepository studentRepo;

        // ========== LOG VIEW ==========
        @GetMapping("/admin/logs")
        public String viewLogs(Model model) {
            List<Log> allLogs = logRepo.findAll();

            // Sort: still inside on top, then latest exit
            List<Log> sortedLogs = allLogs.stream()
                    .filter(log -> log.getEntryTime() != null)
                    .sorted((log1, log2) -> {
                        if (log1.getExitTime() == null && log2.getExitTime() != null) return -1;
                        if (log1.getExitTime() != null && log2.getExitTime() == null) return 1;
                        if (log1.getExitTime() == null && log2.getExitTime() == null)
                            return log2.getEntryTime().compareTo(log1.getEntryTime());
                        return log2.getExitTime().compareTo(log1.getExitTime());
                    })
                    .toList();

            model.addAttribute("logs", sortedLogs);
            return "logs"; // logs.html Thymeleaf template
        }

    @GetMapping("/admin/addStudent")
    public String showAddStudentForm() {
        return "addStudent";
    }

        @PostMapping("/admin/addStudent")
        public String addStudent(@RequestParam String uid,
                                 @RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String address,
                                 @RequestParam String mobile) {

            if (uid == null || uid.trim().isEmpty()) {
                throw new IllegalArgumentException("UID must not be empty");
            }

            Student student = new Student(uid, name, email, address, mobile);
            studentRepo.save(student);  // ✅ works only if UID is set
            return "redirect:/";
        }

        @GetMapping("/admin/allStudent")
        public  String showAllStudent(Model model) {
            List<Student> allStudent = studentRepo.findAll();
            model.addAttribute("allStudent", allStudent);
            return "allStudent";
        }

    }
