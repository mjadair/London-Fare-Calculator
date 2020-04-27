import java.util.ArrayList;
import java.lang.Math;

class FareCalculator {

  int daysUsing;
  int numOfTrips;
  String[] fareTypes = { "Single journey", "7 day travelcard", "Monthly travelcard", "Annual travelcard" };
  double[] farePrices = { 2.90, 27, 103.70, 1080 };

  public FareCalculator(int days, int trips) {
    this.daysUsing = days;
    this.numOfTrips = trips;
  }

  public double sevenDayPrice() {

    double weeksUsed = (Math.ceil(this.daysUsing / 7)) * this.farePrices[1];

    if (weeksUsed == 0.0) {
      return this.farePrices[1];
    }

    return weeksUsed;
  }

  public double monthPrice() {

    double monthsUsed = (Math.ceil(this.daysUsing / 30)) * this.farePrices[2];

    if (monthsUsed == 0.0) {
      return this.farePrices[2];
    }

    return monthsUsed;
  }

  public double annualPrice() {

    double yearsUsed = (Math.ceil(this.daysUsing / 365)) * this.farePrices[3];

    if (yearsUsed == 0.0) {
      return this.farePrices[3];
    }

    return yearsUsed;
  }

  public double[] allFarePrices() {

    double[] allFarePrices = { this.numOfTrips * this.farePrices[0], this.sevenDayPrice(), this.monthPrice(),
        this.annualPrice() };

    return allFarePrices;

  }

  public String checkBestFare() {

    double[] bestFare = this.allFarePrices();

    int index = 0;
    double min = bestFare[index];

    for (int i = 1; i < bestFare.length; i++) {

      if (bestFare[i] < min) {
        min = bestFare[i];
        index = i;
      }

    }
    return this.fareTypes[index];

  }

  public static void main(String[] args) {

    FareCalculator oneDay = new FareCalculator(1, 1);
    FareCalculator busyDay = new FareCalculator(1, 40);
    FareCalculator busyWeek = new FareCalculator(7, 45);
    FareCalculator busyEight = new FareCalculator(8, 55);
    FareCalculator busyTwentyTwo = new FareCalculator(22, 100);
    FareCalculator busyMonth = new FareCalculator(30, 300);
    FareCalculator busyTwoMonths = new FareCalculator(60, 300);
    FareCalculator busyYear = new FareCalculator(364, 1000);

    System.out.println("The best fare for one trip in a day is " + oneDay.checkBestFare());
    System.out.println("The best fare for a busy day is " + busyDay.checkBestFare());
    System.out.println("The best fare for a busy week is " + busyWeek.checkBestFare());
    System.out.println("The best fare for eight days is " + busyEight.checkBestFare());
    System.out.println("The best fare for 22 days is " + busyTwentyTwo.checkBestFare());
    System.out.println("The best fare for a busy month is " + busyMonth.checkBestFare());
    System.out.println("The best fare for a busy two months is " + busyTwoMonths.checkBestFare());
    System.out.println("The best fare for a busy year is " + busyYear.checkBestFare());

  }

}