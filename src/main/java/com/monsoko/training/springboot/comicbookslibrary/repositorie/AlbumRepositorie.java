package com.monsoko.training.springboot.comicbookslibrary.repositorie;

import com.monsoko.training.springboot.comicbookslibrary.domain.Album;
import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlbumRepositorie extends JpaRepository<Album, Long> {

    @Query("select a from Album a where a.idAlbum=:w")
    public Album findAlbumById(@Param("w") Long id );

    @Query("select a from Album a where a.title like :x")
    public Page<Album> pageAlbum(@Param("x") String mc, Pageable pageable);
}
