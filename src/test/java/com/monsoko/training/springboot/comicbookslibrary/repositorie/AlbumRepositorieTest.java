package com.monsoko.training.springboot.comicbookslibrary.repositorie;

import com.monsoko.training.springboot.comicbookslibrary.domain.Album;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AlbumRepositorieTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private AlbumRepositorie albumRepositorie;

    @Test
    void AlbumTest() throws Exception{

        //given
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Album albumA = new Album("azerty",14,df.parse("14/12/2008"),"cover");
        Album albumB = new Album("qwerty",36,df.parse("14/12/2020"),"others");
        Album albumC = new Album("mouse",25,df.parse("14/12/2014"),"yes");
        testEntityManager.persist(albumA);
        testEntityManager.persist(albumB);
        testEntityManager.persist(albumC);
        //when
        List<Album> albums = albumRepositorie.findAll();


        //then
        Assertions.assertThat(albums).containsOnly(albumA,albumB,albumC);
    }

    @Test
    void verifiedAlbumIsNotNullAndNotEmpty() throws Exception{

        //given
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Album albumA = new Album("azerty",14,df.parse("14/12/2008"),"cover");
        Album albumB = new Album("aee",36,df.parse("14/12/2020"),"others");

        //when
        Album albuma = albumRepositorie.save(albumA);
        Album albumb = albumRepositorie.save(albumB);

        Assertions.assertThat(albuma.getTitle()).isNotEmpty().isNotNull();
        Assertions.assertThat(albumb.getTitle()).isNotEmpty().isNotNull();
    }

}