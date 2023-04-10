package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Inscription;
@Stateless
public class InscriptionImpl extends RepositoryImpl<Inscription> implements IInscriptionLocal, IInscriptionRemote {

}
