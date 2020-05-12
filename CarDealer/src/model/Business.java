package model;

import java.util.ArrayList;

public class Business {
    //Relations
    private Seller[] sellers;
    private ArrayList<Vehicle> vehicles;
    private ParkingLot parkingLot;
    private ArrayList<Client> clients;

    //Attributes
    private String name;
    private String nit;
    private double totalProfits;
    private int totalSales;

    //Methods
    /**
     * It creates a new object type Business and also creates 7 sellers
     * @param name The name 
     * @param nit The NIT
     * @param totalProfits The total profits
     * @param totalSales The total sales
     */
    public Business(String name, String nit){
        this.name=name;
        this.nit=nit;
        this.totalProfits=0;
        this.totalSales=0;
        sellers=new Seller[10];
        parkingLot=new ParkingLot();
        vehicles=new ArrayList<Vehicle>();
        clients=new ArrayList<Client>();

        //Vehicles created by default
        vehicles.add(new Motorcycle(2500000, "TOYOTA", 2019, 10, 10, true, "", null, null, 2, 12));
        vehicles.add(new Motorcycle(2500000, "TOYOTA", 2016, 10, 10, false, "ABC456", new Soat(120000, 2017, 1200000), new MechanicalTechnicalReview(120000, 2016, 12.5), 2, 12));
        vehicles.add(new GasolineCar(35000000, "RENAULT", 2017, 10, 10, true, "", null, null, 1, 4, true, 10, 2));
        vehicles.add(new GasolineCar(40000000, "RENAULT", 2020, 10, 10, false, "QWE456", new Soat(600000, 2017, 6200000), new MechanicalTechnicalReview(300000, 2018, 20.2), 1, 4, false, 10, 2));
        vehicles.add(new ElecticCar(80000000, "TESLA", 2020, 12, 12, true, "", null, null, 1, 4, true, 2, 100));
        vehicles.add(new ElecticCar(85000000, "TESLA", 2020, 12, 12, false, "ASD456", new Soat(600000, 2020, 6200000), new MechanicalTechnicalReview(300000, 2020, 25), 1, 4, false, 2, 100));
        vehicles.add(new HybridCar(120000000, "KIA", 2019, 12, 13, true, "", null, null, 1, 4, true, 12, 2, 1, 150));
        vehicles.add(new HybridCar(110000000, "KIA", 2020, 12, 13, false, "ZXC456", new Soat(900000, 2020, 9200000), new MechanicalTechnicalReview(900000, 2020, 20), 1, 4, true, 12, 2, 1, 125));
        
        //Client creted by default
        clients.add(new Client("Camila", "Ceron", 1010, "3145346780", "camila@gmail.com"));
        clients.add(new Client("Ricardo", "Saavedra", 2020, "3106445634", "ricardo@gmail.com"));
        clients.add(new Client("Sofia", "Caicedo", 3030, "3124564554", "sofia@gmail.com"));
        clients.add(new Client("Jerson", "Ramirez", 4040, "3152344553", "jerson@gmail.com"));
        clients.add(new Client("Laura", "Ceron", 5050, "3124455778", "laura@gmail.com"));
        clients.add(new Client("Miguel", "Cuellar", 6060, "3172244234", "miguel@gmail.com"));

        //Sellers created by default
        sellers[0]= new Seller("Michaela", "Pratt", 1234567);
        sellers[1]= new Seller("Annalise", "Keating", 2345678);
        sellers[2]= new Seller("Connor", "Walsh", 3456789);
        sellers[3]= new Seller("Asher", "Millstong", 4567890);
        sellers[4]= new Seller("Frank", "Delfino", 5678901);
        sellers[5]= new Seller("Bonnie", "Winterbottom", 6789012);
        sellers[6]= new Seller("Oliver", "Hampton", 7890123);
    }

