import java.util.ArrayList;
import java.lang.Math;

class FareCalculator {

int daysUsing;
int numOfTrips;
String ticketType;
double fareCost;




public FareCalculator(int days, int trips, String fareType, double farePrice ) {
  this.daysUsing = days;
  this.numOfTrips = trips;
  this.ticketType = fareType;
  this.fareCost = farePrice;
}


public double sevenDayPrice() {

  double weeksUsed = (Math.ceil(this.daysUsing / 7)) * this.fareCost;

  return weeksUsed;




}



public static void main(String[] args) {

   String[] fareTypes =  {"Single journey", "7 day travelcard", "Monthly travelcard", "Annual travelcard"};
   double[] farePrices = {2.90, 27, 103.70, 1080};


  FareCalculator firstTest = new FareCalculator(42, 65, fareTypes[1], farePrices[1]);

  System.out.println(firstTest.ticketType);


  
}


}