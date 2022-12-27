package project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/** the goal of this program is to act like a transaction
* between a movie teller and a customer who wants to watch a
* movie.
* @author Favour Ojo, Urszula Oszczapinska, Kyrie Doniz
*/

public class Main {
  /** Main method to implement input and output.
  */
  public static void main(String [] args) {
    // change the welcome message
    System.out.println("Welcome to Groovy Movies!" + " Today's date is: " + new Date());
    System.out.println();

    Scanner scanner = new Scanner(System.in);

    // ask customer if they would like to have a summary of each movie
    System.out.println("Would you like to know what movies are playing now?");
    String answer = scanner.nextLine();

    // check for answer from customer
    if (answer.contains("yes")) {
      System.out.println("Okay!");
      System.out.println();
    } else {
      System.out.println("You must say yes to use our application. \nGoodbye now!");
      return;
    }

    // creating an arrayList for movies-titles
    Scanner scanner15 = null;
    try {
      File movietitles = new File("input/movie-titles");
      scanner15 = new Scanner(movietitles);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    ArrayList<String> movietitles = new ArrayList<String>();
    while (scanner15.hasNext()) {
      String movietitle1;
      movietitle1 = scanner15.nextLine();
      movietitles.add(movietitle1);
    }

    // printing out the ArrayList of movies
    System.out.println("\nThe following films are currently showing: " + movietitles);

    // User selects what movie they want to see
    Scanner scanner3 = new Scanner(System.in);
    System.out.println("\nWhat film would you like to see? (Case sensitive)");
    System.out.println();
    String movieSelection = scanner3.nextLine();
    System.out.println("\nOkay, you would like to see " + movieSelection + ".");
    System.out.println();

    // Prints the showingtime for the movie
    Scanner scanner4 = null;
    try {
      File showingtime = new File("input/movies");
      scanner4 = new Scanner(showingtime);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    String showingtime = scanner4.nextLine();
    System.out.println("The showing times for " + movieSelection + " are: " + showingtime);

    //user is asked what showing time they want, and prints the showing time...
    Scanner scanner5 = new Scanner(System.in);
    System.out.println("\nWhat showing of " + movieSelection + " would you like to see?");
    String timeSelection = scanner5.nextLine();
    System.out.println("Okay, you would like to go to the " + timeSelection + " showing.");

    // displaying ticket prices with corresponding ticket types
    Scanner scanner6 = null;
    try {
      File ticketPrices = new File("input/prices");
      scanner6 = new Scanner(ticketPrices);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }

    System.out.println("\nChoose from the following ticket types: ");

    String ticketType = scanner6.nextLine();
    String[] types = ticketType.split(",");
    int[] arr = new int[4];

    for (int i = 0; i < arr.length; i += 1) {
      arr[i] = scanner6.nextInt();
    }

    ArrayList<Tickets> ticket = new ArrayList<Tickets>();

    for (int i = 0; i < arr.length; i += 1) {
      Tickets tick = new Tickets(arr[i], types[i]);
      ticket.add(i, tick);
    }

    for (int i = 0; i < ticket.size(); i += 1) {
      System.out.println("Ticket " + (i + 1) + ": " + ticket.get(i).getType()
          + " $" + ticket.get(i).getPrice());
    }

    System.out.println("\nNow we will ask you how many tickets you'd like.");

    // getting input from the user about how many tix they need
    Scanner scanner7 = new Scanner(System.in);

    int adultTix;
    System.out.println("\nPlease enter the number of adult tickets needed: ");
    adultTix = scanner7.nextInt();

    int childTix;
    System.out.println("Please enter the number of child tickets needed: ");
    childTix = scanner7.nextInt();

    int studentTix;
    System.out.println("Please enter the number of student tickets needed: ");
    studentTix = scanner7.nextInt();

    int seniorTix;
    System.out.println("Please enter the number of senior tickets needed: ");
    seniorTix = scanner7.nextInt();

    // confirming the number of each tix the individual needs.
    System.out.println("\nOkay, you will be purchasing a ticket for: " + adultTix
        + " adult(s) " + childTix + " child(ren) " + studentTix + " student(s) and "
        + seniorTix
        + " senior(s).");

    // totaling the cost of all of the tickets
    System.out.println("\nThe total cost of your ticket purchase is: $"
        + (adultTix * 13.00 + childTix * 9.00 + studentTix * 10.00
        + seniorTix * 7.00));


    // creating a scanner and connecting it to file for OFFER
    Scanner scanner9 = null;
    try {
      File offerInput = new File("input/offer");
      scanner9 = new Scanner(offerInput);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // create variables for the info coming from the input file for OFFER
    String offerText = scanner9.nextLine();
    int offerId = scanner9.nextInt();

    //create an instance of an offer class
    Offer myOffer = new Offer(offerId, offerText);

    //print out the offer id and its text aka the coupon
    System.out.println("Coupon " + myOffer.getOfferId() + ": " + myOffer.getOfferText());
    System.out.println("\nYou will be watching " + movieSelection + " at " + timeSelection);
    System.out.println("\nThank you for choosing Groovy Movies! Enjoy your film!");
    System.out.println("\nHere are some quick facts about " + movieSelection);

    // Movie ratings.
    if (movieSelection.contains("Ford v. Ferrari") || movieSelection.contains("Charlie's Angels")
        || movieSelection.contains("Last Christmas")) {
      System.out.println(movieSelection + " is rated PG-13.");
    } else if (movieSelection.contains("Doctor Sleep") || movieSelection.contains("Joker")
        || movieSelection.contains("Terminator: Dark Fate")) {
      System.out.println(movieSelection + " is rated R.");
    } else if (movieSelection.contains("Playing with Fire")
        || movieSelection.contains("Maleficent: Mistress of Evil")) {
      System.out.println(movieSelection + " is rated PG.");
    }

    // Movie genre.
    if (movieSelection.contains("Ford v. Ferrari") || movieSelection.contains("Last Christmas")
        || movieSelection.contains("Joker")) {
      System.out.println(movieSelection + " is considered to be a Drama.");
    } else if (movieSelection.contains("Doctor Sleep")
        || movieSelection.contains("Maleficent: Mistress of Evil")
        || movieSelection.contains("Terminator: Dark Fate")) {
      System.out.println(movieSelection + " is considered to be a Fantasy movie.");
    } else if (movieSelection.contains("Charlie's Angels")) {
      System.out.println(movieSelection + " is considered to be an Action movie.");
    } else if (movieSelection.contains("Playing with Fire")) {
      System.out.println(movieSelection + " is considered to be a Comedy.");
    }

    //movie synopsis
    if (movieSelection.contains("Ford v. Ferrari")) {
      System.out.println("Synopsis: Based on the remarkable true story of the visionary"
          + " American car designer Carroll Shelby (Matt Damon) and"
          + " the fearless British-born driver"
          + " Ken Miles (Christian Bale), who built a revolutionary race car for Ford Motor Company"
          + " at the 24 Hours of Le Mans in France in 1966.");
    } else if (movieSelection.contains("Charlie's Angels")) {
      System.out.println("Synopsis: A sexy, high-octane update of the original '70s action-comedy"
          + " TV series.");
    } else if (movieSelection.contains("Last Christmas")) {
      System.out.println("Synopsis: A Londoner (Emilia Clarke) who works"
          + " as a Christmas shop elf finds"
          + " romance with a charming suitor (Henry Golding).");
    } else if (movieSelection.contains("Doctor Sleep")) {
      System.out.println("Synopsis: Struggling with alcoholism, Dan Torrance (Ewan McGregor)"
          + " remains traumatized by the sinister events that occurred"
          + " at the Overlook Hotel when he was a child.");
    } else if (movieSelection.contains("Playing with Fire")) {
      System.out.println("Synopsis: Three happy-go-lucky firefighters (John Cena,"
          + " Keegan Michael Key, John Leguizamo) find themselves babysitting three"
          + " wild and unpredictable kids.");
    } else if (movieSelection.contains("Joker")) {
      System.out.println("Synopsis: Failed comedian Arthur Fleck encounters violent thugs while"
          + " wandering the streets of Gotham City dressed as a clown."
          + " Disregarded by society, Fleck begins a slow descent into madness as he"
          + " transforms into the criminal mastermind known as the Joker.");
    } else if (movieSelection.contains("Maleficent: Mistress of Evil")) {
      System.out.println("Synopsis: A formidable queen (Michelle Pfeiffer) causes a rift between"
          + " Maleficent (Angelina Jolie) and Princess Aurora (Elle Fanning).");
    } else if (movieSelection.contains("Terminator: Dark Fate")) {
      System.out.println("Synopsis: Linda Hamilton (Sarah Connor) and Arnold Schwarzenegger (T-800)"
          + " return in their iconic roles in Terminator: Dark Fate, directed by Tim Miller"
          + " and produced by visionary filmmaker James Cameron and David Ellison.");
    }
  }
}
