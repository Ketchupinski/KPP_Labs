namespace KPP_lab_1_2
{
    [Serializable]
    internal class Characteristic
    {
        private string name;
        private int value;

        public Characteristic(string name, int value)
        {
            this.name = name;
            this.value = value;
        }

        public string Name
        {
            get { return name; }
            set { name = value; }
        }

        public int Value
        {
            get { return this.value; }
            set { this.value = value; }
        }
    }
}
