package sn.isi.dao;

import jakarta.ejb.Stateless;
import sn.isi.entities.Student;

@Stateless
public class StudentImpl extends RepositoryImpl<Student> implements IStudentLocal, IStudentRemote {

}
