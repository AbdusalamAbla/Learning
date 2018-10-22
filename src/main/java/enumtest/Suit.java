package enumtest;

/**
 * Created by 34784 on 17/10/20.
 */
 enum  Suit {
     CLUBS("black"),DIAMONDS("red"),HEARTS("red"),SPADES("black");
     private final String color;
     Suit(String suitColor){
         color=suitColor;
    }
    public String getColor()
    {
        return color;
    }
}
