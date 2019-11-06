import javafx.scene.Scene;

public class Department {
    int id;
    String name;
    double budget, expenses;
    String rentable;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", expenses=" + expenses +
                ", rentable=" + rentable +
                '}';
    }

    public Department(){

    }

    public Department(int id, String name, double budget, double expenses, String rentable) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.expenses = expenses;
        this.rentable = rentable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getRentable() {
        return rentable;
    }

    public void setRentable(String rentable) {
        this.rentable = rentable;
    }
}
