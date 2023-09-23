package Main;

/**This class is for the In-House products and includes a Machine ID*/
public class InHouse extends Part {

    //Variable
    private int machineId;

    /**Constructor
     * @param id ID for part.
     * @param name Name of part.
     * @param price Price of part.
     * @param stock Stock of part.
     * @param min Minimum stock for that part.
     * @param max Maximum Stock for that part.
     * @param machineId ID of the machine that makes that part.
     * */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id,name,price,stock,min,max);
        setId(id);
        setName(name);
        setPrice(price);
        setStock(stock);
        setMin(min);
        setMax(max);
        setMachineId(machineId);
    }

    /**Default Constructor*/
    public InHouse(){
        super(0,"",0,0,0,0);
    }

    /**
     * Used to set the machine ID for an in-house parts.
     * @param machineId ID of machine.
     * */
    public void setMachineId(int machineId){
        this.machineId = machineId;
    }

    /**
     * @return machineId
     * */
    public int getMachineId(){
        return machineId;
    }
}
