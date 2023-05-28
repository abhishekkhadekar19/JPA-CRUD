package com.example.cruddemo.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOimpl implements StudentDAO {
  // define field for entity manager
  private EntityManager entityManager;

  // inject entity manager using constructer injection
  @Autowired
  // autowired annotation is optional if we only have one constrcter
  
  public StudentDAOimpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional
  // we defining this tranctional annotation as we have performing update operation
  public void save(Student theStudent) {

    entityManager.persist(theStudent);

  }
  
  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class,id);

    
  }

  @Override
  public List<Student> findAll() {
    // TODO Auto-generated method stub
    // create query
    // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastname asc", Student.class);
    
    // return query result
    return theQuery.getResultList();
  }

  @Override
  public List<Student> findByLastname(String Lastname) {
    //  create query
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastname=:theData", Student.class);
    // set query parameter
    theQuery.setParameter("theData", Lastname);

    return theQuery.getResultList();
  }

  @Override
  @Transactional
  public void update(Student theStudent) {
    // TODO Auto-generated method stub
    // this will update the student
    entityManager.merge(theStudent);

  }

  @Override
  @Transactional
  public void delete(Integer id) {
    // TODO Auto-generated method stub
// retrive the student
Student Thestudent = entityManager.find(Student.class, id);

// delet record
entityManager.remove(Thestudent);
    
  }

  @Override
  @Transactional
  public int deleteAll() {
    int rowsdeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
    return rowsdeleted;
  }

  // @Override
  

  
}
