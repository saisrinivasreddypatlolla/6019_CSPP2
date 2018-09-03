class Details {
    String name;String rollNumber;
    double subject1; double subject2;
    double subject3; double average;
    public Details(String name, String rollNum,
            double marks1, double marks2, double marks3) {
        this.name = name;
        this.rollNumber = rollNum;
        this.subject1 = marks1;
        this.subject2 = marks2;
        this.subject3 = marks3;
    }

    public void gPA() {
        average = (subject1 + subject2 + subject3) / 3.0;
        System.out.printf("%.1f",average);
        System.out.println();
        // System.out.println(Math.round(average));
    }

}
class Student {
    public static void main(final String[] args) {
        Details d1 = new Details("Sangay", "IT201985001", 7.5, 7.0, 8.0);
        Details d2 = new Details("Bidhya", "IT201985003", 8.5, 6.0, 7.5);
        Details d3 = new Details("Kelzang", "IT201985065", 7.5, 8.0, 9.0);
        d1.gPA();
        d2.gPA();
        d3.gPA();
    }
}