package editor;
// s
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.KeyCode;
// trying a thing with lists
//import java.util.Arrays;
import java.util.LinkedList;

public class Editor extends Application {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    //LinkedList<String> list = new LinkedList<String>();
    StringBuilder aa = new StringBuilder();
        private class KeyEventHandler implements EventHandler<KeyEvent> {
            int textCenterX;
            int textCenterY;
            private static final int STARTING_FONT_SIZE = 20;
            private static final int STARTING_TEXT_POSITION_X = 250;
            private static final int STARTING_TEXT_POSITION_Y = 10;
       private Text displayText = new Text(STARTING_TEXT_POSITION_X,STARTING_TEXT_POSITION_Y,"");
            private int fontSize = STARTING_FONT_SIZE;
            private String fontName = "Verdana";
      KeyEventHandler(Group root,int windowWidth,int windowHeight){
          textCenterX = windowWidth / 2;
          textCenterY = windowHeight / 2;
          //third arg for text was ""
          displayText = new Text(textCenterX,textCenterY,"");
          displayText.setTextOrigin(VPos.TOP);
          displayText.setFont(Font.font(fontName,fontSize));
          root.getChildren().add(displayText);

      }
            @Override
           public void handle(KeyEvent keyEvent) {
            if (keyEvent.getEventType() == KeyEvent.KEY_TYPED) {
                String characterTyped = keyEvent.getCharacter();
                //
                if (characterTyped.charAt(0) == 8){

                    aa.deleteCharAt(aa.length() -1 );
                    displayText.setText(aa.toString());
                }
                //
                if (characterTyped.length() > 0 && characterTyped.charAt(0) != 8) {
                   // list.addLast(characterTyped);
//setText arg was list.ToString()
                    aa.append(characterTyped);
                    displayText.setText(aa.toString());
                    keyEvent.consume();
                }
                centerText();
            }
                else if (keyEvent.getEventType()==KeyEvent.KEY_PRESSED) {
                    KeyCode code = keyEvent.getCode();
                    if (code == KeyCode.UP){
                        fontSize += 5;
                        displayText.setFont(Font.font(fontName,fontSize));
                        centerText();
                    }
                    else if (code == KeyCode.DOWN){
                        fontSize = Math.max(0,fontSize -5);
                        displayText.setFont(Font.font(fontName, fontSize));
                        centerText();
                    }
                }
            }
            private void centerText() {
            double textHeight = displayText.getLayoutBounds().getHeight();
            double textWidth = displayText.getLayoutBounds().getWidth();
                double textTop = 0; //= textCenterY - textHeight /2;
             double textLeft = 0; //textCenterX - textWidth /2;
            displayText.setX(textLeft);
            displayText.setY(textTop);
             displayText.toFront();
            }
        }



    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.WHITE);
        EventHandler<KeyEvent> keyEventHandler = new KeyEventHandler(root,WINDOW_WIDTH,WINDOW_HEIGHT);
        scene.setOnKeyTyped(keyEventHandler);
        scene.setOnKeyPressed(keyEventHandler);
        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}