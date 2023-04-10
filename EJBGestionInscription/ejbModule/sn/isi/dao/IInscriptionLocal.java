package sn.isi.dao;

import jakarta.ejb.Local;
import sn.isi.entities.Inscription;
import sn.isi.entities.Student;

@Local
public interface IInscriptionLocal extends Repository<Inscription> {

}
