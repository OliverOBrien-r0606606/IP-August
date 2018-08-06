package foodz.entity.Recipe;


public enum Unit {
    KILOGRAM("kg"),
    GRAM("g"),
    LITRE("l"),
    DECILITRE("dl"),
    CENTILITRE("cl"),
    OUNCE("oz"),
    POUND("lb"),
    CUP("cup"),
    TEASPOON("tsp"),
    TABLESPOON("tbsp"),
    DROP("drop"),
    PINCH("pinch"),
    DASH("dash"),
    PIECE("piece");

    private String option;


    Unit(String option){
        this.option=option;
    }

    public String option(){
        return option;
    }
}
