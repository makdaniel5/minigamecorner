package com.example.minigamecorner;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.awt.Robot;
import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;

public class HelloController {

    @FXML
    private ImageView imgHangYou;

    @FXML
    private ImageView imgScaryMaze;

    @FXML
    private ImageView imgTicTacDie;

    @FXML
    private ImageView imageHangYou;

    @FXML
    private Label labelTicTacDie;

    @FXML
    private ImageView imageTicTacDie1;

    @FXML
    private ImageView imageTicTacDie2;

    @FXML
    private ImageView imageTicTacDie3;

    @FXML
    private ImageView imageTicTacDie4;

    @FXML
    private ImageView imageTicTacDie5;

    @FXML
    private ImageView imageTicTacDie6;

    @FXML
    private ImageView imageTicTacDie7;

    @FXML
    private ImageView imageTicTacDie8;

    @FXML
    private ImageView imageTicTacDie9;

    @FXML
    private Label lblA;

    @FXML
    private Label lblB;

    @FXML
    private Label lblC;

    @FXML
    private Label lblD;

    @FXML
    private Label lblE;

    @FXML
    private Label lblF;

    @FXML
    private Label lblG;

    @FXML
    private Label lblH;

    @FXML
    private Label lblHangYou;

    @FXML
    private Label lblI;

    @FXML
    private Label lblJ;

    @FXML
    private Label lblK;

    @FXML
    private Label lblL;

    @FXML
    private Label lblM;

    @FXML
    private Label lblN;

    @FXML
    private Label lblO;

    @FXML
    private Label lblP;

    @FXML
    private Label lblQ;

    @FXML
    private Label lblR;

    @FXML
    private Label lblReturn;

    @FXML
    private Label lblS;

    @FXML
    private Label lblScaryMaze;

    @FXML
    private Label lblT;

    @FXML
    private Label lblTicTacDie;

    @FXML
    private Label lblU;

    @FXML
    private Label lblV;

    @FXML
    private Label lblW;

    @FXML
    private Label lblX;

    @FXML
    private Label lblY;

    @FXML
    private Label lblZ;

    @FXML
    private GridPane letterBox;

    @FXML
    private GridPane menuGridPane;

    @FXML
    private GridPane gridpaneTicTacDie;

    @FXML
    private Label title;

    @FXML
    private Label wordHangYou;

    @FXML
    private ImageView mazePic;

    @FXML
    private ImageView wall;

    @FXML
    private Label losingOrWinning;

    private PixelReader pixelReader;

    private Image maze = new Image("pictures/the_wall_only.png");

    private Image pumpkin = new Image("pictures/pumpkin.png");

    private Image x = new Image("pictures/x.png");

    private List<ImageView> imagesTicTacDie = Arrays.asList(imageTicTacDie1, imageTicTacDie2, imageTicTacDie3, imageTicTacDie4, imageTicTacDie5, imageTicTacDie6, imageTicTacDie7, imageTicTacDie8, imageTicTacDie8);

    private String word, asteriskWord, newasterisk = "";

    private int hangYouCount = 0;

    @FXML
    public void initialize() {
        showMainMenu();
        imgHangYou.setCursor(Cursor.CROSSHAIR);
        imgScaryMaze.setCursor(Cursor.CROSSHAIR);
        imgTicTacDie.setCursor(Cursor.CROSSHAIR);
    }

    @FXML
    void startHangYou(MouseEvent event) {
        hideMainMenu();
        showHangYou();
    }

    @FXML
    void startScaryMaze(MouseEvent event) {
        hideMainMenu();
        showScaryMaze();
    }

    @FXML
    void startTicTacDie(MouseEvent event) {
        hideMainMenu();
        showTicTacDie();
    }

    @FXML
    void stopGame(MouseEvent event) {
        hideHangYou();
        hideScaryMaze();
        hideTicTacDie();
        showMainMenu();
    }

