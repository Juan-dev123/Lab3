package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Business;

public class Main{
    
    //Relations 
    private Business business;
    private Scanner read;
    
    //Methods
    public static void main(String[] args){
        Main objMain=new Main();
        objMain.menu();
    }
    /**
     * It initializes the scanner and the business
     */
    public Main(){
        read=new Scanner(System.in);
        business=new Business("Dealer Company", "123.456.789-1");
    }
    /**
     * It prints on screen the menu
     */
    public void menu(){
        int option;
        boolean stop=false;
        char answer;
        do{
            System.out.println("What do you want to do?");
            System.out.println("1 Register a vehicle");
            System.out.println("2 Register a client");
            System.out.println("3 Register a seller");
            System.out.println("4 Assign a client to a seller");
            System.out.println("5 Assign vehicles of interest to a client");
            System.out.println("6 Show the vehicles of interest of a client");
            option=read.nextInt();
            read.nextLine();
            clean();
            switch(option){
            case 1:
                registerVehicle();
                break;
            case 2:
                registerClient();
                break;
            case 3:
                registerSeller();
                break;
            case 4:
                assignClient();
                break;
            case 5:
                addVehicleOfInterest();
                break;
            case 6:
                showVehiclesOfInterest();
                break;
            default:
                System.out.println("That option doesn't exist");
                read.nextLine();
                break;    
            }
            System.out.println("Do you want to execute the menu again?");
            do{
                System.out.print("Y/N:");
                answer=read.nextLine().toUpperCase().charAt(0);
            }while(answer!='N' && answer!='Y');
            if(answer=='N'){
                stop=true;
            }
            clean();
        }while(!stop);
        
    }
    /**
     * It registers a vehicle
     */
    public void registerVehicle(){  
        double price;
        String brand;
        int model;
        double displacement;
        double mileage;
        boolean isNew;
        char answer;
        String licensePlate="";
        double priceS=0;
        double priceM=0;
        int yearS=0;
        int yearM=0;
        double moneyCovered=0;
        double gasLevels=0;
        boolean uniqueLicensePlate=true;
        
        System.out.println("Please give this information about the vehicle");
        price=checkDouble("Enter the price", 1);
        read.nextLine();
        System.out.println("Enter the brand");
        brand=read.nextLine().toUpperCase();
        model=checkInt("Enter the model", 1950);
        displacement=checkDouble("Enter the displacement", 1);
        mileage=checkDouble("Enter the mileage", 1);
        read.nextLine();
        do{
            System.out.println("Is the vehicle new? Y/N");
            answer=read.nextLine().toUpperCase().charAt(0);
        }while(answer!='Y' && answer!='N');
        if(answer=='Y'){
            isNew=true;
        }else{
            isNew=false;
        }
        if(isNew==false){
            System.out.println("Enter the license plate");
            licensePlate=read.nextLine().toUpperCase();
            uniqueLicensePlate=enterLicensePlate(licensePlate);
            if(uniqueLicensePlate){
                clean();
                //soat
                System.out.println("Please give this information about the soat");
                priceS=checkDouble("What is the price?", 1);
                yearS=checkInt("What is the year?", 1984);
                moneyCovered=checkDouble("What is the money that cover an accident to third parties", 1);
                clean();
                //mechanical technical review
                System.out.println("Please give this information about the mechanical technical review");
                priceM=checkDouble("What is the price?", 1);
                yearM=checkInt("What is the year?", 1950);
                gasLevels=checkDouble("What were the gases levels?", 1);
            }    
        }
        clean();
        if(uniqueLicensePlate){
            System.out.println("What do you want to register?");
            System.out.println("1 Car");
            System.out.println("2 Motorcycle");
            int option=read.nextInt();
            clean();
            switch(option){
                case 1:
                    int typeOfCar;
                    int numberOfDoors;
                    boolean tintedWindows;
                    double tankCapacity;
                    int typeOfFuel;
                    
                    int typeCharger;
                    double batteryDuration;
                    do{
                        System.out.println("Enter the type of car");
                        System.out.println("1 Sedan");
                        System.out.println("2 Van");
                        typeOfCar=read.nextInt();
                    }while(typeOfCar>2 || typeOfCar<1);
                    numberOfDoors=checkInt("What is the number of doors", 1);
                    read.nextLine();
                    do{
                        System.out.println("Are the windows of the car tinted? Y/N");
                        answer=read.nextLine().toUpperCase().charAt(0);
                    }while(answer!='Y' && answer!='N');
                    if(answer=='Y'){
                        tintedWindows=true;
                    }else{
                        tintedWindows=false;
                    }
                    do{
                        System.out.println("Enter the type of the car");
                        System.out.println("1 Gasoline");
                        System.out.println("2 Electric");
                        System.out.println("3 Hybrid");
                        option=read.nextInt();
                    }while(option>3 || option<1);
                    switch(option){
                        case 1:
                            
                            tankCapacity=checkDouble("What is the tank capacity?", 1);
                            do{
                                System.out.println("What is the type of fuel");
                                System.out.println("1 Extra");
                                System.out.println("2 Corriente");
                                System.out.println("3 Diesel");
                                typeOfFuel=read.nextInt();
                            }while(typeOfFuel>3 || typeOfFuel<1);
                            if(isNew==true){
                                System.out.println(business.registerVehicle(price, brand, model, displacement, mileage, isNew, "", null, null, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel));
                            }else{
                                System.out.println(business.registerVehicle(price, brand, model, displacement, mileage, isNew, licensePlate, business.createSoat(priceS, yearS, moneyCovered), business.createMTR(priceM, yearM, gasLevels), typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel));
                            }
                            break;
                        case 2:
                            do{
                                System.out.println("What is the type of charger");
                                System.out.println("1 Normal");
                                System.out.println("2 Fast");
                                typeCharger=read.nextInt();
                            }while(typeCharger>2 || typeCharger<1);
                            batteryDuration=checkDouble("Enter the baterry duration", 1);
                            if(isNew==true){
                                System.out.println(business.registerVehicle(price, brand, model, displacement,mileage, isNew, licensePlate, null, null, typeOfCar, numberOfDoors, tintedWindows, typeCharger, batteryDuration));
                            }else{
                                System.out.println(business.registerVehicle(price, brand, model, displacement,mileage, isNew, licensePlate, business.createSoat(priceS, yearS, moneyCovered), business.createMTR(priceM, yearM, gasLevels), typeOfCar, numberOfDoors, tintedWindows, typeCharger, batteryDuration));
                            }
                            break;
                        case 3:
                            tankCapacity=checkDouble("What is the tank capacity?", 1);
                            do{
                                System.out.println("What is the type of fuel");
                                System.out.println("1 Extra");
                                System.out.println("2 Corriente");
                                System.out.println("3 Diesel");
                                typeOfFuel=read.nextInt();
                            }while(typeOfFuel>3 || typeOfFuel<1);
                            do{
                                System.out.println("What is the type of charger");
                                System.out.println("1 Normal");
                                System.out.println("2 Fast");
                                typeCharger=read.nextInt();
                            }while(typeCharger>2 || typeCharger<1);
                            batteryDuration=checkDouble("Enter the baterry duration", 1);
                            if(isNew==true){
                                System.out.println(business.registerVehicle(price, brand, model, displacement, mileage, isNew, licensePlate, null, null, typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, typeCharger, batteryDuration));
                            }else{
                                System.out.println(business.registerVehicle(price, brand, model, displacement, mileage, isNew, licensePlate, business.createSoat(priceS, yearS, moneyCovered), business.createMTR(priceM, yearM, gasLevels), typeOfCar, numberOfDoors, tintedWindows, tankCapacity, typeOfFuel, typeCharger, batteryDuration));
                            }
                            break;
                        default:
                            System.out.println("That option doesn't exist");
                            break;
                        }
                    break;
                case 2:
                    int type;
                    double gasolineCapacity;
                    do{
                        System.out.println("Enter the type of motorcycle");
                        System.out.println("1 Standard");
                        System.out.println("2 Sporty");
                        System.out.println("3 Scooter");
                        System.out.println("4 Cross");
                        type=read.nextInt();
                    }while(type>4 || type<1);
                    gasolineCapacity=checkDouble("Enter the gasoline capacity", 1);
                    if(isNew==true){
                        System.out.println(business.registerVehicle(price, brand, model, displacement, mileage, isNew, licensePlate, null, null, type, gasolineCapacity));
                    }else{
                        System.out.println(business.registerVehicle(price, brand, model, displacement, mileage, isNew, licensePlate, business.createSoat(priceS, yearS, moneyCovered), business.createMTR(priceM, yearM, gasLevels), type, gasolineCapacity));
                    }               
                    break;
                default:
                    System.out.println("That option doesn't exist");
                    break;
            }
            read.nextLine();
        }   
    }

