package com.monsoko.training.springboot.comicbookslibrary.controller;

import com.monsoko.training.springboot.comicbookslibrary.domain.Album;
import com.monsoko.training.springboot.comicbookslibrary.domain.Comic;
import com.monsoko.training.springboot.comicbookslibrary.repositorie.AlbumRepositorie;
import com.monsoko.training.springboot.comicbookslibrary.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumRepositorie albumRepositorie;

    @PostMapping("/albums")
    public Album savAlbum(@RequestBody Album album) {
        return albumService.saveAlbum(album);
    }

    @DeleteMapping("/albums/{id}")
    public Boolean deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return true;
    }

    @GetMapping("/albums/{id}")
    public Album findAlbumById(@PathVariable("id") Long id) {
        return albumService.findAlbumById(id);
    }

    @GetMapping("/chercherAlbums")
    public Page<Album> pageAlbums(@RequestParam(name = "mc", defaultValue = "") String mc,
                                  @RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "5") int size) {
        return albumRepositorie.pageAlbum("%" + mc + "%", PageRequest.of(page, size));
    }



}