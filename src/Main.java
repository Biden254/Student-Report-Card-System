import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // School Information
        System.out.print("Enter School Name: ");
        String schoolName = input.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = input.nextLine();

        System.out.print("Enter Grade: ");
        int grade = input.nextInt();

        System.out.print("Enter Year: ");
        int year = input.nextInt();
        input.nextLine(); // clear buffer

        // Student Records
        final int N = 12;   // required minimum
        String[] names = new String[N];
        double[] eng = new double[N];
        double[] math = new double[N];
        double[] hist = new double[N];
        double[] geo = new double[N];
        double[] sci = new double[N];
        double[] prog = new double[N];
        double[] total = new double[N];
        char[] rank = new char[N];

        System.out.println("\nEnter details for " + N + " students:\n");

        for (int i = 0; i < N; i++) {
            System.out.println("Student " + (i + 1));

            System.out.print("Name: ");
            names[i] = input.nextLine();

            System.out.print("English: ");
            eng[i] = input.nextDouble();

            System.out.print("Math: ");
            math[i] = input.nextDouble();

            System.out.print("History: ");
            hist[i] = input.nextDouble();

            System.out.print("Geography: ");
            geo[i] = input.nextDouble();

            System.out.print("Science: ");
            sci[i] = input.nextDouble();

            System.out.print("Programming: ");
            prog[i] = input.nextDouble();
            input.nextLine();

            // Compute totals & rank
            total[i] = eng[i] + math[i] + hist[i] + geo[i] + sci[i] + prog[i];

            if (total[i] >= 540) rank[i] = 'A';
            else if (total[i] >= 480) rank[i] = 'B';
            else if (total[i] >= 420) rank[i] = 'C';
            else if (total[i] >= 360) rank[i] = 'D';
            else rank[i] = 'F';

            System.out.println();
        }

        // Compute Subject Totals & Averages
        double totEng = 0, totMath = 0, totHist = 0, totGeo = 0, totSci = 0, totProg = 0;
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int i = 0; i < N; i++) {
            totEng += eng[i];
            totMath += math[i];
            totHist += hist[i];
            totGeo += geo[i];
            totSci += sci[i];
            totProg += prog[i];

            switch (rank[i]) {
                case 'A' -> countA++;
                case 'B' -> countB++;
                case 'C' -> countC++;
                case 'D' -> countD++;
                case 'F' -> countF++;
            }
        }

        double avgEng = totEng / N;
        double avgMath = totMath / N;
        double avgHist = totHist / N;
        double avgGeo = totGeo / N;
        double avgSci = totSci / N;
        double avgProg = totProg / N;

        // OUTPUT
        System.out.println("\n=====================================================================================");
        System.out.printf("%45s%n", schoolName);
        System.out.printf("%40s %s%n", "Teacher:", teacherName);
        System.out.printf("%33s %d%n", "Grade:", grade);
        System.out.printf("%32s %d%n", "Year:", year);
        System.out.println("=====================================================================================");

        System.out.printf(
                "%-20s %8s %8s %10s %12s %10s %14s %10s %6s%n",
                "Student Name", "English", "Math", "History", "Geography",
                "Science", "Programming", "Total", "Rank"
        );

        System.out.println("=====================================================================================");

        for (int i = 0; i < N; i++) {
            System.out.printf(
                    "%-20s %8.2f %8.2f %10.2f %12.2f %10.2f %14.2f %10.2f %6c%n",
                    names[i], eng[i], math[i], hist[i], geo[i],
                    sci[i], prog[i], total[i], rank[i]
            );
        }
        System.out.println("-------------------------------------------------------------------------------------");

        System.out.printf(
                "%-20s %8.2f %8.2f %10.2f %12.2f %10.2f %14.2f%n",
                "Totals:", totEng, totMath, totHist, totGeo, totSci, totProg
        );

        System.out.println();

        System.out.printf(
                "%-20s %8.2f %8.2f %10.2f %12.2f %10.2f %14.2f%n",
                "Averages:", avgEng, avgMath, avgHist, avgGeo, avgSci, avgProg
        );

        System.out.println("\nRanks   A's: " + countA + "   B's: " + countB + "   C's: " + countC +
                "   D's: " + countD + "   F's: " + countF);

        System.out.println("\n=====================================================================================");

    }
}
