import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SecurityException{
        Scanner scanner = new Scanner(System.in);

        // User login, part 1:
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        SignUp signUp = new SignUp(username, password);
        if (signUp.getUser_Name().equals(username) && signUp.getPass_Word().equals(password)) {
            System.out.println("Login successful!");
            userMenu(scanner);
        } else if (signUp.getAUser_Name().equals(username) && signUp.getAPass_Word().equals(password)) {
            System.out.println("Login successful!");
            readMedicineList();
        } else {
            System.out.println("Invalid username or password. Login failed.");
            throw new SecurityException("Invalid username or password. Login failed.");
        }
    }

    private static void userMenu(Scanner scanner) {
        List<AgentMediList> medicineList = new ArrayList<>();
        boolean exitMenu = false;

        while (!exitMenu) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add a new medicine");
            System.out.println("2. Show medicine list");
            System.out.println("3. Remove a medicine");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewMedicine(scanner, medicineList);
                    break;
                case 2:
                    showMedicineList();
                    break;
                case 3:
                    removeMedicine(scanner);
                    break;
                case 4:
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        writeMedicineList(medicineList);
    }

    private static void addNewMedicine(Scanner scanner, List<AgentMediList> medicineList){
        while (true) {
            System.out.println("Enter medicine name:");
            String medicineName = scanner.nextLine();

            if (medicineName.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Enter generic name:");
            String genericName = scanner.nextLine();

            System.out.println("Enter company name:");
            String companyName = scanner.nextLine();

            System.out.println("Enter expiry date:");
            String expiryDate = scanner.nextLine();

            System.out.println("Enter price:");
            double price = scanner.nextDouble();

            System.out.println("Enter total quantity:");
            int totalQuantity = scanner.nextInt();
            scanner.nextLine();

            AgentMediList medicine = new AgentMediList(medicineName, genericName, companyName, expiryDate, price, totalQuantity);
            medicineList.add(medicine);

            System.out.println("Medicine added successfully.");
            System.out.println("Write exit for stop input.");
        }
        writeMedicineList(medicineList);
    }

    private static void showMedicineList() {
        try {
            FileReader fileReader = new FileReader("medicine_list.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    private static void removeMedicine(Scanner scanner) {
        try {
            System.out.println("Enter medicine name to remove:");
            String medicineName = scanner.nextLine();

            FileReader fileReader = new FileReader("medicine_list.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<>();
            String line;
            boolean found = false;

            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(medicineName)) {
                    found = true;
                    continue;
                }
                lines.add(line);
            }

            bufferedReader.close();

            if (!found) {
                System.out.println("Medicine not found in the list.");
                return;
            }

            // Write the updated lines back to the file
            FileWriter fileWriter = new FileWriter("medicine_list.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String updatedLine : lines) {
                bufferedWriter.write(updatedLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            System.out.println("Medicine removed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while removing the medicine: " + e.getMessage());
        }
    }

    private static void writeMedicineList(List<AgentMediList> medicineList) {
        try {
            FileWriter fileWriter = new FileWriter("medicine_list.txt", true); // Append mode
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            AgentMediList medicine = medicineList.get(medicineList.size() - 1); // Get the last added medicine

            bufferedWriter.write(medicine.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            System.out.println("Medicine added successfully. Medicine list updated.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    private static void readMedicineList() {
        try {
            FileReader fileReader = new FileReader("medicine_list.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
