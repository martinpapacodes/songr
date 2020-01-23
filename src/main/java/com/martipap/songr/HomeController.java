package com.martipap.songr;

import org.graalvm.compiler.lir.StandardOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLException;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

@GetMapping("/hello")
    public String getHelloWorld(Model model) {
    String greeting = "Hello World!";
    //m is the hashmap of vars available to thymeleaf
    model.addAttribute("hello", greeting);
    return "hello";
}

@GetMapping("/capitalize/{stringToCapitalize}")
    public String capitalize(@PathVariable String stringToCapitalize, Model m) {
        String capitalize = stringToCapitalize.toUpperCase();
        m.addAttribute("capitalize", capitalize);
        return "hello";
}

@GetMapping("/albumsCollection")
    public String getAlbums(Model model) {

//    Album[] albumsArray = new Album[]
//            {new Album("Doggy Style", "Snoop", 12, 3, "https://place-hold.it/300x300&text=AlbumCover&bold&italic"),
//            new Album("West Coast", "Kurupt", 10, 4, "https://place-hold.it/300x300&text=AlbumCover&bold&italic"),
//            new Album("Taylor", "Taylor Swift", 9, 4, "https://place-hold.it/300x300&text=AlbumCover&bold&italic")
//            };
    List<Album> albums = albumRepository.findAll();

    model.addAttribute("albumsList", albums);
    return "albums";
}

@PostMapping("/albums")
public RedirectView postAlbum(String title, String artist, int songCount, int length, String imageUrl) throws SQLException {
    Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
    albumRepository.save(newAlbum);

    return new RedirectView("albumsCollection");
}

}

