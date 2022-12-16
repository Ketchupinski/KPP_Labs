namespace KPP_lab_1_2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            List<Worker> workers = WorkerManager.generateWorkers();
            ConsoleManager.printMenu(workers);
        }
    }
}
