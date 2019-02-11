package com.library.springdemo.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * Created by ibrahimg on 07.11.2018.
 */
@Entity
@Table(name = "author")
public class Author implements Serializable{

    @Id
    @Column(name = "AUTHOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Column(name = "AUTHOR_LAST_NAME")
    private String authorLastName;

    @Column(name = "BIRTH_DATE")
    @Pattern(regexp = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\-(1[012]|0?[1-9])\\-((?:17|18|19|20)\\d{2})\\s*$", message = "Tarih hatalı (dd-MM-yyyy) şeklinde olmalıdır!...")
    private String birthDate;

    @Pattern(regexp = "^\\s*(3[01]|[12][0-9]|0?[1-9])\\-(1[012]|0?[1-9])\\-((?:17|18|19|20)\\d{2})\\s*$", message = "Tarih hatalı (dd-MM-yyyy) şeklinde olmalıdır!...")
    @Column(name = "DEATH_DATE")
    private String deathDate;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "AUTHOR_ID"), inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private List<Book> books;

    public Author() {
    }

    public Author(String authorName, String authorLastName, String birthDate, String deathDate) {
        this.authorName = authorName;
        this.authorLastName = authorLastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", deathDate='" + deathDate + '\'' +
                '}';
    }
}
