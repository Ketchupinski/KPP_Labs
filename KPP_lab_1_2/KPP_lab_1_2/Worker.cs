namespace KPP_lab_1_2
{
    [Serializable]
    internal class Worker
    {
        private string name;
        private string surname;
        private int salary;
        private string pass_series;
        private string pass_number;
        private string education;
        private List<Career> careers;
        private List<Characteristic> characteristics;

        public Worker(string name, string surname, int salary, string pass_series, string pass_number, string education)
        {
            this.name = name;
            this.surname = surname;
            this.salary = salary;
            this.pass_series = pass_series;
            this.pass_number = pass_number;
            this.education = education;
            this.careers = new List<Career>();
            this.characteristics = new List<Characteristic>();
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public string Surname
        {
            get { return surname; }
            set { surname = value; }
        }

        public string Pass_series
        {
            get { return pass_series; }
            set { pass_series = value; }
        }

        public string Pass_number
        {
            get { return pass_number; }
            set { pass_number = value; }
        }

        public string Education
        {
            get { return education; }
            set { education = value; }
        }

        public List<Career> Careers
        {
            get { return careers; }
            set { careers = value; }
        }

        public List<Characteristic> Characteristics
        {
            get { return characteristics; }
            set { characteristics = value; }
        }

        public int Salary
        {
            get { return salary; }
            set { salary = value; }
        }

        public void AddCareer(Career career)
        {
            careers.Add(career);
        }

        public void AddCharacteristic(Characteristic characteristic)
        {
            characteristics.Add(characteristic);
        }

        public double GetAvarageCharMark()
        {
            double sum = 0;
            foreach (Characteristic characteristic in characteristics)
            {
                sum += characteristic.Value;
            }

            return sum / characteristics.Count;
        }
    }
}
