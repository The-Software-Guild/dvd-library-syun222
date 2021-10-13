package com.dvdlibrary;

import com.dvdlibrary.controller.DvdLibraryController;
import com.dvdlibrary.dao.DvdLibraryDao;
import com.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.dvdlibrary.ui.DvdLibraryView;
import com.dvdlibrary.ui.UserIO;
import com.dvdlibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DvdLibraryView view = new DvdLibraryView(io);
        DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(view, dao);
        controller.run();
    }
}
