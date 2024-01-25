package com.example.demo.repo; //make a repo package/ directory

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Human;

@Repository // for different layers ther is different annotations for spring boot to manage
public class HumanRepo {

  private JdbcTemplate template; // setting a variable( declaring a private field) -> getters and setters ->
                                 // autowire it so that it can be found by the springboot container.

  public JdbcTemplate getTemplate() {
    return this.template;
  }

  @Autowired
  public void setTemplate(JdbcTemplate template) {
    this.template = template;
  }

  public void save(Human human) {
    // save the human object into DB
    System.out.println("Added");

    String sql = "insert into Human (id,name, tech) values(?,?,?)";

    int rows = template.update(sql, human.getId(), human.getName(), human.getTech());

    System.out.println(rows + " row/s affected");

  }

  public List<Human> findAll() {

    String sql = "select * from human";

    RowMapper<Human> mapper = new RowMapper<Human>() // Rowmapper is a functional interface
    {

      @Override
      public Human mapRow(ResultSet rs, int rowNum) throws SQLException {

        Human h = new Human();
        h.setId(rs.getInt(1));
        h.setName(rs.getString(2));
        h.setTech(rs.getString(3));

        return h;
      }
    };

    List<Human> humans = template.query(sql, mapper);
    return humans;
  }

}
