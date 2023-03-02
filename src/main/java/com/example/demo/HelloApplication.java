package com.example.demo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
import java.io.File;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("firstMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400 );
//        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception{
        launch();
        Menu input = new Menu();
        AdminCont.saveAdmin();
        input.firstMenu();
    }
}
// -----------------------PROJECT------------------------
// ******************************************************
abstract class Accounts implements Serializable {

    private String login_name;
    private String password;
    private String name;
    private String email;
    private String addressnum;
    private double credit;

    // *************************CONST***********************
    public Accounts(String name, String login_name, String password, String email, String addressnum, double credit) {
        this.setName(name);
        this.setLoginName(login_name);
        this.setPassword(password);
        this.setEmail(email);
        this.setPhNumber(addressnum);
        this.setCredit(credit);
    }

    // ******************SETER & GETERS******************
    public void setLoginName(String login_name) {

        this.login_name = login_name;
    }

    // ***
    public String getLoginName() {

        return login_name;
    }

    // -------------------
    public void setName(String name) {

        this.name = name;
    }

    // ***
    public String getName() {

        return name;
    }

    // -------------------
    public void setPassword(String password) {

        this.password = password;
    }

    // ***
    public String getPassword() {

        return password;
    }

    // -------------------
    public void setPhNumber(String addressnum) {

        this.addressnum = addressnum;
    }

    // ***
    public String getPhNumber() {

        return addressnum;
    }

    // -------------------
    public void setCredit(double credit) {

        this.credit = credit;
    }

    // ***
    public double getCredit() {

        return credit;
    }

    // -------------------
    public void setEmail(String email) {

        this.email = email;
    }

    // ***
    public String getEmail() {

        return email;
    }
    // -------------------
}
// ************CUSTOMER
class Customer extends Accounts implements Serializable {

    // ---------------------------
    static int customerindex;
    static double paid1;
    static ArrayList<Customer> information = new ArrayList<Customer>();
    static ArrayList<Product> buypack = new ArrayList<Product>();
    static ArrayList<Product> pastbuys = new ArrayList<Product>();
    private ArrayList<BuyFactor> bought = new ArrayList<BuyFactor>();



    public Customer(String name, String login_name, String password, String email, String addressnum, double credit) {

        super(name, login_name, password, email, addressnum, Double.parseDouble(String.valueOf(credit)));



    }

    // ---------------------------
    public ArrayList<Product> getBuyPack() {
        return buypack;
    }

    // ---------------------------
    public ArrayList<Product> getPastBuys() {
        return pastbuys;
    }

    // ---------------------------
    public void setBuyPack(ArrayList<Product> buypack) {

        this.buypack = buypack;
    }

    // ---------------------------
    public void setPastBuys(ArrayList<Product> pastbuys) {

        this.pastbuys = pastbuys;
    }

    // ---------------------------
    public void setInformation(ArrayList<Customer> information) {

        Customer.information = information;
    }

    // ---------------------------
    public ArrayList<Customer> getInformation() {
        return information;
    }

    // ---------------------------
    public ArrayList<BuyFactor> getBought() {

        return bought;

    }

    // ***
    public void setBought(ArrayList<BuyFactor> bought) {

        this.bought = bought;
    }
    // ----------------------------

}
// ***************ADMIN
class Admin extends Accounts implements Serializable {

    ArrayList<String> Category;

    // ---------------------------
    public Admin(String name, String login_name, String password, String email, String addressnum, double credit) {
        super(name, login_name, password, email, addressnum, credit);

    }

    // --------------------------
    public ArrayList<String> getCategory() {
        return Category;
    }

    // ---------------------------
    public void setCategory(ArrayList<String> Category) {


        this.Category = Category;
    }

    // ---------------------------


}
// ****************SELLER
class Seller extends Accounts  implements Serializable{

    static int sellerindex;
    private String coInfo;
    private ArrayList<Product> pastsells = new ArrayList<Product>();
    private ArrayList<Product> product = new ArrayList<Product>();
    private ArrayList<Product> requestpro = new ArrayList<Product>();
    static ArrayList<Seller> sellerInformation = new ArrayList<Seller>();

    // ---------------request to add product----------------
    static  ArrayList<Laptop> saddprolap = new ArrayList<Laptop>();
    static  ArrayList<Mobile> saddpromob = new ArrayList<Mobile>();
    static  ArrayList<Refrigerator> saddproref = new ArrayList<Refrigerator>();
    static  ArrayList<Tv> saddtv = new ArrayList<Tv>();
    static  ArrayList<Oven> saddoven = new ArrayList<Oven>();
    static  ArrayList<Dress> sadddress = new ArrayList<Dress>();
    static  ArrayList<Shoes> saddshoes = new ArrayList<Shoes>();
    static ArrayList<Meal> saddmeal = new ArrayList<Meal>();


    // -------------------
    public Seller(String name, String login_name, String password, String email, String addressnum, double credit,
                  String coInfo) {
        super(name, login_name, password, email, addressnum, credit);
        this.setPastSells(pastsells);
        this.setProduct(product);
        this.coInfo = coInfo;

    }

    // ----------SET & GET---------------
    public void setCoInfo(String coInfo) {

        this.coInfo = coInfo;
    }

    // ***
    public String getCoInfo() {

        return coInfo;
    }

    // --------------------------
    public ArrayList<Product> getProduct() {
        return product;
    }

    // ***
    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }

    // --------------------------
    public ArrayList<Product> getPastSelles() {
        return pastsells;
    }

    // ***
    public void setPastSells(ArrayList<Product> pastsells) {
        this.pastsells = pastsells;
    }

    //----------------------------
    public void setReqProduct(ArrayList<Product> requestpto) {
        this.requestpro = requestpro;
    }

    // ***
    public ArrayList<Product> getReqProduct() {
        return requestpro;
    }

}
// --------------------------
class BuyFactor implements Serializable {
    private int id;
    private String date;
    private double paid;
    private String seller_name;
    private boolean arrive;
    int lastId = 0;
    static ArrayList<BuyFactor> bill = new ArrayList<BuyFactor>();


    public BuyFactor() {
        this.setId(id);
        this.setDate(date);
        this.setPaid(paid);
        this.setSellerName(seller_name);
        this.setArrive(arrive);
    }

    // -------------------
    public void setId(int id) {

        this.id = lastId++;
    }

    // ***
    public int getId() {

        return id;
    }

    // -------------------
    public void setDate(String date) {

        this.date = "1400/01/21";
    }

    // ***
    public String getDate() {

        return date;
    }

    // -------------------
    public void setPaid(double paid) {

        this.paid =  Customer.information.get(Customer.customerindex).paid1;

    }

    // ***
    public double getPaid() {

        return paid;
    }

    // -------------------
    public void setSellerName(String seller_name) {

        this.seller_name = Seller.sellerInformation.get(Seller.sellerindex).getName();
    }

    // ***
    public String getSellerName() {

        return seller_name;
    }

    // -------------------
    public void setArrive(boolean arrive) {

        this.arrive = false;
    }

    // ***
    public boolean getArrive() {

        return arrive;
    }
    // -------------------
}
// --------------------------
class SellFactor implements Serializable {
    private int id;
    int lastId = 0;
    private String date;
    private double received;
    private String customer_name;
    private boolean arrive;
    static ArrayList<SellFactor> bought = new ArrayList<SellFactor>();

    // ------------
    public SellFactor() {
        this.setId(id);
        this.setDate(date);
        this.setReceived(received);
        this.setCustomerName(customer_name);
        this.setArrive(arrive);
        this.setBought(bought);
    }

    // -------------------
    public void setId(int id) {

        this.id = lastId++;
    }

    // ***
    public int getId() {

        return id;
    }

    // -------------------
    public void setDate(String date) {

        this.date = "1400/01/21";
    }

    // ***
    public String getDate() {

        return date;
    }

    // -------------------
    public void setReceived(double received) {

        this.received = Customer.information.get(Customer.customerindex).paid1;
    }

    // ***
    public double getReceived() {

        return received;
    }

    // -------------------
    public void setCustomerName(String customer_name) {

        this.customer_name = Customer.information.get(Customer.customerindex).getName();
    }

    // ***
    public String getCustomerName() {

        return customer_name;
    }

    // -------------------
    public void setArrive(boolean arrive) {

        this.arrive = false;
    }

    // ***
    public boolean getArrive() {

        return arrive;
    }

    // -------------------
    public ArrayList<SellFactor> getBought() {
        return bought;
    }

    // ***
    public void setBought(ArrayList<SellFactor> bought) {

        this.bought = bought;
    }
    // -------------------
}
// -----------------------PRODUCT-----------------------
class Category implements Serializable{
    private ArrayList<String> products;
    String extra;
    String name;

    // ******
    public Category(String name, String extra) {
        this.setName(name);
        this.setExtra(extra);
        this.setProducts(products);
        ArrayList<String> products = new ArrayList<String>();
    }

    // -------------------
    public void setName(String name) {

        this.name = name;
    }

    // ***
    public String getName() {

        return name;
    }

    // -------------------
    public void setExtra(String extra) {

        this.extra = extra;
    }

    // ***
    public String getExtra() {

        return extra;
    }

    // -------------------
    public ArrayList<String> getProducts() {
        return products;
    }

    // ***
    public void setProducts(ArrayList<String> products) {

        this.products = products;
    }
    // ------------------
}
// --------------------------
class Product implements Comparable, Serializable {
    private String name;
    private int id;
    private String company;
    private double price;
    private String condition;
    private String description;
    private double ave_rate;
    private String Sname;
    private ArrayList<String> comments;
    static int editIndex;

    // ----------
    public Product(String name, int id, String company, double price, String condition, String description,
                   double ave_rate , String Sname) {
        this.setName(name);
        this.setId(id);
        this.setCompany(company);
        this.setPrice(price);
        this.setCondition(condition);
        this.setDescription(description);
        this.setAve_rate(ave_rate);
        this.setSname(Sname);
    }

    // -------------------------------
    public void setSname(String Sname) {

        this.Sname = Sname;
    }

    // ***
    public String getSname() {

        return Sname;
    }
    // -------------------------------
    public void setName(String name) {

        this.name = name;
    }

    // ***
    public String getName() {

        return name;
    }

    // -------------------
    public int getId() {
        return id;
    }

    // ****
    public void setId(int id) {
        this.id = id;
    }

    // -------------------------------
    public String getCompany() {
        return company;
    }

    // ****
    public void setCompany(String company) {
        this.company = company;
    }

    // -------------------------------
    public double getPrice() {
        return price;
    }

    // ***
    public void setPrice(double price) {
        this.price = price;
    }

    // -------------------------------
    public String getCondition() {
        return condition;
    }

    // ***
    public void setCondition(String condition) {
        this.condition = condition;
    }

    // -------------------------------
    public String getDescription() {
        return description;
    }

    // ****
    public void setDescription(String description) {
        this.description = description;
    }
    // -------------------------------

    public double getAve_rate() {
        return ave_rate;
    }

    // ***
    public void setAve_rate(double ave_rate) {
        this.ave_rate = ave_rate;
    }

    // -------------------------------
    public ArrayList<String> getComments() {
        return comments;
    }

    // ***
    public void setComments(ArrayList<String> comments) {

        this.comments = comments;
    }
    // -------------------------------


    public int compareTo(Object obj){
        Product pr = (Product) obj;

        int comp = this.name.compareTo(pr.getName());
        if(comp > 0)
            return 1;
        else if (comp < 0) return -1;
        else
        {
            if (this.ave_rate > pr.getAve_rate())
                return 1;
            else if (this.ave_rate < pr.getAve_rate())
                return -1;
            else
            {
                if (this.price > pr.getPrice())
                    return 1;
                else if (this.price < pr.getPrice())
                    return -1;
                else {
                    if(this.condition.equals("true")){
                        return 1;
                    }
                    else return -1;
                }
            }
        }

    }


}
// --------------------------
abstract class Digital extends Product  implements Comparable, Serializable{

    private int capacity;
    private int ram;
    private String os;
    private double weight;
    private String dimensions;
    // ---------------

    public Digital(String name, int id, String company, double price, String condition, String description,
                   double ave_rate,String Sname) {
        super(name, id, company, price, condition, description, ave_rate , Sname);
        this.setCapacity(capacity);
        this.setRam(ram);
        this.setOs(os);
        this.setWeight(weight);
        this.setDimensions(dimensions);
    }

    // -------------------------------
    public int getCapacity() {
        return capacity;
    }

    // ****
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // -------------------------------
    public int getRam() {
        return ram;
    }

    // ****
    public void setRam(int ram) {
        this.ram = ram;
    }

    // -------------------------------
    public String getOs() {
        return os;
    }

    // ****
    public void setOs(String os) {
        this.os = os;
    }

    // -------------------------------
    public double getWeight() {
        return weight;
    }

    // ****
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // -------------------------------
    public String getDimension() {
        return dimensions;
    }

    // ****
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
    // -------------------------------
    public int compareTo(Object obj){
        Digital pr = (Digital) obj;

        int comp = this.os.compareTo(pr.getOs());
        if(comp > 0)
            return 1;
        else if (comp < 0) return -1;
        else
        {
            if (this.ram > pr.getRam())
                return 1;
            else if (this.ram < pr.getRam())
                return -1;
            else
            {
                if (this.capacity > pr.getCapacity())
                    return 1;
                else if (this.capacity < pr.getCapacity())
                    return -1;
            }
        }
        return 0;
    }

}
// *********
class Mobile extends Digital implements Serializable {
    private int simcard;
    private int camera_mp;

    // -----------
    public Mobile(String name, int id, String company, double price, String condition, String description,
                  double ave_rate,String Sname, int simcard, int camera_mp) {
        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setSim(simcard);
        this.setCam(camera_mp);
    }

    // -------------------------------
    public int getSim() {
        return simcard;
    }

    // ****
    public void setSim(int simcard) {
        this.simcard = simcard;
    }

    // -------------------------------
    public int getCam() {
        return camera_mp;
    }

    // ****
    public void setCam(int camera_mp) {
        this.camera_mp = camera_mp;
    }
    // -------------------------------
}
// *********
class Laptop extends Digital implements Serializable{


    public Laptop(String name, int id, String company, double price, String condition, String description,
                  double ave_rate,String Sname, String cpu, boolean gaming) {

        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setCpu(cpu);
        this.setGaming(gaming);

    }

    private String cpu;
    private boolean gaming;

    // -------
    public void setCpu(String cpu) {

        this.cpu = cpu;
    }

    // ***
    public String getCpu() {

        return cpu;
    }

    // -------------------
    public void setGaming(boolean gaming) {

        this.gaming = gaming;
    }

    // ***
    public boolean getGaming() {

        return gaming;
    }
    // -------------------

}
// --------------------------
abstract class Clothing extends Product implements Comparable, Serializable{
    private String country;
    private String material;

    // ------------
    public Clothing(String name, int id, String company, double price, String condition, String description,
                    double ave_rate,String Sname) {

        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setCountry(country);
        this.setMaterial(material);
    }

    // -------------------------------
    public String getCountry() {
        return country;
    }

    // ****
    public void setCountry(String country) {
        this.country = country;
    }

    // -------------------------------
    public String getMaterial() {
        return material;
    }

    // ****
    public void setMaterial(String material) {
        this.material = material;
    }
    // -------------------------------
    public int compareTo(Object obj){
        Clothing pr = (Clothing) obj;

        int comp = this.country.compareTo(pr.getCountry());
        if(comp > 0)
            return 1;
        else if (comp < 0) return -1;
        else
        {

            int comp2 = this.country.compareTo(pr.getCountry());
            if(comp2 > 0)
                return 1;
            else if (comp2 < 0)
                return -1;
        }
        return 0;
    }

}
// *********
class Dress extends Clothing implements Serializable{
    private int size;

    enum Model {
        Tshirt, Pants, Jacket, Hat
    }

    private Model model;

    public Dress(String name, int id, String company, double price, String condition, String description,
                 double ave_rate,String Sname, int size, Model model) {

        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setSize(size);
        this.setModel(model);

    }

    // -------------------
    public void setSize(int size) {

        this.size = size;
    }

    // ***
    public int getSize() {

        return size;
    }

    // -------------------
    public void setModel(Model model) {

        this.model = model;
    }

    // ***
    public Model getModel() {

        return model;
    }
    // -------------------

}
// *********
class Shoes extends Clothing implements Serializable{
    private int footsize;

    enum Type {
        Sport, Party, Hiking
    }

    private Type type;

    // -------
    public Shoes(String name, int id, String company, double price, String condition, String description,
                 double ave_rate,String Sname, int footsize, Type type) {

        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setFootSize(footsize);
        this.setType(type);

    }

    // -------------------
    public void setFootSize(int footsize) {

        this.footsize = footsize;
    }

    // ***
    public int getFootSize() {

        return footsize;
    }

    // -------------------
    public void setType(Type type) {

        this.type = type;
    }

    // ***
    public Type getType() {

        return type;
    }
    // -------------------

}
// --------------------------
abstract class House extends Product implements Serializable{

    private String energy_e;
    private boolean guaranty;

    // ------------------
    public House(String name, int id, String company, double price, String condition, String description,
                 double ave_rate,String Sname) {
        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setEnergy(energy_e);
        this.setGuaranty(guaranty);

    }

    // -------------------
    public void setEnergy(String energy_e) {

        this.energy_e = energy_e;
    }

    // ***
    public String getEnergy() {

        return energy_e;
    }

    // -------------------
    public void setGuaranty(boolean guaranty) {

        this.guaranty = guaranty;
    }

    // ***
    public boolean getGuaranty() {

        return guaranty;
    }
    // -------------------
    public int compareTo(Object obj){
        House pr = (House) obj;

        int comp = this.energy_e.compareTo(pr.getEnergy());
        if(comp > 0)
            return 1;
        else if (comp < 0) return -1;
        else
            return 0;
    }

}
// *********
class Tv extends House implements Serializable{
    private String quality;
    private int inches;

    public Tv(String name, int id, String company, double price, String condition, String description, double ave_rate,String Sname,
              String quality, int inches) {
        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setQuality(quality);
        this.setInches(inches);

    }

    // -------
    public void setQuality(String quality) {

        this.quality = quality;
    }

    // ***
    public String getQuality() {

        return quality;
    }

    // -------------------
    public void setInches(int inches) {

        this.inches = inches;
    }

    // ***
    public int getInches() {

        return inches;
    }
    // ------------------

}
// *********
class Refrigerator extends House implements Serializable{

    private int litre;
    private String doortype;
    private boolean freezer;

    // -------------------
    public Refrigerator(String name, int id, String company, double price, String condition, String description,
                        double ave_rate,String Sname, int litre, String doortype, boolean freezer) {

        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setLitre(litre);
        this.setDoor(doortype);
        this.setFreezer(freezer);

    }

    // -------
    public void setDoor(String doortype) {

        this.doortype = doortype;
    }

    // ***
    public String getDoor() {

        return doortype;
    }

    // -------------------
    public void setLitre(int litre) {

        this.litre = litre;
    }

    // ***
    public int getLitre() {

        return litre;
    }

    // ------------------
    public void setFreezer(boolean freezer) {

        this.freezer = freezer;
    }

    // ***
    public boolean getFreezer() {

        return freezer;
    }

}
// *********
class Oven extends House implements Serializable{

    public Oven(String name, int id, String company, double price, String condition, String description,
                double ave_rate,String Sname, int firecount, String body, boolean microwave) {

        super(name, id, company, price, condition, description, ave_rate, Sname);
        this.setFireCount(firecount);
        this.setBody(body);
        this.setMicro(microwave);

    }

    private int firecount;
    private String body;
    private boolean microwave;

    // -------------------
    public void setBody(String body) {

        this.body = body;
    }

    // ***
    public String getBody() {

        return body;
    }

    // -------------------
    public void setFireCount(int firecount) {

        this.firecount = firecount;
    }

    // ***
    public int getFireCount() {

        return firecount;
    }

    // ------------------
    public void setMicro(boolean microwave) {

        this.microwave = microwave;
    }

    // ***
    public boolean getMicro() {

        return microwave;
    }
}
// --------------------------
class Meal extends Product implements Serializable{

    public Meal(String name, int id, String company, double price, String condition, String description,
                double ave_rate,String Sname) {

        super(name, id, company, price, condition, description, ave_rate, Sname);

    }

}
// *******************EXCEPTIONS*********************
class WrongBuyException extends Exception {
    WrongBuyException(String message) {
        super("INVALID BUY! : " + message);
    }
}
//-------------------------------------
class WrongInputException extends Exception {
    WrongInputException(String message) {
        super("INVALID INPUT! : " + message);
    }
}
//-------------------------------------
class NoMoneyException extends WrongBuyException {
    NoMoneyException(String message) {
        super("YOU DO NOT HAVE ENOUGH MONEY !");
    }
}
//-------------------------------------
class WrongPhoneException extends WrongInputException {
    WrongPhoneException(String message) {
        super("THIS PHONE NYMBER IS LONG !");
    }
}
//-------------------------------------
class WrongEmailException extends WrongInputException {
    WrongEmailException(String message) {
        super("THIS EMAIL IS LONG AND WRONG !");
    }
}
//-------------------------------------
class NoProductException extends WrongBuyException {
    NoProductException(String message) {
        super("WE DO NOT HAVE THIS PRODUCT");
    }
}
// ********************COMMENTS**********************
class Comment implements Serializable {
    private String person;
    private String name_product;
    private String commenttxt;

    static ArrayList<Comment> reqcom = new ArrayList<Comment>();
    static ArrayList<Comment> com = new ArrayList<Comment>();

    enum Condition {
        Checked, NotChecked, Ignored
    }

    private Condition cond;

    // ------------------
    public Comment(String person, String name_product, String commenttxt, Condition cond) {

        this.setPerson(person);
        this.setNameP(name_product);
        this.setCommentsT(commenttxt);
        this.setCond(cond);
    }

    // -------------------
    public void setPerson(String person) {

        this.person = person;
    }

    // ***
    public String getPerson() {

        return person;
    }

    // -------------------
    public void setNameP(String name_product) {

        this.name_product = name_product;
    }

    // ***
    public String getNameP() {

        return name_product;
    }

    // -------------------
    public void setCommentsT(String commenttxt) {

        this.commenttxt = commenttxt;
    }

    // ***
    public String getCommentsT() {

        return commenttxt;
    }

    // -------------------
    public void setCond(Condition cond) {

        this.cond = cond;
    }

    // ***
    public Condition getCond() {

        return cond;
    }
    // -------------------
}
// ************************RATE**********************
abstract class Rate implements Serializable {
    private double rate;
    private String product;

    // -----------
    public Rate(String product, double rate) {

        this.setProduct(product);
        this.setRate(rate);
    }

    // -------------------
    public void setProduct(String product) {

        this.product = product;
    }

    // ***
    public String getProduct() {

        return product;
    }

    // -------------------
    public void setRate(double rate) {

        this.rate = rate;
    }

    // ***
    public double getRate() {

        return rate;
    }
    // -------------------

}
// ************* C & R VOIDS **************
abstract class Operations implements Serializable {

    // --------------------------
    public void reating() {

    }

    // --------------------------
    public void comment() {

    }
}
// ********************REQUESTS**********************
class Requests implements Serializable{
    static ArrayList<Seller> req = new ArrayList<Seller>();

    // ---------------request to add product----------------
    static ArrayList<Laptop> addprolap = new ArrayList<Laptop>();
    static ArrayList<Mobile> addpromob = new ArrayList<Mobile>();
    static ArrayList<Refrigerator> addproref = new ArrayList<Refrigerator>();
    static ArrayList<Tv> addtv = new ArrayList<Tv>();
    static ArrayList<Oven> addoven = new ArrayList<Oven>();
    static ArrayList<Dress> adddress = new ArrayList<Dress>();
    static ArrayList<Shoes> addshoes = new ArrayList<Shoes>();
    static ArrayList<Meal> addmeal = new ArrayList<Meal>();

