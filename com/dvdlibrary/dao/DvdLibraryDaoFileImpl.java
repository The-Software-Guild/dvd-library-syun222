package com.dvdlibrary.dao;

import com.dvdlibrary.dto.Dvd;

import java.io.*;
import java.util.*;

public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
    public static final String ROSTER_FILE = "C:/Users/Admin/IdeaProjects/DVD Library/src/com/dvdlibrary/dao/roster.txt";
    public static final String DELIMITER = "::";

    Map<String, Dvd> dvds = new HashMap<>();

    public Dvd addDvd(String dvdId, Dvd dvd) throws DvdLibraryDaoException{
        loadRoster();
        Dvd prevDvd = dvds.put(dvdId, dvd);
        writeRoster();
        return prevDvd;
    }

    public List<Dvd> getAllDvd() throws DvdLibraryDaoException {
        loadRoster();
        return new ArrayList<Dvd>(dvds.values());
    }

    public Dvd getDvd(String dvdId) throws DvdLibraryDaoException{
        loadRoster();
        return dvds.get(dvdId);
    }

    public Dvd removeDvd(String dvdId) throws DvdLibraryDaoException{
        loadRoster();
        Dvd removedDvd = dvds.remove(dvdId);
        writeRoster();
        return removedDvd;
    }

    private Dvd unmarshallDvd(String dvdAsText) {
        //id0::title1::date2::mpaa3::director4::studio5::note6
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String dvdId = dvdTokens[0];
        Dvd dvd = new Dvd(dvdTokens[0]);
        dvd.setTitle(dvdTokens[1]);
        dvd.setReleaseDate(dvdTokens[2]);
        dvd.setMpaa(dvdTokens[3]);
        dvd.setDirector(dvdTokens[4]);
        dvd.setStudio(dvdTokens[5]);
        dvd.setNote(dvdTokens[6]);
        return dvd;
    }

    private void loadRoster() throws DvdLibraryDaoException {
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("Could not load roster into memory", e);
        }
        String currentLine;
        Dvd currentDvd;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            dvds.put(currentDvd.getDvdId(), currentDvd);
        }
        scanner.close();
    }

    private String marshallDvd(Dvd dvd) {
        return String.join(DELIMITER, dvd.getDvdId(), dvd.getTitle(), dvd.getReleaseDate(), dvd.getMpaa(), dvd.getDirector(), dvd.getStudio(), dvd.getNote());
    }

    private void writeRoster() throws DvdLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save data", e);
        }

        String dvdAsText;
        List<Dvd> dvdList = this.getAllDvd();
        for (Dvd dvd: dvdList) {
            dvdAsText = marshallDvd(dvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
