package com.monsoko.training.springboot.comicbookslibrary.controller;

import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;
import com.monsoko.training.springboot.comicbookslibrary.repositorie.ComicRepositorie;
import com.monsoko.training.springboot.comicbookslibrary.service.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @Autowired
    private ComicRepositorie comicRepositorie;

    @PostMapping("/comics")
    public Comic saveComic(@RequestBody Comic comic ) {
        return comicService.saveComic(comic);
    }

    @PutMapping("/comics/{id}")
    public Comic updateComic(@PathVariable("id") Long id, @RequestBody Comic comic) {
        return comicService.updateComic(id, comic);
    }

    @DeleteMapping("/comics/{id}")
    public Boolean deleteComic(@PathVariable Long id ) {
        comicService.deleteComic(id);
        return true;
    }

    @GetMapping("/comics")
    public List<Comic> getAllComic() {
        return comicService.getAllComics();
    }

    @GetMapping("/chercherComics")
    public Page<Comic> pageComics( @RequestParam(name = "mc", defaultValue = "") String mc,
                                   @RequestParam(name = "page", defaultValue = "0") int page,
                                   @RequestParam(name = "size", defaultValue = "5") int size){
        return comicRepositorie.pageComic("%"+mc+"%", PageRequest.of(page, size));
    }

    @GetMapping("/comics/{id}")
    public Comic getComicById(@PathVariable("id") Long id ) {
        return comicService.findComicById(id);
    }

    @GetMapping("/comicTitle/{title}")
    public Comic getComicByTitle(@PathVariable String title ) {
      return comicService.findComicByTitle(title);
    }
}
