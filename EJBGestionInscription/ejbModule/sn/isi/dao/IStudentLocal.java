package sn.isi.dao;

import jakarta.ejb.Local;
import sn.isi.entities.Student;

@Local
public interface IStudentLocal extends Repository<Student> {

}
