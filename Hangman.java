public class Hangman {
    String[] bodyParts = {"head", "body", "leftArm", "rightArm", "leftLeg", "rightLeg"};
    String[] drawnBodyParts = new String[bodyParts.length];
    int listProgression = 0;
    boolean dead = false;

    public void addDrawnBodyPart(){
        while(bodyParts[listProgression] == null){
            listProgression+= 1;
            if(listProgression == bodyParts.length){
                dead = true;
            }
        }
        drawnBodyParts[listProgression] = bodyParts[listProgression];
        bodyParts[listProgression] = null;
    }
}
