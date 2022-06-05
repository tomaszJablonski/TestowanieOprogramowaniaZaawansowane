package pl.sdacademy.unit.test.advance.exercises.task1;


public class Calculator {
    private Integer a;
    private Integer b;


    public static Integer plus(Integer a, Integer b){
        return a + b;
    }

    public static Integer dividing(Integer a,Integer b ){
        if(b == 0){
            throw new ArithmeticException("You can not divide with zero");

        } else
            return a/b;
    }



    public Calculator(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}
