package com.victor.bookstoresystem.entities.products;

import com.victor.bookstoresystem.enums.MusicGenere;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
public class MusicAlbum extends Product {
    private List<MusicGenere> generes;
    private List<String> musiciansOrBands;

    public MusicAlbum(String name, BigDecimal price) {
        super(name, price);
    }

    public MusicAlbum(String name, BigDecimal price, boolean plus18) {
        super(name, price, plus18);
    }

    public MusicAlbum(String name, BigDecimal price, List<MusicGenere> generes, List<String> musiciansOrBands) {
        super(name, price);
        this.generes = generes;
        this.musiciansOrBands = musiciansOrBands;
    }
}
