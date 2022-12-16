namespace KPP_LAB_1_1
{
    internal class ToyManager
    {
        private static string PATH = "C:\\Users\\Arsen\\source\\repos\\KPP_LAB_1_1\\toys.txt";


        public static List<Toy> ReadToys()
        {
            List<Toy> toys = new List<Toy>();
            using (StreamReader sr = new StreamReader(PATH))
            {
                string line;
                while ((line = sr.ReadLine()) != null)
                {
                    string[] toy = line.Split('|');
                    toys.Add(new Toy(toy[0], int.Parse(toy[1]), int.Parse(toy[2]), int.Parse(toy[3]), toy[4]));
                }
            }
            return toys;
        }

        public static List<Toy> getSortedCheapestToys(List<Toy> toys)
        {
            List<Toy> cheapestToys = new List<Toy>();
            Toy cheapestToy = getMinPriceToy(toys);
            int min_diff = getMinDifferenceBetweenCheapestToys(cheapestToy);
            foreach (Toy toy in toys)
            {
                if (toy.Price - cheapestToy.Price <= min_diff)
                    cheapestToys.Add(toy);
            }
            sortToysByPrice(cheapestToys);
            return cheapestToys;
        }

        private static List<Toy> sortToysByPrice(List<Toy> toys)
        {
            toys.Sort((x, y) => x.Price.CompareTo(y.Price));
            return toys;
        }

        private static Toy getMinPriceToy(List<Toy> toys)
        {
            Toy minPriceToy = toys[0];
            foreach (Toy toy in toys)
            {
                if (toy.Price < minPriceToy.Price)
                {
                    minPriceToy = toy;
                }
            }
            return minPriceToy;
        }



        private static int getMinDifferenceBetweenCheapestToys(Toy cheapestToy)
        {
            return (cheapestToy.Price * 10) / 100;
        }
    }
}
