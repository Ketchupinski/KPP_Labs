using System.Runtime.Serialization.Formatters.Binary;

namespace KPP_lab_1_2
{
    internal class Utilities
    {
        public static void sortByWorkersSalary(List<Worker> workers)
        {
            workers.Sort((x, y) => x.Salary.CompareTo(y.Salary));
        }

        public static void sortByPassportNumber(List<Worker> workers)
        {
            workers.Sort((x, y) => x.Pass_number.CompareTo(y.Pass_number));
        }

        public static void sortByPassportSeries(List<Worker> workers)
        {
            workers.Sort((x, y) => x.Pass_series.CompareTo(y.Pass_series));
        }

        public static void sortByAvgCharMark(List<Worker> workers)
        {
            workers.Sort((x, y) => x.GetAvarageCharMark().CompareTo(y.GetAvarageCharMark()));
        }

        public static void serializeWorkers(List<Worker> workers, string file_name)
        {
            BinaryFormatter formatter = new BinaryFormatter();
            using (FileStream fs = new FileStream(file_name + ".dat", FileMode.OpenOrCreate))
            {
                formatter.Serialize(fs, workers);
            }
        }

        public static List<Worker> deserializeWorkers(string file_name)
        {
            BinaryFormatter formatter = new BinaryFormatter();
            using (FileStream fs = new FileStream(file_name + ".dat", FileMode.OpenOrCreate)) 
            {
                List<Worker> newWorkers = (List<Worker>)formatter.Deserialize(fs);
                return newWorkers;
            }
        } 
    }
}
