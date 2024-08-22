package org.example;

import org.example.config.FactoryConfiguration;
import org.example.embed.FullName;
import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();

        FullName fullName = new FullName("malithi","imasha");
        Student student = new Student();
        student.setId(2);
        student.setName(fullName);
        student.setAddress("angoda");


        //open transaction
        Transaction transaction = session.beginTransaction();
        session.save(student);

        session.update(student);

        //delete, get, another table, note
        transaction.commit();
        session.close();

    }
}