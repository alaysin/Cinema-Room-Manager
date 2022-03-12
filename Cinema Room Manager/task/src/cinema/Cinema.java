package cinema;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Cinema {
    public static int soldTickets = 0;
    public static int currentIncome = 0;
    public static int totalIncome = 0;
    public static double seatsCount = 0.0;
    public static double percentage = 0.0;
    public static boolean sold = false;

    public static void main(String[] args) {
        // Write your code here

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println();
        String[][] theater = theater(rows, seats);
        totalIncome = totalIncome(rows, seats);
        seatsCount = rows * seats;
//        theater(rows, seats);
//        print(theater(rows,seats));
//
//        theaterBySize(rows, seats);
//        tasks();
        tasks();


        boolean exit = false;
        while (!exit) {
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Cinema:");
                    print(theater);
                    System.out.println();
                    tasks();
                    break;
                case 2:
//                    System.out.println("\nEnter a row number:");
//                    int row = scanner.nextInt();
//                    System.out.println("Enter a seat number in that row:");
//                    int seat = scanner.nextInt();
//                    int ticket = ticketPrice(rows, seats, row);

//                    currentIncome += ticket;
//                    theaterBySize(rows, seats, row, seat);
//                    System.out.println();
                    theater = ticketBuy(theater, rows, seats);

//                    System.out.println();

                    break;
                case 3:
                    statistics();
                    System.out.println();
                    tasks();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }


//        System.out.println("\nEnter a row number:");
//        int row = scanner.nextInt();
//        System.out.println("Enter a seat number in that row:");
//        int seat = scanner.nextInt();
//        System.out.println("Ticket price: $" + ticketPrice(rows, seats, row));
//        System.out.println();
//        theaterBySize(rows, seats, row, seat);
//        System.out.println();
//        System.out.println("Total income:");
//        System.out.printf("$%d",totalIncome(rows, seats));
    }

    public static int totalIncome(int rows, int seats) {
        int t = 0;
        int totalSeats = rows * seats;
        if (totalSeats <= 60) {
            t = totalSeats * 10;
        } else {
            t = (rows / 2) * seats * 10 + (rows - rows / 2) * seats * 8;
        }

        return t;
    }

    public static int ticketPrice(int rows, int seats, int row) {
        int price = 0;
        int totalSeats = rows * seats;
        if (totalSeats <= 60) {
            price = 10;
        } else if (rows / 2 >= row) {
            price = 10;
        } else {
            price = 8;
        }
        return price;
    }

    public static void theater() {
        System.out.println("Cinema:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == 0 && j != 0) {
                    System.out.print(j + " ");
                } else if (j == 0 && i != 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }

    public static void theaterBySize(int rows, int seats) {
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == 0 && j != 0) {
                    System.out.print(j + " ");
                } else if (j == 0 && i != 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }

    public static void theaterBySize(int rows, int seats, int row, int seat) {
        System.out.println("Cinema:");
        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= seats; j++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == row && j == seat) {
                    System.out.print("B ");
                } else if (i == 0 && j != 0) {
                    System.out.print(j + " ");
                } else if (j == 0 && i != 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }
    }

    public static void tasks() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static String[][] theater(int rows, int seats) {
        String[][] theater = new String[rows + 1][seats + 1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == 0 && j == 0) {
                    theater[i][j] = " ";
                } else if (i == 0 && j != 0) {
                    theater[i][j] = String.valueOf(j);
                } else if (j == 0 && i != 0) {
                    theater[i][j] = String.valueOf(i);
                } else {
                    theater[i][j] = "S";
                }
            }
        }
        return theater;
    }

    public static void print(String[][] strings) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[0].length; j++) {
                System.out.print(strings[i][j] + " ");
            }
            System.out.println();

        }
    }

    public static String[][] ticketBuy(String[][] theater, int rows, int seats) {

        Scanner scanner = new Scanner(System.in);
        sold = false;
        while (!sold) {
            System.out.println("\nEnter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();
            int ticket = ticketPrice(rows, seats, row);
            theater = buyATicket(theater, row, seat, ticket);
        }
        return theater;
    }

    public static String[][] buyATicket(String[][] strings, int rows, int seats, int ticketPrice) {
        if (rows >= strings.length || seats >= strings[0].length || rows < 1 || seats < 1) {
            System.out.println();
            System.out.println("Wrong input!");
        } else {
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[0].length; j++) {
                    if (i == rows && j == seats && strings[i][j].equals("B")) {
                        System.out.println();
                        System.out.println("That ticket has already been purchased!");
                    } else if (i == rows && j == seats) {
                        strings[i][j] = "B";
                        currentIncome += ticketPrice;
                        soldTickets++;
                        System.out.println("Ticket price: $" + ticketPrice);
                        System.out.println();
                        sold = true;
                        tasks();
                    }
                }
            }
        }

        return strings;
    }


    public static void statistics() {
        System.out.println("Number of purchased tickets: " + soldTickets);
        percentage = soldTickets == 0 ? 0 : (soldTickets / seatsCount) * 100;
        String formattedDouble = new DecimalFormat("#0.00").format(percentage);
        System.out.println("Percentage: " + formattedDouble + "%");
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}