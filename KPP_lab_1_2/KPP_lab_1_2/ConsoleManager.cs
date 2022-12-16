namespace KPP_lab_1_2
{
    internal class ConsoleManager
    {
        public static void printWorkersTable(List<Worker> workers)
        {
            Console.WriteLine("\n");
            String header = String.Format(" | {0, -15} | {1, -15} | {2, -10} | {3, -10} | {4, -15} | ", "Name", "Surname", "Salary", "Pass Number", "Pass Series", "Education");
            Console.WriteLine(new String('_', header.Length));
            Console.WriteLine(header);
            Console.WriteLine(new String('_', header.Length));
            foreach (Worker worker in workers)
            {
                String formated = String.Format(" | {0, -15} | {1, -15} | {2, -10} | {3, -10} | {4, -15} | ", worker.Name, worker.Surname, worker.Salary, worker.Pass_number, worker.Pass_series, worker.Education);
                Console.WriteLine(formated);
            }
            Console.WriteLine(new String('_', header.Length));
            Console.WriteLine("\n");
        }

        public static void printWorkerCharacteristicsTable(Worker worker)
        {
            Console.WriteLine("\n");
            Console.WriteLine("Worker " + worker.Name + " characteristics: ");
            String header = String.Format(" | {0, -15} | {1, -10} | ", "Name", "Value");
            Console.WriteLine(new String('_', header.Length));
            Console.WriteLine(header);
            Console.WriteLine(new String('_', header.Length));
            foreach (Characteristic characteristic in worker.Characteristics)
            {
                String formated = String.Format(" | {0, -15} | {1, -10} | ", characteristic.Name, characteristic.Value);
                Console.WriteLine(formated);
            }
            Console.WriteLine(new String('_', header.Length));
            Console.WriteLine("\n");
        }

        public static void printWorkerCareersTable(Worker worker)
        {
            Console.WriteLine("\n");
            Console.WriteLine("Worker " + worker.Name + " careers: ");
            String header = String.Format(" | {0, -25} | {1, -25} | {2, -25} | {3, -15}", "Start Date", "End Date", "Position", "Department");
            Console.WriteLine(new String('_', header.Length));
            Console.WriteLine(header);
            Console.WriteLine(new String('_', header.Length));
            foreach (Career career in worker.Careers)
            {
                String formated = String.Format(" | {0, -25} | {1, -25} | {2, -25} | {3, -15}", career.Start_date.ToShortDateString(), career.End_date.ToShortDateString(), career.Position, career.Department); ;
                Console.WriteLine(formated);
            }
            Console.WriteLine(new String('_', header.Length));
            Console.WriteLine("\n");
        }

        public static void printMenu(List<Worker> workers)
        {
            while(true)
            {
                Console.WriteLine("\n");
                Console.WriteLine("1. Add worker");
                Console.WriteLine("2. Add career");
                Console.WriteLine("3. Add characteristic");
                Console.WriteLine("4. Print workers table");
                Console.WriteLine("5. Print worker characteristics table");
                Console.WriteLine("6. Print worker careers table");
                Console.WriteLine("7. Sort workers by salary");
                Console.WriteLine("8. Sort workers by passport number");
                Console.WriteLine("9. Sort workers by passport series");
                Console.WriteLine("10. Sort workers by average characteristic mark");
                Console.WriteLine("11. Serialize workers");
                Console.WriteLine("12. Deserialize workers");
                Console.WriteLine("13. Exit");
                Console.Write("Enter your choice: ");
                
                int choice = Convert.ToInt32(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        Console.Write("Enter name: ");
                        String name = Console.ReadLine();
                        Console.Write("Enter surname: ");
                        String surname = Console.ReadLine();
                        Console.Write("Enter salary: ");
                        int salary = Convert.ToInt32(Console.ReadLine());
                        Console.Write("Enter passport series: ");
                        String pass_series = Console.ReadLine();
                        Console.Write("Enter passport number: ");
                        String pass_number = Console.ReadLine();
                        Console.Write("Enter education: ");
                        String education = Console.ReadLine();
                        workers.Add(new Worker(name, surname, salary, pass_series, pass_number, education));
                        break;
                    case 2:
                        Console.Write("Enter worker index: ");
                        int worker_index = Convert.ToInt32(Console.ReadLine());
                        Console.Write("Enter start date: ");
                        DateTime start_date = DateTime.Parse(Console.ReadLine());
                        Console.Write("Enter end date: ");
                        DateTime end_date = DateTime.Parse(Console.ReadLine());
                        Console.Write("Enter position: ");
                        String position = Console.ReadLine();
                        Console.Write("Enter department: ");
                        String department = Console.ReadLine();
                        workers[worker_index].Careers.Add(new Career(start_date, end_date, position, department));
                        break;
                    case 3:
                        Console.Write("Enter worker index: ");
                        worker_index = Convert.ToInt32(Console.ReadLine());
                        Console.Write("Enter characteristic name: ");
                        String characteristic_name = Console.ReadLine();
                        Console.Write("Enter characteristic value: ");
                        int characteristic_value = Convert.ToInt32(Console.ReadLine());
                        workers[worker_index].Characteristics.Add(new Characteristic(characteristic_name, characteristic_value));
                        break;
                    case 4:
                        printWorkersTable(workers);
                        break;
                    case 5:
                        Console.Write("Enter worker index: ");
                        worker_index = Convert.ToInt32(Console.ReadLine());
                        printWorkerCharacteristicsTable(workers[worker_index]);
                        break;
                    case 6:
                        Console.Write("Enter worker index: ");
                        worker_index = Convert.ToInt32(Console.ReadLine());
                        printWorkerCareersTable(workers[worker_index]);
                        break;
                    case 7:
                        Utilities.sortByWorkersSalary(workers);
                        Console.WriteLine("Workers sorted by salary!");
                        break;
                    case 8:
                        Utilities.sortByPassportNumber(workers);
                        Console.WriteLine("Workers sorted by pass number!");
                        break;
                    case 9:
                        Utilities.sortByPassportSeries(workers);
                        Console.WriteLine("Workers sorted by pass series!");
                        break;
                    case 10:
                        Utilities.sortByAvgCharMark(workers);
                        Console.WriteLine("Workers sorted by avarage characteristic mark!");
                        break;
                    case 11:
                        Console.Write("Enter file name: ");
                        String file_name = Console.ReadLine();
                        Utilities.serializeWorkers(workers, file_name);
                        Console.WriteLine("Workers serialized!");
                        break;
                    case 12:
                        Console.Write("Enter file name: ");
                        file_name = Console.ReadLine();
                        workers = Utilities.deserializeWorkers(file_name);
                        Console.WriteLine("Workers deserialized!");
                        break;
                    case 13:
                        return;
                }
            }
        }
    }
}
   