    static ArrayList<Laptop> dellap = new ArrayList<Laptop>();
    static ArrayList<Mobile> delmob = new ArrayList<Mobile>();
    static ArrayList<Refrigerator> delref = new ArrayList<Refrigerator>();
    static ArrayList<Tv> deltv = new ArrayList<Tv>();
    static ArrayList<Oven> deloven = new ArrayList<Oven>();
    static ArrayList<Dress> deldress = new ArrayList<Dress>();
    static ArrayList<Shoes> delshoes = new ArrayList<Shoes>();
    static ArrayList<Meal> delmeal = new ArrayList<Meal>();

    static ArrayList<Product> deldel = new ArrayList<Product>();


    static ArrayList<Laptop> editprolap = new ArrayList<Laptop>();
    static ArrayList<Mobile> editpromob = new ArrayList<Mobile>();
    static ArrayList<Refrigerator> editproref = new ArrayList<Refrigerator>();
    static ArrayList<Tv> edittv = new ArrayList<Tv>();
    static ArrayList<Oven> editoven = new ArrayList<Oven>();
    static ArrayList<Dress> editdress = new ArrayList<Dress>();
    static ArrayList<Shoes> editshoes = new ArrayList<Shoes>();
    static ArrayList<Meal> editmeal = new ArrayList<Meal>();



}
// *****************MAIN LISTS***********************
class MainLists implements Serializable{

    // ------main ones-------
    static ArrayList<Laptop> prolap = new ArrayList<Laptop>();
    static ArrayList<Mobile> promob = new ArrayList<Mobile>();
    static ArrayList<Refrigerator> proref = new ArrayList<Refrigerator>();
    static ArrayList<Tv> tv = new ArrayList<Tv>();
    static ArrayList<Oven> oven = new ArrayList<Oven>();
    static ArrayList<Dress> dress = new ArrayList<Dress>();
    static ArrayList<Shoes> shoes = new ArrayList<Shoes>();
    static ArrayList<Meal> meal = new ArrayList<Meal>();
    static ArrayList<Product> all = new ArrayList<Product>();
}
// *****************SELLER LISTS*********************
class SellerCont
{


    // ----------------------------------------------------
    public static void sellerPanel()throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();


