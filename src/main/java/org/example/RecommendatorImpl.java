package org.example;

public class RecommendatorImpl implements Recommendator {
    @InjectProperty // name property ip default name variable alcohol or @InjectProperty("nameProperty")
    private String alcohol;

    @Override
    public void recommend() {
        
        System.out.println("To protect from covid-19 drink - "+alcohol);
    }
}
