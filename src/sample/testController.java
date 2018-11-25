package sample;


import javafx.fxml.FXML;
import javafx.event.ActionEvent;
public class testController
{
    private boolean available ;

// ...

    @FXML
    private void setAvailable(ActionEvent event) {
        available = true ;
    }

    @FXML
    private void setUnavailable(ActionEvent event) {
        available = false ;
    }
}
