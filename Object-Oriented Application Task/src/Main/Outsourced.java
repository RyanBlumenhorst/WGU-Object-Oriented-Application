package Main;

/**This class is for the Outsourced products and includes a Company Name.*/
public class Outsourced extends Part{
    //Variable
    private String companyName;



    /**Constructor
     * @param id ID for part.
     * @param name Name of part.
     * @param price Price of part.
     * @param stock Stock of part.
     * @param min Minimum stock for that part.
     * @param max Maximum Stock for that part.
     * @param companyName Name of the company that makes that part.
     * */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName){
        super(0,"",0,0,0,0);
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setStock(stock);
        this.setMin(min);
        this.setMax(max);
        this.setCompanyName(companyName);
    }

    /**Default Constructor*/
    public Outsourced(){
        super(0,"",0,0,0,0);
    }

    /**
     * Used to set the company name of an outsourced part.
     * @param companyName Name of the company that makes the outsourced part.
     * */
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    /**
     * @return companyName
     * */
    public String getCompanyName(){
        return companyName;
    }
}
