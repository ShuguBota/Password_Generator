package ro.cristian.password_generator;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MainController {
    private boolean  lowerCaseB;
    private boolean  upperCaseB;
    private boolean  numberB;
    private boolean sCharacterB;
    @FXML
    TextField lengthInput;

    @FXML
    private void generatePassword(){
        System.out.println("A new password needs to be generated");
        Password passowrd = new Password(Integer.parseInt(lengthInput.getText()), lowerCaseB, upperCaseB, numberB, sCharacterB);
        System.out.println(passowrd.generatePassword());
    }

    public void lowerCasePressed(MouseEvent mouseEvent) {
        lowerCaseB = !lowerCaseB;
    }

    public void upperCasePressed(MouseEvent mouseEvent) {
        upperCaseB = !upperCaseB;
    }

    public void numberPressed(MouseEvent mouseEvent) {
        numberB = !numberB;
    }

    public void sCharacterPressed(MouseEvent mouseEvent) {
        sCharacterB = !sCharacterB;
    }
}
