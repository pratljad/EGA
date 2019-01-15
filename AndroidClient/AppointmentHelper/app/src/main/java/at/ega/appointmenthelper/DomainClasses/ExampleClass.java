package at.ega.appointmenthelper.DomainClasses;

public class ExampleClass {
    private int ValueX;
    private int ValueY;
    private String Description;


    public ExampleClass(int valueX, int valueY, String desc) {
        ValueX = valueX;
        ValueY = valueY;
        Description = desc;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getValueX() {
        return ValueX;
    }

    public void setValueX(int valueX) {
        ValueX = valueX;
    }

    public int getValueY() {
        return ValueY;
    }

    public void setValueY(int valueY) {
        ValueY = valueY;
    }
}