    /**
     * It registers a client
     */
    public void registerClient(){
        System.out.println("Enter the name");
        String name=read.nextLine();
        System.out.println("Enter the last name");
        String lastName=read.nextLine();
        int id=checkInt("Enter the id", 1);
        System.out.println("Enter the phone number");
        read.nextLine();
        String phoneNumber=read.nextLine();
        System.out.println("Enter the email");
        String email=read.nextLine();
        System.out.println(business.registerClient(name, lastName, id, phoneNumber, email));
    }

    /**
     * It register a seller
     */
    public void registerSeller(){
        System.out.println("Enter the name");
        String name=read.nextLine();
        System.out.println("Enter the last name");
        String lastName=read.nextLine();
        int id=checkInt("Enter the id", 1);
        read.nextLine();
        System.out.println(business.registerSeller(name, lastName, id));
    }

    /**
     * It assigns a client to a seller
     */
    public void assignClient(){
        int positionClient=0;
        int positionSeller=0;
        int numberClients;
        int numberSellers=0;
        boolean stop;
        if(business.getClients().size()==0){
            System.out.println("There are not clients");
        }else{
            do{
                System.out.println("Choose a client");
                numberClients=printClients();
                positionClient=read.nextInt();
            }while(positionClient<1 || positionClient>numberClients);
            if(business.getSellers().length==0){
                System.out.println("There are not sellers");
            }else{
                do{
                    System.out.println("Choose a seller");
                    stop=false;
                    for(int i=0; i<business.getSellers().length && !stop; i++){
                        if(business.getSellers()[i]!=null){
                            System.out.printf("%d Name:%s %s%n  Id:%d%n",i+1,business.getSellers()[i].getName(), business.getSellers()[i].getLastName(), business.getSellers()[i].getId());
                        }else{
                            stop=true;
                            numberSellers=i;
                        }    
                    }
                    positionSeller=read.nextInt();
                }while(positionSeller<1 || positionSeller>numberSellers);
                System.out.println(business.assignClient(positionSeller-1, positionClient-1));
                read.nextLine(); 
            } 
        }   
    }

