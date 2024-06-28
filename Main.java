import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String sum = scanner.nextLine();
            if(!sum.isEmpty()) {
              calc(sum);
            }else{
                break;
            }
        }


    }

    public static String calc(String input) throws IOException {
        calculate calculate = new calculate();

        return calculate.arithmeticOperation(input);
    }
}

class calculate{
    char char1 = ' ';
    char num = ' ';
    int number1 = 0;
    int number2 = 0;
    int result = 0;
    String romNumber2;
    String romNumber1;
    String [] romNumbersArray = {"ZERO","I","II","III","IV","V","VI","VII","VIII","IX","X","XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXII","LXXXIII","LXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
    String[] arrayRomNumber = new String[2];

    String arithmeticOperation(String operation) throws IOException {
        for (int counter = 0; counter < operation.length(); counter++) {
            char i = operation.charAt(counter);

            if (i == '1' || i == '2' || i == '3' || i == '4' || i == '5' || i == '6' || i == '7' || i == '8' || i == '9' || i == '0') {
                if(number1 != 0 && char1 == ' ') {
                    String numberChar1 = String.valueOf(i);
                    String result = num + numberChar1;
                    number1 = Integer.parseInt(result);
                }else if (number1 == 0) {
                    num = i;
                    number1 = Integer.parseInt(String.valueOf(num));
                } else if(number2 != 0){
                    String numberChar2 = String.valueOf(i);
                    String result = num + numberChar2;
                    number2 = Integer.parseInt(result);
                }else{
                    num = i;
                    number2 = Integer.parseInt(String.valueOf(num));
                }
            }else if(i == 'I'|| i == 'X' || i == 'V' || i == 'L' || i == 'C'){  //Делаю из строк-Цифры

                if(romNumber1 == null && char1 == ' '){
                    romNumber1 = String.valueOf(i);
                }else if(char1 == ' '){
                    romNumber1 = romNumber1 + i;
                }else if(romNumber2 == null){
                    romNumber2 = String.valueOf(i);
                }else{
                    romNumber2 = romNumber2 + i;

                }
            }else if((i == '+') || (i == '-') || (i == '*') || (i == '/')){
                if (char1 == " ") {
                    char1 = i;
                }else{
                    throw new IOException();
                }
            }else{
                throw new IOException();
            }
        }

        if (romNumber1 != null && romNumber2 != null) {
            arrayRomNumber = new String[]{romNumber1, romNumber2};
            int countDo = 0;
            do {
                if (romNumber1.equals(romNumbersArray[countDo])) {
                    number1 = countDo;
                }else if(number1 == 0){
                    number1 = 11;
                }
                if(romNumber2.equals(romNumbersArray[countDo])){
                    number2 = countDo;
                }else if(number2 == 0){
                    number2 = 11;
                }
                countDo++;
            }while(countDo <= 10);
        }

        if(number1 <= 10 && number2 <= 10 && number1 > 0 && number2 > 0) {
            switch (char1) {
                case '+':
                    result = number1 + number2;
                    break;
                case '*':
                    result = number1 * number2;
                    break;
                case '/':
                        result = number1 / number2;
                        break;
                case '-':
                    result = number1 - number2;
                    break;
                default:
                    System.out.println("произошла ошибка попробуйте еще раз");
                    break;
            }
        }else{
            //System.out.println("Введите число меньше 10 и больше 0");
            throw new IOException();
        }

        if(romNumber1 != null && romNumber2 != null){
            //В случае отрицательных Римских цифр
            if (result > 0){
                System.out.println(romNumbersArray[result]);
            }else throw new IOException();
        }

        if (romNumber1 == null && romNumber2 == null){
            System.out.println(result);
        }else if(romNumber1 == null || romNumber2 == null){//Калькулятор умеет работать или с арабскими или с римскими цифрами
            throw new IOException();
        }
        return String.valueOf(result);
    }
}



