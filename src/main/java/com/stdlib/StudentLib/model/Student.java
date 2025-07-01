//package com.stdlib.StudentLib.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.Setter;
//
//
//@Entity
//@Getter
//@Setter
//public class Student {
//
//    @Id // ✅ REMOVED @GeneratedValue
//    private String uid;
//
//    private String name;
//    private String email;
//    private String address;
//    private String mobile;
//
//
//    public Student() {} // Required by JPA
//
//    // ✅ FIXED CONSTRUCTOR: Initialize all fields
//    public Student(String uid, String name, String email, String address, String mobile) {
//        this.uid = uid;
//        this.name = name;
//        this.email = email;
//        this.address = address;
//        this.mobile = mobile;
//    }
//
//}



package com.stdlib.StudentLib.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {

    @Id
    private String uid;

    public String getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    private String name;
    private String email;
    private String address;
    private String mobile;

    public Student() {}

    public Student(String uid, String name, String email, String address, String mobile) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
    }
}

