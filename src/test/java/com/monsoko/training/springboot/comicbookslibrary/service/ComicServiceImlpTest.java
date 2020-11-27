package com.monsoko.training.springboot.comicbookslibrary.service;

import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;
import com.monsoko.training.springboot.comicbookslibrary.repositorie.ComicRepositorie;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ComicServiceImlpTest {

    @Autowired
    private ComicService comicService;
    @Autowired
    private ComicRepositorie comicRepositorie;

    @Test
    void saveComic() {
        Comic comic = new Comic("music","aze","illustrator","publisher",true);
        Comic comic1 = comicService.saveComic(comic);

        Assertions.assertThat(comicService.getAllComics()).contains(comic1);
        Assertions.assertThat(comicService.findComicByTitle("music")).isEqualTo(comic1);

    }

    @Test
    void updateComic() {
        Comic comic = new Comic("music","aze","illustrator","publisher",true);

        Comic comic1 = comicService.updateComic((long) 1,comic);

        Assertions.assertThat(comicService.getAllComics()).contains(comic1);
    }


    @Test
    void getAllComics() {
        Comic comicA;
        comicA = new Comic("music","aze","illustrator","publisher",true);
        Comic comicC;
        comicC = new Comic("dakar","paris","reggea","music",true);
        Comic comicB;
        comicB = new Comic("song",
                "aze",
                "illustrator",
                "publisher",
                true);
        List<Comic> comic = comicRepositorie.saveAll(Arrays.asList(comicA,comicB,comicC));

        Assertions.assertThat(comicService.getAllComics()).hasSameElementsAs(comic);
    }

    @Test
    void findComicById() {
        Comic comicA = new Comic("music","aze","illustrator","publisher",true);
        Comic comicC = new Comic("dakar","paris","reggea","music",true);
        Comic comicB = new Comic("song","aze","illustrator","publisher",true);
        List<Comic> comic = comicRepositorie.saveAll(Arrays.asList(comicA,comicB,comicC));

        Comic c = comicService.findComicById(comicA.getIdComic());

        Assertions.assertThat(c.getIdComic()).isEqualTo(comicA.getIdComic());

    }

    @Test
    void findComicByTitle() {

        Comic comicA = new Comic("music","aze","illustrator","publisher",true);
        Comic comicC = new Comic("dakar","paris","reggea","music",true);
        Comic comicB = new Comic("song","aze","illustrator","publisher",true);
        List<Comic> comic = comicRepositorie.saveAll(Arrays.asList(comicA,comicB,comicC));

        Comic c = comicService.findComicByTitle(comicA.getTitle());

        Assertions.assertThat(c.getTitle()).isEqualTo(comicA.getTitle());
    }
}