    /**
     * It adds a vehicle of interest to a client 
     */
    public void addVehicleOfInterest(){
        int id;
        int option;
        int numberVehicles;
        int positionVehicle=0;
        boolean stop=false;
        do{
            id=checkInt("Please enter the id of the client", 1);
            read.nextLine();
        }while(business.searchClient(id)==null);
        System.out.println("With what do you want to search for the vehicle?");
        System.out.println("1 License plate");
        System.out.println("2 Brand");
        System.out.println("3 Model");
        System.out.println("4 Displacement");
        option=read.nextInt();
        read.nextLine();
        switch(option){
            case 1:
                String licensePlate;
                System.out.println("Enter the license plate");
                licensePlate=read.nextLine().toUpperCase();
                System.out.println(business.addVehicleOfInterest(id, licensePlate));
                
                break;
            case 2:
                String brand;
                System.out.println("Enter the brand");
                brand=read.nextLine().toUpperCase();
                do{
                    clean();
                    System.out.println("Choose a vehicle");
                    numberVehicles=printVehicles(business.lookForVehicles(brand));
                    if(numberVehicles==0){
                        stop=true;
                    }else{
                        positionVehicle=read.nextInt();
                    }
                }while((positionVehicle<1 || positionVehicle>numberVehicles) && !stop);
                if(stop==false){
                    System.out.println(business.addVehicleOfInterest(id, business.lookForVehicles(brand).get(positionVehicle-1)));
                    read.nextLine();
                }
                break;
            case 3:
                int model;
                model=checkInt("Enter the model", 1950);
                do{
                    clean();
                    System.out.println("Choose a vehicle");
                    numberVehicles=printVehicles(business.lookForVehicles(model));
                    if(numberVehicles==0){
                        stop=true;
                    }else{
                        positionVehicle=read.nextInt();
                    }
                }while((positionVehicle<1 || positionVehicle>numberVehicles) && !stop);
                if(stop==false){
                    System.out.println(business.addVehicleOfInterest(id, business.lookForVehicles(model).get(positionVehicle-1)));  
                }
                read.nextLine();
                break;
            case 4:
                double displacement;
                displacement=checkDouble("Enter the displacement", 1);
                do{
                    clean();
                    System.out.println("Choose a vehicle");
                    numberVehicles=printVehicles(business.lookForVehicles(displacement));
                    if(numberVehicles==0){
                        stop=true;
                    }else{
                        positionVehicle=read.nextInt();
                    }
                }while((positionVehicle<1 || positionVehicle>numberVehicles) && !stop);
                if(stop==false){
                    System.out.println(business.addVehicleOfInterest(id, business.lookForVehicles(displacement).get(positionVehicle-1)));    
                }
                read.nextLine();
                break;
            default:
                System.out.println("That option doesn't exist");
                break;
        }
          
    }