        Scanner x = new Scanner(System.in);
        // Display the menu
        System.out.println("**************WELLCOME**************");
        System.out.println("* 1 : ADD PRODUCT      -->         *");
        System.out.println("* 2 : EDIT INFORMATION -->         *");
        System.out.println("* 3 : DELETE PRODUCT   -->         *");
        System.out.println("* 4 : EDIT PRODUCT     -->         *");
        System.out.println("* 5 : INFO OF ACCOUNT  -->         *");
        System.out.println("* 6 : YOUR PRODUCTS    -->         *");
        System.out.println("* 7 : PAST SELLES      -->         *");
        System.out.println("* 8 : SELL BILLS       -->         *");
        System.out.println("* 9 : BACK TO MAIN MENU-->         *");
        System.out.println("************************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                editInfoSeller();
                break;
            case 3:
                deleteProduct();
                break;
            case 4:
                editProductInfo();
                break;
            case 5:
                showInfoS();
                break;
            case 6:
                sellerProShow();
                break;
            case 7:
                pastSells();
                break;
            case 8:
                sellBill();
                break;
            case 9:
                Menu.firstMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }

    }
    // -----
    public static void showInfoS()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();


        Scanner x = new Scanner(System.in);

        System.out.println("*************DEAR SELLER************");
        System.out.println("* 1 : FULL NAME :       -->"+Seller.sellerInformation.get(Seller.sellerindex).getName()+"*");
        System.out.println("* 2 : FULL USER NAME :  -->"+Seller.sellerInformation.get(Seller.sellerindex).getLoginName()+"*");
        System.out.println("* 3 : FULL PASSWORD :   -->"+Seller.sellerInformation.get(Seller.sellerindex).getPassword()+"*");
        System.out.println("* 4 : YOUR EMAIL :      -->"+Seller.sellerInformation.get(Seller.sellerindex).getEmail()+"*");
        System.out.println("* 5 : PHONE NUMBER :    -->"+Seller.sellerInformation.get(Seller.sellerindex).getPhNumber()+"*");
        System.out.println("* 6 : YOUR CREDIT :     -->"+Seller.sellerInformation.get(Seller.sellerindex).getCredit()+"*");
        System.out.println("* 7 : BACK TO MENU      -->*");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                CustomerCont.customerPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }


    }
    // -----
    public static void editInfoSeller()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);

        String newuser , newpassword , newemail , newname , newphone , newcomp;
        double newcredit;

        System.out.println("*********SELLER INFORMATION EDIT PANEL************");
        System.out.println("*********      ENTER NEW NAME --->               *");
        newname = x.next();
        Seller.sellerInformation.get(Seller.sellerindex).setName(newname);
        System.out.println("*********      ENTER NEW USER --->              *");
        newuser = x.next();
        Seller.sellerInformation.get(Seller.sellerindex).setLoginName(newuser);
        System.out.println("*********      ENTER NEW PASS --->               *");
        newpassword = x.next();
        Seller.sellerInformation.get(Seller.sellerindex).setPassword(newpassword);
        System.out.println("*********      ENTER NEW EMAIL--->               *");
        newemail = x.next();
        try {
            if (newemail.length() > 40)
                throw new WrongEmailException("!!!YOUR EMAIL IS LONG!!!");
        }
        catch(WrongEmailException e)
        {
            System.out.print(e.getMessage());
            editInfoSeller();
        }
        Seller.sellerInformation.get(Seller.sellerindex).setEmail(newemail);
        System.out.println("*********      ENTER NEW PHONE--->               *");
        newphone = x.next();
        try {
            if (newphone.length() > 16)
                throw new WrongPhoneException("!!!YOUR PHONE NUMBER IS LONG!!!");
        }
        catch(WrongPhoneException e)
        {
            System.out.print(e.getMessage());
            editInfoSeller();
        }
        Seller.sellerInformation.get(Seller.sellerindex).setPhNumber(newphone);
        System.out.println("*********    ENTER NEW COMAPNY--->               *");
        newcomp = x.next();
        Seller.sellerInformation.get(Seller.sellerindex).setCoInfo(newcomp);
        System.out.println("*********    ENTER NEW CREDIT --->               *");
        newcredit= x.nextDouble();
        Seller.sellerInformation.get(Seller.sellerindex).setCredit(newcredit);

        Seller person = new Seller(newname, newuser, newpassword, newemail, newphone, newcredit, newcomp);
        File User = new File("SavedData//Users//Sellers//Sellerfolder");
        if ( !User.mkdirs()){
            System.out.print("!!! FILE CAN NOT CREATE !!!");
            Menu.firstMenu();
        }
        User = new File(User.getPath() + "//seller.txt");
        FileOutputStream fileSeller = new FileOutputStream(User);
        ObjectOutputStream objSeller = new ObjectOutputStream(fileSeller);
        objSeller.writeObject(person);
        objSeller.close();
        fileSeller.close();

        System.out.println("*GREAT DONE !! BACK TO MAIN MENU WHITH 1 -->    *");
        System.out.println("*************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                Menu.firstMenu();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }



    }
    // -----
    public static void addProduct()throws Exception{
        System.out.print("\033[H\033[2J");
        System.out.flush();


        Scanner x = new Scanner(System.in);
        // Display the menu
        System.out.println("*******************WELLCOME*******************");
        System.out.println("* ! WHAT KIND OF PRODUCT DO YOU WANT TO ADD? *");
        System.out.println("* 1 : DIGITAL         -->                    *");
        System.out.println("* 2 : HOUSE & KITCHEN -->                    *");
        System.out.println("* 3 : CLOTHING        -->                    *");
        System.out.println("* 4 : MEAL & FOOD     -->                    *");
        System.out.println("* 5 : BACK TO MAIN MENU-->                   *");
        System.out.println("**********************************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                addDigital();
                break;
            case 2:
                addHouse();
                break;
            case 3:
                addCloth();
                break;
            case 4:
                addFood();
                break;
            case 5:
                Menu.firstMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }


    }
    // -----
    public static  void addDigital()throws Exception{



        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("*******************WELLCOME TO ADD DIGI PANEL*****************");
        System.out.println("**************************************************************");
        System.out.println("* ENTER YOUR PRODUCT NAME :                              --->       *");
        Scanner inner = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        String diginame = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR  INT ID DIGI :                              --->       *");
        Integer digiid  = null;
        try {
            digiid  = inner.nextInt();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addDigital();
        }
        inner.nextLine();
        inner.nextLine();
        for (int i = 0 ; i < Seller.saddprolap.size(); i++)
        {
            if(digiid == Seller.saddprolap.get(i).getId())
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addDigital();
            }
        }
        for ( int i = 0; i < Seller.saddpromob.size(); i++)
        {
            if(digiid == Seller.saddpromob.get(i).getId() )
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addDigital();
            }
        }

        System.out.println("* ENTER THE COMPANY :                                    --->       *");
        String digico = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR PRICE :                                     --->       *");
        Double digiprice = null;
        try {
            digiprice = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addDigital();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR CONDITION :                                 --->       *");
        String digicond = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR DESCRIPTION(ram , capacity , os)            --->       *");
        String digides = inner.nextLine();
        inner.nextLine();
        System.out.println("* HOW WAS THE RATE OF IT :                               --->       *");
        Double digirate = null;
        try {
            digirate = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addDigital();
        }
        inner.nextLine();
        System.out.println("* SELLER NAME :                                          --->       *");
        String sellername = inner.next();
        inner.nextLine();
        inner.nextLine();
        System.out.println("* LAPTOP(1) OR MOBILE(2) :                               --->       *");
        int gozine = inner.nextInt();
        inner.nextLine();
        if (gozine == 2) {
            System.out.println("* ENTER YOUR SIMCARD CAPACITY :                         --->       *");
            Integer mobsim = null;
            try {
                mobsim = inner.nextInt();
            }
            catch(InputMismatchException e){
                e.getMessage();
                addDigital();
            }
            System.out.println("* ENTER YOUR CAMERA MP :                                --->       *");
            Integer mobcam = null;
            try {
                mobcam = inner.nextInt();
            }
            catch(InputMismatchException e){
                e.getMessage();
                addDigital();
            }


            Mobile added = new Mobile(diginame, digiid, digico, digiprice, digicond, digides, digirate , sellername, mobsim, mobcam);
            Requests.addpromob.add(added);


            System.out.println("*** GREAT DONE ! WAIT UNTIL ADMIN CONFIRM*** BACK TO MENU(1)");
            int choice = x.nextInt();

            switch (choice) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }


        } else {

            System.out.println("* ENTER YOUR CPU MODEL  :                                  --->       *");
            String lapcpu = inner.nextLine();
            inner.nextLine();

            System.out.println("* ENTER THAT IS GAMING OR NOT ? :                          --->       *");
            Boolean game = inner.nextBoolean();
            inner.nextLine();

            Laptop adedd2 = new Laptop(diginame, digiid, digico, digiprice, digicond, digides, digirate , sellername, lapcpu, game);
            Requests.addprolap.add(adedd2);




            System.out.println("***** GREAT!! DONE! WAIT UNTIL ADMIN CONFIRM **** BACK TO MENU(1)");
            int choices = x.nextInt();

            switch (choices) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }


        }







    }
    // -----
    public static  void addHouse()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();


        System.out.println("*******************WELLCOME TO ADD HOUSE PANEL****************");
        System.out.println("**************************************************************");
        System.out.println("* ENTER YOUR HOUSE PRODUCT NAME :                  --->       *");
        Scanner inner = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        String hname = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR  INT ID DIGI :                        --->       *");
        Integer hid  = null;
        try {
            hid  = inner.nextInt();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addHouse();
        }
        for (int i = 0 ; i < Seller.saddoven.size(); i++)
        {
            if(hid == Seller.saddoven.get(i).getId())
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addHouse();
            }
        }
        for ( int i = 0; i < Seller.saddproref.size(); i++)
        {
            if(hid == Seller.saddproref.get(i).getId() )
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addHouse();
            }
        }
        for (int i = 0 ; i < Seller.saddtv.size(); i++)
        {
            if(hid == Seller.saddtv.get(i).getId())
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addHouse();
            }
        }



        inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR COUNTRY MADE :                       --->       *");
        String hco = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR PRICRE :                             --->       *");
        Double hprice = null;
        try {
            hprice = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addHouse();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR CONDITION :                          --->       *");
        String hcond = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR DESCRIPTION(energy & guaranty) :     --->       *");
        String hdes = inner.nextLine();
        inner.nextLine();
        inner.nextLine();
        System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
        Double hrate = null;
        try {
            hrate = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addHouse();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* SELLER NAME :                                   --->       *");
        String sellername = inner.next();
        inner.nextLine();
        inner.nextLine();
        System.out.println("* REFRIGERATOR(1) ; OVENS(2) ; TV'S(3) :          --->       *");
        int gozine = inner.nextInt();
        inner.nextLine();
        if (gozine == 1) {
            System.out.println("* ENTER YOUR LITRE CAPACITY :                     --->       *");
            int lit = inner.nextInt();
            inner.nextLine();

            System.out.println("* ENTER YOUR REFRIGERATOR DOORTYPE :              --->       *");
            String door = inner.nextLine();
            inner.nextLine();

            System.out.println("* DOES IT HAVE FREEZER :                          --->       *");
            boolean freezerh = inner.nextBoolean();
            inner.nextLine();

            Refrigerator added3 = new Refrigerator(hname, hid, hco, hprice, hcond, hdes, hrate, sellername, lit, door, freezerh);
            Requests.addproref.add(added3);


            System.out.println("*** GREAT DONE ! WAIT UNTIL ADMIN CONFIRM*** BACK TO MENU(1)");
            int choice = x.nextInt();

            switch (choice) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }


        } else if (gozine == 2) {

            System.out.println("* ENTER YOUR OVEN'S FIRECOUNT :               --->       *");
            Integer fire = null;
            try{
                fire = inner.nextInt();
            }
            catch(InputMismatchException e){
                e.getMessage();
                addHouse();
            }
            inner.nextLine();

            System.out.println("* ENTER YOUR OVEN'S BODY MATERIAL :           --->       *");
            String bodymat = inner.nextLine();
            inner.nextLine();

            System.out.println("* ENTER THAT HAS MICROWAVE ? :                --->       *");
            Boolean fer = inner.nextBoolean();
            inner.nextLine();

            Oven added4  = new Oven(hname, hid, hco, hprice, hcond, hdes, hrate , sellername, fire, bodymat, fer);
            Requests.addoven.add(added4);


            System.out.println("***** GREAT!! DONE ! WAIT UNTIL ADMIN CONFIRM **** BACK TO MENU(1)");
            int choices = x.nextInt();

            switch (choices) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();

            }
        }


        else if (gozine == 3) {


            System.out.println("* ENTER YOUR TV'S  QUALITY :                  --->       *");
            String bodyqua = inner.nextLine();
            inner.nextLine();

            System.out.println("* ENTER YOUR TV'S INCHES :                    --->       *");
            Integer inctv = null;
            try{
                inctv = inner.nextInt();
            }
            catch(InputMismatchException e){
                e.getMessage();
                addHouse();
            }
            inner.nextLine();

            Tv added5  = new Tv(hname, hid, hco, hprice, hcond, hdes, hrate ,sellername, bodyqua, inctv);
            Requests.addtv.add(added5);


            System.out.println("***** GREAT!! DONE **** BACK TO MENU(1)");
            int choices = x.nextInt();

            switch (choices) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();

            }
        }




    }
    // -----
    public static  void addCloth()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("*******************WELLCOME TO ADD CLOTH PANEL****************");
        System.out.println("**************************************************************");
        System.out.println("* ENTER YOUR CLOTH PRODUCT NAME :                 --->       *");
        Scanner inner = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        String cname = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR  INT ID CLOTH :                      --->       *");
        Integer cid  = null;
        try{
            cid  = inner.nextInt();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addCloth();
        }
        for ( int i = 0; i < Seller.sadddress.size(); i++)
        {
            if(cid == Seller.sadddress.get(i).getId() )
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addCloth();
            }
        }
        for (int i = 0 ; i < Seller.saddshoes.size(); i++)
        {
            if(cid == Seller.saddshoes.get(i).getId())
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addCloth();
            }
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR COUNTRY MADE :                       --->       *");
        String cco = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR PRICE :                              --->       *");
        Double cprice = null;
        try{
            cprice  = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addCloth();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR CONDITION :                          --->       *");
        String ccond = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR DESCRIPTION(material , made by) :    --->       *");
        String cdes = inner.nextLine();
        inner.nextLine();
        inner.nextLine();
        System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
        Double crate = null;
        try{
            crate  = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addCloth();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* SELLER NAME :                                   --->       *");
        String sellername = inner.next();
        inner.nextLine();
        inner.nextLine();
        System.out.println("* DRESS(1) ; SHOES(2) :                           --->       *");
        int gozine = inner.nextInt();
        inner.nextLine();
        if (gozine == 1) {
            System.out.println("* ENTER YOUR DRESS SIZE :                     --->       *");
            Integer dsize = null;
            try{
                dsize  = inner.nextInt();
            }
            catch(InputMismatchException e){
                e.getMessage();
                addCloth();
            }
            inner.nextInt();

            System.out.println("* ENTER YOUR MODEL(Tshirt,Pants,Hat) :        --->       *");
            String modele = inner.nextLine();
            inner.nextLine();

            Dress added6 = new Dress(cname, cid, cco, cprice, ccond, cdes, crate ,sellername, dsize,Dress.Model.valueOf(inner.next(modele)) );
            Requests.adddress.add(added6);


            System.out.println("*** GREAT DONE! WAIT UNTIL ADMIN CONFIRM *** BACK TO MENU(1)");
            int choice = x.nextInt();

            switch (choice) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }


        } else if (gozine == 2) {

            System.out.println("* ENTER YOUR SHOES SIZE :                     --->       *");
            Integer ssize = null;
            try{
                ssize  = inner.nextInt();
            }
            catch(InputMismatchException e){
                e.getMessage();
                addCloth();
            }
            inner.nextInt();

            System.out.println("* ENTER YOUR SHOES TYPE :                     --->       *");
            String typee = inner.nextLine();
            inner.nextLine();


            Shoes added7  = new Shoes(cname, cid, cco, cprice, ccond, cdes, crate ,sellername, ssize, Shoes.Type.valueOf(typee));
            Requests.addshoes.add(added7);

            System.out.println("***** GREAT!! DONE ! WAIT UNTIL ADMIN CONFIRM **** BACK TO MENU(1)");
            int choices = x.nextInt();

            switch (choices) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();

            }
        }

    }
    // -----
    public static  void  addFood()throws Exception{
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("*******************WELLCOME TO ADD FOOD PANEL*****************");
        System.out.println("**************************************************************");
        System.out.println("* ENTER YOUR FOOD PRODUCT NAME :                  --->       *");
        Scanner inner = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        String fname = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR  INT ID FOOD :                       --->       *");
        Integer fid  = null;
        try {
            fid  = inner.nextInt();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addFood();
        }
        for ( int i = 0; i < Seller.saddmeal.size(); i++)
        {
            if(fid == Seller.saddmeal.get(i).getId() )
            {
                System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                addFood();
            }
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR BRAND MADE :                         --->       *");
        String fco = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR PRICRE :                             --->       *");
        Double fprice = null;
        try{
            fprice = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addFood();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR CONDITION :                          --->       *");
        String fcond = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR DESCRIPTION(date , materials ...) :  --->       *");
        String fdes = inner.nextLine();
        inner.nextLine();
        inner.nextLine();
        System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
        Double frate = null;
        try{
            frate = inner.nextDouble();
        }
        catch(InputMismatchException e){
            e.getMessage();
            addFood();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* SELLER NAME :                                   --->       *");
        String sellername = inner.next();
        inner.nextLine();

        Meal added8 = new Meal(fname, fid, fco, fprice, fcond, fdes, frate, sellername);
        Requests.addmeal.add(added8);

        System.out.println("*GREAT DONE !! ! WAIT UNTIL ADMIN CONFIRM! BACK TO MAIN MENU WHITH 1 -->    *");
        System.out.println("*************************************************");
        int choice = x.nextInt();
        switch (choice) {
            case 1:
                Menu.firstMenu();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }


    }
    // -----
    public static void deleteProduct()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("****************WELLCOME TO DELETE PRODUCT PANEL**************");
        System.out.println("**************************************************************");
        System.out.println("******************* HERE IS YOUR PRODUCTS ********************");


        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddpromob.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getId());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddprolap.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getId());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).sadddress.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getId());

            System.out.println("------------------------------------------");
        }

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddshoes.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getId());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddoven.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getId());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddtv.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getId());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddproref.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getId());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddmeal.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getId());
            System.out.println("------------------------------------------");
        }


        Scanner x = new Scanner(System.in);
        System.out.println("*ENTER THE ID OF THE PRODUCT THAT YOU WANT TO DELETE ; --->  *");
        Integer idsearch = null;
        try{
            idsearch = x.nextInt();
        }
        catch(InputMismatchException e)
        {
            e.getMessage();
            deleteProduct();
        }
        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).sadddress.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getId())
            {
                Requests.deldress.add(Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i));
            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddshoes.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getId())
            {
                Requests.delshoes.add(Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i));
            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddtv.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getId())
            {
                Requests.deltv.add(Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i));
            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddmeal.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getId())
            {
                Requests.delmeal.add(Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i));
            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddoven.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getId())
            {
                Requests.deloven.add(Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i));
            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddprolap.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getId())
            {
                Requests.dellap.add(Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i));
            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddpromob.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getId())
            {
                Requests.delmob.add(Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i));
            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddproref.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getId())
            {
                Requests.delref.add(Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i));
                Requests.deldel.add(Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i));
            }
        }





        System.out.println("***** GREAT!! DONE ! WAIT UNTIL ADMIN CONFIRM **** BACK TO MENU(1)");
        int choices = x.nextInt();

        switch (choices) {
            case 1:
                sellerPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }




    }
    // -----
    public static void editProductInfo()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner inner = new Scanner(System.in);
        Scanner x = new Scanner(System.in);


        System.out.println("********************WELLCOME TO EDIT PRODUCT PANEL*******************");
        System.out.println("******************* HERE IS YOUR PRODUCTS ********************");
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddpromob.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getId());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddprolap.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getId());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).sadddress.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getId());

            System.out.println("------------------------------------------");
        }
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddshoes.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getId());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddoven.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getId());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddtv.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getId());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddproref.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getId());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddmeal.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getId());
            System.out.println("------------------------------------------");
        }

        System.out.println("****** ENTER YOUR PRODUCT ID YOU WANT CHANGE ****** ---->  ");
        Integer idsearch =  null;
        try{
            idsearch =  x.nextInt();
        }
        catch(InputMismatchException e){
            e.getMessage();
            editProductInfo();
        }


        for ( int j = 0 ; j < Seller.sellerInformation.get(Seller.sellerindex).sadddress.size() ; j++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(j).getId())
            {
                j = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR CLOTH PRODUCT NAME :                 --->       *");
                String cname = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID CLOTH :                      --->       *");
                Integer cid  = null;
                try{
                    cid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                for ( int i = 0; i < Seller.sadddress.size(); i++)
                {
                    if(cid == Seller.sadddress.get(i).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addCloth();
                    }
                }
                for (int i = 0 ; i < Seller.saddshoes.size(); i++)
                {
                    if(cid == Seller.saddshoes.get(i).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addCloth();
                    }
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR COUNTRY MADE :                       --->       *");
                String cco = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICE :                              --->       *");
                Double cprice = null;
                try{
                    cprice  = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                          --->       *");
                String ccond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(material , made by) :    --->       *");
                String cdes = inner.nextLine();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
                Double crate = null;
                try{
                    crate  = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* SELLER NAME :                                   --->       *");
                String sellername = inner.next();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DRESS SIZE :                     --->       *");
                Integer dsize = null;
                try{
                    dsize  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                inner.nextInt();

                System.out.println("* ENTER YOUR MODEL(Tshirt,Pants,Hat) :        --->       *");
                String modele = inner.nextLine();
                inner.nextLine();


                Dress added6 = new Dress(cname, cid, cco, cprice, ccond, cdes, crate ,sellername, dsize,Dress.Model.valueOf(inner.next(modele)) );
                Requests.editdress.add(added6);





            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddshoes.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getId())
            {
                i = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR CLOTH PRODUCT NAME :                 --->       *");
                String cname = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID CLOTH :                      --->       *");
                Integer cid  = null;
                try{
                    cid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                for ( int l = 0; l < Seller.sadddress.size(); l++)
                {
                    if(cid == Seller.sadddress.get(i).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addCloth();
                    }
                }
                for (int a = 0 ; a < Seller.saddshoes.size(); a++)
                {
                    if(cid == Seller.saddshoes.get(a).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addCloth();
                    }
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR COUNTRY MADE :                       --->       *");
                String cco = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICE :                              --->       *");
                Double cprice = null;
                try{
                    cprice  = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                          --->       *");
                String ccond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(material , made by) :    --->       *");
                String cdes = inner.nextLine();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
                Double crate = null;
                try{
                    crate  = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* SELLER NAME :                                   --->       *");
                String sellername = inner.next();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR SHOES SIZE :                     --->       *");
                Integer ssize = null;
                try{
                    ssize  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addCloth();
                }
                inner.nextInt();

                System.out.println("* ENTER YOUR SHOES TYPE :                     --->       *");
                String typee = inner.nextLine();
                inner.nextLine();


                Shoes added7  = new Shoes(cname, cid, cco, cprice, ccond, cdes, crate ,sellername, ssize, Shoes.Type.valueOf(typee));
                Requests.editshoes.add(added7);

            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddtv.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getId())
            {
                i = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR HOUSE PRODUCT NAME :                  --->       *");
                String hname = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID DIGI :                        --->       *");
                Integer hid  = null;
                try {
                    hid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                for (int q = 0 ; q < Seller.saddoven.size(); q++)
                {
                    if(hid == Seller.saddoven.get(q).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }
                for ( int p = 0; p < Seller.saddproref.size(); p++)
                {
                    if(hid == Seller.saddproref.get(p).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }
                for (int o = 0 ; o < Seller.saddtv.size(); o++)
                {
                    if(hid == Seller.saddtv.get(o).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }

                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR COUNTRY MADE :                       --->       *");
                String hco = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICRE :                             --->       *");
                Double hprice = null;
                try {
                    hprice = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                          --->       *");
                String hcond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(energy & guaranty) :     --->       *");
                String hdes = inner.nextLine();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
                Double hrate = null;
                try {
                    hrate = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* SELLER NAME :                                  --->       *");
                String sellername = inner.next();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR TV'S  QUALITY :                     --->       *");
                String bodyqua = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR TV'S INCHES :                       --->       *");
                Integer inctv = null;
                try{
                    inctv = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();


                Tv added5  = new Tv(hname, hid, hco, hprice, hcond, hdes, hrate ,sellername, bodyqua, inctv);
                Requests.edittv.add(added5);


            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddmeal.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getId())
            {
                i = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR FOOD PRODUCT NAME :                  --->       *");
                String fname = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID FOOD :                       --->       *");
                Integer fid  = null;
                try {
                    fid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addFood();
                }
                for ( int q = 0; q < Seller.saddmeal.size(); q++)
                {
                    if(fid == Seller.saddmeal.get(q).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addFood();
                    }
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR BRAND MADE :                         --->       *");
                String fco = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICRE :                             --->       *");
                Double fprice = null;
                try{
                    fprice = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addFood();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                          --->       *");
                String fcond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(date , materials ...) :  --->       *");
                String fdes = inner.nextLine();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
                Double frate = null;
                try{
                    frate = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addFood();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* SELLER NAME :                                   --->       *");
                String sellername = inner.next();
                inner.nextLine();

                Meal added8 = new Meal(fname, fid, fco, fprice, fcond, fdes, frate, sellername);
                Requests.editmeal.add(added8);

            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddoven.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getId())
            {
                i = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR HOUSE PRODUCT NAME :                  --->       *");
                String hname = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID DIGI :                        --->       *");
                Integer hid  = null;
                try {
                    hid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                for (int q = 0 ; q < Seller.saddoven.size(); q++)
                {
                    if(hid == Seller.saddoven.get(q).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }
                for ( int p = 0; p < Seller.saddproref.size(); p++)
                {
                    if(hid == Seller.saddproref.get(p).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }
                for (int o = 0 ; o < Seller.saddtv.size(); o++)
                {
                    if(hid == Seller.saddtv.get(o).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }

                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR COUNTRY MADE :                       --->       *");
                String hco = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICRE :                             --->       *");
                Double hprice = null;
                try {
                    hprice = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                          --->       *");
                String hcond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(energy & guaranty) :     --->       *");
                String hdes = inner.nextLine();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
                Double hrate = null;
                try {
                    hrate = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* SELLER NAME :                                  --->       *");
                String sellername = inner.next();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR OVEN'S FIRECOUNT :               --->       *");
                Integer fire = null;
                try{
                    fire = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();

                System.out.println("* ENTER YOUR OVEN'S BODY MATERIAL :           --->       *");
                String bodymat = inner.nextLine();
                inner.nextLine();

                System.out.println("* ENTER THAT HAS MICROWAVE ? :                --->       *");
                Boolean fer = inner.nextBoolean();
                inner.nextLine();

                Oven added4  = new Oven(hname, hid, hco, hprice, hcond, hdes, hrate , sellername, fire, bodymat, fer);
                Requests.editoven.add(added4);

            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddprolap.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getId())
            {
                i = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR PRODUCT NAME :                              --->       *");
                String diginame = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID DIGI :                              --->       *");
                Integer digiid  = null;
                try {
                    digiid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                inner.nextLine();
                inner.nextLine();
                for (int f = 0 ; f < Seller.saddprolap.size(); f++)
                {
                    if(digiid == Seller.saddprolap.get(i).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addDigital();
                    }
                }
                for ( int k = 0; k < Seller.saddpromob.size(); k++)
                {
                    if(digiid == Seller.saddpromob.get(i).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addDigital();
                    }
                }

                System.out.println("* ENTER THE COMPANY :                                    --->       *");
                String digico = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICE :                                     --->       *");
                Double digiprice = null;
                try {
                    digiprice = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                                 --->       *");
                String digicond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(ram , capacity , os)            --->       *");
                String digides = inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                               --->       *");
                Double digirate = null;
                try {
                    digirate = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                inner.nextLine();
                System.out.println("* SELLER NAME :                                          --->       *");
                String sellername = inner.next();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CPU MODEL  :                               --->       *");
                String lapcpu = inner.nextLine();
                inner.nextLine();

                System.out.println("* ENTER THAT IS GAMING OR NOT ? :                       --->       *");
                Boolean game = inner.nextBoolean();
                inner.nextLine();

                Laptop adedd2 = new Laptop(diginame, digiid, digico, digiprice, digicond, digides, digirate , sellername, lapcpu, game);
                Requests.editprolap.add(adedd2);



            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddpromob.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getId())
            {
                i = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR PRODUCT NAME :                              --->       *");
                String diginame = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID DIGI :                              --->       *");
                Integer digiid  = null;
                try {
                    digiid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                inner.nextLine();
                inner.nextLine();
                for (int f = 0 ; f < Seller.saddprolap.size(); f++)
                {
                    if(digiid == Seller.saddprolap.get(i).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addDigital();
                    }
                }
                for ( int k = 0; k < Seller.saddpromob.size(); k++)
                {
                    if(digiid == Seller.saddpromob.get(i).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addDigital();
                    }
                }

                System.out.println("* ENTER THE COMPANY :                                    --->       *");
                String digico = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICE :                                     --->       *");
                Double digiprice = null;
                try {
                    digiprice = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                                 --->       *");
                String digicond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(ram , capacity , os)            --->       *");
                String digides = inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                               --->       *");
                Double digirate = null;
                try {
                    digirate = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                inner.nextLine();
                System.out.println("* SELLER NAME :                                          --->       *");
                String sellername = inner.next();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR SIMCARD CAPACITY :                         --->       *");
                Integer mobsim = null;
                try {
                    mobsim = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                System.out.println("* ENTER YOUR CAMERA MP :                                --->       *");
                Integer mobcam = null;
                try {
                    mobcam = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addDigital();
                }
                Mobile added = new Mobile(diginame, digiid, digico, digiprice, digicond, digides, digirate , sellername, mobsim, mobcam);
                Requests.editpromob.add(added);




            }
        }

        for ( int i = 0 ; i < Seller.sellerInformation.get(Seller.sellerindex).saddproref.size() ; i++)
        {
            if(idsearch == Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getId())
            {

                i = Product.editIndex;
                System.out.println("**************************************************************");
                System.out.println("* ENTER YOUR HOUSE PRODUCT NAME :                  --->       *");
                String hname = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR  INT ID DIGI :                        --->       *");
                Integer hid  = null;
                try {
                    hid  = inner.nextInt();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                for (int q = 0 ; q < Seller.saddoven.size(); q++)
                {
                    if(hid == Seller.saddoven.get(q).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }
                for ( int p = 0; p < Seller.saddproref.size(); p++)
                {
                    if(hid == Seller.saddproref.get(p).getId() )
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }
                for (int o = 0 ; o < Seller.saddtv.size(); o++)
                {
                    if(hid == Seller.saddtv.get(o).getId())
                    {
                        System.out.println(" YOU CAN NOT WRITE THIS ID !!!!");
                        addHouse();
                    }
                }

                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR COUNTRY MADE :                       --->       *");
                String hco = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR PRICRE :                             --->       *");
                Double hprice = null;
                try {
                    hprice = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR CONDITION :                          --->       *");
                String hcond = inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR DESCRIPTION(energy & guaranty) :     --->       *");
                String hdes = inner.nextLine();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* HOW WAS THE RATE OF IT :                        --->       *");
                Double hrate = null;
                try {
                    hrate = inner.nextDouble();
                }
                catch(InputMismatchException e){
                    e.getMessage();
                    addHouse();
                }
                inner.nextLine();
                inner.nextLine();
                System.out.println("* SELLER NAME :                                  --->       *");
                String sellername = inner.next();
                inner.nextLine();
                inner.nextLine();
                System.out.println("* ENTER YOUR LITRE CAPACITY :                     --->       *");
                int lit = inner.nextInt();
                inner.nextLine();

                System.out.println("* ENTER YOUR REFRIGERATOR DOORTYPE :              --->       *");
                String door = inner.nextLine();
                inner.nextLine();

                System.out.println("* DOES IT HAVE FREEZER :                          --->       *");
                boolean freezerh = inner.nextBoolean();
                inner.nextLine();


                Refrigerator added3 = new Refrigerator(hname, hid, hco, hprice, hcond, hdes, hrate, sellername, lit, door, freezerh);
                Requests.editproref.add(added3);


            }
        }



        System.out.println("***** GREAT!! DONE ! WAIT UNTIL ADMIN CONFIRM **** BACK TO MENU(1)");
        int choices = inner.nextInt();

        switch (choices) {
            case 1:
                sellerPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }

    }
    // -----
    public static void pastSells()throws Exception{




        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**************WELLCOME TO YOUR PAST SELLES*************");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(i).getId());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(i).getPrice());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(i).getDescription());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(i).getCompany());
            System.out.println("RATE : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(i).getAve_rate());
            System.out.println("-----------------------------------------------");
        }

        System.out.println("*BACK TO MAIN MENU WHITH 1               -->    *");
        System.out.println("*************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                sellerPanel();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }
    }
    // -----
    public static void sellBill()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        for ( int i = 0 ; i < BuyFactor.bill.size(); i++)
        {


            System.out.println("**************WELLCOME TO YOUR BILLS *************");
            System.out.println("DATE :     --->" + SellFactor.bought.get(i).getDate());
            System.out.println(" ID  :     --->"  + SellFactor.bought.get(i).getId());
            System.out.println("CUSTOMER : --->"  + SellFactor.bought.get(i).getCustomerName());
            System.out.println("RECIEVE :  --->"  + SellFactor.bought.get(i).getReceived());
            System.out.println("CONDITION: --->"  + SellFactor.bought.get(i).getArrive());
            System.out.println("---------------------------------------------------");

            for (int j = 0; j <Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().size(); j++)
            {
                System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(j).getName());
                System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(j).getId());
                System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(j).getPrice());
                System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(j).getDescription());
                System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(j).getCompany());
                System.out.println("RATE : " + Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().get(j).getAve_rate());
                System.out.println("-----------------------------------------------");
            }

        }
        Scanner x = new Scanner(System.in);
        System.out.println("*BACK TO MAIN MENU WHITH 1               -->    *");
        System.out.println("*************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                sellerPanel();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                sellBill();

        }





    }
    // -----
    public static void sellerProShow()throws Exception{




        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR PRODUCTS ***********");
        System.out.println("******************************************");


        System.out.println("**********HERE IS YOUR MOBILE PRODUCTS ***********");
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddpromob.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getSname());
            System.out.println("SIM CARDS : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getSim());
            System.out.println("CAMERA MP : " + Seller.sellerInformation.get(Seller.sellerindex).saddpromob.get(i).getCam());
            System.out.println("------------------------------------------");
        }

        System.out.println("**********HERE IS YOUR LAPTOP PRODUCTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddprolap.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getSname());
            System.out.println("CPU : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getCpu());
            System.out.println("GAMING : " + Seller.sellerInformation.get(Seller.sellerindex).saddprolap.get(i).getGaming());
            System.out.println("------------------------------------------");
        }


        System.out.println("**********HERE IS YOUR DRESS PRODUCTS ***********");

        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).sadddress.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getCondition());
            System.out.println("DESCRIPTION : " +Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getSname());
            System.out.println("SIZE : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getSize());
            System.out.println("MODEL : " + Seller.sellerInformation.get(Seller.sellerindex).sadddress.get(i).getModel());
            System.out.println("------------------------------------------");
        }

        System.out.println("**********HERE IS YOUR  SHOES  PRODUCTS ***********");
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddshoes.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getSname());
            System.out.println("FOOT SIZE : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getFootSize());
            System.out.println("TYPE : " + Seller.sellerInformation.get(Seller.sellerindex).saddshoes.get(i).getType());
            System.out.println("------------------------------------------");
        }

        System.out.println("**********HERE IS YOUR  OVEN PRODUCTS ***********");
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddoven.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getSname());
            System.out.println("FIRE COUNTS : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getFireCount());
            System.out.println("BODY MATERIAL : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getBody());
            System.out.println("MICROWAVE : " + Seller.sellerInformation.get(Seller.sellerindex).saddoven.get(i).getMicro());
            System.out.println("------------------------------------------");
        }


        System.out.println("**********HERE IS YOUR  TV  PRODUCTS ***********");
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddtv.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getSname());
            System.out.println("QUALITY : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getQuality());
            System.out.println("INCHES : " + Seller.sellerInformation.get(Seller.sellerindex).saddtv.get(i).getInches());
            System.out.println("------------------------------------------");
        }


        System.out.println("**********HERE IS YOUR REFRIGERATOR PRODUCTS ***********");
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddproref.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getSname());
            System.out.println("CAPACITY : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getLitre());
            System.out.println("DOOR TYPE : " +Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getDoor());
            System.out.println("FREEZER : " + Seller.sellerInformation.get(Seller.sellerindex).saddproref.get(i).getFreezer());
            System.out.println("------------------------------------------");
        }


        System.out.println("**********HERE IS YOUR FOOD PRODUCTS ***********");
        for (int i = 0; i <Seller.sellerInformation.get(Seller.sellerindex).saddmeal.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getName());
            System.out.println("ID : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getId());
            System.out.println("COMPANY : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sellerInformation.get(Seller.sellerindex).saddmeal.get(i).getSname());
            System.out.println("------------------------------------------");
        }



        System.out.println("**********HERE IS OUR  TV  PRODUCTS ***********");

        File Use = new File("SavedData//Sellers//Sellerfolder//Products//Houes//Tv//tv.txt");
        FileInputStream filetv = new FileInputStream(Use);
        ObjectInputStream objtv = new ObjectInputStream(filetv);

        while(true){

            Tv tv;
            try{
                tv = (Tv) objtv.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + tv.getName());
            System.out.println("ID : " + tv.getId());
            System.out.println("COMPANY : " + tv.getCompany());
            System.out.println("PRICE : " + tv.getPrice());
            System.out.println("CONDITION : " + tv.getCondition());
            System.out.println("DESCRIPTION : " + tv.getDescription());
            System.out.println("AVERAGE RATE : " + tv.getAve_rate());
            System.out.println("SELLER NAME : " + tv.getSname());
            System.out.println("QUALITY : " + tv.getQuality());
            System.out.println("INCHES : " + tv.getInches());
            System.out.println("------------------------------------------");

            if(objtv.available() == 0){
                break;
            }

        }


        System.out.println("**********HERE IS OUR  OVEN PRODUCTS ***********");
        File User = new File("SavedData//Seller//Sellerfolder//Products//Houes//Ovens//ovens.txt");
        FileInputStream fileOven = new FileInputStream(User);
        ObjectInputStream objOven = new ObjectInputStream(fileOven);

        while(true){

            Oven oven;
            try{
                oven = (Oven) objOven.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + oven.getName());
            System.out.println("ID : " + oven.getId());
            System.out.println("COMPANY : " + oven.getCompany());
            System.out.println("PRICE : " + oven.getPrice());
            System.out.println("CONDITION : " + oven.getCondition());
            System.out.println("DESCRIPTION : " + oven.getDescription());
            System.out.println("AVERAGE RATE : " + oven.getAve_rate());
            System.out.println("SELLER NAME : " + oven.getSname());
            System.out.println("FIRE COUNTS : " + oven.getFireCount());
            System.out.println("BODY MATERIAL : " + oven.getBody());
            System.out.println("MICROWAVE : " + oven.getMicro());
            System.out.println("------------------------------------------");

            if(objOven.available() == 0){
                break;
            }

        }

        File ser = new File("SavedData//Seller//Sellerfolder//Products//Houes//Refrigerator//refrigerator.txt");
        FileInputStream fileref = new FileInputStream(ser);
        ObjectInputStream objref = new ObjectInputStream(fileref);


        System.out.println("**********HERE IS OUR REFRIGERATOR PRODUCTS ***********");
        while(true){

            Refrigerator ref;
            try{
                ref = (Refrigerator) objref.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + ref.getName());
            System.out.println("ID : " + ref.getId());
            System.out.println("COMPANY : " + ref.getCompany());
            System.out.println("PRICE : " + ref.getPrice());
            System.out.println("CONDITION : " + ref.getCondition());
            System.out.println("DESCRIPTION : " + ref.getDescription());
            System.out.println("AVERAGE RATE : " + ref.getAve_rate());
            System.out.println("SELLER NAME : " + ref.getSname());
            System.out.println("CAPACITY : " + ref.getLitre());
            System.out.println("DOOR TYPE : " +ref.getDoor());
            System.out.println("FREEZER : " + ref.getFreezer());
            System.out.println("------------------------------------------");


            if(objref.available() == 0){
                break;
            }
        }



        File Usr = new File("SavedData//Seller//Sellerfolder//Products//Clothing//Dress//dress.txt");
        FileInputStream filedress = new FileInputStream(Usr);
        ObjectInputStream objdress = new ObjectInputStream(filedress);



        while(true){

            Dress dress;
            try{
                dress = (Dress) objdress.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + dress.getName());
            System.out.println("ID : " + dress.getId());
            System.out.println("COMPANY : " + dress.getCompany());
            System.out.println("PRICE : " + dress.getPrice());
            System.out.println("CONDITION : " + dress.getCondition());
            System.out.println("DESCRIPTION : " + dress.getDescription());
            System.out.println("AVERAGE RATE : " + dress.getAve_rate());
            System.out.println("SELLER NAME : " +dress.getSname());
            System.out.println("SIZE : " + dress.getSize());
            System.out.println("MODEL : " + dress.getModel());
            System.out.println("------------------------------------------");

            if(objdress.available() == 0){
                break;
            }

        }


        System.out.println("**********HERE IS OUR  SHOES  PRODUCTS ***********");

        File se = new File("SavedData//Seller//Sellerfolder//Products//Clothing//Shoes//shoes.txt");
        FileInputStream filesh = new FileInputStream(se);
        ObjectInputStream objsh = new ObjectInputStream(filesh);



        while(true){

            Shoes shoes;
            try{
                shoes = (Shoes) objsh.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + shoes.getName());
            System.out.println("ID : " + shoes.getId());
            System.out.println("COMPANY : " + shoes.getCompany());
            System.out.println("PRICE : " + shoes.getPrice());
            System.out.println("CONDITION : " + shoes.getCondition());
            System.out.println("DESCRIPTION : " + shoes.getDescription());
            System.out.println("AVERAGE RATE : " + shoes.getAve_rate());
            System.out.println("SELLER NAME : " + shoes.getSname());
            System.out.println("FOOT SIZE : " + shoes.getFootSize());
            System.out.println("TYPE : " +shoes.getType());
            System.out.println("------------------------------------------");

            if(objsh.available() == 0){
                break;
            }

        }

        System.out.println("**********HERE IS OUR DIGITAL PRODUCTS ***********");
        File Users = new File("SavedData//Seller//Sellerfolder//Products//Digital//Mobiles//mobiles.txt");
        FileInputStream filemob = new FileInputStream(Users);
        ObjectInputStream objmob = new ObjectInputStream(filemob);

        while(true){
            Mobile mobile;
            try{
                mobile = (Mobile) objmob.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + mobile.getName());
            System.out.println("ID : " + mobile.getId());
            System.out.println("COMPANY : " + mobile.getCompany());
            System.out.println("PRICE : " + mobile.getPrice());
            System.out.println("CONDITION : " + mobile.getCondition());
            System.out.println("DESCRIPTION : " + mobile.getDescription());
            System.out.println("AVERAGE RATE : " + mobile.getAve_rate());
            System.out.println("SELLER NAME : " + mobile.getSname());
            System.out.println("SIM CARDS : " + mobile.getSim());
            System.out.println("CAMERA MP : " + mobile.getCam());
            System.out.println("------------------------------------------");

            if(objmob.available() == 0){
                break;
            }
        }

        File Us = new File("SavedData//Seller//Sellerfolder//Products//Digital//Laptops//laptop.txt");
        FileInputStream fileLap = new FileInputStream(Us);
        ObjectInputStream objLap = new ObjectInputStream(fileLap);


        while(true){

            Laptop laptop;
            try{
                laptop = (Laptop) objLap.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + laptop.getName());
            System.out.println("ID : " + laptop.getId());
            System.out.println("COMPANY : " + laptop.getCompany());
            System.out.println("PRICE : " + laptop.getPrice());
            System.out.println("CONDITION : " + laptop.getCondition());
            System.out.println("DESCRIPTION : " + laptop.getDescription());
            System.out.println("AVERAGE RATE : " + laptop.getAve_rate());
            System.out.println("SELLER NAME : " + laptop.getSname());
            System.out.println("CPU : " + laptop.getCpu());
            System.out.println("GAMING : " + laptop.getGaming());
            System.out.println("------------------------------------------");

            if(objLap.available() == 0){
                break;
            }

            System.out.println("**********HERE IS OUR FOOD PRODUCTS ***********");
            File sr = new File("SavedData//Seller//Sellerfolder//Products//Meal//food.txt");
            FileInputStream filefood = new FileInputStream(sr);
            ObjectInputStream objfood = new ObjectInputStream(filefood);

            while(true){

                Meal food;
                try{
                    food = (Meal) objfood.readObject();
                }
                catch(Exception except){

                    break;
                }

                System.out.println("NAME : " + food.getName());
                System.out.println("ID : " + food.getId());
                System.out.println("COMPANY : " + food.getCompany());
                System.out.println("PRICE : " + food.getPrice());
                System.out.println("CONDITION : " + food.getCondition());
                System.out.println("DESCRIPTION : " + food.getDescription());
                System.out.println("AVERAGE RATE : " + food.getAve_rate());
                System.out.println("SELLER NAME : " + food.getSname());
                System.out.println("------------------------------------------");


                if(objfood.available() == 0){
                    break;
                }

            }

















            System.out.println("******************************************");
            System.out.println("*BACK TO MENU  (1)      -->*");
            int choice = x.nextInt();

            switch (choice) {
                case 1:
                    sellerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }
        // -----------------------------------------------------


    }

}
// ***************CUSTOMER LISTS*********************
class CustomerCont
{
    // ----------------------------------------------------
    public static  void customerPanel() throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner x = new Scanner(System.in);
        // Display the menu
        System.out.println("**************WELLCOME**************");
        System.out.println("* 1 : LIST OF PRODUCTS -->         *");
        System.out.println("* 2 : EDIT INFORMATION -->         *");
        System.out.println("* 3 : BUY PACK & BUY   -->         *");
        System.out.println("* 4 : PAST BUYS        -->         *");
        System.out.println("* 5 : COMMENT & RATE   -->         *");
        System.out.println("* 6 : INFO OF ACCOUNT  -->         *");
        System.out.println("* 7 : BUY BILLS        -->         *");
        System.out.println("* 8 : RATE A PRODUCT   -->         *");
        System.out.println("* 9 : BACK TO MAIN MENU-->         *");
        System.out.println("************************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                Menu.listProductMenu();
                break;
            case 2:
                editInfoCustomer();
                break;
            case 3:
                buyPack();
                break;
            case 4:
                pastBuys();
                break;
            case 5:
                commentRate();
                break;
            case 6:
                showInfoC();
                break;
            case 7:
                buyBill();;
                break;
            case 8:
                ratePro();
                break;
            case 9:
                Menu.firstMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }


    }
    // -----
    public static void showInfoC()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();


        Scanner x = new Scanner(System.in);

        System.out.println("*************DEAR CUSTOMER**************");
        System.out.println("* 1 : FULL NAME :       -->"+Customer.information.get(Customer.customerindex).getName()+"*");
        System.out.println("* 2 : FULL USER NAME :  -->"+Customer.information.get(Customer.customerindex).getLoginName()+"*");
        System.out.println("* 3 : FULL PASSWORD :   -->"+Customer.information.get(Customer.customerindex).getPassword()+"*");
        System.out.println("* 4 : YOUR EMAIL :      -->"+Customer.information.get(Customer.customerindex).getEmail()+"*");
        System.out.println("* 5 : PHONE NUMBER :    -->"+Customer.information.get(Customer.customerindex).getPhNumber()+"*");
        System.out.println("* 6 : YOUR CREDIT :     -->"+Customer.information.get(Customer.customerindex).getCredit()+"*");
        System.out.println("* 7 : BACK TO MENU      -->*");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                customerPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }


    }
    // -----
    public static void editInfoCustomer()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);

        String newuser , newpassword , newemail , newname , newphone;
        double newcredit;
        System.out.println("*********CUSTOMER INFORMATION EDIT PANEL**********");
        System.out.println("*********      ENTER NEW NAME --->               *");
        newname = x.next();
        Customer.information.get(Customer.customerindex).setName(newname);
        System.out.println("*********      ENTER NEW USER --->              *");
        newuser = x.next();
        Customer.information.get(Customer.customerindex).setLoginName(newuser);
        System.out.println("*********      ENTER NEW PASS --->               *");
        newpassword = x.next();
        Customer.information.get(Customer.customerindex).setPassword(newpassword);
        System.out.println("*********      ENTER NEW EMAIL--->               *");
        newemail = x.next();
        try {
            if (newemail.length() > 40)
                throw new WrongEmailException("!!!YOUR EMAIL IS LONG!!!");
        }
        catch(WrongEmailException e)
        {
            System.out.print(e.getMessage());
            editInfoCustomer();
        }
        Customer.information.get(Customer.customerindex).setEmail(newemail);
        System.out.println("*********      ENTER NEW PHONE--->               *");
        newphone = x.next();
        try {
            if (newphone.length() > 16)
                throw new WrongPhoneException("!!!YOUR PHONE NUMBER IS LONG!!!");
        }
        catch(WrongPhoneException e)
        {
            System.out.print(e.getMessage());
            editInfoCustomer();
        }
        Customer.information.get(Customer.customerindex).setPhNumber(newphone);
        System.out.println("*********      ENTER NEW CREDIT--->              *");
        newcredit = x.nextDouble();
        Customer.information.get(Customer.customerindex).setCredit(newcredit);


        Customer person = new Customer(newname, newuser, newpassword, newemail, newphone, newcredit);
        File User = new File("SavedData//Users//Customers//");
        if ( !User.mkdirs()){
            System.out.print("!!! FILE CAN NOT CREATE !!!");
            Menu.firstMenu();
        }
        User = new File(User.getPath() + "//customer.txt");
        FileOutputStream fileCustomer = new FileOutputStream(User);
        ObjectOutputStream objCustomer = new ObjectOutputStream(fileCustomer);
        objCustomer.writeObject(person);
        objCustomer.close();
        fileCustomer.close();


        System.out.println("*GREAT DONE !! BACK TO MAIN MENU WHITH 1 -->    *");
        System.out.println("*************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                Menu.firstMenu();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }




    }
    // -----
    public static void commentRate()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner x = new Scanner(System.in);
        System.out.println("**************WELLCOME**************");
        System.out.println("* DID YOU BOUGHT PRODUCTS ?  -->   *");
        System.out.println("* IF YES ENTER 1 ELSE 2  !!  -->   *");
        System.out.println("* BACK TO YOUR PANEL WITH 3  -->   *");
        System.out.println("************************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                commentRateMenu();
                break;
            case 2:
                System.out.println("YOU SHOULD FIRST BUY SOMETHING TO RATE AND COMMENT");
                x.nextLine();
                x.nextLine();
                customerPanel();
                break;
            case 3:
                customerPanel();
                break;
        }


    }
    // -----
    public static void commentRateMenu()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**************YOUR PAST BUYS*************");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Customer.information.get(Customer.customerindex).getPastBuys().size();i++)
        {
            System.out.println("NAME : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getName());
            System.out.println("ID : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getId());
            System.out.println("PRICE : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getPrice());
            System.out.println("DESCRIPTION : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getDescription());
            System.out.println("COMPANY : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getCompany());
            System.out.println("RATE : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getAve_rate());
            System.out.println("-----------------------------------------------");
        }

        System.out.println("****** ENTER YOUR PRODUCT ID YOU WANT COMMENT ****** ---->  ");
        Integer idsearch = null;
        try{
            idsearch =  x.nextInt();
        }
        catch(InputMismatchException e)
        {
            e.getMessage();
            commentRateMenu();
        }

        for ( int j = 0 ; j < Customer.information.get(Customer.customerindex).getPastBuys().size() ; j++)
        {
            if(idsearch == Customer.information.get(Customer.customerindex).getPastBuys().get(j).getId() )
            {
                System.out.println("****** ENTER YOUR NAME ****** ---->  ");
                String  namein =  x.nextLine();
                System.out.println("****** ENTER YOUR PRODUCT NAME ****** ---->  ");
                String  pronamein =  x.nextLine();
                System.out.println("****** ENTER YOUR COMMENT ****** ---->  ");
                String  comment =  x.nextLine();
                String  condi =  "NotChecked";

                Comment requestcom = new Comment(namein, pronamein, comment, Comment.Condition.valueOf(condi));
                Comment.reqcom.add(requestcom);

            }
        }

        System.out.println("*BACK TO MAIN MENU WITH(1)WAIT UNTIL ADMIN CONFIRM--> *");
        System.out.println("*******************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                customerPanel();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                customerPanel();

        }


    }
    // -----
    public static void pastBuys()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**************WELLCOME TO YOUR PAST BUYS*************");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Customer.information.get(Customer.customerindex).getPastBuys().size();i++)
        {
            System.out.println("NAME : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getName());
            System.out.println("ID : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getId());
            System.out.println("PRICE : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getPrice());
            System.out.println("DESCRIPTION : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getDescription());
            System.out.println("COMPANY : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getCompany());
            System.out.println("RATE : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getAve_rate());
            System.out.println("-----------------------------------------------");
        }
        System.out.println("*GOOD FOR YOU*** :) WE'LL SEND YOUR PACK TO YOU    *");
        System.out.println("*BACK TO MAIN MENU WHITH 1 -->                     *");
        System.out.println("****************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                customerPanel();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }
    }
    // -----
    public static void ratePro()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner inner = new Scanner(System.in);
        Scanner x = new Scanner(System.in);


        System.out.println("********************WELLCOME TO RATING PRODUCT PANEL*******************");
        for (int i = 0; i <Customer.information.get(Customer.customerindex).getPastBuys().size();i++)
        {
            System.out.println("NAME : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getName());
            System.out.println("ID : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getId());
            System.out.println("PRICE : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getPrice());
            System.out.println("DESCRIPTION : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getDescription());
            System.out.println("COMPANY : " + Customer.information.get(Customer.customerindex).getPastBuys().get(i).getCompany());
            System.out.println("-----------------------------------------------");
        }

        System.out.println("****** ENTER YOUR PRODUCT ID YOU WANT RATE ****** ---->  ");
        int idsearch =  x.nextInt();

        for ( int j = 0 ; j < Customer.information.get(Customer.customerindex).getPastBuys().size() ; j++)
        {
            if(idsearch == Customer.information.get(Customer.customerindex).getPastBuys().get(j).getId() )
            {
                System.out.println("****** ENTER YOUR RATE (1 - 10) ****** ---->  ");
                double rate =  x.nextDouble();
                double sum = 0;
                sum = sum + rate;
                int count = 0;
                count++;
                double ave = sum / count;
                Customer.information.get(Customer.customerindex).getPastBuys().get(j).setAve_rate(ave);
            }
        }

        System.out.println("***** GREAT!! DONE ! **** BACK TO MENU(1)");
        int choices = x.nextInt();

        switch (choices) {
            case 1:
                customerPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }

    }
    // -----
    public static void buyPack()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**************WELLCOME TO YOUR BUY PACK*************");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Customer.information.get(Customer.customerindex).getBuyPack().size();i++)
        {
            System.out.println("NAME : " + Customer.information.get(Customer.customerindex).getBuyPack().get(i).getName());
            System.out.println("ID : " + Customer.information.get(Customer.customerindex).getBuyPack().get(i).getId());
            System.out.println("PRICE : " + Customer.information.get(Customer.customerindex).getBuyPack().get(i).getPrice());
            System.out.println("DESCRIPTION : " + Customer.information.get(Customer.customerindex).getBuyPack().get(i).getDescription());
            System.out.println("COMPANY : " + Customer.information.get(Customer.customerindex).getBuyPack().get(i).getCompany());
            System.out.println("RATE : " + Customer.information.get(Customer.customerindex).getBuyPack().get(i).getAve_rate());
            System.out.println("-----------------------------------------------");


            System.out.println("PLEASE ENTER YOUR CHOICE (1 buy) or (2 cancel) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();
            double cash = (Customer.information.get(Customer.customerindex).getCredit()) - (Customer.information.get(Customer.customerindex).getBuyPack().get(i).getPrice());

            switch (choice) {
                case 1:
                    try {
                        if(Customer.information.get(Customer.customerindex).getCredit() < Customer.information.get(Customer.customerindex).getBuyPack().get(i).getPrice()){
                            throw new NoMoneyException("SORRY YOU CAN'T BUY THIS YOU DON'T HAVE ENOUGH MONEY!!! ");
                        }
                    }
                    catch(NoMoneyException e){
                        e.getMessage();
                        buyPack();
                    }
                    try{
                        if(Customer.information.get(Customer.customerindex).getBuyPack().get(i).getCondition().equals("false"))
                            throw new NoProductException("SORRY WE DON'T HAVE THIS PRODUCT!!!");
                    }
                    catch(NoProductException e)
                    {
                        e.getMessage();
                        buyPack();
                    }



                    Customer.information.get(Customer.customerindex).paid1 = Customer.information.get(Customer.customerindex).getBuyPack().get(i).getPrice();
                    Customer.information.get(Customer.customerindex).getPastBuys().add(Customer.information.get(Customer.customerindex).getBuyPack().get(i));
                    Customer.information.get(Customer.customerindex).getBuyPack().remove(i);
                    Seller.sellerInformation.get(Seller.sellerindex).getPastSelles().add(Customer.information.get(Customer.customerindex).getBuyPack().get(i));
                    Customer.information.get(Customer.customerindex).setCredit(cash);
                    Seller.sellerInformation.get(Seller.sellerindex).setCredit((Seller.sellerInformation.get(Seller.sellerindex).getCredit())  + (Customer.information.get(Customer.customerindex).getBuyPack().get(i).getPrice()));
                    BuyFactor buy = new BuyFactor();
                    BuyFactor.bill.add(buy);
                    SellFactor sell = new SellFactor();
                    SellFactor.bought.add(sell);
                    buyBill();

                    break;
                case 2:
                    Customer.information.get(Customer.customerindex).getBuyPack().remove(i);
                    customerPanel();
                    break;
                case 3:
                    customerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }


        }

    }
    // -----
    public static  void buyBill()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        for ( int i = 0 ; i < BuyFactor.bill.size(); i++)
        {


            System.out.println("**************WELLCOME TO YOUR BILLS *************");
            System.out.println("DATE :     --->" + BuyFactor.bill.get(i).getDate());
            System.out.println(" ID  :     --->"  + BuyFactor.bill.get(i).getId());
            System.out.println("SELLER :   --->"  + BuyFactor.bill.get(i).getSellerName());
            System.out.println(" PAID  :   --->"  + BuyFactor.bill.get(i).getPaid());
            System.out.println("CONDITION: --->"  + BuyFactor.bill.get(i).getArrive());
            System.out.println("---------------------------------------------------");

            for (int j = 0; j <Customer.information.get(Customer.customerindex).getPastBuys().size();j++)
            {
                System.out.println("NAME : " + Customer.information.get(Customer.customerindex).getPastBuys().get(j).getName());
                System.out.println("ID : " + Customer.information.get(Customer.customerindex).getPastBuys().get(j).getId());
                System.out.println("PRICE : " + Customer.information.get(Customer.customerindex).getPastBuys().get(j).getPrice());
                System.out.println("DESCRIPTION : " + Customer.information.get(Customer.customerindex).getPastBuys().get(j).getDescription());
                System.out.println("COMPANY : " + Customer.information.get(Customer.customerindex).getPastBuys().get(j).getCompany());
                System.out.println("RATE : " + Customer.information.get(Customer.customerindex).getPastBuys().get(j).getAve_rate());
                System.out.println("-----------------------------------------------");
            }

        }
        System.out.println("*BACK TO MAIN MENU WHITH 1 -->                     *");
        System.out.println("****************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                customerPanel();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                buyBill();

        }

    }
    // -----
    public static void buyMenu()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);

        System.out.println("**************************************************************");
        System.out.println("*ENTER THE ID  OF THE PRODUCT THAT YOU WANT TO BUY ; --->    *");
        int buyid = x.nextInt();
        System.out.println("*ENTER THE NAME  OF THE PRODUCT THAT YOU WANT TO BUY ; --->  *");
        String buyname = x.next();
        for ( int i = 0 ; i < Seller.saddpromob.size() ; i++)
        {
            if(buyid == Seller.saddpromob.get(i).getId() && buyname.equals(Seller.saddpromob.get(i).getName()))
            {
                if(Seller.saddpromob.get(i).getCondition().equals("true")){
                    Customer.information.get(Customer.customerindex).getBuyPack().add(Seller.saddpromob.get(i));
                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }

        for ( int j = 0 ; j < Seller.saddprolap.size() ; j++)
        {
            if(buyid == Seller.saddprolap.get(j).getId() && buyname.equals(Seller.saddprolap.get(j).getName()))
            {
                if(Seller.saddprolap.get(j).getCondition().equals("true")){

                    Customer.information.get(Customer.customerindex).getBuyPack().add(Seller.saddprolap.get(j));
                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }



        for ( int z = 0 ; z < Seller.saddproref.size() ; z++)
        {
            if(buyid == Seller.saddproref.get(z).getId() && buyname.equals(Seller.saddproref.get(z).getName()))
            {
                if(Seller.saddproref.get(z).getCondition().equals("true")){
                    Customer.information.get(Customer.customerindex).getBuyPack().add(Seller.saddproref.get(z));
                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }


        for ( int n = 0 ; n < Seller.saddoven.size() ; n++)
        {
            if(buyid == Seller.saddoven.get(n).getId() && buyname.equals(Seller.saddoven.get(n).getName()))
            {
                if(Seller.saddoven.get(n).getCondition().equals("true")){
                    Customer.information.get(Customer.customerindex).getBuyPack().add(Seller.saddoven.get(n));
                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }


        for ( int f = 0 ; f < Seller.saddshoes.size() ; f++)
        {
            if(buyid == Seller.saddshoes.get(f).getId() && buyname.equals(Seller.saddshoes.get(f).getName()))
            {
                if(Seller.saddshoes.get(f).getCondition().equals("true")){
                    Customer.information.get(Customer.customerindex).getBuyPack().add(Seller.saddshoes.get(f));
                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }


        for ( int l = 0 ; l < Seller.sadddress.size() ; l++)
        {
            if(buyid == Seller.sadddress.get(l).getId() && buyname.equals(Seller.sadddress.get(l).getName()))
            {
                if(Seller.sadddress.get(l).getCondition().equals("true")){
                    Customer.information.get(Customer.customerindex).getBuyPack().add(Seller.sadddress.get(l));
                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }


        for ( int a = 0 ; a < Seller.saddtv.size() ; a++)
        {
            if(buyid == Seller.saddtv.get(a).getId() && buyname.equals(Seller.saddtv.get(a).getName()))
            {
                if(MainLists.tv.get(a).getCondition().equals("true")){
                    Customer.information.get(Customer.customerindex).getBuyPack().add(Seller.saddtv.get(a));
                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }

        for ( int t = 0 ; t < Seller.saddmeal.size() ; t++)
        {
            if(buyid == Seller.saddmeal.get(t).getId() && buyname.equals(Seller.saddmeal.get(t).getName()))
            {
                if(MainLists.meal.get(t).getCondition().equals("true")){

                }
                else
                {
                    System.out.println("SORRY WE DON'T HAVE IT :( !");
                }
            }

        }

        System.out.println("* GREAT DONE!!! *** BACK TO MENU 1  -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                customerPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }





    }
    // -----
}
// *****************ADMIN LISTS**********************
class AdminCont
{

    static Admin koohdel = new Admin("Koohdel", "admin", "admin", "sabersabzi2002@gmail.com", "09334821007", 80000);

    public static void saveAdmin()  throws Exception {

        File Use = new File("SavedData//Users//Admin//");
        if ( !Use.mkdirs()){
            System.out.print("!!! FILE CAN NOT CREATE !!!");
            Menu.firstMenu();
        }
        Use = new File(Use.getPath() + "//admin.txt");
        FileOutputStream fileAdmin = new FileOutputStream(Use);
        ObjectOutputStream objAdmin = new ObjectOutputStream(fileAdmin);
        objAdmin.writeObject(koohdel);
        objAdmin.close();
        fileAdmin.close();
    }
    // ----------------------------------------------------
    public static void adminPanel()throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();


        Scanner x = new Scanner(System.in);
        // Display the menu
        System.out.println("***********WELLCOME ADMIN************");
        System.out.println("* 1 : SIGN UP REQUESTS  -->         *");
        System.out.println("* 2 : EDIT INFORMATION  -->         *");
        System.out.println("* 3 : PRODUCT REQUESTS  -->         *");
        System.out.println("* 4 : ACCOUNTS LISTS    -->         *");
        System.out.println("* 5 : PRODUCTS LISTS    -->         *");
        System.out.println("* 6 : DELETE AN ACCOUNT -->         *");
        System.out.println("* 7 : DELETE AN PRODUCT -->         *");
        System.out.println("* 8 : EDIT AN PRODUCT   -->         *");
        System.out.println("* 9 : INFO OF ACCOUNT   -->         *");
        System.out.println("* 10: COMMENT REQUESTS  -->         *");
        System.out.println("* 11: BACK  MAIN MENU   -->         *");
        System.out.println("*************************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                signInRequests();
                break;
            case 2:
                editInfoAdmin();
                break;
            case 3:
                productRequests();
                break;
            case 4:
                accountsList();
                break;
            case 5:
                Menu.allGoods();
                break;
            case 6:
                deleteAccount();
                break;
            case 7:
                deleteProductAdmin();
                break;
            case 8:
                editProAdmin();
                break;
            case 9:
                showInfo();
                break;
            case 10:
                commentConfirm();
                break;
            case 11:
                Menu.firstMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }


    }
    // -----
    public static void commentConfirm()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**************YOUR COMMENTS REQUESTS*************");
        for (int i = 0; i <Comment.reqcom.size();i++)
        {
            System.out.println("****** NAME ****** ---->  " + Comment.reqcom.get(i).getPerson());
            System.out.println("****** PRODUCT NAME ****** ---->  " + Comment.reqcom.get(i).getNameP());
            System.out.println("****** COMMENT ****** ---->  " + Comment.reqcom.get(i).getCommentsT());
            System.out.println("****** CONDITION ****** ---->  " + Comment.reqcom.get(i).getCond());
            System.out.println("-----------------------------------------------");


            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Comment.com.add(Comment.reqcom.get(i));
                    Comment.com.get(i).setCond(Comment.Condition.Checked);
                    Comment.reqcom.remove(i);
                    adminPanel();
                    break;
                case 2:
                    Comment.reqcom.remove(i);
                    adminPanel();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }




    }
    // -----
    public static void editProAdmin()throws Exception{




        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("***********HERE IS YOUR ALL MODEL PRODUCTS ************");
        Scanner x = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("*(1) LASPTOP      --> : *");
        System.out.println("*(2) MOBILE       --> : *");
        System.out.println("*(3) OVEN         --> : *");
        System.out.println("*(4) TV           --> : *");
        System.out.println("*(5) REFRIGERATOR --> : *");
        System.out.println("*(6) DRESS        --> : *");
        System.out.println("*(7) SHOES        --> : *");
        System.out.println("*(8) MEAL         --> : *");
        System.out.println("*(9) MAIN PANEL   --> : *");
        System.out.println("*************************");
        System.out.println("ENTER YOUR CHOICE --> : *");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                editLap();
                break;
            case 2:
                editMob();
                break;
            case 3:
                editOven();
                break;
            case 4:
                editTv();
                break;
            case 5:
                editRef();
                break;
            case 6:
                editDress();
                break;
            case 7:
                editShoes();
                break;
            case 8:
                editMeal();
                break;
            case 9:
                adminPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }







    }
    // -----
    public static void editLap()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  LAPTOPS EDIT  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.editprolap.size();i++)
        {
            System.out.println("NAME : " + Requests.editprolap.get(i).getName());
            System.out.println("ID : " + Requests.editprolap.get(i).getId());
            System.out.println("COMPANY : " + Requests.editprolap.get(i).getCompany());
            System.out.println("PRICE : " + Requests.editprolap.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.editprolap.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.editprolap.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.editprolap.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.editprolap.get(i).getSname());
            System.out.println("CPU : " + Requests.editprolap.get(i).getCpu());
            System.out.println("GAMING : " + Requests.editprolap.get(i).getGaming());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Laptop nemoone = Requests.editprolap.get(i);
                    File User = new File("SavedData//Products//Digital//Laptops");
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Digital//Laptops");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//laptop.txt");
                    User = new File(User.getPath() + "//laptop.txt");

                    FileOutputStream fileSlap = new FileOutputStream(Use);
                    ObjectOutputStream objSlp = new ObjectOutputStream(fileSlap);
                    objSlp.writeObject(nemoone);
                    objSlp.close();
                    fileSlap.close();
                    FileOutputStream fileLap = new FileOutputStream(User);
                    ObjectOutputStream objLap = new ObjectOutputStream(fileLap);
                    objLap.writeObject(nemoone);
                    objLap.close();
                    fileLap.close();

                    Requests.editprolap.remove(i);

                    productRequests();
                    break;
                case 2:
                    Requests.editprolap.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }
    }
    // -----
    public static void editMob()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  MOBILE EDIT REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.editpromob.size();i++)
        {
            System.out.println("NAME : " + Requests.editpromob.get(i).getName());
            System.out.println("ID : " + Requests.editpromob.get(i).getId());
            System.out.println("COMPANY : " + Requests.editpromob.get(i).getCompany());
            System.out.println("PRICE : " + Requests.editpromob.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.editpromob.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.editpromob.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.editpromob.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.editpromob.get(i).getSname());
            System.out.println("SIM CARDS : " + Requests.editpromob.get(i).getSim());
            System.out.println("CAMERA MP : " + Requests.editpromob.get(i).getCam());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Mobile nemoone = Requests.editpromob.get(i);
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Digital//Mobiles");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//mobiles.txt");

                    FileOutputStream fileSmob = new FileOutputStream(Use);
                    ObjectOutputStream objSmob = new ObjectOutputStream(fileSmob);
                    objSmob.writeObject(nemoone);
                    objSmob.close();
                    fileSmob.close();

                    File User = new File("SavedData//Products//Digital//Mobiles");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//mobiles.txt");
                    FileOutputStream filemob = new FileOutputStream(User);
                    ObjectOutputStream objmob = new ObjectOutputStream(filemob);
                    objmob.writeObject(nemoone);
                    objmob.close();
                    filemob.close();
                    Requests.editpromob.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.editpromob.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }
    }
    // -----
    public static void editDress()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**********HERE IS YOUR  DRESS EDIT  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.editdress.size();i++)
        {
            System.out.println("NAME : " + Requests.editdress.get(i).getName());
            System.out.println("ID : " + Requests.editdress.get(i).getId());
            System.out.println("COMPANY : " + Requests.editdress.get(i).getCompany());
            System.out.println("PRICE : " + Requests.editdress.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.editdress.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.editdress.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.editdress.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.editdress.get(i).getSname());
            System.out.println("SIZE : " + Requests.editdress.get(i).getSize());
            System.out.println("MODEL : " + Requests.editdress.get(i).getModel());
            System.out.println("------------------------------------------");
            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();
            switch (choice) {
                case 1:
                    Dress nemoone = Requests.editdress.get(i);

                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Clothing//Dress");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//dress.txt");

                    FileOutputStream fileSdress = new FileOutputStream(Use);
                    ObjectOutputStream objSdress = new ObjectOutputStream(fileSdress);
                    objSdress.writeObject(nemoone);
                    objSdress.close();
                    fileSdress.close();



                    File User = new File("SavedData//Products//Clothing//Dress");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//dress.txt");
                    FileOutputStream filedress = new FileOutputStream(User);
                    ObjectOutputStream objdress = new ObjectOutputStream(filedress);
                    objdress.writeObject(nemoone);
                    objdress.close();
                    filedress.close();
                    productRequests();
                    Seller.sellerInformation.get(Seller.sellerindex).sadddress.remove(Product.editIndex);
                    break;
                case 2:
                    Requests.editdress.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }
    }
    // -----
    public static void editShoes()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  SHOES EDIT  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.editshoes.size();i++)
        {
            System.out.println("NAME : " + Requests.editshoes.get(i).getName());
            System.out.println("ID : " + Requests.editshoes.get(i).getId());
            System.out.println("COMPANY : " + Requests.editshoes.get(i).getCompany());
            System.out.println("PRICE : " + Requests.editshoes.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.editshoes.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.editshoes.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.editshoes.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.editshoes.get(i).getSname());
            System.out.println("FOOT SIZE : " + Requests.editshoes.get(i).getFootSize());
            System.out.println("TYPE : " + Requests.editshoes.get(i).getType());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Shoes nemoone = Requests.editshoes.get(i);

                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Clothing//Shoes");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//shoes.txt");

                    FileOutputStream fileSsh = new FileOutputStream(Use);
                    ObjectOutputStream objSsh = new ObjectOutputStream(fileSsh);
                    objSsh.writeObject(nemoone);
                    objSsh.close();
                    fileSsh.close();





                    File User = new File("SavedData//Products//Clothing//Shoes");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//shoes.txt");
                    FileOutputStream filesh = new FileOutputStream(User);
                    ObjectOutputStream objsh = new ObjectOutputStream(filesh);
                    objsh.writeObject(nemoone);
                    objsh.close();
                    filesh.close();
                    Requests.editshoes.remove(i);
                    Seller.sellerInformation.get(Seller.sellerindex).saddshoes.remove(Product.editIndex);
                    productRequests();
                    break;
                case 2:
                    Requests.editshoes.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }





    }
    // -----
    public static void editOven()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  OVEN EDIT REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.editoven.size();i++)
        {
            System.out.println("NAME : " + Requests.editoven.get(i).getName());
            System.out.println("ID : " + Requests.editoven.get(i).getId());
            System.out.println("COMPANY : " + Requests.editoven.get(i).getCompany());
            System.out.println("PRICE : " + Requests.editoven.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.editoven.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.editoven.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.editoven.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.editoven.get(i).getSname());
            System.out.println("FIRE COUNTS : " + Requests.editoven.get(i).getFireCount());
            System.out.println("BODY MATERIAL : " + Requests.editoven.get(i).getBody());
            System.out.println("MICROWAVE : " + Requests.editoven.get(i).getMicro());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();
            switch (choice) {
                case 1:
                    Oven nemoone = Requests.editoven.get(i);


                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//House//Ovens");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//ovens.txt");

                    FileOutputStream fileSoven = new FileOutputStream(Use);
                    ObjectOutputStream objSoven = new ObjectOutputStream(fileSoven);
                    objSoven.writeObject(nemoone);
                    objSoven.close();
                    fileSoven.close();


                    File User = new File("SavedData//Products//House//Ovens");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//ovens.txt");
                    FileOutputStream fileOven = new FileOutputStream(User);
                    ObjectOutputStream objOven = new ObjectOutputStream(fileOven);
                    objOven.writeObject(nemoone);
                    objOven.close();
                    fileOven.close();
                    Requests.editoven.remove(i);
                    Seller.sellerInformation.get(Seller.sellerindex).saddoven.remove(Product.editIndex);
                    productRequests();
                    break;
                case 2:
                    Requests.editoven.remove(i);

                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }

    }
    // -----
    public static void editTv()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  TV EDIT REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.edittv.size();i++)
        {
            System.out.println("NAME : " + Requests.edittv.get(i).getName());
            System.out.println("ID : " + Requests.edittv.get(i).getId());
            System.out.println("COMPANY : " + Requests.edittv.get(i).getCompany());
            System.out.println("PRICE : " + Requests.edittv.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.edittv.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.edittv.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.edittv.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.edittv.get(i).getSname());
            System.out.println("QUALITY : " + Requests.edittv.get(i).getQuality());
            System.out.println("INCHES : " + Requests.edittv.get(i).getInches());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Tv nemoone = Requests.edittv.get(i);
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//House//Tv");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//tv.txt");

                    FileOutputStream fileStv = new FileOutputStream(Use);
                    ObjectOutputStream objStv = new ObjectOutputStream(fileStv);
                    objStv.writeObject(nemoone);
                    objStv.close();
                    fileStv.close();





                    File User = new File("SavedData//Products//House//Tv");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//tv.txt");
                    FileOutputStream filetv = new FileOutputStream(User);
                    ObjectOutputStream objtv = new ObjectOutputStream(filetv);
                    objtv.writeObject(nemoone);
                    objtv.close();
                    filetv.close();
                    Requests.edittv.remove(i);
                    Seller.sellerInformation.get(Seller.sellerindex).saddtv.remove(Product.editIndex);
                    productRequests();
                    break;
                case 2:
                    Requests.edittv.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }

    }
    // -----
    public static void editRef()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  REFRIGERATOR EDIT REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.editproref.size();i++)
        {
            System.out.println("NAME : " + Requests.editproref.get(i).getName());
            System.out.println("ID : " + Requests.editproref.get(i).getId());
            System.out.println("COMPANY : " + Requests.editproref.get(i).getCompany());
            System.out.println("PRICE : " + Requests.editproref.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.editproref.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.editproref.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.editproref.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.editproref.get(i).getSname());
            System.out.println("CAPACITY : " + Requests.editproref.get(i).getLitre());
            System.out.println("DOOR TYPE : " + Requests.editproref.get(i).getDoor());
            System.out.println("FREEZER : " + Requests.editproref.get(i).getFreezer());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Refrigerator nemoone = Requests.editproref.get(i);

                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//House//Refrigerator");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//refrigerator.txt");

                    FileOutputStream fileSref = new FileOutputStream(Use);
                    ObjectOutputStream objSref = new ObjectOutputStream(fileSref);
                    objSref.writeObject(nemoone);
                    objSref.close();
                    fileSref.close();


                    File User = new File("SavedData//Products//House//Refrigerator");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//refrigerator.txt");
                    FileOutputStream fileref = new FileOutputStream(User);
                    ObjectOutputStream objref = new ObjectOutputStream(fileref);
                    objref.writeObject(nemoone);
                    objref.close();
                    fileref.close();
                    Requests.editproref.remove(i);
                    Seller.sellerInformation.get(Seller.sellerindex).saddproref.remove(Product.editIndex);
                    productRequests();
                    break;
                case 2:
                    Requests.editproref.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }




    }
    // -----
    public static void editMeal()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  FOOD  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.editmeal.size();i++)
        {
            System.out.println("NAME : " + Requests.editmeal.get(i).getName());
            System.out.println("ID : " + Requests.editmeal.get(i).getId());
            System.out.println("COMPANY : " + Requests.editmeal.get(i).getCompany());
            System.out.println("PRICE : " + Requests.editmeal.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.editmeal.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.editmeal.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.editmeal.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.editmeal.get(i).getSname());
            System.out.println("------------------------------------------");


            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Meal nemoone = Requests.editmeal.get(i);
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Meal");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//food.txt");

                    FileOutputStream fileSfood = new FileOutputStream(Use);
                    ObjectOutputStream objSfood = new ObjectOutputStream(fileSfood);
                    objSfood.writeObject(nemoone);
                    objSfood.close();
                    fileSfood.close();



                    File User = new File("SavedData//Products//Meal");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//food.txt");
                    FileOutputStream filefood = new FileOutputStream(User);
                    ObjectOutputStream objfood = new ObjectOutputStream(filefood);
                    objfood.writeObject(nemoone);
                    objfood.close();
                    filefood.close();
                    Seller.sellerInformation.get(Seller.sellerindex).saddmeal.remove(Product.editIndex);
                    Requests.editmeal.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.addmeal.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }
    }
    // -----
    public static void deleteProductAdmin()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("********** REQUESTS TO DELETE PRODUCT ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.deldel.size();i++)
        {
            System.out.println("NAME : " + Requests.deldel.get(i).getName());
            System.out.println("ID : " + Requests.deldel.get(i).getId());
            System.out.println("PRICE : " + Requests.deldel.get(i).getPrice());
            System.out.println("DESCRIPTION : " + Requests.deldel.get(i).getDescription());
            System.out.println("COMPANY : " + Requests.deldel.get(i).getCompany());
            System.out.println("RATE : " + Requests.deldel.get(i).getAve_rate());
            System.out.println("-----------------------------------------------");
            System.out.println("PLEASE ENTER YOUR CHOICE (1 delete item) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();
            x.nextLine();


            switch (choice) {
                case 1:

                    for ( int k = 0 ; k < Seller.sadddress.size() ; k++){

                        if(Requests.deldel.get(i).getId() == Seller.sadddress.get(k).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).sadddress.remove(k);
                            Requests.deldel.remove(i);
                        }
                    }
                    for ( int d = 0 ; d < Seller.saddmeal.size(); d++){

                        if(Requests.deldel.get(i).getId() == Seller.saddmeal.get(d).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).saddmeal.remove(d);
                            Requests.deldel.remove(i);
                        }
                    }
                    for (int r = 0 ; r < Seller.saddoven.size(); r++){

                        if(Requests.deldel.get(i).getId() == Seller.saddoven.get(r).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).saddoven.remove(r);
                            Requests.deldel.remove(i);
                        }
                    }
                    for( int w = 0; w < Seller.saddtv.size(); w++){

                        if(Requests.deldel.get(i).getId() == Seller.saddtv.get(w).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).saddtv.remove(w);
                            Requests.deldel.remove(i);
                        }
                    }
                    for( int a = 0; a < Seller.saddprolap.size(); a++){

                        if(Requests.deldel.get(i).getId() == Seller.saddprolap.get(a).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).saddprolap.remove(a);
                            Requests.deldel.remove(i);
                        }
                    }
                    for(int z = 0; z < Seller.saddpromob.size(); z++){

                        if(Requests.deldel.get(i).getId() == Seller.saddpromob.get(z).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).saddpromob.remove(z);
                            Requests.deldel.remove(i);
                        }
                    }
                    for ( int c = 0; c < Seller.saddshoes.size(); c++){

                        if(Requests.deldel.get(i).getId() == Seller.saddshoes.get(c).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).saddshoes.remove(c);
                            Requests.deldel.remove(i);

                        }
                    }
                    for (int v = 0; v < Seller.saddproref.size(); v++){

                        if(Requests.deldel.get(i).getId() == Seller.saddproref.get(v).getId())
                        {
                            Seller.sellerInformation.get(Seller.sellerindex).saddproref.remove(v);
                            Requests.deldel.remove(i);

                        }
                    }

                    adminPanel();
                    break;
                case 2:
                    Requests.deldel.remove(i);
                    adminPanel();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }


    }
    // -----
    public static void showInfo()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("*************DEAR ADMIN**************");
        System.out.println("* 1 : FULL NAME :       -->"+koohdel.getName()+"*");
        System.out.println("* 2 : FULL USER NAME :  -->"+koohdel.getLoginName()+"*");
        System.out.println("* 3 : FULL PASSWORD :   -->"+koohdel.getPassword()+"*");
        System.out.println("* 4 : YOUR EMAIL :      -->"+koohdel.getEmail()+"*");
        System.out.println("* 5 : PHONE NUMBER :    -->"+koohdel.getPhNumber()+"*");
        System.out.println("* 6 : YOUR CREDIT :     -->"+koohdel.getCredit()+"*");
        System.out.println("* 7 : BACK TO MENU      -->*");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                adminPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }



    }
    // -----
    public static void signInRequests()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.req.size();i++)
        {
            System.out.println("NAME : " + Requests.req.get(i).getName());
            System.out.println("EMAIL : " + Requests.req.get(i).getEmail());
            System.out.println("PHONE NUMBER : " + Requests.req.get(i).getPhNumber());
            System.out.println("USER NAME : " + Requests.req.get(i).getLoginName());
            System.out.println("PASSWORD : " + Requests.req.get(i).getPassword());
            System.out.println("COMPANY NAME : " + Requests.req.get(i).getCoInfo());

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();
            Seller person = Requests.req.get(i);

            switch (choice) {
                case 1:
                    Seller.sellerInformation.add(Requests.req.get(i));
                    File User = new File("SavedData//Users//Sellers//Sellerfolder");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//seller.txt");
                    FileOutputStream fileSeller = new FileOutputStream(User);
                    ObjectOutputStream objSeller = new ObjectOutputStream(fileSeller);
                    objSeller.writeObject(person);
                    objSeller.close();
                    fileSeller.close();
                    Requests.req.remove(i);
                    adminPanel();
                    break;
                case 2:
                    Requests.req.remove(i);
                    signInRequests();
                    break;

                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }



    }
    // -----
    public static void productRequests()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("***********HERE IS YOUR ALL MODEL PRODUCTS ************");
        Scanner x = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("*(1) LASPTOP      --> : *");
        System.out.println("*(2) MOBILE       --> : *");
        System.out.println("*(3) OVEN         --> : *");
        System.out.println("*(4) TV           --> : *");
        System.out.println("*(5) REFRIGERATOR --> : *");
        System.out.println("*(6) DRESS        --> : *");
        System.out.println("*(7) SHOES        --> : *");
        System.out.println("*(8) MEAL         --> : *");
        System.out.println("*(9) MAIN PANEL   --> : *");
        System.out.println("*************************");
        System.out.println("ENTER YOUR CHOICE --> : *");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                confLap();
                break;
            case 2:
                confMob();
                break;
            case 3:
                confOven();
                break;
            case 4:
                confTv();
                break;
            case 5:
                confRef();
                break;
            case 6:
                confDress();
                break;
            case 7:
                confShoes();
                break;
            case 8:
                confMeal();
                break;
            case 9:
                adminPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }

    }
    // -----
    public static void confLap()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  LAPTOPS REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.addprolap.size();i++)
        {
            System.out.println("NAME : " + Requests.addprolap.get(i).getName());
            System.out.println("ID : " + Requests.addprolap.get(i).getId());
            System.out.println("COMPANY : " + Requests.addprolap.get(i).getCompany());
            System.out.println("PRICE : " + Requests.addprolap.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.addprolap.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.addprolap.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.addprolap.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.addprolap.get(i).getSname());
            System.out.println("CPU : " + Requests.addprolap.get(i).getCpu());
            System.out.println("GAMING : " + Requests.addprolap.get(i).getGaming());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Laptop nemoone = Requests.addprolap.get(i);
                    File User = new File("SavedData//Products//Digital//Laptops");
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Digital//Laptops");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//laptop.txt");
                    User = new File(User.getPath() + "//laptop.txt");

                    FileOutputStream fileSlap = new FileOutputStream(Use);
                    ObjectOutputStream objSlp = new ObjectOutputStream(fileSlap);
                    objSlp.writeObject(nemoone);
                    objSlp.close();
                    fileSlap.close();
                    FileOutputStream fileLap = new FileOutputStream(User);
                    ObjectOutputStream objLap = new ObjectOutputStream(fileLap);
                    objLap.writeObject(nemoone);
                    objLap.close();
                    fileLap.close();
                    Requests.addprolap.remove(i);
                    productRequests();

                    break;
                case 2:
                    Requests.addprolap.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }


    }
    // -----
    public static void confMob()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**********HERE IS YOUR  MOBILE REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.addpromob.size();i++)
        {
            System.out.println("NAME : " + Requests.addpromob.get(i).getName());
            System.out.println("ID : " + Requests.addpromob.get(i).getId());
            System.out.println("COMPANY : " + Requests.addpromob.get(i).getCompany());
            System.out.println("PRICE : " + Requests.addpromob.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.addpromob.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.addpromob.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.addpromob.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.addpromob.get(i).getSname());
            System.out.println("SIM CARDS : " + Requests.addpromob.get(i).getSim());
            System.out.println("CAMERA MP : " + Requests.addpromob.get(i).getCam());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Mobile nemoone = Requests.addpromob.get(i);
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Digital//Mobiles");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//mobiles.txt");

                    FileOutputStream fileSmob = new FileOutputStream(Use);
                    ObjectOutputStream objSmob = new ObjectOutputStream(fileSmob);
                    objSmob.writeObject(nemoone);
                    objSmob.close();
                    fileSmob.close();

                    File User = new File("SavedData//Products//Digital//Mobiles");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//mobiles.txt");
                    FileOutputStream filemob = new FileOutputStream(User);
                    ObjectOutputStream objmob = new ObjectOutputStream(filemob);
                    objmob.writeObject(nemoone);
                    objmob.close();
                    filemob.close();
                    Requests.addpromob.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.addpromob.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }



    }
    // -----
    public static void confOven()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();


        System.out.println("**********HERE IS YOUR  OVEN REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.addoven.size();i++)
        {
            System.out.println("NAME : " + Requests.addoven.get(i).getName());
            System.out.println("ID : " + Requests.addoven.get(i).getId());
            System.out.println("COMPANY : " + Requests.addoven.get(i).getCompany());
            System.out.println("PRICE : " + Requests.addoven.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.addoven.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.addoven.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.addoven.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.addoven.get(i).getSname());
            System.out.println("FIRE COUNTS : " + Requests.addoven.get(i).getFireCount());
            System.out.println("BODY MATERIAL : " + Requests.addoven.get(i).getBody());
            System.out.println("MICROWAVE : " + Requests.addoven.get(i).getMicro());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Oven nemoone = Requests.addoven.get(i);


                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//House//Ovens");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//ovens.txt");

                    FileOutputStream fileSoven = new FileOutputStream(Use);
                    ObjectOutputStream objSoven = new ObjectOutputStream(fileSoven);
                    objSoven.writeObject(nemoone);
                    objSoven.close();
                    fileSoven.close();


                    File User = new File("SavedData//Products//House//Ovens");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//ovens.txt");
                    FileOutputStream fileOven = new FileOutputStream(User);
                    ObjectOutputStream objOven = new ObjectOutputStream(fileOven);
                    objOven.writeObject(nemoone);
                    objOven.close();
                    fileOven.close();
                    Requests.addoven.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.addoven.remove(i);

                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }

    }
    // -----
    public static void confRef()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  REFRIGERATOR REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.addproref.size();i++)
        {
            System.out.println("NAME : " + Requests.addproref.get(i).getName());
            System.out.println("ID : " + Requests.addproref.get(i).getId());
            System.out.println("COMPANY : " + Requests.addproref.get(i).getCompany());
            System.out.println("PRICE : " + Requests.addproref.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.addproref.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.addproref.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.addproref.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.addproref.get(i).getSname());
            System.out.println("CAPACITY : " + Requests.addproref.get(i).getLitre());
            System.out.println("DOOR TYPE : " + Requests.addproref.get(i).getDoor());
            System.out.println("FREEZER : " + Requests.addproref.get(i).getFreezer());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Refrigerator nemoone = Requests.addproref.get(i);

                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//House//Refrigerator");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//refrigerator.txt");

                    FileOutputStream fileSref = new FileOutputStream(Use);
                    ObjectOutputStream objSref = new ObjectOutputStream(fileSref);
                    objSref.writeObject(nemoone);
                    objSref.close();
                    fileSref.close();


                    File User = new File("SavedData//Products//House//Refrigerator");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//refrigerator.txt");
                    FileOutputStream fileref = new FileOutputStream(User);
                    ObjectOutputStream objref = new ObjectOutputStream(fileref);
                    objref.writeObject(nemoone);
                    objref.close();
                    fileref.close();
                    Requests.addproref.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.addproref.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }




    }
    // -----
    public static void confTv()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  TV  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.addtv.size();i++)
        {
            System.out.println("NAME : " + Requests.addtv.get(i).getName());
            System.out.println("ID : " + Requests.addtv.get(i).getId());
            System.out.println("COMPANY : " + Requests.addtv.get(i).getCompany());
            System.out.println("PRICE : " + Requests.addtv.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.addtv.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.addtv.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.addtv.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.addtv.get(i).getSname());
            System.out.println("QUALITY : " + Requests.addtv.get(i).getQuality());
            System.out.println("INCHES : " + Requests.addtv.get(i).getInches());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Tv nemoone = Requests.addtv.get(i);
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//House//Tv");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//tv.txt");

                    FileOutputStream fileStv = new FileOutputStream(Use);
                    ObjectOutputStream objStv = new ObjectOutputStream(fileStv);
                    objStv.writeObject(nemoone);
                    objStv.close();
                    fileStv.close();





                    File User = new File("SavedData//Products//House//Tv");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//tv.txt");
                    FileOutputStream filetv = new FileOutputStream(User);
                    ObjectOutputStream objtv = new ObjectOutputStream(filetv);
                    objtv.writeObject(nemoone);
                    objtv.close();
                    filetv.close();
                    Requests.addtv.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.addtv.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }




    }
    // -----
    public static void confShoes()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  SHOES  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.addshoes.size();i++)
        {
            System.out.println("NAME : " + Requests.addshoes.get(i).getName());
            System.out.println("ID : " + Requests.addshoes.get(i).getId());
            System.out.println("COMPANY : " + Requests.addshoes.get(i).getCompany());
            System.out.println("PRICE : " + Requests.addshoes.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.addshoes.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.addshoes.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.addshoes.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.addshoes.get(i).getSname());
            System.out.println("FOOT SIZE : " + Requests.addshoes.get(i).getFootSize());
            System.out.println("TYPE : " + Requests.addshoes.get(i).getType());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Shoes nemoone = Requests.addshoes.get(i);

                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Clothing//Shoes");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//shoes.txt");

                    FileOutputStream fileSsh = new FileOutputStream(Use);
                    ObjectOutputStream objSsh = new ObjectOutputStream(fileSsh);
                    objSsh.writeObject(nemoone);
                    objSsh.close();
                    fileSsh.close();





                    File User = new File("SavedData//Products//Clothing//Shoes");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//shoes.txt");
                    FileOutputStream filesh = new FileOutputStream(User);
                    ObjectOutputStream objsh = new ObjectOutputStream(filesh);
                    objsh.writeObject(nemoone);
                    objsh.close();
                    filesh.close();
                    Requests.addshoes.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.addshoes.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }




    }
    // -----
    public static void confDress()throws Exception{



        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  DRESS  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.adddress.size();i++)
        {
            System.out.println("NAME : " + Requests.adddress.get(i).getName());
            System.out.println("ID : " + Requests.adddress.get(i).getId());
            System.out.println("COMPANY : " + Requests.adddress.get(i).getCompany());
            System.out.println("PRICE : " + Requests.adddress.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.adddress.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.adddress.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.adddress.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.adddress.get(i).getSname());
            System.out.println("SIZE : " + Requests.adddress.get(i).getSize());
            System.out.println("MODEL : " + Requests.adddress.get(i).getModel());
            System.out.println("------------------------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Dress nemoone = Requests.adddress.get(i);

                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Clothing//Dress");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//dress.txt");

                    FileOutputStream fileSdress = new FileOutputStream(Use);
                    ObjectOutputStream objSdress = new ObjectOutputStream(fileSdress);
                    objSdress.writeObject(nemoone);
                    objSdress.close();
                    fileSdress.close();



                    File User = new File("SavedData//Products//Clothing//Dress");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//dress.txt");
                    FileOutputStream filedress = new FileOutputStream(User);
                    ObjectOutputStream objdress = new ObjectOutputStream(filedress);
                    objdress.writeObject(nemoone);
                    objdress.close();
                    filedress.close();
                    Requests.adddress.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.adddress.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }


    }
    // -----
    public static void confMeal()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS YOUR  FOOD  REQUESTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Requests.addmeal.size();i++)
        {
            System.out.println("NAME : " + Requests.addmeal.get(i).getName());
            System.out.println("ID : " + Requests.addmeal.get(i).getId());
            System.out.println("COMPANY : " + Requests.addmeal.get(i).getCompany());
            System.out.println("PRICE : " + Requests.addmeal.get(i).getPrice());
            System.out.println("CONDITION : " + Requests.addmeal.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Requests.addmeal.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Requests.addmeal.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Requests.addmeal.get(i).getSname());
            System.out.println("------------------------------------------");


            System.out.println("PLEASE ENTER YOUR CHOICE (1 confirm) or (2 ignore) --> :");
            System.out.println("BACK TO MENU WITH 3 ---> : ");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Meal nemoone = Requests.addmeal.get(i);
                    File Use = new File("SavedData//Users//Sellers//Sellerfolder//Products//Meal");
                    if ( !Use.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    Use = new File(Use.getPath() + "//food.txt");

                    FileOutputStream fileSfood = new FileOutputStream(Use);
                    ObjectOutputStream objSfood = new ObjectOutputStream(fileSfood);
                    objSfood.writeObject(nemoone);
                    objSfood.close();
                    fileSfood.close();



                    File User = new File("SavedData//Products//Meal");
                    if ( !User.mkdirs()){
                        System.out.print("!!! FILE CAN NOT CREATE !!!");
                        Menu.firstMenu();
                    }
                    User = new File(User.getPath() + "//food.txt");
                    FileOutputStream filefood = new FileOutputStream(User);
                    ObjectOutputStream objfood = new ObjectOutputStream(filefood);
                    objfood.writeObject(nemoone);
                    objfood.close();
                    filefood.close();
                    Requests.addmeal.remove(i);
                    productRequests();
                    break;
                case 2:
                    Requests.addmeal.remove(i);
                    productRequests();
                    break;
                case 3:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }

    }
    // -----
    public static void accountsList()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("***********HERE IS YOUR SELLERS ************");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.sellerInformation.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(i).getName());
            System.out.println("EMAIL : " + Seller.sellerInformation.get(i).getEmail());
            System.out.println("PHONE NUMBER : " + Seller.sellerInformation.get(i).getPhNumber());
            System.out.println("USER NAME : " + Seller.sellerInformation.get(i).getLoginName());
            System.out.println("PASSWORD : " + Seller.sellerInformation.get(i).getPassword());
            System.out.println("COMPANY NAME : " + Seller.sellerInformation.get(i).getCoInfo());
        }




        System.out.println("**********HERE IS YOUR CUSTOMERS ***********");
        for (int i = 0; i <Customer.information.size();i++)
        {
            System.out.println("NAME : " + Customer.information.get(i).getName());
            System.out.println("EMAIL : " + Customer.information.get(i).getEmail());
            System.out.println("PHONE NUMBER : " + Customer.information.get(i).getPhNumber());
            System.out.println("USER NAME : " + Customer.information.get(i).getLoginName());
            System.out.println("PASSWORD : " + Customer.information.get(i).getPassword());
        }

        System.out.println("BACK TO YOUR PANEL WITH (1) --> :");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                adminPanel();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }
    }
    // -----
    public static void deleteAccount()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("***********HERE IS YOUR SELLERS ************");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.sellerInformation.size();i++)
        {
            System.out.println("NAME : " + Seller.sellerInformation.get(i).getName());
            System.out.println("EMAIL : " + Seller.sellerInformation.get(i).getEmail());
            System.out.println("PHONE NUMBER : " + Seller.sellerInformation.get(i).getPhNumber());
            System.out.println("USER NAME : " + Seller.sellerInformation.get(i).getLoginName());
            System.out.println("PASSWORD : " + Seller.sellerInformation.get(i).getPassword());
            System.out.println("COMPANY NAME : " + Seller.sellerInformation.get(i).getCoInfo());
            System.out.println("-----------------------------");
        }




        System.out.println("**********HERE IS YOUR CUSTOMERS ***********");
        for (int i = 0; i <Customer.information.size();i++)
        {
            System.out.println("NAME : " + Customer.information.get(i).getName());
            System.out.println("EMAIL : " + Customer.information.get(i).getEmail());
            System.out.println("PHONE NUMBER : " + Customer.information.get(i).getPhNumber());
            System.out.println("USER NAME : " + Customer.information.get(i).getLoginName());
            System.out.println("PASSWORD : " + Customer.information.get(i).getPassword());
            System.out.println("-----------------------------");
        }

        System.out.println("PLEASE ENTER YOUR CHOICE (1 customers) or (2 sellers) --> :");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                deleteCustomer();
                break;
            case 2:
                deleteSeller();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();
        }
    }
    // -----
    public static void deleteSeller()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("***********HERE IS YOUR SELLERS ************");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.sellerInformation.size();i++)
        {

            System.out.println("NAME : " + Seller.sellerInformation.get(i).getName());
            System.out.println("EMAIL : " + Seller.sellerInformation.get(i).getEmail());
            System.out.println("PHONE NUMBER : " + Seller.sellerInformation.get(i).getPhNumber());
            System.out.println("USER NAME : " + Seller.sellerInformation.get(i).getLoginName());
            System.out.println("PASSWORD " + Seller.sellerInformation.get(i).getPassword());
            System.out.println("COMPANY NAME " + Seller.sellerInformation.get(i).getCoInfo());
            System.out.println("-----------------------------");

            System.out.println("PLEASE ENTER YOUR CHOICE (1 delete) or (2 last menu) --> :");

            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Seller.sellerInformation.remove(i);
                    break;
                case 2:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }





    }
    // -----
    public static void deleteCustomer()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();


        System.out.println("**********HERE IS YOUR CUSTOMERS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Customer.information.size();i++)
        {

            System.out.println("NAME : " + Customer.information.get(i).getName());
            System.out.println("EMAIL : " + Customer.information.get(i).getEmail());
            System.out.println("PHONE NUMBER : " + Customer.information.get(i).getPhNumber());
            System.out.println("USER NAME : " + Customer.information.get(i).getLoginName());
            System.out.println("PASSWORD " + Customer.information.get(i).getPassword());
            System.out.println("-----------------------------");


            System.out.println("PLEASE ENTER YOUR CHOICE (1 delete) or (2 last menu) --> :");

            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    Customer.information.remove(i);
                    break;
                case 2:
                    adminPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    Menu.firstMenu();
            }
        }

    }
    // -----
    public static  void editInfoAdmin()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);

        String newuser , newpassword , newemail , newname , newphone;

        System.out.println("*********ADMIN INFORMATION EDIT PANEL*************");
        System.out.println("*********      ENTER NEW NAME --->               *");
        newname = x.next();
        koohdel.setName(newname);
        System.out.println("*********      ENTER NEW USER --->              *");
        newuser = x.next();
        koohdel.setLoginName(newuser);
        System.out.println("*********      ENTER NEW PASS --->               *");
        newpassword = x.next();
        koohdel.setPassword(newpassword);
        System.out.println("*********      ENTER NEW EMAIL--->               *");
        newemail = x.next();
        koohdel.setEmail(newemail);
        try {
            if (newemail.length() > 40)
                throw new WrongEmailException("!!!YOUR EMAIL IS LONG!!!");
        }
        catch(WrongEmailException e)
        {
            System.out.print(e.getMessage());
            editInfoAdmin();
        }
        System.out.println("*********      ENTER NEW PHONE--->               *");
        newphone = x.next();
        try {
            if (newphone.length() > 16)
                throw new WrongPhoneException("!!!YOUR PHONE NUMBER IS LONG!!!");
        }
        catch(WrongPhoneException e)
        {
            System.out.print(e.getMessage());
            editInfoAdmin();
        }
        koohdel.setPhNumber(newphone);

        System.out.println("*GREAT DONE !! BACK TO MAIN MENU WHITH 1 -->    *");
        System.out.println("*************************************************");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                AdminCont.adminPanel();
                break;

            default:
                System.out.println("INVALID CHOICE !");
                Menu.firstMenu();

        }


    }

}
// *********************MENU TABS********************
class Menu
{
    static Customer customerLoggedin;
    static Seller sellerLoggedin;
    public static void firstMenu()throws Exception{
        System.out.print("\033[H\033[2J");
        System.out.flush();


        Scanner in = new Scanner(System.in);
        // Display the menu
        System.out.println("----KOOHDEL ONLINE SHOP!----");
        System.out.println("****************************");
        System.out.println("* 1 : LOGIN MENU       --> *");
        System.out.println("* 2 : LIST OF PRODUCTS --> *");
        System.out.println("* 3 : PROGRAMMER INFO  --> *");
        System.out.println("* 4 : EXIT !           --> *");
        System.out.println("****************************");

        System.out.println("PLEASE ENTER YOUR CHOICE-->:");

        int choice = in.nextInt();

        switch (choice) {
            case 1:
                loginMenu();
                break;
            case 2:
                checkBuySee();
                break;
            case 3:
                System.out.println("***Saber Sabzi 1400 UI Dr.Ramzani Student***");
                break;
            case 4:
                System.out.println("!!!!!! GOOD BYE !!!!!!");
                return;
            default:
                System.out.println("INVALID CHOICE !");
        }
    }
    // ----------------------------------------------------
    public static void checkBuySee()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner in  = new Scanner(System.in);
        System.out.println("*!DO YOU WANT TO BUY ? FIRST LOGIN!*");
        System.out.println("****************************");
        System.out.println("* 1 : LOGIN & BUY      --> *");
        System.out.println("* 2 : JUST SEE         --> *");
        System.out.println("* 3 : MAIN MENU        --> *");
        System.out.println("****************************");

