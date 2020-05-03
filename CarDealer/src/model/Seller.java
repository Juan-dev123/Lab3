package model;

public class Seller extends Person {
    //Constants
    public static final int CLIENTS_IN_CARE=5;
    //Relations
    private Client[] clients;

    //Attributes
    private int totalSales;

    //Methods
    /**
     * It creates a new object type Seller
     * @param name  The name
     * @param lastName The last name
     * @param id The id
     */
    public Seller(String name, String lastName, int id){
        super(name, lastName, id);
        this.totalSales=0;
        clients=new Client[CLIENTS_IN_CARE];
    }

    /**
     * It searches a client in the clients in care of the seller
     * @param client The client
     * @return True if the clients is in care of the seller. False if is not
     */
    public boolean findClient(Client client){
        boolean stop=false;
        boolean exist=false;
        for(int i=0; i<clients.length && !stop; i++){
            if(clients[i]!=null){
                if(clients[i].getId()==client.getId()){
                    exist=true;
                    stop=true;
                }
            }else{
                stop=true;
            }
        }
        return exist;
    }

    /**
     * It assigns a client to the seller
     * @param client The client
     * @param position The position
     */
    public void assignClient(Client client, int position){
        clients[position]=client;
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