package foodz.rest.entity;

public class Nutrition {

    private double calories;
    private double total_fat;
    private double saturated_fat;
    private double cholesterol;
    private double sodium;
    private double total_carbohydrate;
    private double dietary_fiber;
    private double sugar;
    private double protein;
    private double potassium;

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getTotal_fat() {
        return total_fat;
    }

    public void setTotal_fat(double total_fat) {
        this.total_fat = total_fat;
    }

    public double getSaturated_fat() {
        return saturated_fat;
    }

    public void setSaturated_fat(double saturated_fat) {
        this.saturated_fat = saturated_fat;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public double getTotal_carbohydrate() {
        return total_carbohydrate;
    }

    public void setTotal_carbohydrate(double total_carbohydrate) {
        this.total_carbohydrate = total_carbohydrate;
    }

    public double getDietary_fiber() {
        return dietary_fiber;
    }

    public void setDietary_fiber(double dietary_fiber) {
        this.dietary_fiber = dietary_fiber;
    }

    public double getSugar() {
        return sugar;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getPotassium() {
        return potassium;
    }

    public void setPotassium(double potassium) {
        this.potassium = potassium;
    }

    public Nutrition() {

    }
    public Nutrition(double calories, double total_fat, double saturated_fat, double cholesterol, double sodium, double total_carbohydrate, double dietary_fiber, double sugar, double protein, double potassium) {

        this.calories = calories;
        this.total_fat = total_fat;
        this.saturated_fat = saturated_fat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.total_carbohydrate = total_carbohydrate;
        this.dietary_fiber = dietary_fiber;
        this.sugar = sugar;
        this.protein = protein;
        this.potassium = potassium;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                ", calories=" + calories +
                ", total_fat=" + total_fat +
                ", saturated_fat=" + saturated_fat +
                ", cholesterol=" + cholesterol +
                ", sodium=" + sodium +
                ", total_carbohydrate=" + total_carbohydrate +
                ", dietary_fiber=" + dietary_fiber +
                ", sugar=" + sugar +
                ", protein=" + protein +
                ", potassium=" + potassium +
                '}';
    }

    public void addNutrition(Food food){
        calories+=food.getNf_calories();
        cholesterol+=food.getNf_cholesterol();
        total_carbohydrate+=food.getNf_total_carbohydrate();
        total_fat+= food.getNf_total_fat();
        saturated_fat+=food.getNf_saturated_fat();
        sodium+= food.getNf_sodium();
        dietary_fiber+= food.getNf_dietary_fiber();
        sugar+= food.getNf_sugars();
        protein+= food.getNf_protein();
        potassium+= food.getNf_potassium();
    }
}
