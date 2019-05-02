# Kotlin Bowling Kata

![](https://github.com/phillwiggins/kotlin_bowling_tdd_kata/blob/master/screenshot.png)

## Installation

Standard Android development requirements:

* Install the Android Studio
* Install Android SDK & Emulator
* Gradle build system
* Android Studio is recommended for ease of testing
* Clone or otherwise acquire the repository

## Usage

* Open the provided Android Studio project
* Run the `app` configuration in an emulator or device running Android

## Kata requirements
Every feature below should be tackled from a TTD manner

Create app code, which, given a valid sequence of rolls for one line of American Ten-Pin Bowling, produces the total score for the game. 

## Game Summary

* Each game, or "line" of bowling, includes ten turns, or "frames" for the bowler.
* In each frame, the bowler gets up to two tries to knock down all the pins.
* If in two tries, he fails to knock them all down, his score for that frame is the total number of pins knocked down in his two tries.
* If in two tries he knocks them all down, this is called a "spare" and his score for the frame is ten plus the number of pins knocked down on his next throw (in his next turn).
* If on his first try in the frame he knocks down all the pins, this is called a "strike". His turn is over, and his score for the frame is ten plus the simple total of the pins knocked down in his next two rolls.
* If he gets a spare or strike in the last (tenth) frame, the bowler gets to throw one or two more bonus balls, respectively. These bonus throws are taken as part of the same turn. If the bonus throws knock down all the pins, the process does not repeat: the bonus throws are only used to calculate the score of the final frame.
* The game score is the total of all frame scores.

More info on the rules at: www.topendsports.com/sport/tenpin/scoring.htm

## Clues

What makes this game interesting to score is the lookahead in the scoring for strike and spare. At the time we throw a strike or spare, we cannot calculate the frame score: we have to wait one or two frames to find out what the bonus is.

## Further reading

* `rolling` Clicking any of the numbered buttons should update the scoreboard with the number of pins knocked down for the roll.

* `game score` The game consists of 10 frames.  In each frame the player has
               two opportunities to knock down 10 pins.  The score for the frame is the total
               number of pins knocked down, plus bonuses for strikes and spares.
               
* `spare` A spare is when the player knocks down all 10 pins in two tries.  The bonus for
          that frame is the number of pins knocked down by the next roll.  So in frame 3
          above, the score is 10 (the total number knocked down) plus a bonus of 5 (the
          number of pins knocked down on the next roll.)
          
* `strike` A strike is when the player knocks down all 10 pins on his first try.  The bonus
           for that frame is the value of the next two balls rolled.
           
* `10th frame` In the tenth frame a player who rolls a spare or strike is allowed to roll the extra
               balls to complete the frame.  However no more than three balls can be rolled in
               tenth frame.


