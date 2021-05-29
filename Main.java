import java.awt.image.WritableRaster;
import java.io.*;
import java.util.*;
/*
Done: add
delete
main menu
options menu

Pending:
arraylist (not able to add names of file to arraylist to be displayed)
search (Done with displaying contents, cannot open the file)
display all ()
 */
//class Filelist {
//    public String nameOfFile;
//
//    public Filelist(String nameOfFile) {
//        this.nameOfFile = nameOfFile;
//    }
//    }

class Menu {
    public Menu() {
        System.out.println("\n          !!..Welcome to LockedMe.com (Assessment 1)..!!");
        System.out.println("             Developed by-    Mohanish Pingale \n");
        System.out.println(" Please select from one of the following options and enter the number associated with it : ");
        System.out.println(" 1 : View All Files \n" + " 2 : View the Options Menu\n" + " 3 : Exit the Application\n");

        Scanner userip = new Scanner(System.in);
        int x = userip.nextInt();
        if (x == 1) {
            DisplayAllFiles disss = new DisplayAllFiles();
        } else if (x == 2) {
            Optionsmenu omenu = new Optionsmenu();
        } else if (x == 3) {
            System.out.println("THANK-YOU");
            System.exit(0);
        } else {
            System.out.println("Invalid Input Please Try Again");
        }
    }
}

class Optionsmenu {

    public ArrayList alfil = new ArrayList();
    Scanner uip2 = new Scanner(System.in);

    public Optionsmenu(int x) {
        for (int i = 0; i < alfil.size(); i += 1) {
            System.out.println(alfil.get(i));
            this.alfil = alfil;
        }

    }

    public Optionsmenu() {
        System.out.println("Welcome to Options Menu");
        System.out.println(" Please select from one of the following options and enter the number associated with it : ");
        System.out.println(" 1 : Add a File \n" + " 2 : Delete a File \n" + " 3 : Search for a Specific File \n"
                + " 4 : Edit a specific file \n" + " 5 : Go Back to Main Menu \n" + " 6 : Exit the Application");

        int y = uip2.nextInt();
        if (y == 1) {
            add();
        } else if (y == 2) {
            delete();
        } else if (y == 3) {
            search();
        } else if (y == 4) {
            //writeAFile();
        } else if (y == 5) {
            Menu mmenu = new Menu();
        } else if (y == 6) {
            System.exit(0);
        } else {
            System.out.println("Invalid input please try again..");
        }
    }

    public void add() {
        System.out.println("Please enter the name of the file you want to create along with the file extension. (.txt , .pdf etc etc..)");
        String addd = uip2.next();
        try {
            File file1 = new File("D:\\11\\" + addd);
            boolean flag = file1.createNewFile();
            if (flag) {
                System.out.println("File " + file1.getName() + " has been created successfully at the specified location");
                this.alfil.add(addd); // ERROR, CANT CREATE OBJ
            } else {
                System.out.println("File already present at the specified location.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        System.out.println("Please enter the name of the file you want to delete along with the file extension. (.txt , .pdf etc etc..)");
        String deleteee = uip2.next();
        File myFile = new File(deleteee);
        if (myFile.delete()) {
            System.out.println("I have deleted: " + myFile.getName());
        } else {
            System.out.println("Some problem occurred while deleting the file");
        }
    }

    public void search() {
        System.out.println("Please enter the name of the file you want to search along with the file extension. (.txt , .pdf etc etc..)");
        String searrchh = uip2.next();
        File myFile = new File(searrchh);
        try {
            System.out.println("The contents of searched file '" + searrchh + "' are as displayed below");
            Scanner sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

//    public void writeAFile(){
//        System.out.println("Please enter the name of the file you want to search along with the file extension. (.txt , .pdf etc etc..)");
//        String wrrite = uip2.next();
////        try {
////            System.out.println("Enter the context of the file");
////            FileWriter fileWriter =  new FileWriter(wrrite);
////            String wr = uip2.nextLine();
////            fileWriter.write(wr);
////            fileWriter.close();
////        } catch (IOException e) {
////            e.printStackTrace();
////        }

}


    class DisplayAllFiles {
        public DisplayAllFiles() {
//        ArrayList ef = null;
//        Optionsmenu d = new Optionsmenu(2);
//        System.out.println(d.toString());
            File folder = new File("D:\\11\\");

            File[] files = folder.listFiles();

            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    public class Main {
        public static void main(String[] args) {
            Menu mainmenu = new Menu();
        }
    }

