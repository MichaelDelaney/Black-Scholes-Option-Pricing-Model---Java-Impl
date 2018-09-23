package main.java.OptionPricing;

public class Options {

    /**
     * Black-Scholes option pricing model for theoretical value of
     * Euro-style options
     * @param price
     * @param time
     * @param strike
     * @param rate
     * @param normalDistribution
     * @param exponentialTerm
     * @param volatility
     * @return
     */
    public static double evaluateBlackScholesPrice(double price,
                                                   double time, double strike,
                                                   double rate, double normalDistribution,
                                                   double exponentialTerm, double volatility) {
        double expectedBenefit = priceChange(price, strike, rate, volatility, time);
        double currentValue = currentValue(expectedBenefit, volatility, time);
        double premium = (price*normalDistribution*expectedBenefit) -
                normalDistribution * currentValue * strike * (Math.pow(exponentialTerm, (-rate*time)));
        return premium;
    }


    /**
     * Determines the expected benefit of obtained the underling asset
     * @param price
     * @param strike
     * @param rate
     * @param volatility
     * @param time
     * @return
     */
    public static double priceChange(double price, double strike,
                                     double rate, double volatility, double time){
        double numerator = Math.log(price/strike)+
                ((rate + (Math.pow(volatility, 2)/2))*time);
        return numerator/(volatility *  Math.sqrt(time));
    }

    /**
     * Determines the curent value of paying premium at time of expiration
     * @param expectedBenefit
     * @param volatility
     * @param time
     * @return
     */
    public static double currentValue(double expectedBenefit, double volatility, double time){
        return expectedBenefit - (volatility * Math.sqrt(time));
    }

}