    void hideMainMenu() {
        menuGridPane.setVisible(false);
        imgHangYou.setVisible(false);
        imgScaryMaze.setVisible(false);
        imgTicTacDie.setVisible(false);
        lblHangYou.setVisible(false);
        lblScaryMaze.setVisible(false);
        lblTicTacDie.setVisible(false);
        title.setVisible(false);
        lblReturn.setVisible(true);
    }

    void showMainMenu() {
        menuGridPane.setVisible(true);
        imgHangYou.setVisible(true);
        imgScaryMaze.setVisible(true);
        imgTicTacDie.setVisible(true);
        lblHangYou.setVisible(true);
        lblScaryMaze.setVisible(true);
        lblTicTacDie.setVisible(true);
        title.setVisible(true);
        lblReturn.setVisible(false);
    }

    // SCARY MAZE

    private boolean isWall(Color color) {
        return color.equals(Color.BLACK);
    }

    void moveCursorToStart() {
        try {

            Robot robot = new Robot();

            int startX = (int) mazePic.getLayoutX() + 400; // 250 pixelre a mazePic elejétől
            int startY = (int) mazePic.getLayoutY() + 200; // 50 pixelre a mazePic tetejétől

            robot.mouseMove(startX, startY);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void goal(MouseEvent event) {
        losingOrWinning.setText("You won!");
    }

    @FXML
    void collision(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();

        double imageWidth = mazePic.getImage().getWidth();
        double imageHeight = mazePic.getImage().getHeight();

        double displayedWidth = mazePic.getBoundsInLocal().getWidth();
        double displayedHeight = mazePic.getBoundsInLocal().getHeight();

        double scaleX = imageWidth / displayedWidth;
        double scaleY = imageHeight / displayedHeight;

        int imageX = (int) (mouseX * scaleX);
        int imageY = (int) (mouseY * scaleY);

        if (imageX >= 0 && imageY >= 0 && imageX < imageWidth && imageY < imageHeight) {
            Color pixelColor = pixelReader.getColor(imageX, imageY);
            if (isWall(pixelColor)) {
                losingOrWinning.setText("You lost!");
                moveCursorToStart();
            }
        }
    }

    void hideScaryMaze() {
        mazePic.setVisible(false);
        losingOrWinning.setVisible(false);
        wall.setVisible(false);
    }

    void showScaryMaze() {
        mazePic.setVisible(true);
        losingOrWinning.setVisible(true);
        wall.setVisible(true);
        wall.setOnMouseMoved(this::collision);
        pixelReader = maze.getPixelReader();
        losingOrWinning.setText("");
    }

    // TIC-TAC-DIE

    void hideTicTacDie() {
        gridpaneTicTacDie.setVisible(false);
        labelTicTacDie.setVisible(false);
        imageTicTacDie1.setVisible(false);
        imageTicTacDie2.setVisible(false);
        imageTicTacDie3.setVisible(false);
        imageTicTacDie4.setVisible(false);
        imageTicTacDie5.setVisible(false);
        imageTicTacDie6.setVisible(false);
        imageTicTacDie7.setVisible(false);
        imageTicTacDie8.setVisible(false);
        imageTicTacDie9.setVisible(false);
    }

    void showTicTacDie() {
        hideMainMenu();
        gridpaneTicTacDie.setVisible(true);
        labelTicTacDie.setVisible(true);
        imageTicTacDie1.setVisible(true);
        imageTicTacDie2.setVisible(true);
        imageTicTacDie3.setVisible(true);
        imageTicTacDie4.setVisible(true);
        imageTicTacDie5.setVisible(true);
        imageTicTacDie6.setVisible(true);
        imageTicTacDie7.setVisible(true);
        imageTicTacDie8.setVisible(true);
        imageTicTacDie9.setVisible(true);
        imagesTicTacDie = Arrays.asList(imageTicTacDie1, imageTicTacDie2, imageTicTacDie3, imageTicTacDie4, imageTicTacDie5, imageTicTacDie6, imageTicTacDie7, imageTicTacDie8, imageTicTacDie9);
        for (ImageView image : imagesTicTacDie) {
            image.setOnMouseClicked(this::tictacdieMove);
            image.setImage(null);
        }
        labelTicTacDie.setText(null);
        tictacdieGame();
    }

    public void tictacdieGame() {
        gridpaneTicTacDie.setCursor(Cursor.CROSSHAIR);
    }

    @FXML
    void tictacdieMove(MouseEvent event) {
        ImageView clicked = (ImageView) event.getSource();
        clicked.setImage(x);
        clicked.setOnMouseClicked(null);
        tictacdieisEnd();
    }

    void tictacdieBotMove() {
        boolean found = false;
        if (imagesTicTacDie.stream().noneMatch(image -> image.getImage() == null)) {
            return;
        }
        while (!found) {
            int number = (int) Math.floor(Math.random() * imagesTicTacDie.size());
            if (imagesTicTacDie.get(number).getImage() == null) {
                imagesTicTacDie.get(number).setImage(pumpkin);
                imagesTicTacDie.get(number).setOnMouseClicked(null);
                found = true;
            }
        }
    }

    void tictacdieisEnd() {
        tictacdieCheckWin();
        boolean isTie = true;
        for (ImageView image : imagesTicTacDie) {
            if (image.getOnMouseClicked() != null) {
                isTie = false;
            }
        }
        if (isTie && labelTicTacDie.getText() == null) {
            tictacdieEnd();
            labelTicTacDie.setText("Tie!");
        }
        else  {
            tictacdieBotMove();
            tictacdieCheckWin();
        }
    }

    void tictacdieCheckWin() {
        if (imageTicTacDie1.getImage() != null && imageTicTacDie1.getImage().equals(imageTicTacDie2.getImage()) && imageTicTacDie1.getImage().equals(imageTicTacDie3.getImage())) {
            if (imageTicTacDie1.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie1.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
        else if (imageTicTacDie1.getImage() != null && imageTicTacDie1.getImage().equals(imageTicTacDie5.getImage()) && imageTicTacDie1.getImage().equals(imageTicTacDie9.getImage())) {
            if (imageTicTacDie1.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie1.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
        else if (imageTicTacDie1.getImage() != null && imageTicTacDie1.getImage().equals(imageTicTacDie4.getImage()) && imageTicTacDie1.getImage().equals(imageTicTacDie7.getImage())) {
            if (imageTicTacDie1.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie1.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
        else if (imageTicTacDie4.getImage() != null && imageTicTacDie4.getImage().equals(imageTicTacDie5.getImage()) && imageTicTacDie4.getImage().equals(imageTicTacDie6.getImage())) {
            if (imageTicTacDie4.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie4.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
        else if (imageTicTacDie7.getImage() != null && imageTicTacDie7.getImage().equals(imageTicTacDie8.getImage()) && imageTicTacDie7.getImage().equals(imageTicTacDie9.getImage())) {
            if (imageTicTacDie7.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie7.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
        else if (imageTicTacDie2.getImage() != null && imageTicTacDie2.getImage().equals(imageTicTacDie5.getImage()) && imageTicTacDie2.getImage().equals(imageTicTacDie8.getImage())) {
            if (imageTicTacDie2.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie2.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
        else if (imageTicTacDie3.getImage() != null && imageTicTacDie3.getImage().equals(imageTicTacDie6.getImage()) && imageTicTacDie3.getImage().equals(imageTicTacDie9.getImage())) {
            if (imageTicTacDie3.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie3.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
        else if (imageTicTacDie3.getImage() != null && imageTicTacDie3.getImage().equals(imageTicTacDie5.getImage()) && imageTicTacDie3.getImage().equals(imageTicTacDie7.getImage())) {
            if (imageTicTacDie3.getImage().equals(x)) {
                labelTicTacDie.setText("You won!");
                tictacdieEnd();
            }
            else if (imageTicTacDie3.getImage().equals(pumpkin)) {
                labelTicTacDie.setText("You lost!");
                tictacdieEnd();
            }
        }
    }

    void tictacdieEnd() {
        for (ImageView image : imagesTicTacDie) {
            image.setOnMouseClicked(null);
        }
    }

    // HANG-YOU

    void hideHangYou() {
        wordHangYou.setVisible(false);
        letterBox.setVisible(false);
        imageHangYou.setVisible(false);
    }

    void showHangYou() {
        hideMainMenu();
        imageHangYou.setImage(null);
        wordHangYou.setVisible(true);
        letterBox.setVisible(true);
        imageHangYou.setVisible(true);
        Label[] labels = {lblA, lblB, lblC, lblD, lblE, lblF, lblG, lblH, lblI, lblJ, lblK, lblL, lblM, lblN, lblO, lblP, lblQ, lblR, lblS, lblT, lblU, lblV, lblW, lblX, lblY, lblZ};
        for (Label label : labels) {
            label.setOnMouseClicked(this::letterClick);
            label.setOpacity(1);
        }
        hangmanGame();
    }

    public void hangmanGame() {
        String[] words = {"TERMINATOR", "BANANA", "COMPUTER", "COW", "RAIN", "WATER", "WHALE", "FOX", "CURTAIN", "PATIENCE", "EXAMINE", "BEARD", "lANGUAGE", "CASTLE", "REPORT", "STRAWBERRY", "PASCAL", "RAILWAY", "LITERATURE", "JOKE", "MATH", "GORGEOUS"};
        word = words[(int) (Math.random() * words.length)];
        asteriskWord = "*".repeat(word.length());
        hangYouCount = 0;
        wordHangYou.setText(asteriskWord);
        letterBox.setCursor(Cursor.CROSSHAIR);
    }

    @FXML
    void letterClick(MouseEvent event) {
        Label clicked = (Label) event.getSource();
        String letter = clicked.getText();
        hang(letter);
        clicked.setOnMouseClicked(null);
        clicked.setOpacity(0.2);
    }

    public void hang(String letter) {
        newasterisk = "";

        for (int i = 0; i < word.length(); i++) {
            if (word.toUpperCase().charAt(i) == letter.charAt(0)) {
                newasterisk += letter.charAt(0);
            }
            else if (asteriskWord.charAt(i) != '*') {
                newasterisk += word.toUpperCase().charAt(i);
            }
            else {
                newasterisk += "*";
            }
        }

        Label[] labels = {lblA, lblB, lblC, lblD, lblE, lblF, lblG, lblH, lblI, lblJ, lblK, lblL, lblM, lblN, lblO, lblP, lblQ, lblR, lblS, lblT, lblU, lblV, lblW, lblX, lblY, lblZ};

        if (asteriskWord.equals(newasterisk)) {
            hangYouCount++;
            if (hangYouCount == 6) {
                wordHangYou.setText(word + " - You lost!");
                for (Label label : labels) {
                    label.setOnMouseClicked(null);
                }
            }
            hangmanImage(hangYouCount);
        } else {
            asteriskWord = newasterisk;
            wordHangYou.setText(newasterisk);
        }
        if (asteriskWord.equals(word.toUpperCase())) {
            wordHangYou.setText(word);
            wordHangYou.setText(word + " - You won!");
            for (Label label : labels) {
                label.setOnMouseClicked(null);
            }
        }
    }

    void hangmanImage(int hangYouCount) {
        switch (hangYouCount) {
            case 1 -> imageHangYou.setImage(new Image("pictures/hangman_1.png"));
            case 2 -> imageHangYou.setImage(new Image("pictures/hangman_2.png"));
            case 3 -> imageHangYou.setImage(new Image("pictures/hangman_3.png"));
            case 4 -> imageHangYou.setImage(new Image("pictures/hangman_4.png"));
            case 5 -> imageHangYou.setImage(new Image("pictures/hangman_5.png"));
            case 6 -> imageHangYou.setImage(new Image("pictures/hangman_6.png"));
            default -> imageHangYou.setImage(null);
        }
    }
}