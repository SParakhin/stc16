package ru.innopolis.stc16.innobazaar.service;

import org.springframework.stereotype.Service;
import ru.innopolis.stc16.innobazaar.dao.BookedMerchandiseDAO;
import ru.innopolis.stc16.innobazaar.entity.BookedMerchandise;

@Service
public class BookedMerchandiseServiceImpl implements BookedMerchandiseService{

    private BookedMerchandiseDAO bookedMerchandiseDAO;

    public BookedMerchandiseServiceImpl(BookedMerchandiseDAO bookedMerchandiseDAO) {
        this.bookedMerchandiseDAO = bookedMerchandiseDAO;
    }

    @Override
    public BookedMerchandise save(BookedMerchandise bookedMerchandise) {
        return bookedMerchandiseDAO.saveBookedMerchandise(bookedMerchandise);
    }
}
