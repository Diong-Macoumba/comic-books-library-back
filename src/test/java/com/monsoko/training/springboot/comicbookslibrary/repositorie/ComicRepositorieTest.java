package com.monsoko.training.springboot.comicbookslibrary.repositorie;

import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ComicRepositorieTest {

    @Autowired
    private ComicRepositorie comicRepositorie;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findComicByTitle() {

        //given
        Comic comic = new Comic("dakar","paris","reggea","music",false);
        testEntityManager.persist(comic);

        //when
        Comic found = comicRepositorie.findComicByTitle("dakar");

        //then
        Assertions.assertThat(found.getTitle()).isEqualTo(comic.getTitle());
    }

    @Test
    void verifiedComicIsNotNullAndNotEmpty() throws Exception {

        //given
        Comic comic = new Comic("dakar","paris","reggea","music",true);

        //when
        Comic found = comicRepositorie.save(comic);

        //then
        Assertions.assertThat(found.getScriptWriter()).isNotNull().isNotEmpty();
    }
}