    /**
     * It registered a new motorcycle
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param type The type
     * @param gasolineCapacity The gasoline capacity
     * @return A message informing that the vehicle was registered
     */
    public String registerVehicle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int type, double gasolineCapacity){
        String message;
        vehicles.add(new Motorcycle(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, type, gasolineCapacity));
        message="The vehicle was registered successfully";
        return message;
    }
    /**
     * It registered a new gasoline car
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param typeOfCar The type of car
     * @param numberOfDoors The number of doors
     * @param tintedWindows True if the windows are tinted. False if they don't
     * @param tankCapacity The tank capacity
     * @param typeOfFuel The type of fuel
     * @return A message informing that the vehicle was registered
     */
    public String registerVehicle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, double tankCapacity, int typeOfFuel){
        String message;
        GasolineCar vehicle=new GasolineCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel);
        if(saveInParkingLot(model, isNew)){
            int freeSpace;
            message="The vehicle was registered successfully in the parking lot";
            if(model<2011){
                freeSpace=lookForSpaceinParkingLot(4);
                if(freeSpace==-1){
                    message="The vehicle was not registered. There is not space in the parking lot";
                }else{
                    parkingLot.saveVehicle(freeSpace, 4, vehicle);
                }
            }else{
                switch(model){
                    case 2014:
                        freeSpace=lookForSpaceinParkingLot(0);
                        if(freeSpace==-1){
                            
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 0, vehicle);
                        }
                        break;
                    case 2013:
                        freeSpace=lookForSpaceinParkingLot(1);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 1, vehicle);
                        }
                        break;
                    case 2012:
                        freeSpace=lookForSpaceinParkingLot(2);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 2, vehicle);
                        }
                        break;
                    case 2011:
                        freeSpace=lookForSpaceinParkingLot(3);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 3, vehicle);
                        }
                        break;
                }
            }
        }else{
            vehicles.add(vehicle);
            message="The vehicle was registered successfully in the concessionaire";
        }
        return message;
    }

    /**
     * It registers a new electric car
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param typeOfCar The type of car
     * @param numberOfDoors The number of doors
     * @param tintedWindows True if the windows are tinted. False if they don't
     * @param typeCharger The type of charger 
     * @param batteryDuration The battery duration
     * @return A message informing that the vehicle was registered
     */
    public String registerVehicle(double price, String brand, int model, double displacement,double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, int typeCharger, double batteryDuration){
        String message;
        ElecticCar vehicle=new ElecticCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, typeCharger, batteryDuration);
        if(saveInParkingLot(model, isNew)){
            int freeSpace;
            message="The vehicle was registered successfully in the parking lot";
            if(model<2011){
                freeSpace=lookForSpaceinParkingLot(4);
                if(freeSpace==-1){
                    message="The vehicle was not registered. There is not space in the parking lot";
                }else{
                    parkingLot.saveVehicle(freeSpace, 4, vehicle);
                }
            }else{
                switch(model){
                    case 2014:
                        freeSpace=lookForSpaceinParkingLot(0);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 0, vehicle);
                        }
                        break;
                    case 2013:
                        freeSpace=lookForSpaceinParkingLot(1);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 1, vehicle);
                        }
                        break;
                    case 2012:
                        freeSpace=lookForSpaceinParkingLot(2);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 2, vehicle);
                        }
                        break;
                    case 2011:
                        freeSpace=lookForSpaceinParkingLot(3);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 3, vehicle);
                        }
                        break;
                }
            }
        }else{
            vehicles.add(vehicle);
            message="The vehicle was registered successfully";
        }
        return message;
    }

    /**
     * It registers a new hybrid car
     * @param price The base price
     * @param brand The brand
     * @param model The year of the model
     * @param displacement The displacement  
     * @param mileage The mileage
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @param licensePlate The license plate
     * @param soat The soat
     * @param mechanicalTechnicalReview The mechanical technical review
     * @param typeOfCar The type of car
     * @param numberOfDoors The number of doors
     * @param tintedWindows True if the windows are tinted. False if they don't
     * @param tankCapacity The tank capacity
     * @param typeOfFuel The type of fuel
     * @param typeCharger The type of charger 
     * @param batteryDuration The battery duration
     * @return A message informing that the vehicle was registered 
     */
    public String registerVehicle(double price, String brand, int model, double displacement, double mileage, boolean isNew, String licensePlate, Document soat, Document mechanicalTechnicalReview, int typeOfCar, int numberOfDoors, boolean tintedWindows, double tankCapacity, int typeOfFuel, int typeCharger, double batteryDuration){
        String message;
        HybridCar vehicle=new HybridCar(price, brand, model, displacement, mileage, isNew, licensePlate, soat, mechanicalTechnicalReview, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, typeCharger, batteryDuration);
        if(saveInParkingLot(model, isNew)){
            int freeSpace;
            message="The vehicle was registered successfully in the parking lot";
            if(model<2011){
                freeSpace=lookForSpaceinParkingLot(4);
                if(freeSpace==-1){
                    message="The vehicle was not registered. There is not space in the parking lot";
                }else{
                    parkingLot.saveVehicle(freeSpace, 4, vehicle);
                }
            }else{
                switch(model){
                    case 2014:
                        freeSpace=lookForSpaceinParkingLot(0);
                        if(freeSpace==-1){
                            
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{                            
                            parkingLot.saveVehicle(freeSpace, 0, vehicle);
                        }
                        break;
                    case 2013:
                        freeSpace=lookForSpaceinParkingLot(1);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 1, vehicle);
                        }
                        break;
                    case 2012:
                        freeSpace=lookForSpaceinParkingLot(2);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 2, vehicle);
                        }
                        break;
                    case 2011:
                        freeSpace=lookForSpaceinParkingLot(3);
                        if(freeSpace==-1){
                            message="The vehicle was not registered. There is not space in the parking lot";
                        }else{
                            parkingLot.saveVehicle(freeSpace, 3, vehicle);
                        }
                        break;
                }
            }
        }else{
            vehicles.add(vehicle);
            message="The vehicle was registered successfully";
        }
        return message;
    }

    /**
     * It registers a client
     * @param name The name
     * @param lastName The last name
     * @param id The id
     * @param phoneNumber The phone number
     * @param email The email
     * @return A message informing if the client was registered
     */
    public String registerClient(String name, String lastName, int id, String phoneNumber, String email){
        String message;
        if(searchClient(id)==null){
            clients.add(new Client(name, lastName, id, phoneNumber, email));
            message="The client was registered successfully";
        }else{
            message="A client with that id is already existed";
        }
        return message;
    }

    /**
     * It registers a seller
     * @param name  The name
     * @param lastName The last name
     * @param id The id
     * @return A message informing if the seller was registered
     */
    public String registerSeller(String name, String lastName, int id){
        String message="";
        if(searchSeller(id)==null){
            boolean stop=false;
            for(int i=0; i<sellers.length && !stop; i++){
                if(sellers[i]==null){
                    sellers[i]=new Seller(name, lastName, id);
                    message="The client was registered successfully";
                    stop=true;
                }else if(i==sellers.length-1){
                    message="There is not space for a new seller";
                }
            }   
        }else{
            message="A seller with that id is already existed";
        }
        return message;
    }
    
    /**
     * It assigns a client to a seller
     * @param positionSeller The position of the seller in the array sellers
     * @param positionClient The position of the client in the ArrayList clients
     * @return A message informing if the client was assigned to the seller
     */
    public String assignClient(int positionSeller, int positionClient){
        String message="";
        boolean stop=false;
        Seller sellerInCharge=findSellerInCharge(clients.get(positionClient));
        boolean clientBussy=false; //If the client is assigned to a seller
        int quantityClient=0; //Quantity of the clients cared for the seller
        //Checks if the clients belong to another seller
        if(sellerInCharge!=null){
            clientBussy=true;
            message="This client already belongs to a seller";
        }
        for(int i=0; i<sellers[positionSeller].getClients().length && !stop; i++){
            if(sellers[positionSeller].getClients()[i]!=null){    
                quantityClient++; 
            }else{
                stop=true;
            }
        }
        if(quantityClient==Seller.CLIENTS_IN_CARE){
            message="This seller can't have more clients in care";
        }
        if(!clientBussy && quantityClient<Seller.CLIENTS_IN_CARE){
            sellers[positionSeller].assignClient(clients.get(positionClient), quantityClient);
            clients.get(positionClient).setActive(true);
            message="The client was assigned to the seller successfully";
        }
        return message;
    }

    /**
     * It adds a vehicle of interest to a client  
     * @param id The id of the client
     * @param licensePlate The license plate of the vehicle
     * @return A message informing the result
     */
    public String addVehicleOfInterest(int id, String licensePlate){
        String message="";
        Client client=searchClient(id);
        Vehicle vehicle=searchVehicle(licensePlate);
        if(vehicle!=null){
            if(client.searchVehicle(licensePlate)==null){
                client.addInterestingVehicle(vehicle);
                message="The vehicle of interest was added successfully";
            }else{
                message="This vehicle had already been added";
            }    
        }else{
            message="The vehicle with the license plate "+licensePlate+" doesn't exist"; 
        }
        return message;
    }
    /**
     * It adds a vehicle of interest to a client  
     * @param id The id of the client
     * @param vehicle The vehicle
     * @return A message informing the result
     */
    public String addVehicleOfInterest(int id, Vehicle vehicle){
        String message="";
        Client client=searchClient(id);
        if(lookForVehicle(client.getInterestingVehicles(), vehicle)){
            message="This vehicle had already been added";
        }else{
            client.addInterestingVehicle(vehicle);
            message="The vehicle of interest was added successfully";
        } 
        return message;
    }

    public String makeDiscount(double percentage, Vehicle vehicle){
        String message="The new data of the vehicle is:\n";
        double totalPrice=vehicle.getTotalPrice();
        if((vehicle.getSoat()==null || vehicle.getMechanicalTechnicalReview()==null) || (vehicle.getSoat().getYear()!=Document.CURRENT_YEAR && vehicle.getMechanicalTechnicalReview().getYear()!=Document.CURRENT_YEAR)){
            totalPrice-=500000;
        }
        totalPrice-=totalPrice*percentage;
        if((vehicle.getSoat()==null || vehicle.getMechanicalTechnicalReview()==null) || (vehicle.getSoat().getYear()!=Document.CURRENT_YEAR && vehicle.getMechanicalTechnicalReview().getYear()!=Document.CURRENT_YEAR)){
            totalPrice+=500000;
        }
        vehicle.setTotalPrice(totalPrice);
        message+=vehicle.toString();
        return message;
    }

    /**
     * It gets the new vehicles of a type of vehicle
     * @param typeVehicle The type of vehicle. Motorcycle=1. Gasoline Car=2. Electric Car=3. Hybrid Car=4. 
     * @return The new vehicles.
     */
    public ArrayList<Vehicle> getNewVehicles(int typeVehicle){
        ArrayList<Vehicle> newVehicles=new ArrayList<>();
        switch(typeVehicle){
            case 1: 
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof Motorcycle && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()){
                            newVehicles.add(vehicles.get(i));
                        }
                    }
                }       
                break;
            case 2:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof GasolineCar && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()){
                            newVehicles.add(vehicles.get(i));
                        }
                    }
                }
                break;
            case 3:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof ElecticCar && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()){
                            newVehicles.add(vehicles.get(i));
                        }
                    }
                }
                break;
            case 4:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof HybridCar && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()){
                            newVehicles.add(vehicles.get(i));
                        }
                    }
                }
                break;
        }
        return newVehicles;
    }

    /**
     * It gets the used vehicles of a type of vehicle
     * @param typeVehicle The type of vehicle. Motorcycle=1. Gasoline Car=2. Electric Car=3. Hybrid Car=4. 
     * @return The used vehicles.
     */
    public ArrayList<Vehicle> getUsedVehicles(int typeVehicle){
        ArrayList<Vehicle> usedVehicles=new ArrayList<>();
        boolean stop;
        switch(typeVehicle){
            case 1: 
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof Motorcycle && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()==false){
                            usedVehicles.add(vehicles.get(i));
                        }
                    }
                }       
                break;
            case 2:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof GasolineCar && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()==false){
                            usedVehicles.add(vehicles.get(i));
                        }
                    }
                }
                stop=false;
                for(int i=0; i<parkingLot.getVehicles().length && !stop; i++){
                    if(parkingLot.getVehicles()[i]!=null){
                        if(parkingLot.getVehicles()[i] instanceof GasolineCar && !vehicles.get(i).getSold()){
                            usedVehicles.add(parkingLot.getVehicles()[i]);
                        }
                    }
                }
                break;
            case 3:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof ElecticCar && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()==false){
                            usedVehicles.add(vehicles.get(i));
                        }
                    }
                }
                stop=false;
                for(int i=0; i<parkingLot.getVehicles().length && !stop; i++){
                    if(parkingLot.getVehicles()[i]!=null){
                        if(parkingLot.getVehicles()[i] instanceof ElecticCar && !vehicles.get(i).getSold()){
                            usedVehicles.add(parkingLot.getVehicles()[i]);
                        }
                    }
                }
                break;
            case 4:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof HybridCar && !vehicles.get(i).getSold()){
                        if(vehicles.get(i).getIsnew()==false){
                            usedVehicles.add(vehicles.get(i));
                        }
                    }
                }
                stop=false;
                for(int i=0; i<parkingLot.getVehicles().length && !stop; i++){
                    if(parkingLot.getVehicles()[i]!=null){
                        if(parkingLot.getVehicles()[i] instanceof HybridCar && !vehicles.get(i).getSold()){
                            usedVehicles.add(parkingLot.getVehicles()[i]);
                        }
                    }
                }
                break;
        }
        return usedVehicles;
    }

    /**
     * It gets all vehicles of a type of vehicle
     * @param typeVehicle The type of vehicle. Motorcycle=1. Gasoline Car=2. Electric Car=3. Hybrid Car=4. 
     * @return The vehicles.
     */
    public ArrayList<Vehicle> getAllVehicles(int typeVehicle){
        ArrayList<Vehicle> allVehicles=new ArrayList<>();
        switch(typeVehicle){
            case 1: 
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof Motorcycle && !vehicles.get(i).getSold()){
                        allVehicles.add(vehicles.get(i)); 
                    }
                }       
                break;
            case 2:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof GasolineCar && !vehicles.get(i).getSold()){
                        allVehicles.add(vehicles.get(i));
                    }
                }
                for(int i=0; i<parkingLot.getVehicles().length; i++){
                    if(parkingLot.getVehicles()[i]!=null){
                        if(parkingLot.getVehicles()[i] instanceof GasolineCar && !vehicles.get(i).getSold()){
                            allVehicles.add(parkingLot.getVehicles()[i]);
                        }
                    }
                }
                break;
            case 3:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof ElecticCar && !vehicles.get(i).getSold()){
                        allVehicles.add(vehicles.get(i));
                    }
                }
                for(int i=0; i<parkingLot.getVehicles().length; i++){
                    if(parkingLot.getVehicles()[i]!=null){
                        if(parkingLot.getVehicles()[i] instanceof ElecticCar && !vehicles.get(i).getSold()){
                            allVehicles.add(parkingLot.getVehicles()[i]);
                        }
                    }
                }
                break;
            case 4:
                for(int i=0; i<vehicles.size(); i++){
                    if(vehicles.get(i) instanceof HybridCar && !vehicles.get(i).getSold()){
                        allVehicles.add(vehicles.get(i));
                    }
                }
                for(int i=0; i<parkingLot.getVehicles().length; i++){
                    if(parkingLot.getVehicles()[i]!=null){
                        if(parkingLot.getVehicles()[i] instanceof HybridCar && !vehicles.get(i).getSold()){
                            allVehicles.add(parkingLot.getVehicles()[i]);
                        }
                    }
                }
                break;
        }
        return allVehicles;
    }
    /**
     * It looks for vehicles in the parking lot by model
     * @param model The model. model < 2015
     * @return The vehicles
     */
    public ArrayList<Vehicle> getVehiclesInParkingLot(int model){
        ArrayList<Vehicle> vehiclesParkingLot=new ArrayList<>();
        for(int i=0; i<parkingLot.getVehicles().length; i++){
            if(parkingLot.getVehicles()[i]!=null){
                if(parkingLot.getVehicles()[i].getModel()==model){
                    vehiclesParkingLot.add(parkingLot.getVehicles()[i]);
                }
            }
        }
        return vehiclesParkingLot;
    }

    public String sellVehicle(Vehicle vehicle, Client client){
        Seller seller=findSellerInCharge(client);
        String message;
        if(seller!=null){
            int totalSalesSeller=seller.getTotalSales();
            //Create soat
            Soat soat=new Soat(250000, Document.CURRENT_YEAR, 800000);
            //Create technical mechanical review
            MechanicalTechnicalReview mtr=new MechanicalTechnicalReview(250000, Document.CURRENT_YEAR, 18);
            //Create license plate
            String licensePlate="";
            for(int i=0; i<6; i++){
                if(i<3){
                    licensePlate+=(char)(int)(Math.random()*14+65);
                }else{
                    licensePlate+=(int)(Math.random()*8+1);
                }
            }
            //Update status in business and seller
            totalSales++;
            totalProfits+=vehicle.getTotalPrice();
            totalSalesSeller++;
            seller.setTotalSales(totalSalesSeller);
            setFreeClient(seller, client);
            //Update status of vehicle and client
            if(vehicle.getIsnew()){
                vehicle.setSoat(soat);
                vehicle.setMechanicalTechnicalReview(mtr);
                vehicle.setLicensePlate(licensePlate);
            }else{ 
                if(vehicle.getSoat()==null || vehicle.getSoat().getYear()!=Document.CURRENT_YEAR){
                    vehicle.setSoat(soat);
                }
                if(vehicle.getMechanicalTechnicalReview()==null || vehicle.getMechanicalTechnicalReview().getYear()!=Document.CURRENT_YEAR){
                    vehicle.setMechanicalTechnicalReview(mtr);
                }
            }
            vehicle.setOwner(client);
            vehicle.setSold(true);
            client.setActive(false);
            client.getBoughtVehicles().add(vehicle);
            //If the vehicle is in the parking lot, then the vehicle is removed
            parkingLot.removeVehicle(vehicle);
            message="The vehicle was sold";
        }else{
            message="First you have to assign this client to a seller";
        }
        
        return message;
    }

    /**
     * It searches a vehicle
     * @param licensePlate The license plate
     * @return The vehicle
     */
    public Vehicle searchVehicle(String licensePlate){
        boolean exist=false;
        Vehicle vehicle=null;
        //Search in the parking lot
        for(int i=0; i<parkingLot.getVehicles().length; i++){
            if(parkingLot.getVehicles()[i]!=null){
                if(parkingLot.getVehicles()[i].getLicensePlate().equals(licensePlate) && !parkingLot.getVehicles()[i].getSold() && !parkingLot.getVehicles()[i].getIsnew()){
                    exist=true;
                    vehicle=parkingLot.getVehicles()[i];
                }
            }
        }
        if(!exist){
            for(int i=0; i<vehicles.size() && !exist;i++){
                if(vehicles.get(i).getLicensePlate().equals(licensePlate) && !vehicles.get(i).getIsnew() && !vehicles.get(i).getSold()){
                    vehicle=vehicles.get(i);
                    exist=true;
                }
            }
        }
        return vehicle;
    }
    /**
     * It creates an object type Soat
     * @param price The price
     * @param year The year
     * @param moneyCovered The money covered for an accident to third parties
     * @return The object type Soat
     */
    public Soat createSoat(double price, int year, double moneyCovered){
        Soat soat=new Soat(price, year, moneyCovered);
        return soat;
    }

    /**
     * It creates an object type MechanicalTechnicalReview
     * @param price The price
     * @param year The year
     * @param gasLevels The gases levels
     * @return The object type MechanicalTechnicalReview
     */
    public MechanicalTechnicalReview createMTR(double price, int year, double gasLevels){
        MechanicalTechnicalReview mtr=new MechanicalTechnicalReview(price, year, gasLevels);
        return mtr;
    }
    /**
     * It checks if a car should go to the parking lot
     * @param model The model
     * @param isNew The status. True if the car is new. False if it doesn't 
     * @return True if the car should go to the praking lot. False if it shouldn't
     */
    public boolean saveInParkingLot(int model, boolean isNew){
        boolean toTheGarage=false;
        if(model<2015 && isNew==false){
            toTheGarage=true;
        }
        return toTheGarage;
    }

    /**
     * It searches a free space in a column of the parking lot
     * @param column The column
     * @return  The free space. If there are not space return -1
     */
    public int lookForSpaceinParkingLot(int column){
        int freeSpace=-1;
        boolean stop=false;
        Vehicle[][] parkinLot=this.parkingLot.getParkingLot();
        for(int i=0; i<parkinLot.length && !stop;i++){
            if(parkinLot[i][column]==null){
                freeSpace=i;
                stop=true;
            }
        }
        return freeSpace;
    }
    /**
     * It search a client with an id
     * @param id The id 
     * @return The client
     */
    public Client searchClient(int id){
        Client client=null;
        boolean stop=false;
        for(int i=0; i<clients.size() && !stop; i++){
            if(clients.get(i).getId()==id){
                client=clients.get(i);
                stop=true;
            }
        }
        return client;
    }
    /**
     * It search a seller with an id
     * @param id The id
     * @return The seller
     */
    public Seller searchSeller(int id){
        Seller seller=null;
        boolean stop=false;
        for(int i=0; i<sellers.length && !stop; i++){
            if(sellers[i]!=null){
                if(sellers[i].getId()==id){
                    seller=sellers[i];
                    stop=true;
                }
            }else{
                stop=true;
            }
            
        }
        return seller;
    }

    /**
     * It finds the seller in charge of a client
     * @param client The client
     * @return The seller
     */
    public Seller findSellerInCharge(Client client){
        Seller seller=null;
        boolean stop=false;
        for(int i=0; i<sellers.length && !stop; i++){
            if(sellers[i]!=null){
                if(sellers[i].findClient(client)){
                    seller=sellers[i];
                    stop=true;
                } 
            }else{
                stop=true;
            }
        }
        return seller;
    }

    /**
     * It sets free the client of the seller
     * @param sellerInCharge The seller in charge
     * @param client The client
     */
    public void setFreeClient(Seller sellerInCharge, Client client){
        boolean stop=false;
        for(int i=0; i<sellerInCharge.getClients().length && !stop; i++){
            if(sellerInCharge.getClients()[i]!=null){
                if(sellerInCharge.getClients()[i]==client){
                    sellerInCharge.getClients()[i]=null;
                    stop=true;
                }
            }else{
                stop=true;
            }
        }
    }

    /**
     * Look for vehicles with the brand
     * @param brand The brand
     * @return All the vehicles with that brand
     */
    public ArrayList<Vehicle> lookForVehicles(String brand){
        ArrayList<Vehicle> foundVehicles=new ArrayList<Vehicle>(); 
        for(int i=0; i<vehicles.size(); i++){
            if(vehicles.get(i).getBrand().equals(brand) && !vehicles.get(i).getSold()){
                foundVehicles.add(vehicles.get(i));
            }
        }
        //Search in the parking lot
        for(int i=0; i<parkingLot.getVehicles().length; i++){
            if(parkingLot.getVehicles()[i]!=null){
                if(parkingLot.getVehicles()[i].getBrand().equals(brand) && !parkingLot.getVehicles()[i].getSold()){
                    foundVehicles.add(parkingLot.getVehicles()[i]);
                }
            }
        }
        return foundVehicles;
    }

    /**
     * Look for vehicles with the model
     * @param model The model
     * @return All the vehicles with that model
     */
    public ArrayList<Vehicle> lookForVehicles(int model){
        ArrayList<Vehicle> foundVehicles=new ArrayList<Vehicle>(); 
        for(int i=0; i<vehicles.size(); i++){
            if(vehicles.get(i).getModel()==model && !vehicles.get(i).getSold()){
                foundVehicles.add(vehicles.get(i));
            }
        }
        //Search in the parking lot
        for(int i=0; i<parkingLot.getVehicles().length; i++){
            if(parkingLot.getVehicles()[i]!=null){
                if(parkingLot.getVehicles()[i].getModel()==model && !parkingLot.getVehicles()[i].getSold()){
                    foundVehicles.add(parkingLot.getVehicles()[i]);
                }
            }
        }
        return foundVehicles;
    }

    /**
     * Look for vehicles with the model
     * @param displacement The displacement
     * @return All the vehicles with that displacement
     */
    public ArrayList<Vehicle> lookForVehicles(double displacement){
        ArrayList<Vehicle> foundVehicles=new ArrayList<Vehicle>(); 
        for(int i=0; i<vehicles.size(); i++){
            if(vehicles.get(i).getDisplacement()==displacement && !vehicles.get(i).getSold()){
                foundVehicles.add(vehicles.get(i));
            }
        }
        //Search in the parking lot
        for(int i=0; i<parkingLot.getVehicles().length; i++){
            if(parkingLot.getVehicles()[i]!=null){
                if(parkingLot.getVehicles()[i].getDisplacement()==displacement && !parkingLot.getVehicles()[i].getSold()){
                    foundVehicles.add(parkingLot.getVehicles()[i]);
                }
            }
        }
        return foundVehicles;
    }

    /**
     * It look for a vehicle in an ArrayList type Vehicle
     * @param array The ArrayList type Vehicle
     * @param vehicle The vehicle
     * @return True if the vehicle exist. False if it doesn't
     */
    public boolean lookForVehicle(ArrayList<Vehicle> array, Vehicle vehicle){
        boolean exist=false;
        for(int i=0; i<array.size() && !exist; i++){
            if(array.get(i)==vehicle){
                exist=true;
            }
        }
        return exist;
    }
    //getters
    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @return The NIT
     */
    public String getNit() {
        return nit;
    }

    /**
     * @return The total profits
     */
    public double getTotalProfits() {
        return totalProfits;
    }

    /**
     * @return The total sales
     */
    public int getTotalSales() {
        return totalSales;
    }

    /**
     * @return The sellers
     */
    public Seller[] getSellers() {
        return sellers;
    }

    /**
     * @return The vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * @return The parking lot
     */
    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    /**
     * @return The clients
     */
    public ArrayList<Client> getClients() {
        return clients;
    }

    //setters
    /**
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param nit The NIT to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @param totalProfits The total profits to set
     */
    public void setTotalProfits(double totalProfits) {
        this.totalProfits = totalProfits;
    }

    /**
     * @param totalSales The total sales to set
     */
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * @param sellers The sellers to set
     */
    public void setSellers(Seller[] sellers) {
        this.sellers = sellers;
    }

    /**
     * @param vehicles The vehicles to set
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * @param parkingLot The parking lot to set
     */
    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    /**
     * @param clients The clients to set
     */
    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    //Quiz
    public String calculatePercentageOfUsedMotorcycles(){
        String message;
        int numberMotorcycles=0;
        int numberUsedMotorcycles=0;
        double percentageUsedMotorcycles;
        //Calculates the number of motorcycles 
        for(int i=0; i<vehicles.size(); i++){
            if(vehicles.get(i) instanceof Motorcycle){
                numberMotorcycles++;
                if(vehicles.get(i).getIsnew()==false){
                    numberUsedMotorcycles++;
                }
            }
        }
        //Calculates the percentage
        percentageUsedMotorcycles=(double)(numberUsedMotorcycles*100)/(double)numberMotorcycles;
        message="The percentage of used motorcycles is "+percentageUsedMotorcycles+"%";
        return message;
    }

    public String getClientsActiveWithoutSeller(){
        String message;
        boolean stop=false;
        boolean clientWithSeller=false;
        ArrayList<Client> activeClientsWithoutSeller=new ArrayList<>();
        //Search if each client has a seller
        for(int i=0; i<clients.size(); i++){
            if(clients.get(i).getActive()==true){
                for(int j=0; j<sellers.length && !stop; j++){
                    if(sellers[i]!=null){
                        if(sellers[i].findClient(clients.get(i))){
                            clientWithSeller=true;
                            stop=true;
                        }
                    }else{
                        stop=true;
                    }   
                }
                if(clientWithSeller==false){
                    activeClientsWithoutSeller.add(clients.get(i));
                }
            } 
        }
        message="The clients withour sellers are:\n";
        for(int i=0; i<activeClientsWithoutSeller.size(); i++){
            if(activeClientsWithoutSeller.size()==0){
                message+="Nobody";
            }else{
                message+="Id:"+activeClientsWithoutSeller.get(i).getId()+"\n Name:"+activeClientsWithoutSeller.get(i).getName()+"\n";
            }
        }
        return message;
    }
}