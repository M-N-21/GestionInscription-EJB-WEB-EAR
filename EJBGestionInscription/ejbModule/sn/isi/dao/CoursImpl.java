package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Cours;
@Stateless
public class CoursImpl extends RepositoryImpl<Cours> implements ICoursLocal, ICoursRemote {

}
