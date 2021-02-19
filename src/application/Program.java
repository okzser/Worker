package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

public class Program {
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Enter Department's name: ");
        String WorkerDepartment = sc.next();
        
        System.out.println("Enter worker's data:");
        
        System.out.print("Name: ");
        String WorkerName = sc.next();
        
        System.out.print("Level: ");
        String workerLevel = sc.next();
        
        System.out.print("Base Salary: ");
        Double WorkerBaseSalary = sc.nextDouble();
        
        Worker w = new Worker(WorkerName, WorkerLevel.valueOf(workerLevel), WorkerBaseSalary, new Department(WorkerDepartment));

        System.out.println("How many contracts to this worker?");
        int contracts = sc.nextInt();

        for (int i = 0; i < contracts; i++) {
            System.out.println("Enter contract #" + (i + 1)  + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            w.addContract(contract);
        }
        System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + w.getName());
		System.out.println("Department: " + w.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", w.income(year, month)));
		
		sc.close();

        
    }
    
}
