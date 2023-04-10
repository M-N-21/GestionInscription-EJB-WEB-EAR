package sn.isi.dao;

import jakarta.ejb.Local;
import sn.isi.entities.Inscription;
import sn.isi.entities.Year;

@Local
public interface IYearRemote extends Repository<Year> {

}
