package htlklu;

import java.util.Objects;

public class Sports {
    private int id;
    private String name;
    private String sportType;
    private boolean olympic;
    private boolean globallyPopular;
    private String countryOfOrigin;

    public Sports(int id, String name, String sportType, boolean olympic, boolean globallyPopular, String countryOfOrigin) {
        this.id = id;

        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters. Provided: " + name);
        }
        this.name = name;
        if (sportType == null || sportType.length() < 5) {
            throw new IllegalArgumentException("SportType must be at least 5 characters. Provided: " + sportType);
        }
        this.sportType = sportType;
        this.olympic = olympic;
        this.globallyPopular = globallyPopular;
        if (countryOfOrigin != null && (countryOfOrigin.length() < 2 || countryOfOrigin.length() > 20)) {
            throw new IllegalArgumentException("Country Of Origin must be between 2 and 20 characters if provided. Provided: " + countryOfOrigin);
        }
        this.countryOfOrigin = countryOfOrigin;
    }

    public Sports(int id, String name, String sportType, boolean olympic) {
        this(id, name, sportType, olympic, false, null);
    }

    public Sports(int id, String name, String sportType) {
        this(id, name, sportType, false, false, null);
    }

    public Sports(String record){
        var argsArray = record.split(";");

        var id = Integer.parseInt(argsArray[0]);
        var name = argsArray[1];
        var sportType = argsArray[2];
        var olympic = Boolean.parseBoolean(argsArray[3]);
        var globallyPopular = Boolean.parseBoolean(argsArray[4]);
        var countryOfOrigin = argsArray[5];

        //Since a constructor must be called before anything else the only way as of now to check for illegal arguments is by copying the checks from the main constructor
        this.id = id;

        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters. Provided: " + name);
        }
        this.name = name;
        if (sportType == null || sportType.length() < 5) {
            throw new IllegalArgumentException("SportType must be at least 5 characters. Provided: " + sportType);
        }
        this.sportType = sportType;
        this.olympic = olympic;
        this.globallyPopular = globallyPopular;
        if (countryOfOrigin != null && (countryOfOrigin.length() < 2 || countryOfOrigin.length() > 20)) {
            throw new IllegalArgumentException("Country Of Origin must be between 2 and 20 characters if provided. Provided: " + countryOfOrigin);
        }
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        final var sb = new StringBuffer(name).append(": ");
        sb.append(sportType).append(" ");
        sb.append("(olympisch: ").append(olympic).append(", ");
        sb.append("weltweit verbreitet: ").append(globallyPopular).append(", ");
        sb.append("Herkunft: ").append(countryOfOrigin).append(")");
        return sb.toString();
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        if (countryOfOrigin != null && (countryOfOrigin.length() < 2 || countryOfOrigin.length() > 20)) {
            throw new IllegalArgumentException("Country Of Origin must be between 2 and 20 characters if provided. Provided: " + countryOfOrigin);
        }
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    //Beispiel 10 but better
    @Override
    public boolean equals(Object o) {
        var result = true;

        if (!(o instanceof Sports sport)) {
            return false;
        }

        if (!this.name.equals(sport.name)) {
            result = false;
        }

        if (!this.sportType.equals(sport.sportType)) {
            result = false;
        }

        if (this.olympic != sport.olympic) {
            result = false;
        }

        if (this.globallyPopular != sport.globallyPopular) {
            result = false;
        }

        if (!this.countryOfOrigin.equals(sport.countryOfOrigin)) {
            result = false;
        }

        return result;
    }
}
