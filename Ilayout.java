import java.util.List;
/**
 * Interface Ilayout 
 **/
interface Ilayout {
/**
@return the children of the receiver.
*/
List<Ilayout> children();
/**
 * @return one random child of the receiver
 */
Ilayout randomChild();
/**
 * @return true if the game is over
 */
boolean statusGameOver();
/**
 * @return 1 if the Monte Carlo Tree Search wins or draws and 0 if it loses
 */
int winnerToInt();
/**
 * @return the best move to play
 */
int getMovePlayed();

}