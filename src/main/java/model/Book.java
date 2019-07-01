package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
public class Book {
    @Getter @Setter
    private String isbn;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String author;
    @Getter @Setter
    private String type;
    @Getter @Setter
    private String press;
    @Getter @Setter
    private String date;
    @Getter @Setter
    private double price;
    @Getter @Setter
    private String cover;
    @Getter @Setter
    private int avgScore;
}
