package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.entities.Product;
import com.victor.bookstoresystem.enums.Category;
import com.victor.bookstoresystem.enums.generes.MusicGenere;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MusicAlbum extends Product {
    private List<MusicGenere> generes;
    private List<String> musiciansOrBands;

    public MusicAlbum(String name, Double price, Integer ageGreaterThan) {
        super(Category.MUSIC_ALBUM, name, price, ageGreaterThan);
    }

    public MusicAlbum(String name, Double price, Integer ageGreaterThan, List<MusicGenere> generes, List<String> musiciansOrBands) {
        super(Category.MUSIC_ALBUM, name, price, ageGreaterThan);
        this.generes = generes;
        this.musiciansOrBands = musiciansOrBands;
    }
}
