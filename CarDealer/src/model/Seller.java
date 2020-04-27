package model;

public class Seller extends Person {

    //Relations
    private Client[] clients;

    //Atributes
    private int totalSales;

    //Methods
    /**
     * It creates a new object type Seller
     * @param name  The name
     * @param lastName The last name
     * @param id The id
     * @param totalSales The total sales
     */
    public Seller(String name, String lastName, int id, int totalSales){
        super(name, lastName, id);
        this.totalSales=totalSales;
        clients=new Client[5];
    }

    //getters
    /**
     * @return The total sales
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * @return The clients
     */
    public Client[] getClients() {
        return clients;
    }

    //setters
    /**
     * @param totalSales The total sales to set
     */
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * @param clients The clients to set
     */
    public void setClients(Client[] clients) {
        this.clients = clients;
    }
}