        System.out.println("PLEASE ENTER YOUR CHOICE-->:");

        int choice = in.nextInt();

        switch (choice) {
            case 1:
                loginMenu();
                break;
            case 2:
                listProductMenu();
                break;
            case 3:
                firstMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // ----------------------------------------------------
    public static void loginMenu()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner x = new Scanner(System.in);
        // Display the menu
        System.out.println("*******************************************");
        System.out.println("* 1 : LOGIN TO ADMIN & SELLER ACCOUNT --> *");
        System.out.println("* 2 : LOGIN TO CUSTOMER ACCOUNT       --> *");
        System.out.println("* 3 : SIGN UP & CREATE ACCOUNT        --> *");
        System.out.println("* 4 : BACK TO MAIN MENU               --> *");
        System.out.println("*******************************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                asEntrance();
                break;
            case 2:
                cEntrance();
            case 3:
                signUp();
                break;
            case 4:
                firstMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
        }

    }
    // ----------------------------------------------------
    public static void listProductMenu()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner x = new Scanner(System.in);

        System.out.println("********WELLCOME TO LIST OF PRODUCTS PANEL********");
        System.out.println("**************************************************");
        System.out.println("* 1 : DIGITAL PRODUCTS              -->          *");
        System.out.println("* 2 : CLOTING PART                  -->          *");
        System.out.println("* 3 : HOUSE AND KITCHEN             -->          *");
        System.out.println("* 4 : MEAL AND FOODS                -->          *");
        System.out.println("* 5 : ALL OF GOODFS(NO FILTER)      -->          *");
        System.out.println("* 6 : COMMENTS OF PEOPLE FOR GOODS  -->          *");
        System.out.println("* 7 : SORT BY PRICE (UP)            -->          *");
        System.out.println("* 8 : SORT BY PRICE (LESS)          -->          *");
        System.out.println("* 9 : SORT BY RATE                  -->          *");
        System.out.println("* 10 : BACK TO MAIN MENU            -->          *");
        System.out.println("**************************************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                digitalPart();
                break;
            case 2:
                clothingPart();
            case 3:
                housePart();
                break;
            case 4:
                foodPart();
                break;
            case 5:
                allGoods();
                break;
            case 6:
                showComments();
                break;
            case 7:
                sortedMenu();
                break;
            case 8:
                sortedMenuLess();
                break;
            case 9:
                sortedMenuRate();
                break;
            case 10:
                firstMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
        }


    }
    // ----------------------------------------------------
    public static void asEntrance()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("******WELLCOME TO LOGIN UP PANEL******");
        System.out.println("**************************************");
        System.out.println("* ENTER YOUR USER NAME :     --->    *");
        Scanner inner = new Scanner(System.in);
        String loginname = inner.nextLine();
        System.out.println("* ENTER YOUR FULL PASSWORD : --->    *");
        String inpassword = inner.nextLine();
        if (loginname.equals(AdminCont.koohdel.getLoginName()) && inpassword.equals(AdminCont.koohdel.getPassword())) {

            AdminCont.adminPanel();
        }

        else {
            System.out.println("YOUR PASSWORD AND USER NAME IS WRONG");
        }
        File file = new File("SavedData//Users//Sellers//Sellerfolder//seller.txt");
        FileInputStream fileSeller = new FileInputStream(file);
        ObjectInputStream objSeller = new ObjectInputStream(fileSeller);


        while(true)
        {
            Seller seller;
            try{

                seller = (Seller) objSeller.readObject();

            }
            catch(Exception except){

                break;
            }

            if(loginname.equals(seller.getLoginName()) && inpassword.equals(seller.getPassword())) {
                sellerLoggedin = seller;
                SellerCont.sellerPanel();
            }

            else {
                System.out.println("YOUR PASSWORD AND USER NAME IS WRONG");

            }
        }

    }
    // ----------------------------------------------------
    public static void cEntrance()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("******WELLCOME TO LOGIN UP PANEL******");
        System.out.println("**************************************");
        System.out.println("* ENTER YOUR USER NAME :     --->    *");
        Scanner inner = new Scanner(System.in);
        String loginnames = inner.nextLine();
        System.out.println("* ENTER YOUR FULL PASSWORD : --->    *");
        String inpasswords = inner.nextLine();

        File file = new File("SavedData//Users//Customers//customerfolder//customer.txt");
        FileInputStream fileCustomer = new FileInputStream(file);
        ObjectInputStream objCustomer = new ObjectInputStream(fileCustomer);


        while(true)
        {
            Customer customer;
            try{
                customer = (Customer) objCustomer.readObject();
            }
            catch(Exception except){

                break;
            }

            if(loginnames.equals(customer.getLoginName()) && inpasswords.equals(customer.getPassword())) {
                customerLoggedin = customer;
                CustomerCont.customerPanel();
            }

            else {
                System.out.println("YOUR PASSWORD AND USER NAME IS WRONG");
            }
        }

    }
    // ----------------------------------------------------
    public static void signUp() throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("*******WELLCOME TO SIGN UP PANEL********");
        System.out.println("****************************************");
        System.out.println("* ENTER YOUR USER NAME :         --->  *");
        Scanner inner = new Scanner(System.in);
        Scanner x = new Scanner(System.in);
        String loginname = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR FULL INT PASSWORD : --->  *");
        String inpassword = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR FULL NAME  :        --->  *");
        String inname = inner.nextLine();
        inner.nextLine();
        System.out.println("* ENTER YOUR PHONE NUMBER :      --->  *");
        String inphone = inner.nextLine();

        inner.nextLine();
        try{
            if (inphone.length() > 16)
                throw new WrongPhoneException("!!!YOUR PHONE NUMBER IS MORE THAN 16!!!");
        }
        catch(WrongPhoneException e)
        {
            System.out.print(e.getMessage());
        }
        System.out.println("* ENTER YOUR EMAIL :             --->  *");
        String inemail = inner.nextLine();
        inner.nextLine();

        try {
            if (inemail.length() > 35)
                throw new WrongEmailException("!!!YOUR EMAIL IS LONG!!!");
        }
        catch(WrongEmailException e)
        {
            System.out.print(e.getMessage());
        }
        System.out.println("* ENTER YOUR CREDIT MONEY :      --->  *");
        Double incredit = null;
        try {
            incredit = inner.nextDouble();

        }
        catch(InputMismatchException e){

            signUp();
            e.getMessage();
        }
        inner.nextLine();
        inner.nextLine();
        System.out.println("* CUSTOMER(1) OR SELLER(2) :     --->  *");
        int inWho = inner.nextInt();
        inner.nextLine();
        inner.nextLine();
        if (inWho == 2) {
            System.out.println("* ENTER YOUR COMPANY NAME :  --->  *");
            String incoInfo = inner.nextLine();
            inner.nextLine();

            Seller request = new Seller(inname, loginname, inpassword, inemail, inphone, incredit, incoInfo);
            Requests.req.add(request);


            System.out.println("*** WAIT UNTIL ADMIN CONFIRM *** BACK TO MENU(1)");
            int choice = x.nextInt();


            switch (choice) {
                case 1:
                    firstMenu();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
            }


        } else {

            Customer person = new Customer(inname, loginname, inpassword, inemail, inphone, incredit);
            Customer.information.add(person);
            File User = new File("SavedData//Users//Customers//customerfolder");
            if ( !User.mkdirs()){
                System.out.print("!!! FILE CAN NOT CREATE !!!");
                firstMenu();
            }
            User = new File(User.getPath() + "//customer.txt");
            FileOutputStream fileCustomer = new FileOutputStream(User);
            ObjectOutputStream objCustomer = new ObjectOutputStream(fileCustomer);
            objCustomer.writeObject(person);
            objCustomer.close();
            fileCustomer.close();

            System.out.println("***** GREAT!! DONE **** BACK TO MENU(1) GO TO YOUR PANEL(2)");
            int choices = x.nextInt();

            switch (choices) {
                case 1:
                    firstMenu();
                    break;
                case 2:
                    CustomerCont.customerPanel();
                    break;
                default:
                    System.out.println("INVALID CHOICE !");
                    firstMenu();
            }

        }

    }
    // ----------------------------------------------------
    public static void digitalPart()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**************WELLCOME TO DIGITAL PRODUCTS PART*************");
        System.out.println("* 1 : LAPTOPS DEVICES   -->  *");
        System.out.println("* 2 : MOBILE  DEVICES   -->  *");
        System.out.println("* 3 : ALL DEVICES       -->  *");
        System.out.println("* 4 : BACK TO LAST MENU -->  *");
        System.out.println("******************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {

            case 1:
                laptopList();
                break;
            case 2:
                mobileList();
                break;
            case 3:
                digitalall();
                break;
            case 4:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----
    public static void digitalall()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**********HERE IS OUR DIGITAL PRODUCTS ***********");
        File User = new File("SavedData//Products//Digital//Mobiles//mobiles.txt");
        FileInputStream filemob = new FileInputStream(User);
        ObjectInputStream objmob = new ObjectInputStream(filemob);

        while(true){
            Mobile mobile;
            try{
                mobile = (Mobile) objmob.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + mobile.getName());
            System.out.println("ID : " + mobile.getId());
            System.out.println("COMPANY : " + mobile.getCompany());
            System.out.println("PRICE : " + mobile.getPrice());
            System.out.println("CONDITION : " + mobile.getCondition());
            System.out.println("DESCRIPTION : " + mobile.getDescription());
            System.out.println("AVERAGE RATE : " + mobile.getAve_rate());
            System.out.println("SELLER NAME : " + mobile.getSname());
            System.out.println("SIM CARDS : " + mobile.getSim());
            System.out.println("CAMERA MP : " + mobile.getCam());
            System.out.println("------------------------------------------");

            if(objmob.available() == 0){
                break;
            }
        }

        File Use = new File("SavedData//Products//Digital//Laptops//laptop.txt");
        FileInputStream fileLap = new FileInputStream(Use);
        ObjectInputStream objLap = new ObjectInputStream(fileLap);


        while(true){

            Laptop laptop;
            try{
                laptop = (Laptop) objLap.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + laptop.getName());
            System.out.println("ID : " + laptop.getId());
            System.out.println("COMPANY : " + laptop.getCompany());
            System.out.println("PRICE : " + laptop.getPrice());
            System.out.println("CONDITION : " + laptop.getCondition());
            System.out.println("DESCRIPTION : " + laptop.getDescription());
            System.out.println("AVERAGE RATE : " + laptop.getAve_rate());
            System.out.println("SELLER NAME : " + laptop.getSname());
            System.out.println("CPU : " + laptop.getCpu());
            System.out.println("GAMING : " + laptop.getGaming());
            System.out.println("------------------------------------------");

            if(objLap.available() == 0){
                break;
            }

        }
        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                digitalPart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }

    }
    // -----
    public static void mobileList()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**********HERE IS OUR MOBILE PRODUCTS ***********");

        File User = new File("SavedData//Products//Digital//Mobiles//mobiles.txt");
        FileInputStream filemob = new FileInputStream(User);
        ObjectInputStream objmob = new ObjectInputStream(filemob);

        while(true){
            Mobile mobile;
            try{
                mobile = (Mobile) objmob.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + mobile.getName());
            System.out.println("ID : " + mobile.getId());
            System.out.println("COMPANY : " + mobile.getCompany());
            System.out.println("PRICE : " + mobile.getPrice());
            System.out.println("CONDITION : " + mobile.getCondition());
            System.out.println("DESCRIPTION : " + mobile.getDescription());
            System.out.println("AVERAGE RATE : " + mobile.getAve_rate());
            System.out.println("SELLER NAME : " + mobile.getSname());
            System.out.println("SIM CARDS : " + mobile.getSim());
            System.out.println("CAMERA MP : " + mobile.getCam());
            System.out.println("------------------------------------------");

            if(objmob.available() == 0){
                break;
            }
        }
        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                digitalPart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }


    }
    // -----
    public static void showComments()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("************** COMMENTS *************");
        for (int i = 0; i <Comment.com.size();i++)
        {
            System.out.println("****** NAME ****** ---->  " + Comment.com.get(i).getPerson());
            System.out.println("****** PRODUCT NAME ****** ---->  " + Comment.com.get(i).getNameP());
            System.out.println("****** COMMENT ****** ---->  " + Comment.com.get(i).getCommentsT());
            System.out.println("****** CONDITION ****** ---->  " + Comment.com.get(i).getCond());
            System.out.println("-----------------------------------------------");



        }
        System.out.println("BACK TO MENU WITH 1 ---> : ");
        int choice = x.nextInt();


        switch (choice) {
            case 1:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }

    }
    // -----
    public static void laptopList()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS OUR LAPTOP PRODUCTS ***********");
        Scanner x = new Scanner(System.in);

        File User = new File("SavedData//Products//Digital//Laptops//laptop.txt");
        FileInputStream fileLap = new FileInputStream(User);
        ObjectInputStream objLap = new ObjectInputStream(fileLap);


        while(true){

            Laptop laptop;
            try{
                laptop = (Laptop) objLap.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + laptop.getName());
            System.out.println("ID : " + laptop.getId());
            System.out.println("COMPANY : " + laptop.getCompany());
            System.out.println("PRICE : " + laptop.getPrice());
            System.out.println("CONDITION : " + laptop.getCondition());
            System.out.println("DESCRIPTION : " + laptop.getDescription());
            System.out.println("AVERAGE RATE : " + laptop.getAve_rate());
            System.out.println("SELLER NAME : " + laptop.getSname());
            System.out.println("CPU : " + laptop.getCpu());
            System.out.println("GAMING : " + laptop.getGaming());
            System.out.println("------------------------------------------");

            if(objLap.available() == 0){
                break;
            }

        }
        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                digitalPart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }


    }
    // -----
    public static void clothingPart()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**************WELLCOME TO CLOTHING PRODUCTS PART*************");
        System.out.println("* 1 : DRESS CLOTHES     -->  *");
        System.out.println("* 2 : SHOES             -->  *");
        System.out.println("* 3 : ALL CLOTHES       -->  *");
        System.out.println("* 4 : BACK TO LAST MENU -->  *");
        System.out.println("******************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {

            case 1:
                dressList();
                break;
            case 2:
                shoesList();
                break;
            case 3:
                clothesAll();
                break;
            case 4:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }


    }
    // -----
    public static void clothesAll()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        File User = new File("SavedData//Products//Clothing//Dress//dress.txt");
        FileInputStream filedress = new FileInputStream(User);
        ObjectInputStream objdress = new ObjectInputStream(filedress);



        while(true){

            Dress dress;
            try{
                dress = (Dress) objdress.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + dress.getName());
            System.out.println("ID : " + dress.getId());
            System.out.println("COMPANY : " + dress.getCompany());
            System.out.println("PRICE : " + dress.getPrice());
            System.out.println("CONDITION : " + dress.getCondition());
            System.out.println("DESCRIPTION : " + dress.getDescription());
            System.out.println("AVERAGE RATE : " + dress.getAve_rate());
            System.out.println("SELLER NAME : " +dress.getSname());
            System.out.println("SIZE : " + dress.getSize());
            System.out.println("MODEL : " + dress.getModel());
            System.out.println("------------------------------------------");

            if(objdress.available() == 0){
                break;
            }

        }


        System.out.println("**********HERE IS OUR  SHOES  PRODUCTS ***********");

        File Use = new File("SavedData//Products//Clothing//Shoes//shoes.txt");
        FileInputStream filesh = new FileInputStream(Use);
        ObjectInputStream objsh = new ObjectInputStream(filesh);



        while(true){

            Shoes shoes;
            try{
                shoes = (Shoes) objsh.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + shoes.getName());
            System.out.println("ID : " + shoes.getId());
            System.out.println("COMPANY : " + shoes.getCompany());
            System.out.println("PRICE : " + shoes.getPrice());
            System.out.println("CONDITION : " + shoes.getCondition());
            System.out.println("DESCRIPTION : " + shoes.getDescription());
            System.out.println("AVERAGE RATE : " + shoes.getAve_rate());
            System.out.println("SELLER NAME : " + shoes.getSname());
            System.out.println("FOOT SIZE : " + shoes.getFootSize());
            System.out.println("TYPE : " +shoes.getType());
            System.out.println("------------------------------------------");

            if(objsh.available() == 0){
                break;
            }

        }


        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {

            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                clothingPart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }

    }
    // -----
    public static void dressList()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**********HERE IS OUR DRESS PRODUCTS ***********");

        File User = new File("SavedData//Products//Clothing//Dress//dress.txt");
        FileInputStream filedress = new FileInputStream(User);
        ObjectInputStream objdress = new ObjectInputStream(filedress);



        while(true){

            Dress dress;
            try{
                dress = (Dress) objdress.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + dress.getName());
            System.out.println("ID : " + dress.getId());
            System.out.println("COMPANY : " + dress.getCompany());
            System.out.println("PRICE : " + dress.getPrice());
            System.out.println("CONDITION : " + dress.getCondition());
            System.out.println("DESCRIPTION : " + dress.getDescription());
            System.out.println("AVERAGE RATE : " + dress.getAve_rate());
            System.out.println("SELLER NAME : " +dress.getSname());
            System.out.println("SIZE : " + dress.getSize());
            System.out.println("MODEL : " + dress.getModel());
            System.out.println("------------------------------------------");

            if(objdress.available() == 0){
                break;
            }

        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                clothingPart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }



    }
    //-----
    public static void shoesList()throws Exception{

        Scanner x = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**********HERE IS OUR  SHOES  PRODUCTS ***********");

        File User = new File("SavedData//Products//Clothing//Shoes//shoes.txt");
        FileInputStream filesh = new FileInputStream(User);
        ObjectInputStream objsh = new ObjectInputStream(filesh);



        while(true){

            Shoes shoes;
            try{
                shoes = (Shoes) objsh.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + shoes.getName());
            System.out.println("ID : " + shoes.getId());
            System.out.println("COMPANY : " + shoes.getCompany());
            System.out.println("PRICE : " + shoes.getPrice());
            System.out.println("CONDITION : " + shoes.getCondition());
            System.out.println("DESCRIPTION : " + shoes.getDescription());
            System.out.println("AVERAGE RATE : " + shoes.getAve_rate());
            System.out.println("SELLER NAME : " + shoes.getSname());
            System.out.println("FOOT SIZE : " + shoes.getFootSize());
            System.out.println("TYPE : " +shoes.getType());
            System.out.println("------------------------------------------");

            if(objsh.available() == 0){
                break;
            }

        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                clothingPart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }


    }
    // ----
    public static void housePart()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**************WELLCOME TO HOUSE AND KITCHEN PRODUCTS PART*************");
        System.out.println("* 1 : TV & MEDIA        -->  *");
        System.out.println("* 2 : OVENS             -->  *");
        System.out.println("* 3 : REFRIGERATORS     -->  *");
        System.out.println("* 4 : ALL OF IT         -->  *");
        System.out.println("* 5 : BACK TO LAST MENU -->  *");
        System.out.println("******************************");

        System.out.println("PLEASE ENTER YOUR CHOICE--> :");
        int choice = x.nextInt();

        switch (choice) {

            case 1:
                tvList();
                break;
            case 2:
                ovenList();
                break;
            case 3:
                refList();
                break;
            case 4:
                houseAll();
                break;
            case 5:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----
    public static void houseAll()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**********HERE IS OUR  TV  PRODUCTS ***********");

        File Use = new File("SavedData//Products//Houes//Tv//tv.txt");
        FileInputStream filetv = new FileInputStream(Use);
        ObjectInputStream objtv = new ObjectInputStream(filetv);

        while(true){

            Tv tv;
            try{
                tv = (Tv) objtv.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + tv.getName());
            System.out.println("ID : " + tv.getId());
            System.out.println("COMPANY : " + tv.getCompany());
            System.out.println("PRICE : " + tv.getPrice());
            System.out.println("CONDITION : " + tv.getCondition());
            System.out.println("DESCRIPTION : " + tv.getDescription());
            System.out.println("AVERAGE RATE : " + tv.getAve_rate());
            System.out.println("SELLER NAME : " + tv.getSname());
            System.out.println("QUALITY : " + tv.getQuality());
            System.out.println("INCHES : " + tv.getInches());
            System.out.println("------------------------------------------");

            if(objtv.available() == 0){
                break;
            }

        }


        System.out.println("**********HERE IS OUR  OVEN PRODUCTS ***********");
        File User = new File("SavedData//Products//Houes//Ovens//ovens.txt");
        FileInputStream fileOven = new FileInputStream(User);
        ObjectInputStream objOven = new ObjectInputStream(fileOven);

        while(true){

            Oven oven;
            try{
                oven = (Oven) objOven.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + oven.getName());
            System.out.println("ID : " + oven.getId());
            System.out.println("COMPANY : " + oven.getCompany());
            System.out.println("PRICE : " + oven.getPrice());
            System.out.println("CONDITION : " + oven.getCondition());
            System.out.println("DESCRIPTION : " + oven.getDescription());
            System.out.println("AVERAGE RATE : " + oven.getAve_rate());
            System.out.println("SELLER NAME : " + oven.getSname());
            System.out.println("FIRE COUNTS : " + oven.getFireCount());
            System.out.println("BODY MATERIAL : " + oven.getBody());
            System.out.println("MICROWAVE : " + oven.getMicro());
            System.out.println("------------------------------------------");

            if(objOven.available() == 0){
                break;
            }

        }

        File ser = new File("SavedData//Products//Houes//Refrigerator//refrigerator.txt");
        FileInputStream fileref = new FileInputStream(ser);
        ObjectInputStream objref = new ObjectInputStream(fileref);


        System.out.println("**********HERE IS OUR REFRIGERATOR PRODUCTS ***********");
        while(true){

            Refrigerator ref;
            try{
                ref = (Refrigerator) objref.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + ref.getName());
            System.out.println("ID : " + ref.getId());
            System.out.println("COMPANY : " + ref.getCompany());
            System.out.println("PRICE : " + ref.getPrice());
            System.out.println("CONDITION : " + ref.getCondition());
            System.out.println("DESCRIPTION : " + ref.getDescription());
            System.out.println("AVERAGE RATE : " + ref.getAve_rate());
            System.out.println("SELLER NAME : " + ref.getSname());
            System.out.println("CAPACITY : " + ref.getLitre());
            System.out.println("DOOR TYPE : " +ref.getDoor());
            System.out.println("FREEZER : " + ref.getFreezer());
            System.out.println("------------------------------------------");


            if(objref.available() == 0){
                break;
            }

        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                housePart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }

    }
    // -----
    public static void tvList()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        System.out.println("**********HERE IS OUR  TV  PRODUCTS ***********");

        File Use = new File("SavedData//Products//Houes//Tv//tv.txt");
        FileInputStream filetv = new FileInputStream(Use);
        ObjectInputStream objtv = new ObjectInputStream(filetv);

        while(true){

            Tv tv;
            try{
                tv = (Tv) objtv.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + tv.getName());
            System.out.println("ID : " + tv.getId());
            System.out.println("COMPANY : " + tv.getCompany());
            System.out.println("PRICE : " + tv.getPrice());
            System.out.println("CONDITION : " + tv.getCondition());
            System.out.println("DESCRIPTION : " + tv.getDescription());
            System.out.println("AVERAGE RATE : " + tv.getAve_rate());
            System.out.println("SELLER NAME : " + tv.getSname());
            System.out.println("QUALITY : " + tv.getQuality());
            System.out.println("INCHES : " + tv.getInches());
            System.out.println("------------------------------------------");

            if(objtv.available() == 0){
                break;
            }

        }












        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                housePart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----
    public static void ovenList()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);

        System.out.println("**********HERE IS OUR  OVEN PRODUCTS ***********");
        File User = new File("SavedData//Products//Houes//Ovens//ovens.txt");
        FileInputStream fileOven = new FileInputStream(User);
        ObjectInputStream objOven = new ObjectInputStream(fileOven);

        while(true){

            Oven oven;
            try{
                oven = (Oven) objOven.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + oven.getName());
            System.out.println("ID : " + oven.getId());
            System.out.println("COMPANY : " + oven.getCompany());
            System.out.println("PRICE : " + oven.getPrice());
            System.out.println("CONDITION : " + oven.getCondition());
            System.out.println("DESCRIPTION : " + oven.getDescription());
            System.out.println("AVERAGE RATE : " + oven.getAve_rate());
            System.out.println("SELLER NAME : " + oven.getSname());
            System.out.println("FIRE COUNTS : " + oven.getFireCount());
            System.out.println("BODY MATERIAL : " + oven.getBody());
            System.out.println("MICROWAVE : " + oven.getMicro());
            System.out.println("------------------------------------------");

            if(objOven.available() == 0){
                break;
            }

        }
        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                housePart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }

    }
    // -----
    public static void refList()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);

        File User = new File("SavedData//Products//Houes//Refrigerator//refrigerator.txt");
        FileInputStream fileref = new FileInputStream(User);
        ObjectInputStream objref = new ObjectInputStream(fileref);


        System.out.println("**********HERE IS OUR REFRIGERATOR PRODUCTS ***********");
        while(true){

            Refrigerator ref;
            try{
                ref = (Refrigerator) objref.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + ref.getName());
            System.out.println("ID : " + ref.getId());
            System.out.println("COMPANY : " + ref.getCompany());
            System.out.println("PRICE : " + ref.getPrice());
            System.out.println("CONDITION : " + ref.getCondition());
            System.out.println("DESCRIPTION : " + ref.getDescription());
            System.out.println("AVERAGE RATE : " + ref.getAve_rate());
            System.out.println("SELLER NAME : " + ref.getSname());
            System.out.println("CAPACITY : " + ref.getLitre());
            System.out.println("DOOR TYPE : " +ref.getDoor());
            System.out.println("FREEZER : " + ref.getFreezer());
            System.out.println("------------------------------------------");


            if(objref.available() == 0){
                break;
            }

        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                housePart();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }

    }
    // -----
    public static void sortedMenu()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS OUR PRODUCTS ***********");
        System.out.println("******************************************");

        for (int i = 0; i < Seller.saddprolap.size()-1; i++)
            for (int j = 0; j < Seller.saddprolap.size()-i-1; j++){
                if (Seller.saddprolap.get(j).getPrice() > Seller.saddprolap.get(j+1).getPrice())
                {

                    Laptop temp =Seller.saddprolap.get(j);
                    Seller.saddprolap.remove(j);
                    Seller.saddprolap.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR LAPTOP PRODUCTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.saddprolap.size();i++)
        {
            System.out.println("NAME : " + Seller.saddprolap.get(i).getName());
            System.out.println("ID : " + Seller.saddprolap.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddprolap.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddprolap.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddprolap.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddprolap.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddprolap.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddprolap.get(i).getSname());
            System.out.println("CPU : " + Seller.saddprolap.get(i).getCpu());
            System.out.println("GAMING : " + Seller.saddprolap.get(i).getGaming());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddpromob.size()-1; i++)
            for (int j = 0; j < Seller.saddpromob.size()-i-1; j++){
                if (Seller.saddpromob.get(j).getPrice() > Seller.saddpromob.get(j+1).getPrice())
                {

                    Mobile temp =Seller.saddpromob.get(j);
                    Seller.saddpromob.remove(j);
                    Seller.saddpromob.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR MOBILE PRODUCTS ***********");
        for (int i = 0; i <Seller.saddpromob.size();i++)
        {
            System.out.println("NAME : " + Seller.saddpromob.get(i).getName());
            System.out.println("ID : " + Seller.saddpromob.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddpromob.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddpromob.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddpromob.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddpromob.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddpromob.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddpromob.get(i).getSname());
            System.out.println("SIM CARDS : " + Seller.saddpromob.get(i).getSim());
            System.out.println("CAMERA MP : " + Seller.saddpromob.get(i).getCam());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.sadddress.size()-1; i++)
            for (int j = 0; j < Seller.sadddress.size()-i-1; j++){
                if (Seller.sadddress.get(j).getPrice() > Seller.sadddress.get(j+1).getPrice())
                {

                    Dress temp =Seller.sadddress.get(j);
                    Seller.sadddress.remove(j);
                    Seller.sadddress.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR DRESS PRODUCTS ***********");

        for (int i = 0; i <Seller.sadddress.size();i++)
        {
            System.out.println("NAME : " + Seller.sadddress.get(i).getName());
            System.out.println("ID : " + Seller.sadddress.get(i).getId());
            System.out.println("COMPANY : " + Seller.sadddress.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sadddress.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sadddress.get(i).getCondition());
            System.out.println("DESCRIPTION : " +Seller.sadddress.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sadddress.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sadddress.get(i).getSname());
            System.out.println("SIZE : " + Seller.sadddress.get(i).getSize());
            System.out.println("MODEL : " + Seller.sadddress.get(i).getModel());
            System.out.println("------------------------------------------");
        }


        for (int i = 0; i < Seller.saddshoes.size()-1; i++)
            for (int j = 0; j < Seller.saddshoes.size()-i-1; j++){
                if (Seller.saddshoes.get(j).getPrice() > Seller.saddshoes.get(j+1).getPrice())
                {

                    Shoes temp =Seller.saddshoes.get(j);
                    Seller.saddshoes.remove(j);
                    Seller.saddshoes.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR  SHOES  PRODUCTS ***********");
        for (int i = 0; i <Seller.saddshoes.size();i++)
        {
            System.out.println("NAME : " + Seller.saddshoes.get(i).getName());
            System.out.println("ID : " + Seller.saddshoes.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddshoes.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddshoes.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddshoes.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddshoes.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddshoes.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddshoes.get(i).getSname());
            System.out.println("FOOT SIZE : " + Seller.saddshoes.get(i).getFootSize());
            System.out.println("TYPE : " + Seller.saddshoes.get(i).getType());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.saddtv.size()-1; i++)
            for (int j = 0; j < Seller.saddtv.size()-i-1; j++){
                if (Seller.saddtv.get(j).getPrice() > Seller.saddtv.get(j+1).getPrice())
                {

                    Tv temp =Seller.saddtv.get(j);
                    Seller.saddtv.remove(j);
                    Seller.saddtv.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR  TV  PRODUCTS ***********");
        for (int i = 0; i <Seller.saddtv.size();i++)
        {
            System.out.println("NAME : " + Seller.saddtv.get(i).getName());
            System.out.println("ID : " + Seller.saddtv.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddtv.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddtv.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddtv.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddtv.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddtv.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddtv.get(i).getSname());
            System.out.println("QUALITY : " + Seller.saddtv.get(i).getQuality());
            System.out.println("INCHES : " + Seller.saddtv.get(i).getInches());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.saddoven.size()-1; i++)
            for (int j = 0; j < Seller.saddoven.size()-i-1; j++){
                if (Seller.saddoven.get(j).getPrice() > Seller.saddoven.get(j+1).getPrice())
                {

                    Oven temp =Seller.saddoven.get(j);
                    Seller.saddoven.remove(j);
                    Seller.saddoven.add(j + 1 , temp);

                }
            }

        System.out.println("**********HERE IS OUR  OVEN PRODUCTS ***********");
        for (int i = 0; i <Seller.saddoven.size();i++)
        {
            System.out.println("NAME : " + Seller.saddoven.get(i).getName());
            System.out.println("ID : " + Seller.saddoven.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddoven.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddoven.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddoven.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddoven.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddoven.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddoven.get(i).getSname());
            System.out.println("FIRE COUNTS : " + Seller.saddoven.get(i).getFireCount());
            System.out.println("BODY MATERIAL : " + Seller.saddoven.get(i).getBody());
            System.out.println("MICROWAVE : " + Seller.saddoven.get(i).getMicro());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddproref.size()-1; i++)
            for (int j = 0; j < Seller.saddproref.size()-i-1; j++){
                if (Seller.saddproref.get(j).getPrice() > Seller.saddproref.get(j+1).getPrice())
                {

                    Refrigerator temp =Seller.saddproref.get(j);
                    Seller.saddproref.remove(j);
                    Seller.saddproref.add(j + 1 , temp);

                }
            }


        System.out.println("**********HERE IS OUR REFRIGERATOR PRODUCTS ***********");
        for (int i = 0; i <Seller.saddproref.size();i++)
        {
            System.out.println("NAME : " + Seller.saddproref.get(i).getName());
            System.out.println("ID : " + Seller.saddproref.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddproref.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddproref.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddproref.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddproref.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddproref.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddproref.get(i).getSname());
            System.out.println("CAPACITY : " + Seller.saddproref.get(i).getLitre());
            System.out.println("DOOR TYPE : " +Seller.saddproref.get(i).getDoor());
            System.out.println("FREEZER : " + Seller.saddproref.get(i).getFreezer());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddmeal.size()-1; i++)
            for (int j = 0; j < Seller.saddmeal.size()-i-1; j++){
                if (Seller.saddmeal.get(j).getPrice() > Seller.saddmeal.get(j+1).getPrice())
                {

                    Meal temp =Seller.saddmeal.get(j);
                    Seller.saddmeal.remove(j);
                    Seller.saddmeal.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR FOOD PRODUCTS ***********");
        for (int i = 0; i <Seller.saddmeal.size();i++)
        {
            System.out.println("NAME : " + Seller.saddmeal.get(i).getName());
            System.out.println("ID : " + Seller.saddmeal.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddmeal.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddmeal.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddmeal.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddmeal.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddmeal.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddmeal.get(i).getSname());
            System.out.println("------------------------------------------");
        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----
    public static void sortedMenuLess()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS OUR PRODUCTS ***********");
        System.out.println("******************************************");

        for (int i = 0; i < Seller.saddprolap.size()-1; i++)
            for (int j = 0; j < Seller.saddprolap.size()-i-1; j++){
                if (Seller.saddprolap.get(j).getPrice() < Seller.saddprolap.get(j+1).getPrice())
                {

                    Laptop temp =Seller.saddprolap.get(j);
                    Seller.saddprolap.remove(j);
                    Seller.saddprolap.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR LAPTOP PRODUCTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.saddprolap.size();i++)
        {
            System.out.println("NAME : " + Seller.saddprolap.get(i).getName());
            System.out.println("ID : " + Seller.saddprolap.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddprolap.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddprolap.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddprolap.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddprolap.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddprolap.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddprolap.get(i).getSname());
            System.out.println("CPU : " + Seller.saddprolap.get(i).getCpu());
            System.out.println("GAMING : " + Seller.saddprolap.get(i).getGaming());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddpromob.size()-1; i++)
            for (int j = 0; j < Seller.saddpromob.size()-i-1; j++){
                if (Seller.saddpromob.get(j).getPrice() < Seller.saddpromob.get(j+1).getPrice())
                {

                    Mobile temp =Seller.saddpromob.get(j);
                    Seller.saddpromob.remove(j);
                    Seller.saddpromob.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR MOBILE PRODUCTS ***********");
        for (int i = 0; i <Seller.saddpromob.size();i++)
        {
            System.out.println("NAME : " + Seller.saddpromob.get(i).getName());
            System.out.println("ID : " + Seller.saddpromob.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddpromob.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddpromob.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddpromob.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddpromob.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddpromob.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddpromob.get(i).getSname());
            System.out.println("SIM CARDS : " + Seller.saddpromob.get(i).getSim());
            System.out.println("CAMERA MP : " + Seller.saddpromob.get(i).getCam());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.sadddress.size()-1; i++)
            for (int j = 0; j < Seller.sadddress.size()-i-1; j++){
                if (Seller.sadddress.get(j).getPrice() < Seller.sadddress.get(j+1).getPrice())
                {

                    Dress temp =Seller.sadddress.get(j);
                    Seller.sadddress.remove(j);
                    Seller.sadddress.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR DRESS PRODUCTS ***********");

        for (int i = 0; i <Seller.sadddress.size();i++)
        {
            System.out.println("NAME : " + Seller.sadddress.get(i).getName());
            System.out.println("ID : " + Seller.sadddress.get(i).getId());
            System.out.println("COMPANY : " + Seller.sadddress.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sadddress.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sadddress.get(i).getCondition());
            System.out.println("DESCRIPTION : " +Seller.sadddress.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sadddress.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sadddress.get(i).getSname());
            System.out.println("SIZE : " + Seller.sadddress.get(i).getSize());
            System.out.println("MODEL : " + Seller.sadddress.get(i).getModel());
            System.out.println("------------------------------------------");
        }


        for (int i = 0; i < Seller.saddshoes.size()-1; i++)
            for (int j = 0; j < Seller.saddshoes.size()-i-1; j++){
                if (Seller.saddshoes.get(j).getPrice() < Seller.saddshoes.get(j+1).getPrice())
                {

                    Shoes temp =Seller.saddshoes.get(j);
                    Seller.saddshoes.remove(j);
                    Seller.saddshoes.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR  SHOES  PRODUCTS ***********");
        for (int i = 0; i <Seller.saddshoes.size();i++)
        {
            System.out.println("NAME : " + Seller.saddshoes.get(i).getName());
            System.out.println("ID : " + Seller.saddshoes.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddshoes.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddshoes.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddshoes.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddshoes.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddshoes.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddshoes.get(i).getSname());
            System.out.println("FOOT SIZE : " + Seller.saddshoes.get(i).getFootSize());
            System.out.println("TYPE : " + Seller.saddshoes.get(i).getType());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.saddtv.size()-1; i++)
            for (int j = 0; j < Seller.saddtv.size()-i-1; j++){
                if (Seller.saddtv.get(j).getPrice() < Seller.saddtv.get(j+1).getPrice())
                {

                    Tv temp =Seller.saddtv.get(j);
                    Seller.saddtv.remove(j);
                    Seller.saddtv.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR  TV  PRODUCTS ***********");
        for (int i = 0; i <Seller.saddtv.size();i++)
        {
            System.out.println("NAME : " + Seller.saddtv.get(i).getName());
            System.out.println("ID : " + Seller.saddtv.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddtv.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddtv.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddtv.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddtv.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddtv.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddtv.get(i).getSname());
            System.out.println("QUALITY : " + Seller.saddtv.get(i).getQuality());
            System.out.println("INCHES : " + Seller.saddtv.get(i).getInches());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.saddoven.size()-1; i++)
            for (int j = 0; j < Seller.saddoven.size()-i-1; j++){
                if (Seller.saddoven.get(j).getPrice() < Seller.saddoven.get(j+1).getPrice())
                {

                    Oven temp =Seller.saddoven.get(j);
                    Seller.saddoven.remove(j);
                    Seller.saddoven.add(j + 1 , temp);

                }
            }

        System.out.println("**********HERE IS OUR  OVEN PRODUCTS ***********");
        for (int i = 0; i <Seller.saddoven.size();i++)
        {
            System.out.println("NAME : " + Seller.saddoven.get(i).getName());
            System.out.println("ID : " + Seller.saddoven.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddoven.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddoven.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddoven.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddoven.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddoven.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddoven.get(i).getSname());
            System.out.println("FIRE COUNTS : " + Seller.saddoven.get(i).getFireCount());
            System.out.println("BODY MATERIAL : " + Seller.saddoven.get(i).getBody());
            System.out.println("MICROWAVE : " + Seller.saddoven.get(i).getMicro());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddproref.size()-1; i++)
            for (int j = 0; j < Seller.saddproref.size()-i-1; j++){
                if (Seller.saddproref.get(j).getPrice() < Seller.saddproref.get(j+1).getPrice())
                {

                    Refrigerator temp =Seller.saddproref.get(j);
                    Seller.saddproref.remove(j);
                    Seller.saddproref.add(j + 1 , temp);

                }
            }


        System.out.println("**********HERE IS OUR REFRIGERATOR PRODUCTS ***********");
        for (int i = 0; i <Seller.saddproref.size();i++)
        {
            System.out.println("NAME : " + Seller.saddproref.get(i).getName());
            System.out.println("ID : " + Seller.saddproref.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddproref.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddproref.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddproref.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddproref.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddproref.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddproref.get(i).getSname());
            System.out.println("CAPACITY : " + Seller.saddproref.get(i).getLitre());
            System.out.println("DOOR TYPE : " +Seller.saddproref.get(i).getDoor());
            System.out.println("FREEZER : " + Seller.saddproref.get(i).getFreezer());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddmeal.size()-1; i++)
            for (int j = 0; j < Seller.saddmeal.size()-i-1; j++){
                if (Seller.saddmeal.get(j).getPrice() < Seller.saddmeal.get(j+1).getPrice())
                {

                    Meal temp =Seller.saddmeal.get(j);
                    Seller.saddmeal.remove(j);
                    Seller.saddmeal.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR FOOD PRODUCTS ***********");
        for (int i = 0; i <Seller.saddmeal.size();i++)
        {
            System.out.println("NAME : " + Seller.saddmeal.get(i).getName());
            System.out.println("ID : " + Seller.saddmeal.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddmeal.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddmeal.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddmeal.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddmeal.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddmeal.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddmeal.get(i).getSname());
            System.out.println("------------------------------------------");
        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----
    public static void sortedMenuRate()throws Exception{


        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS OUR PRODUCTS ***********");
        System.out.println("******************************************");

        for (int i = 0; i < Seller.saddprolap.size()-1; i++)
            for (int j = 0; j < Seller.saddprolap.size()-i-1; j++){
                if (Seller.saddprolap.get(j).getAve_rate() > Seller.saddprolap.get(j+1).getAve_rate())
                {

                    Laptop temp =Seller.saddprolap.get(j);
                    Seller.saddprolap.remove(j);
                    Seller.saddprolap.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR LAPTOP PRODUCTS ***********");
        Scanner x = new Scanner(System.in);
        for (int i = 0; i <Seller.saddprolap.size();i++)
        {
            System.out.println("NAME : " + Seller.saddprolap.get(i).getName());
            System.out.println("ID : " + Seller.saddprolap.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddprolap.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddprolap.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddprolap.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddprolap.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddprolap.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddprolap.get(i).getSname());
            System.out.println("CPU : " + Seller.saddprolap.get(i).getCpu());
            System.out.println("GAMING : " + Seller.saddprolap.get(i).getGaming());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddpromob.size()-1; i++)
            for (int j = 0; j < Seller.saddpromob.size()-i-1; j++){
                if (Seller.saddpromob.get(j).getAve_rate() > Seller.saddpromob.get(j+1).getAve_rate())
                {

                    Mobile temp =Seller.saddpromob.get(j);
                    Seller.saddpromob.remove(j);
                    Seller.saddpromob.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR MOBILE PRODUCTS ***********");
        for (int i = 0; i <Seller.saddpromob.size();i++)
        {
            System.out.println("NAME : " + Seller.saddpromob.get(i).getName());
            System.out.println("ID : " + Seller.saddpromob.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddpromob.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddpromob.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddpromob.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddpromob.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddpromob.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddpromob.get(i).getSname());
            System.out.println("SIM CARDS : " + Seller.saddpromob.get(i).getSim());
            System.out.println("CAMERA MP : " + Seller.saddpromob.get(i).getCam());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.sadddress.size()-1; i++)
            for (int j = 0; j < Seller.sadddress.size()-i-1; j++){
                if (Seller.sadddress.get(j).getAve_rate() > Seller.sadddress.get(j+1).getAve_rate())
                {

                    Dress temp =Seller.sadddress.get(j);
                    Seller.sadddress.remove(j);
                    Seller.sadddress.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR DRESS PRODUCTS ***********");

        for (int i = 0; i <Seller.sadddress.size();i++)
        {
            System.out.println("NAME : " + Seller.sadddress.get(i).getName());
            System.out.println("ID : " + Seller.sadddress.get(i).getId());
            System.out.println("COMPANY : " + Seller.sadddress.get(i).getCompany());
            System.out.println("PRICE : " + Seller.sadddress.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.sadddress.get(i).getCondition());
            System.out.println("DESCRIPTION : " +Seller.sadddress.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.sadddress.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.sadddress.get(i).getSname());
            System.out.println("SIZE : " + Seller.sadddress.get(i).getSize());
            System.out.println("MODEL : " + Seller.sadddress.get(i).getModel());
            System.out.println("------------------------------------------");
        }


        for (int i = 0; i < Seller.saddshoes.size()-1; i++)
            for (int j = 0; j < Seller.saddshoes.size()-i-1; j++){
                if (Seller.saddshoes.get(j).getAve_rate() > Seller.saddshoes.get(j+1).getAve_rate())
                {

                    Shoes temp =Seller.saddshoes.get(j);
                    Seller.saddshoes.remove(j);
                    Seller.saddshoes.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR  SHOES  PRODUCTS ***********");
        for (int i = 0; i <Seller.saddshoes.size();i++)
        {
            System.out.println("NAME : " + Seller.saddshoes.get(i).getName());
            System.out.println("ID : " + Seller.saddshoes.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddshoes.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddshoes.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddshoes.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddshoes.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddshoes.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddshoes.get(i).getSname());
            System.out.println("FOOT SIZE : " + Seller.saddshoes.get(i).getFootSize());
            System.out.println("TYPE : " + Seller.saddshoes.get(i).getType());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.saddtv.size()-1; i++)
            for (int j = 0; j < Seller.saddtv.size()-i-1; j++){
                if (Seller.saddtv.get(j).getAve_rate() > Seller.saddtv.get(j+1).getAve_rate())
                {

                    Tv temp =Seller.saddtv.get(j);
                    Seller.saddtv.remove(j);
                    Seller.saddtv.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR  TV  PRODUCTS ***********");
        for (int i = 0; i <Seller.saddtv.size();i++)
        {
            System.out.println("NAME : " + Seller.saddtv.get(i).getName());
            System.out.println("ID : " + Seller.saddtv.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddtv.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddtv.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddtv.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddtv.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddtv.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddtv.get(i).getSname());
            System.out.println("QUALITY : " + Seller.saddtv.get(i).getQuality());
            System.out.println("INCHES : " + Seller.saddtv.get(i).getInches());
            System.out.println("------------------------------------------");
        }
        for (int i = 0; i < Seller.saddoven.size()-1; i++)
            for (int j = 0; j < Seller.saddoven.size()-i-1; j++){
                if (Seller.saddoven.get(j).getAve_rate() > Seller.saddoven.get(j+1).getAve_rate())
                {

                    Oven temp =Seller.saddoven.get(j);
                    Seller.saddoven.remove(j);
                    Seller.saddoven.add(j + 1 , temp);

                }
            }

        System.out.println("**********HERE IS OUR  OVEN PRODUCTS ***********");
        for (int i = 0; i <Seller.saddoven.size();i++)
        {
            System.out.println("NAME : " + Seller.saddoven.get(i).getName());
            System.out.println("ID : " + Seller.saddoven.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddoven.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddoven.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddoven.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddoven.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddoven.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddoven.get(i).getSname());
            System.out.println("FIRE COUNTS : " + Seller.saddoven.get(i).getFireCount());
            System.out.println("BODY MATERIAL : " + Seller.saddoven.get(i).getBody());
            System.out.println("MICROWAVE : " + Seller.saddoven.get(i).getMicro());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddproref.size()-1; i++)
            for (int j = 0; j < Seller.saddproref.size()-i-1; j++){
                if (Seller.saddproref.get(j).getAve_rate() > Seller.saddproref.get(j+1).getAve_rate())
                {

                    Refrigerator temp =Seller.saddproref.get(j);
                    Seller.saddproref.remove(j);
                    Seller.saddproref.add(j + 1 , temp);

                }
            }


        System.out.println("**********HERE IS OUR REFRIGERATOR PRODUCTS ***********");
        for (int i = 0; i <Seller.saddproref.size();i++)
        {
            System.out.println("NAME : " + Seller.saddproref.get(i).getName());
            System.out.println("ID : " + Seller.saddproref.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddproref.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddproref.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddproref.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddproref.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddproref.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddproref.get(i).getSname());
            System.out.println("CAPACITY : " + Seller.saddproref.get(i).getLitre());
            System.out.println("DOOR TYPE : " +Seller.saddproref.get(i).getDoor());
            System.out.println("FREEZER : " + Seller.saddproref.get(i).getFreezer());
            System.out.println("------------------------------------------");
        }

        for (int i = 0; i < Seller.saddmeal.size()-1; i++)
            for (int j = 0; j < Seller.saddmeal.size()-i-1; j++){
                if (Seller.saddmeal.get(j).getAve_rate() > Seller.saddmeal.get(j+1).getAve_rate())
                {

                    Meal temp =Seller.saddmeal.get(j);
                    Seller.saddmeal.remove(j);
                    Seller.saddmeal.add(j + 1 , temp);

                }
            }
        System.out.println("**********HERE IS OUR FOOD PRODUCTS ***********");
        for (int i = 0; i <Seller.saddmeal.size();i++)
        {
            System.out.println("NAME : " + Seller.saddmeal.get(i).getName());
            System.out.println("ID : " + Seller.saddmeal.get(i).getId());
            System.out.println("COMPANY : " + Seller.saddmeal.get(i).getCompany());
            System.out.println("PRICE : " + Seller.saddmeal.get(i).getPrice());
            System.out.println("CONDITION : " + Seller.saddmeal.get(i).getCondition());
            System.out.println("DESCRIPTION : " + Seller.saddmeal.get(i).getDescription());
            System.out.println("AVERAGE RATE : " + Seller.saddmeal.get(i).getAve_rate());
            System.out.println("SELLER NAME : " + Seller.saddmeal.get(i).getSname());
            System.out.println("------------------------------------------");
        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----
    public static void foodPart()throws Exception{

        Scanner x = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("**********HERE IS OUR FOOD PRODUCTS ***********");
        File ser = new File("SavedData//Products//Meal//food.txt");
        FileInputStream filefood = new FileInputStream(ser);
        ObjectInputStream objfood = new ObjectInputStream(filefood);

        while(true){

            Meal food;
            try{
                food = (Meal) objfood.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + food.getName());
            System.out.println("ID : " + food.getId());
            System.out.println("COMPANY : " + food.getCompany());
            System.out.println("PRICE : " + food.getPrice());
            System.out.println("CONDITION : " + food.getCondition());
            System.out.println("DESCRIPTION : " + food.getDescription());
            System.out.println("AVERAGE RATE : " + food.getAve_rate());
            System.out.println("SELLER NAME : " + food.getSname());
            System.out.println("------------------------------------------");


            if(objfood.available() == 0){
                break;
            }

        }

        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----
    public static void allGoods()throws Exception{

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("**********HERE IS OUR PRODUCTS ***********");
        System.out.println("******************************************");

        System.out.println("**********HERE IS OUR  TV  PRODUCTS ***********");

        File Use = new File("SavedData//Products//Houes//Tv//tv.txt");
        FileInputStream filetv = new FileInputStream(Use);
        ObjectInputStream objtv = new ObjectInputStream(filetv);

        while(true){

            Tv tv;
            try{
                tv = (Tv) objtv.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + tv.getName());
            System.out.println("ID : " + tv.getId());
            System.out.println("COMPANY : " + tv.getCompany());
            System.out.println("PRICE : " + tv.getPrice());
            System.out.println("CONDITION : " + tv.getCondition());
            System.out.println("DESCRIPTION : " + tv.getDescription());
            System.out.println("AVERAGE RATE : " + tv.getAve_rate());
            System.out.println("SELLER NAME : " + tv.getSname());
            System.out.println("QUALITY : " + tv.getQuality());
            System.out.println("INCHES : " + tv.getInches());
            System.out.println("------------------------------------------");

            if(objtv.available() == 0){
                break;
            }

        }


        System.out.println("**********HERE IS OUR  OVEN PRODUCTS ***********");
        File User = new File("SavedData//Products//Houes//Ovens//ovens.txt");
        FileInputStream fileOven = new FileInputStream(User);
        ObjectInputStream objOven = new ObjectInputStream(fileOven);

        while(true){

            Oven oven;
            try{
                oven = (Oven) objOven.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + oven.getName());
            System.out.println("ID : " + oven.getId());
            System.out.println("COMPANY : " + oven.getCompany());
            System.out.println("PRICE : " + oven.getPrice());
            System.out.println("CONDITION : " + oven.getCondition());
            System.out.println("DESCRIPTION : " + oven.getDescription());
            System.out.println("AVERAGE RATE : " + oven.getAve_rate());
            System.out.println("SELLER NAME : " + oven.getSname());
            System.out.println("FIRE COUNTS : " + oven.getFireCount());
            System.out.println("BODY MATERIAL : " + oven.getBody());
            System.out.println("MICROWAVE : " + oven.getMicro());
            System.out.println("------------------------------------------");

            if(objOven.available() == 0){
                break;
            }

        }

        File ser = new File("SavedData//Products//Houes//Refrigerator//refrigerator.txt");
        FileInputStream fileref = new FileInputStream(ser);
        ObjectInputStream objref = new ObjectInputStream(fileref);


        System.out.println("**********HERE IS OUR REFRIGERATOR PRODUCTS ***********");
        while(true){

            Refrigerator ref;
            try{
                ref = (Refrigerator) objref.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + ref.getName());
            System.out.println("ID : " + ref.getId());
            System.out.println("COMPANY : " + ref.getCompany());
            System.out.println("PRICE : " + ref.getPrice());
            System.out.println("CONDITION : " + ref.getCondition());
            System.out.println("DESCRIPTION : " + ref.getDescription());
            System.out.println("AVERAGE RATE : " + ref.getAve_rate());
            System.out.println("SELLER NAME : " + ref.getSname());
            System.out.println("CAPACITY : " + ref.getLitre());
            System.out.println("DOOR TYPE : " +ref.getDoor());
            System.out.println("FREEZER : " + ref.getFreezer());
            System.out.println("------------------------------------------");


            if(objref.available() == 0){
                break;
            }
        }


        Scanner x = new Scanner(System.in);
        File Usr = new File("SavedData//Products//Clothing//Dress//dress.txt");
        FileInputStream filedress = new FileInputStream(Usr);
        ObjectInputStream objdress = new ObjectInputStream(filedress);



        while(true){

            Dress dress;
            try{
                dress = (Dress) objdress.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + dress.getName());
            System.out.println("ID : " + dress.getId());
            System.out.println("COMPANY : " + dress.getCompany());
            System.out.println("PRICE : " + dress.getPrice());
            System.out.println("CONDITION : " + dress.getCondition());
            System.out.println("DESCRIPTION : " + dress.getDescription());
            System.out.println("AVERAGE RATE : " + dress.getAve_rate());
            System.out.println("SELLER NAME : " +dress.getSname());
            System.out.println("SIZE : " + dress.getSize());
            System.out.println("MODEL : " + dress.getModel());
            System.out.println("------------------------------------------");

            if(objdress.available() == 0){
                break;
            }

        }


        System.out.println("**********HERE IS OUR  SHOES  PRODUCTS ***********");

        File se = new File("SavedData//Products//Clothing//Shoes//shoes.txt");
        FileInputStream filesh = new FileInputStream(se);
        ObjectInputStream objsh = new ObjectInputStream(filesh);



        while(true){

            Shoes shoes;
            try{
                shoes = (Shoes) objsh.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + shoes.getName());
            System.out.println("ID : " + shoes.getId());
            System.out.println("COMPANY : " + shoes.getCompany());
            System.out.println("PRICE : " + shoes.getPrice());
            System.out.println("CONDITION : " + shoes.getCondition());
            System.out.println("DESCRIPTION : " + shoes.getDescription());
            System.out.println("AVERAGE RATE : " + shoes.getAve_rate());
            System.out.println("SELLER NAME : " + shoes.getSname());
            System.out.println("FOOT SIZE : " + shoes.getFootSize());
            System.out.println("TYPE : " +shoes.getType());
            System.out.println("------------------------------------------");

            if(objsh.available() == 0){
                break;
            }

        }

        System.out.println("**********HERE IS OUR DIGITAL PRODUCTS ***********");
        File Users = new File("SavedData//Products//Digital//Mobiles//mobiles.txt");
        FileInputStream filemob = new FileInputStream(Users);
        ObjectInputStream objmob = new ObjectInputStream(filemob);

        while(true){
            Mobile mobile;
            try{
                mobile = (Mobile) objmob.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + mobile.getName());
            System.out.println("ID : " + mobile.getId());
            System.out.println("COMPANY : " + mobile.getCompany());
            System.out.println("PRICE : " + mobile.getPrice());
            System.out.println("CONDITION : " + mobile.getCondition());
            System.out.println("DESCRIPTION : " + mobile.getDescription());
            System.out.println("AVERAGE RATE : " + mobile.getAve_rate());
            System.out.println("SELLER NAME : " + mobile.getSname());
            System.out.println("SIM CARDS : " + mobile.getSim());
            System.out.println("CAMERA MP : " + mobile.getCam());
            System.out.println("------------------------------------------");

            if(objmob.available() == 0){
                break;
            }
        }

        File Us = new File("SavedData//Products//Digital//Laptops//laptop.txt");
        FileInputStream fileLap = new FileInputStream(Us);
        ObjectInputStream objLap = new ObjectInputStream(fileLap);


        while(true){

            Laptop laptop;
            try{
                laptop = (Laptop) objLap.readObject();
            }
            catch(Exception except){

                break;
            }
            System.out.println("NAME : " + laptop.getName());
            System.out.println("ID : " + laptop.getId());
            System.out.println("COMPANY : " + laptop.getCompany());
            System.out.println("PRICE : " + laptop.getPrice());
            System.out.println("CONDITION : " + laptop.getCondition());
            System.out.println("DESCRIPTION : " + laptop.getDescription());
            System.out.println("AVERAGE RATE : " + laptop.getAve_rate());
            System.out.println("SELLER NAME : " + laptop.getSname());
            System.out.println("CPU : " + laptop.getCpu());
            System.out.println("GAMING : " + laptop.getGaming());
            System.out.println("------------------------------------------");

            if(objLap.available() == 0){
                break;
            }
        }
        System.out.println("**********HERE IS OUR FOOD PRODUCTS ***********");
        File sr = new File("SavedData//Products//Meal//food.txt");
        FileInputStream filefood = new FileInputStream(sr);
        ObjectInputStream objfood = new ObjectInputStream(filefood);

        while(true){

            Meal food;
            try{
                food = (Meal) objfood.readObject();
            }
            catch(Exception except){

                break;
            }

            System.out.println("NAME : " + food.getName());
            System.out.println("ID : " + food.getId());
            System.out.println("COMPANY : " + food.getCompany());
            System.out.println("PRICE : " + food.getPrice());
            System.out.println("CONDITION : " + food.getCondition());
            System.out.println("DESCRIPTION : " + food.getDescription());
            System.out.println("AVERAGE RATE : " + food.getAve_rate());
            System.out.println("SELLER NAME : " + food.getSname());
            System.out.println("------------------------------------------");


            if(objfood.available() == 0){
                break;
            }

        }







        System.out.println("******************************************");
        System.out.println("*BUY SOMETHING (1)      -->*");
        System.out.println("*BACK TO MENU  (2)      -->*");
        int choice = x.nextInt();

        switch (choice) {
            case 1:
                CustomerCont.buyMenu();
                break;
            case 2:
                listProductMenu();
                break;
            default:
                System.out.println("INVALID CHOICE !");
                firstMenu();
        }
    }
    // -----

}