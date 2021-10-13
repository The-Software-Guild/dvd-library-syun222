package com.dvdlibrary.dao;

import com.dvdlibrary.dto.Dvd;

import java.util.List;

public interface DvdLibraryDao {
    Dvd addDvd(String dvdId, Dvd dvd) throws DvdLibraryDaoException;

    List<Dvd> getAllDvd() throws DvdLibraryDaoException;

    Dvd getDvd(String dvdId) throws DvdLibraryDaoException;

    Dvd removeDvd(String dvdId) throws DvdLibraryDaoException;
}
