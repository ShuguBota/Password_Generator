package ro.cristian.password_generator;

import java.util.*;

public class Password {
    private final int length;
    private final boolean lowerCase;
    private final boolean upperCase;
    private final boolean numbers;
    private final boolean sCharacters;
    private final Random random = new Random();

    private final List<Character> lowerCasePossible = new LinkedList<>(List.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
    private final List<Character> upperCasePossible = new LinkedList<>(List.of('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'));
    private final List<Character> numbersPossible = new LinkedList<>(List.of('0','1','2','3','4','5','6','7','8','9'));
    private final List<Character> sCharactersPossible = new LinkedList<>(List.of('`', '"','\'','!','@','#','%','^','&','*','(',')','-','=','+','_','<','>','.','?','/'));

    public Password(int length, boolean lowerCase, boolean upperCase, boolean numbers, boolean sCharacters){
        this.length = length;
        this.lowerCase = lowerCase;
        this.upperCase = upperCase;
        this.numbers = numbers;
        this.sCharacters = sCharacters;
    }

    protected String generatePassword(){
        StringBuilder password = new StringBuilder();
        List<Character> possibleCharacters = new LinkedList<>();

        if(lowerCase){
            add(password, lowerCasePossible);
            possibleCharacters.addAll(lowerCasePossible);
        }

        if(upperCase){
            add(password, upperCasePossible);
            possibleCharacters.addAll(upperCasePossible);
        }

        if(numbers){
            add(password, numbersPossible);
            possibleCharacters.addAll(numbersPossible);
        }

        if(sCharacters){
            add(password, sCharactersPossible);
            possibleCharacters.addAll(sCharactersPossible);
        }
        
        while(password.length() < length) add(password, possibleCharacters);

        //Shuffle the characters for more randomness
        List<Character> shuffle = new ArrayList<>();
        for(int i = 0; i < password.length(); i++) shuffle.add(password.charAt(i));
        Collections.shuffle(shuffle);
        password.delete(0, password.length());
        for(char c : shuffle) password.append(c);

        //Delete if the password is too long
        //User might want 4 types of chars in a length of 3 which is not possible
        if(password.length() - length > 0) password.delete(0, password.length() - length);

        //TODO: make sure that each type of character is used at least once
        return password.toString();
    }

    private void add(StringBuilder builder, List<Character> list){
        int posAdd = random.nextInt(list.size());
        builder.append(list.get(posAdd));
    }

}
