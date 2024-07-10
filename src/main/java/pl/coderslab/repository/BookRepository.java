package pl.coderslab.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

// TE 4 METODY są dziedziczone z JpaRepo i nie trzeba ich deklarować:
    //    List<Book> findAll();
    //    Optional<Book> findById(Long id);
    //    Book save(Book book);
    //    void deleteById(Long id);

}
