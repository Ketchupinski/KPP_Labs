namespace KPP_lab_1_2
{
    [Serializable]
    internal class Career
    {
        private DateTime start_date;
        private DateTime end_date;
        private string position;
        private string department;

        public Career(DateTime start_date, DateTime end_date, string position, string department)
        {
            this.start_date = start_date;
            this.end_date = end_date;
            this.position = position;
            this.department = department;
        }

        public DateTime Start_date
        {
            get { return start_date; }
            set { start_date = value; }
        }

        public DateTime End_date
        {
            get { return end_date; }
            set { end_date = value; }
        }

        public string Position
        {
            get { return position; }
            set { position = value; }
        }

        public string Department
        {
            get { return department; }
            set { department = value; }
        }
    }
}
