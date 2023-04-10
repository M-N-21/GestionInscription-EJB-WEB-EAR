package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Year;
@Stateless
public class YearImpl extends RepositoryImpl<Year> implements IYearRemote, IYearLocal {

}
