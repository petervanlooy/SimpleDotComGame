import java.util.ArrayList;

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

    private void setUpGame() {
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your goal is to sink three dot coms.");
        System.out.println("Pets.com, eToys.com and Go2.com");
        System.out.println("Try to sink them all in the fewest number of guesses.");

        for (DotCom dotComToSet: dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while(!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Enter a guess:");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void finishGame() {
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result = "miss";

        for(DotCom dotComToTest: dotComsList) {
            result = dotComToTest.checkYourself(userGuess);

        }
    }
}
