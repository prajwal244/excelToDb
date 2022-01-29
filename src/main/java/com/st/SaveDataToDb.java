package com.st;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveDataToDb extends JpaRepository<Student, Long> {

}
