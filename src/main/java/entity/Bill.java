package entity;
public class Bill {
    int ID;
    String drinkName;
    int drinkPrice;
    int drinkQuantity;
    public Bill(){}

    public Bill(int ID, String drinkName, int drinkPrice, int drinkQuantity) {
        this.ID = ID;
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkQuantity = drinkQuantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(int drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public int getDrinkQuantity() {
        return drinkQuantity;
    }

    public void setDrinkQuantity(int drinkQuantity) {
        this.drinkQuantity = drinkQuantity;
    }

    public int getTotalPrice() {
        return drinkQuantity*drinkPrice;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }
}
