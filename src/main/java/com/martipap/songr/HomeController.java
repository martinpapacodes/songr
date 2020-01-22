package com.martipap.songr;

import org.graalvm.compiler.lir.StandardOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

@GetMapping("/hello")
    public String getHelloWorld(Model model) {
    String greeting = "Hello World!";

    model.addAttribute("hello", greeting);
    return "hello";
}

@GetMapping("/capitalize/{stringToCapitalize}")
    public String capitalize(@PathVariable String stringToCapitalize, Model m) {
        String capitalize = stringToCapitalize.toUpperCase();
        m.addAttribute("capitalize", capitalize);
        return "hello";
}

@GetMapping("/albums")
    public String getAlbums(Model model) {
    List<Album> albums = albumRepository.findAll();

//    Album[] albumsArray = new Album[]
//            {new Album("Doggy Style", "Snoop", 12, 3, "https://place-hold.it/300x300&text=AlbumCover&bold&italic"),
//            new Album("West Coast", "Kurupt", 10, 4, "https://place-hold.it/300x300&text=AlbumCover&bold&italic"),
//            new Album("Taylor", "Taylor Swift", 9, 4, "https://place-hold.it/300x300&text=AlbumCover&bold&italic")
//            };
    model.addAttribute("albumsList", albums);
    return "albums";
}
}

