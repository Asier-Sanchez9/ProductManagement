package labs.pm.data;

@FunctionalInterface

public interface Rateable <T>{
    // Static, final y public (por defecto)
    public static final Rating DEFAULT_RATING = Rating.NOT_RATED;

    public abstract T applyRating(Rating rating);

    public default Rating getRating(){
        return DEFAULT_RATING;
    }

    public static Rating convert(int stars){
        // method logic will be assed here
//        Rating [] valores = Rating.values();
//        return (stars >= 0 && stars <=5) ? valores [stars]: DEFAULT_RATING;
        return (stars >= 0 && stars <=5) ? Rating.values() [stars]: DEFAULT_RATING;
    }




}
