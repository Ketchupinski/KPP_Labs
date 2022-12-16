namespace KPP_LAB_1_1
{
    internal class TableManager
    {
        public static void PrintTable(List<Toy> toys)
        {
            String header = String.Format(" | {0, -20} | {1, -10} | {2, -10} | {3, -10} | {4, -20} | ", "Name", "Price", "Age from", "Age to", "Characteristics");
            Console.WriteLine(new String('_', header.Length));
            Console.WriteLine(header);
            Console.WriteLine(new String('_', header.Length));
            foreach (Toy toy in toys)
            {
                String formated = String.Format(" | {0, -20} | {1, -10} | {2, -10} | {3, -10} | {4, -20} | ", toy.Name, toy.Price, toy.Age_from, toy.Age_to, toy.Characteristics);
                Console.WriteLine(formated);
            }
            Console.WriteLine(new String('_', header.Length));
            
        }
    }
}
