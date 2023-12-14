package com.devmaster.services.managestudent.untils;

public class Sql {
    public  static final String STUDENT_FILTER_BY_CLASS = "select  s.id as id,\n" +
            "        concat(s.last_name,' ',s.first_name) as name,\n" +
            "        c.nameClass as className,\n" +
            "        sub.name as subjectName,\n" +
            "        ss.point as point\n" +
            "from student s\n" +
            "         left join  classes c on s.id_classes=c.id\n" +
            "         left join student_subject ss on s.id=ss.id_student\n" +
            "         left join subject sub on ss.id_subject=sub.id\n" +
            "where c.nameClass='2'";
    public  static final String AVG_BY_SUBJECT ="select sj.id    as id,\n" +
            "       sj.name  as subjectName,\n" +
            "       AVG(ss.point) as avgPoint\n" +
            "from subject sj\n" +
            "         left join student_subject ss on sj.id = ss.id_subject\n" +
            "group by  sj.id";
    public static  final  String MAX_POINT_STUDENT ="select s.id as id,\n" +
            "        concat(\n" +
            "           s.last_name,' ',s.first_name\n" +
            "           )  as fullName,\n" +
            "       MAX(ss.point) as maxPoint\n" +
            "from student s\n" +
            "         left join student_subject ss on s.id = ss.id_student\n" +
            "group by s.id";


}
