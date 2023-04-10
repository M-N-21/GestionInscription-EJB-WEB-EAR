package sn.isi.dao;

import jakarta.ejb.Local;
import sn.isi.entities.Inscription;

@Local
public interface IInscriptionRemote extends Repository<Inscription> {

}
