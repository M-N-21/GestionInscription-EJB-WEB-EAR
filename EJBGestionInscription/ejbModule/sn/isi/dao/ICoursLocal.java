package sn.isi.dao;

import jakarta.ejb.Local;
import sn.isi.entities.Cours;

@Local
public interface ICoursLocal extends Repository<Cours> {

}
