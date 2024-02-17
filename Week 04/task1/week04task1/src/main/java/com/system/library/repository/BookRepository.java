package com.system.library.repository; 

import com.system.library.entity.Book; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
