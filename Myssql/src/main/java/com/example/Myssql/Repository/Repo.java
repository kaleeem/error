package com.example.Myssql.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Myssql.Model.Student;

public interface Repo extends JpaRepository<Student, Integer>{

}
