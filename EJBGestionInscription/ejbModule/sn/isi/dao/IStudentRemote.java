package sn.isi.dao;

import jakarta.ejb.Remote;
import sn.isi.entities.Student;

@Remote
public interface IStudentRemote extends Repository<Student> {

}
