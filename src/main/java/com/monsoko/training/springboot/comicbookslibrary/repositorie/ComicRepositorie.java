package com.monsoko.training.springboot.comicbookslibrary.repositorie;

import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepositorie extends JpaRepository<Comic, Long> {

    @Query("select c from Comic c where c.title=:x")
    public Comic findComicByTitle( @Param("x") String title );

    @Query("select c from Comic c where c.idComic=:w")
    public Comic findComicById( @Param("w") Long id );

    @Query("select c from Comic c where c.title like :x")
    public Page<Comic> pageComic(@Param("x") String mc, Pageable pageable);

}
