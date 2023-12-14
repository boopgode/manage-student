package com.devmaster.services.managestudent.repository;

import com.devmaster.services.managestudent.domain.Student;
import com.devmaster.services.managestudent.projection.IAvgBySubject;
import com.devmaster.services.managestudent.projection.IGetAllDemo;
import com.devmaster.services.managestudent.projection.IMaxpointByStudent;
import com.devmaster.services.managestudent.projection.IStudentFilterClass;
import com.devmaster.services.managestudent.untils.Sql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>, JpaSpecificationExecutor<Student> {
    //viet query theo native
//    @Query(nativeQuery = true, value ="select  * from student")
//    List<Student> filterByName(@Param("name") String name);

    //HQL
    @Query(value = "select s from Student  s where  s.firstName like concat('%',:name,'%')")
    List<Student> filterByName(@Param("name")String name);

    @Query(nativeQuery = true,value = "select student.* from subject,student_subject,student " +
            " where student.id = student_subject.id_student " +
            "    and  student_subject.id_subject = subject.id " +
            "    and subject.name like  concat('%',:name,'%')")
    List<Student> getStudentBySubject(String name);

//    @Query(value = "select  s from Student  s where s.subjects like concat('%':name,'%') ")
//    List<Student> filterBySubject(@Param("name")String name);
//    List<Student> findAllByFirstName(String name);


    @Query(value = Sql.STUDENT_FILTER_BY_CLASS, nativeQuery = true)
    List<IStudentFilterClass> findAllByClass(@Param("nameClass")String nameclass);

    @Query(value =Sql.AVG_BY_SUBJECT,nativeQuery = true )
    List<IAvgBySubject> findAllBySubject();
    @Query(value = Sql.MAX_POINT_STUDENT,nativeQuery = true)
    List<IMaxpointByStudent> findMaxpointByStudent();

    @Query( nativeQuery = true,value ="select CONCAT(s.last_name,' ',s.first_name)  as name,\n" +
            "       a.district as district,\n" +
            "       a.city as city\n" +
            "from student s\n" +
            "         join  adress a on s.id_address = a.id;" )
    List<IGetAllDemo> getAllDemo();
}
