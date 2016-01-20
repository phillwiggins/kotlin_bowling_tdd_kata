package com.example.marine.katabowlingandroid;

/**
 * Created by Marine on 15/01/2016.
 * class for american ten pines bowling score calculation based on a valid line of rolls
 */
public class Score {

    String lineOfRoll;

    Score(){

       lineOfRoll ="";

    }

    // return the score for the line of rolls
    protected int getScore(){
        int score = 0;
        int iter = 0;
        // for each frame in the line ( one line has 10 frames)
        for(int i=0;i<10;i++){
                String roll1 = lineOfRoll.substring(iter, iter + 1);
                String roll2 = lineOfRoll.substring(iter + 1, iter + 2);
                // if the first roll is a strike
                if (roll1.equals("X")) {
                    score = score + 10 + getStrikeBonus(iter);
                    iter++;
                }
                // if the second roll is a spare
                else if (roll2.equals("/")) {
                    score = score + 10 + getSpareBonus(iter + 1);
                    iter = iter + 2;
                }
                // if no strike and no spare
                else {
                    score = score + getRollValue(iter) + getRollValue(iter + 1);
                    iter = iter + 2;
                }
            }
        return score;
    }

    // the bonus for a strike is the score of the next two rolls
    protected int getStrikeBonus(int indexStrike){return getRollValue(indexStrike+1)+getRollValue(indexStrike+2); }

    // the bonus for a spare is the score of the next roll
    protected int getSpareBonus(int indexSpare){
        return getRollValue(indexSpare+1);
    }

    // return the integer value of a roll depending the associated charactere
    protected int getRollValue(int index)
    {
        String roll = lineOfRoll.substring(index,index+1);
        if(roll.equals("X"))
        {
            return 10;
        }
        else if(roll.equals("/"))
        {
            return 10 - getRollValue(index-1);
        }
        else if(roll.equals("-"))
        {
            return 0;
        }
        else return Integer.parseInt(roll);
    }

    // set the line attribute
    protected void setLine(String line)
    {
        lineOfRoll = line;
    }


}
