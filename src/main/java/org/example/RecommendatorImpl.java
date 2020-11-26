package org.example;


@Singleton
public class RecommendatorImpl implements Recommendator {


    @InjectProperty("wisky") // name property ip default name variable alcohol or @InjectProperty("nameProperty")
    private String alcohol;

    @Override
    public void recommend() {
        
        System.out.println("To protect from covid-19 drink - "+alcohol);
    }
}
