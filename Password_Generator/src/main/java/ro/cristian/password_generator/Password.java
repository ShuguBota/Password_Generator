package ro.cristian.password_generator;

import java.util.Random;

public class Password {
    private int length;
    private boolean lowerCase;
    private boolean upperCase;
    private boolean numbers;
    private boolean sCharacters;

    private String[] lowerCasePosible = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private String[] upperCasePosible = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private String[] numbersPosible = {"0","1","2","3","4","5","6","7","8","9"};
    private String[] sCharactersPosible = {"'","!","@","#","%","^","&","*","(",")","-","=","+","_","<",">",".","?","/"};

    public Password(int length, boolean lowerCase, boolean upperCase, boolean numbers, boolean sCharacters){
        this.length = length;
        this.lowerCase = lowerCase;
        this.upperCase = upperCase;
        this.numbers = numbers;
        this.sCharacters = sCharacters;
    }

    protected String generatePassword(){
        String password = "";

        int currentPos = 0;
        String[] posibleCharacters = new String[100];

        if(lowerCase){
            for(int i=0; i< lowerCasePosible.length; i++){
                posibleCharacters[currentPos]=lowerCasePosible[i];
                currentPos++;
            }
        }

        if(upperCase){
            for(int i=0; i< upperCasePosible.length; i++){
                posibleCharacters[currentPos]=upperCasePosible[i];
                currentPos++;
            }
        }

        if(numbers){
            for(int i=0; i< numbersPosible.length; i++){
                posibleCharacters[currentPos]=numbersPosible[i];
                currentPos++;
            }
        }

        if(sCharacters){
            for(int i=0; i< sCharactersPosible.length; i++){
                posibleCharacters[currentPos]=numbersPosible[i];
                currentPos++;
            }
        }

        for(int i=1; i<=length; i++){
            Random r = new Random();
            int x = r.nextInt(posibleCharacters.length-1);
            System.out.println(x);
            password = password.concat(posibleCharacters[x]);
        }

        //TODO: make sure that each type of character is used at least once

        return password;
    }

}
