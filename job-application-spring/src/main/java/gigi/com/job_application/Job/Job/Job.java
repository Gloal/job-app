package gigi.com.job_application.Job.Job;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import gigi.com.job_application.Job.company.Company;

@Entity
//@Table(name="job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String maxSalary;
    private String minSalary;
    private String location;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Company company;


    //you need a default no-args constructor when using JPA as it needs a way to create an entity
    //JPA needs to create instances of the entity when retrieving from the database and it uses reflection
    //and populates the data with what it has retrieved so without this constructor, it has no way of turning them into objects

    /*
    ring JPA uses reflection to dynamically interact with your entity classes during runtime. This approach allows Spring (or Hibernate, which underpins JPA in many cases) to perform tasks such as instantiating entities, accessing fields, invoking methods, and constructing queries without requiring you to write boilerplate code.
Key Aspects of Reflection in Spring JPA

    Entity Instantiation:
        When JPA fetches data from the database, it needs to create an instance of your entity class to populate with the retrieved data. Reflection is used to instantiate the entity.

    Field and Method Access:
        Reflection is used to map database columns to entity fields or properties. For example, if your entity has a field private String title;, JPA uses reflection to set its value based on the corresponding database column.

    Annotation Processing:
        JPA annotations (e.g., @Entity, @Id, @Column) are processed at runtime using reflection to determine how to map classes and fields to database tables and columns.

Why Does JPA Require a No-Args Constructor?

JPA requires a no-args constructor for entity classes because it uses reflection to instantiate the class when loading entities from the database. Here’s why:

    Instance Creation via Reflection:
        When JPA or Hibernate creates an instance of your entity, it uses the Class.newInstance() or similar methods, which require a no-args constructor. Without it, the framework cannot create an instance of the entity class.

    Proxies and Lazy Loading:
        Hibernate often wraps your entity in a proxy class for features like lazy loading. This proxy requires a no-args constructor to work properly.

    Population of Fields Post-Creation:
        JPA creates the entity instance first and then populates its fields using reflection. A no-args constructor ensures that this process can occur without needing custom instantiation logic.

    Flexibility in Framework Behavior:
        A no-args constructor ensures that JPA can handle different scenarios, such as deserialization or object hydration, without needing to rely on custom constructor logic.

Best Practices for the No-Args Constructor

    Make it protected (Preferred):
        You don’t need to expose the no-args constructor as public. Instead, make it protected to restrict its visibility while still allowing JPA to use it.
    * */
    public Job(){}


    public Job(Long id, String title, String description, String maxSalary, String minSalary, String location, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.location = location;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Company getCompany(Company company){
        return this.company;
    }
}