package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Comment {
    @Setter @Getter
    private String isbn;
    @Setter @Getter
    private String id;
    @Setter @Getter
    private String comment;
}
