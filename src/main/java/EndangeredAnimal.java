import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal extends Animal {


  public static final String ILL_OPTION = "Ill";
  public static final String OKAY_OPTION = "Okay";
  public static final String HEALTHY_OPTION = "Healthy";
  public static final String NEWBORN_OPTION = "Newborn";
  public static final String YOUNG_OPTION = "Young";
  public static final String ADULT_OPTION = "Adult";

  public EndangeredAnimal(String name, String health, String age) {
    super(name);
    this.id = id;
    this.health = health;
    this.age = age;
    this.endangered = true;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

  public boolean getEndangered() {
    return endangered;
  }

  @Override
  public boolean equals(Object otherEndangeredAnimal) {
    if(!(otherEndangeredAnimal instanceof EndangeredAnimal)) {
      return false;
    } else {
      EndangeredAnimal newEndangeredAnimal = (EndangeredAnimal) otherEndangeredAnimal;
      return this.getName().equals(newEndangeredAnimal.getName()) && this.getHealth().equals(newEndangeredAnimal.getHealth()) && this.getAge().equals(newEndangeredAnimal.getAge());
    }
  }

  // public void save() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "INSERT INTO endangered_animals (name, health, age) VALUES (:name, :health, :age);";
  //     this.id = (int) con.createQuery(sql, true)
  //       .addParameter("name", this.name)
  //       .addParameter("health", this.health)
  //       .addParameter("age", this.age)
  //       .executeUpdate()
  //       .getKey();
  //   }
  // }

  // public static List<EndangeredAnimal> all() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM animals WHERE health=" + !(null) + ";";
  //     return con.createQuery(sql)
  //     .throwOnMappingFailure(false)
  //       .executeAndFetch(EndangeredAnimal.class);
  //   }
  // }

  public static EndangeredAnimal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id=:id;";
      EndangeredAnimal endangeredanimal = con.createQuery(sql)
        .addParameter("id", id)
        .throwOnMappingFailure(false)
        .executeAndFetchFirst(EndangeredAnimal.class);
      return endangeredanimal;
    }
  }

  public void updateHealth(String health) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE endangered_animals SET health=:health WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("id", id)
        .addParameter("health", health)
        .executeUpdate();
    }
  }

  public void updateAge(String age) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE endangered_animals SET age=:age WHERE id=:id;";
      con.createQuery(sql)
        .addParameter("age", age)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public List<Sighting> getSightings() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings WHERE animal_id=:id;";
        List<Sighting> sightings = con.createQuery(sql)
          .addParameter("id", id)
          .executeAndFetch(Sighting.class);
      return sightings;
    }
  }


}
