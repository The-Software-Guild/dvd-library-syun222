package com.dvdlibrary.controller;

import com.dvdlibrary.dao.DvdLibraryDao;
import com.dvdlibrary.dao.DvdLibraryDaoException;
import com.dvdlibrary.dto.Dvd;
import com.dvdlibrary.ui.DvdLibraryView;

import java.util.List;

public class DvdLibraryController {
    private DvdLibraryView view;
    private DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        exitMessage();
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getDvdId(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException{
        List<Dvd> dvdList = dao.getAllDvd();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException{
        view.displayViewDvdBanner();
        String dvdId = view.getDvdIdChoice();
        Dvd dvd = dao.getDvd(dvdId);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException{
        view.displayRemoveBanner();
        String dvdId = view.getDvdIdChoice();
        Dvd removedDvd = dao.removeDvd(dvdId);
        view.displayRemoveResult(removedDvd);
    }

    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditBanner();
        String dvdId = view.getDvdIdChoice();
        Dvd dvd = dao.getDvd(dvdId);
        if (dvd!= null) {
            view.setField(dvd);
            dao.addDvd(dvdId, dvd);
        } else {
            view.displayField("No such DVD.");
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