    public void showVehiclesOfInterest(){
        int id;
        do{
            id=checkInt("Please enter the id of the client", 1);
            read.nextLine();
        }while(business.searchClient(id)==null);
        printVehicles(business.searchClient(id).getInterestingVehicles());
    }

    /**
     * It checks if a license plate is already existed
     * @param licensePlate The license plate
     * @return True if the license plate is unique. False if it isn't
     */
    public boolean enterLicensePlate(String licensePlate){
        int option;
        boolean uniqueLicensePlate=true;
        if(business.searchVehicle(licensePlate)!=null){
                System.out.println("That license plate is already exists. You have two change it or quit");
                System.out.println("What do you want to do?");
               do{
                    System.out.println("1 Change it");
                    System.out.println("2 Quit");
                    option=read.nextInt();
                    read.nextLine();
                }while(option!=1 && option!=2);
                if(option==1){
                    System.out.println("Enter the license plate");
                    licensePlate=read.nextLine().toUpperCase();
                    uniqueLicensePlate=enterLicensePlate(licensePlate);
                }else{
                    uniqueLicensePlate=false;
                }         
        }
        return uniqueLicensePlate;
    }

    /**
     * It checks that the valid information is saved.
     * @param message The message that will print on the screen
     * @param minumum The minimum value
     * @return  The validated information
     */
    public double checkDouble(String message, int minumum){
        double variable;
        do{
            System.out.println(message);
            variable=read.nextDouble();
        }while(variable<minumum);
        return variable;
    }
    
    /**
     * It checks that the valid information is saved.
     * @param message The message that will print on the screen
     * @param minumum The minimum value
     * @return  The validated information
     */
    public int checkInt(String message, int minumum){
        int variable;
        do{
            System.out.println(message);
            variable=read.nextInt();
        }while(variable<minumum);
        return variable;
    }

    /**
     * It prints on screen all the clients registered in the business
     * @return The number of clients
     */
    public int printClients(){
        int numberClients=business.getClients().size();
        for(int i=0; i<business.getClients().size(); i++){
            System.out.printf("%d Name:%s %s%n  Id:%d%n",i+1,business.getClients().get(i).getName(), business.getClients().get(i).getLastName(), business.getClients().get(i).getId());
        }
        return numberClients;
    }

    public int printVehicles(ArrayList vehicles){
        int numberVehicles=vehicles.size();
        if(vehicles.size()==0){
            System.out.println("There are not vehicles");
        }else{
            for(int i=0; i<vehicles.size(); i++){
                System.out.printf("%d   %s%n",i+1,vehicles.get(i).toString());
            }
        }
        return numberVehicles;
    }

    /**
	 * Cleans the screen of the console
	 */
	public void clean(){
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
        }
	}
}
