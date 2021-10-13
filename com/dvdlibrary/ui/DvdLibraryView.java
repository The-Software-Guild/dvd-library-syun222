package com.dvdlibrary.ui;

import com.dvdlibrary.dto.Dvd;

import java.util.List;

public class DvdLibraryView {
    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuGetSelection() {
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Search DVD");
        io.print("4. List DVD");
        io.print("5. Edit DVD");
        io.print("6. Exit");

        return io.readInt("Enter 1 - 6: ");
    }

    public Dvd getNewDvdInfo() {
        String dvdId = io.readString("DVD ID: ");
        String title = io.readString("title: ");
        String releaseDate = io.readString("release date: ");
        String mpaa = io.readString("mpaa: ");
        String director = io.readString("director: ");
        String studio = io.readString("studio: ");
        String note = io.readString("note: ");

        Dvd dvd = new Dvd(dvdId);
        dvd.setTitle(title);
        dvd.setReleaseDate(releaseDate);
        dvd.setMpaa(mpaa);
        dvd.setDirector(director);
        dvd.setStudio(studio);
        dvd.setNote(note);
        return dvd;
    }

    public void displayCreateDvdBanner() {
        io.print("==== Create DVD ====");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created. Press Enter to continue.");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        io.print("=== All DVD ===");
        for (Dvd dvd: dvdList) {
            io.print(dvd.getStringInfo());
        }
        io.readString("Press Enter to continue.");
    }

    public void displayViewDvdBanner() {
        io.print("=== View DVD ===");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getStringInfo());
        } else {
            io.print("No such DVD");
        }
        io.readString("Press Enter to continue.");
    }

    public String getDvdIdChoice() {
        return io.readString("Enter DVD ID: ");
    }

    public void displayRemoveBanner() {
        io.print("Remove DVD");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if (dvdRecord != null) {
            io.print("Successfully removed.");
        } else {
            io.print("No such DVD");
        }
        io.readString("Press Enter to continue.");
    }

    public void displayEditBanner() {
        io.print("=== Edit DVD ===");
    }

    public int getFieldSelection() {
        io.print("Choose the field to edit.");
        io.print("1. Title");
        io.print("2. Release Date");
        io.print("3. mpaa");
        io.print("4. director");
        io.print("5. Stutio");
        io.print("6. Note");
        return io.readInt("Enter 1-6: ");
    }

    public void setField(Dvd dvd) {
        io.print(dvd.getStringInfo());
        int fieldSelection = getFieldSelection();
        switch (fieldSelection) {
            case 1:
                io.print("Title = " + dvd.getTitle());
                dvd.setTitle(io.readString("New Title: "));
                break;
            case 2:
                io.print("Release Date = " + dvd.getReleaseDate());
                dvd.setReleaseDate(io.readString("New Release Date: "));
                break;
            case 3:
                io.print("Mpaa = " + dvd.getMpaa());
                dvd.setMpaa(io.readString("New Mpaa: "));
                break;
            case 4:
                io.print("Director = " + dvd.getDirector());
                dvd.setDirector(io.readString("New Director: "));
                break;
            case 5:
                io.print("Studio = " + dvd.getStudio());
                dvd.setStudio(io.readString("New Studio: "));
                break;
            case 6:
                io.print("Note = " + dvd.getNote());
                dvd.setNote(io.readString("New Note: "));
                break;
            default:
                displayUnknownCommandBanner();
        }
        io.print("Edit Result");
        io.print(dvd.getStringInfo());
    }

    public void displayField(String msg) {
        io.print("msg");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!");
    }

    public void displayExitBanner() {
        io.print("Goodbye!");
    }

    public void displayErrorMessage(String msg) {
        io.print("=== ERROR ===");
        io.print(msg);
    }
}
