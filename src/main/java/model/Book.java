package model;

import lombok.Getter;
import lombok.Setter;

public class Book {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private String bookClass;
    @Getter @Setter
    private int java;
    @Getter @Setter
    private int page;
}
