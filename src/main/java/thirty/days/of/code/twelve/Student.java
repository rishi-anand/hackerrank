package thirty.days.of.code.twelve;

public class Student extends Person{

    private int[] score;

    public Student(String firstName, String lastName, int idNo, int[] score){
        super(firstName, lastName, idNo);
        this.score = score;
    }

    public char calculate(){
        int sum = 0;
        for (int i = 0; i < score.length; i++){
            sum += score[i];
        }

        int average = sum / score.length;

        if(90 <= average && average <= 100){
            return 'O';
        } else if(80 <= average && average < 90){
            return 'E';
        } else if(70 <= average && average < 80){
            return 'A';
        } else if(55 <= average && average < 70){
            return 'P';
        } else if(40 <= average && average < 55){
            return 'D';
        } else {
            return 'T';
        }
    }
}
