namespace KPP_lab_1_2
{
    internal class WorkerManager
    {
        public static List<Worker> generateWorkers()
        {
            List<Worker> workers = new List<Worker>();

            Worker ivan = new Worker("Ivan", "Ivanov", 1000, "LK", "523756", "Management University");
            ivan.Careers.Add(new Career(new DateTime(2010, 1, 1), new DateTime(2011, 1, 1), "Manager", "IT"));
            ivan.Careers.Add(new Career(new DateTime(2011, 1, 1), new DateTime(2012, 1, 1), "Senior Manager", "IT"));
            ivan.Characteristics.Add(new Characteristic("Hardworking", 5));
            ivan.Characteristics.Add(new Characteristic("Honest", 4));
            workers.Add(ivan);

            Worker petr = new Worker("Petr", "Petrov", 2000, "MP", "923856", "IT University");
            petr.Careers.Add(new Career(new DateTime(2013, 1, 1), new DateTime(2014, 1, 1), "Middle Developer", "IT"));
            petr.Careers.Add(new Career(new DateTime(2014, 1, 1), new DateTime(2015, 1, 1), "Senior Developer", "IT"));
            petr.Characteristics.Add(new Characteristic("Sociable", 4));
            petr.Characteristics.Add(new Characteristic("Stressfull", 3));
            workers.Add(petr);

            Worker jamal = new Worker("Jamal", "Jamalov", 3000, "AB", "323556", "Malahit University");
            jamal.Careers.Add(new Career(new DateTime(2015, 1, 1), new DateTime(2016, 1, 1), "Middle Developer", "IT"));
            jamal.Careers.Add(new Career(new DateTime(2016, 1, 1), new DateTime(2017, 1, 1), "Senior Developer", "IT"));
            jamal.Characteristics.Add(new Characteristic("Stressfull", 5));
            jamal.Characteristics.Add(new Characteristic("Honest", 5));
            workers.Add(jamal);

            return workers;
        }
    }
}
