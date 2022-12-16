namespace KPP_LAB_1_1
{
    internal class Toy
    {
        private string name;
        private int price;
        private int age_from;
        private int age_to;
        private string characteristics;

        public Toy(string name, int price, int age_from, int age_to, string characteristics)
        {
            this.name = name;
            this.price = price;
            this.age_from = age_from;
            this.age_to = age_to;
            this.characteristics = characteristics;
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public int Price
        {
            get { return price; }
            set { price = value; }
        }

        public int Age_from
        {
            get { return age_from; }
            set { age_from = value; }
        }
        
        public int Age_to
        {
            get { return age_to; }
            set { age_to = value; }
        }

        public string Characteristics
        {
            get { return characteristics; }
            set { characteristics = value; }
        }
    }
}
