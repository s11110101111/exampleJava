package org.example;


@Singleton
@Deprecated
public class RecommendatorImpl implements Recommendator {

    @InjectProperty("wisky") // name property ip default name variable alcohol or @InjectProperty("nameProperty")
    private String alcohol;

    public RecommendatorImpl() {
        System.out.println("Recommendator was created.");
    }

    @Override
    public void recommend() {
        
        System.out.println("To protect from covid-19 drink - "+alcohol);
    }
}
