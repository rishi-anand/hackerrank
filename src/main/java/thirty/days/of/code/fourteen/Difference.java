package thirty.days.of.code.fourteen;

public class Difference {

    private int[] elements;
    public int maximumDifference;

    public Difference(int[] elements){
        this.elements = elements;
    }

    public void computeDifference(){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < elements.length; i++){
            min = (elements[i] > min) ? min : elements[i];
            max = (max > elements[i]) ? max : elements[i];
        }

        this.maximumDifference = max - min;
    }
}
