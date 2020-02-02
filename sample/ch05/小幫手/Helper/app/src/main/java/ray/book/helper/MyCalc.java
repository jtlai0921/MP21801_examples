package ray.book.helper;

/**
 * Created by ray63 on 2018/1/20.
 */

public class MyCalc {

    double calcInvest(double a,double r,double n)
    {
        return a * Math.pow(1+r,n);
    }

    double calcLoan(double s,double r,double n)
    {
        return  s * ( Math.pow( ( 1 + r / 12 ) , ( n * 12 ) ) * (r / 12) ) / ( Math.pow( ( 1 + r / 12 ) , ( n * 12 ) ) -1 ) ;
    }

}
