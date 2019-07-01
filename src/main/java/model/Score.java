package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Score {
    @Setter @Getter
    private String isbn;
    @Setter @Getter
    private String id;
    @Setter @Getter
    private int score;
}
