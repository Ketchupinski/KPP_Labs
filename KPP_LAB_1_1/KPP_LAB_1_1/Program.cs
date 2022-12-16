namespace KPP_LAB_1_1
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            List<Toy> toys = ToyManager.ReadToys();
            TableManager.PrintTable(toys);
            Console.WriteLine("\n\nНайдешевшi iграшки:\n");
            List<Toy> cheapestToys = ToyManager.getSortedCheapestToys(toys);
            TableManager.PrintTable(cheapestToys);
        }
    }
}
