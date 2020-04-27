package model;

public abstract class Person {
    //Atributes
    private String name;
    private String lastName;
    private int id;

    //Methods
    /**
     * It creates a new object type Person
     * @param name The name
     * @param lastName The last name
     * @param id The id
     */
    public Person(String name, String lastName, int id){
        this.name=name;
        this.lastName=lastName;
        this.id=id;
    }

    //getters
    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    //setters
    /**
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param lastName The last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param id The id to set
     */
    public void setId(int id) {
        this.id = id;
    }


}