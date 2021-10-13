package com.dvdlibrary.dto;

public class Dvd {
    private String dvdId;
    private String title;
    private String releaseDate;
    private String mpaa;
    private String director;
    private String studio;
    private String note;

    public Dvd(String dvdId) {
        this.dvdId = dvdId;
    }

    public String getTitle() {
        return title;
    }

    public String getStringInfo() {
        String stringInfo = String.format("ID: %s, title: %s, release date: %s, mpaa: %s, director: %s, studio: %s, note: %s", dvdId, title, releaseDate, mpaa, director, studio, note);
        return stringInfo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDvdId() {
        return dvdId;
    }
}
