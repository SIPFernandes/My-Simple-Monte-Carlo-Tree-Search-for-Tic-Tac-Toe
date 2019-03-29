import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author samuel
 * Monte Carlo Tree Search class
 */
public class MTCS {
	/**
	 * My state class which represents a state node 
	 */
	static class State {
		private Ilayout layout;
		private State father;
		private double w, n, g;
		/**
		 * State constructor
		 * @param l		for example the layout of a Tic-Tac-Toe board 
		 * @param s		the state which originated this actual state
		 */
		public State(Ilayout l, State s) {
			layout = l;
			father = s;
			w = 0;
			n = 0;
			g = 0;
		}
		/**
		 * @return 		layout toString method		
		 */
		public String toString() { 
			return layout.toString(); 
		}
		/**
		 * @return		value of g
		 */
		public double getG() {
			return g;
		}
		/**
		 * sets the g value 
		 */
		public void setG() {
			g = w/n+Math.sqrt(2)*Math.sqrt(Math.log(father.n)/n);
		}
	}
	
	private State actual;
	/**
	 * Expands the state given
	 * @param n		given state
	 * @return		list with the given state childs
	 */
	final private List<State> expand(State n) {
		List<State> sucs = new ArrayList<>();
		List<Ilayout> children = n.layout.children();
		for(Ilayout e: children) {
			if (n.father == null || !e.equals(n.father.layout)){
				State nn = new State(e, n);
				sucs.add(nn);
			}
		}
		return sucs;
	}
	/**
	 * from the actual state simulates randomly all plays left until the game ends
	 */
	final private void simulation() {
		while(actual.layout.statusGameOver() != true) {
			Ilayout child = actual.layout.randomChild();
			if (actual.father == null || !child.equals(actual.father.layout))
					actual = new State(child, actual);
		}
		actual.w = actual.layout.winnerToInt();
		actual.n = 1;
	}
	/**
	 * from the actual state, excluding it, until the root state, it increments the value of w and n 
	 */
	final private void backup() {
		double tmp = actual.w, tmp2 = actual.n;
		while(actual.father != null) {
			actual = actual.father;
			actual.w += tmp;
			actual.n += tmp2;
		}
	}
	/**
	 * Gets the best child and should return it but instead, to simplify in this specific case,
	 * it returns the move played in that child.  
	 * @param sucs		list of children
	 * @return			position played in that child
	 */
	final private int bestChild(List<State> sucs) {
		Queue<State> abertos = new PriorityQueue<>(10, (s1, s2) -> (int) Math.signum(s2.getG()-s1.getG()));
		for(State e: sucs) {
			e.setG();
			abertos.add(e);
		}
		return abertos.peek().layout.getMovePlayed();
	}
	/**
	 * My simpler Mote Carlo Tree Search algorithm
	 * @param s			It's the layout with the current board
	 * @return			the best position to play in that moment
	 */
	final public int MctsSearch(Ilayout s) {
		State root = new State(s, null);
		actual = root;	//select
		List<State> sucs = expand(actual);
		int k = 0;
		while(k < 70) {
			for(int i = 0; i < sucs.size(); i++) {
				actual = sucs.get(i);
				simulation();
				backup(); 
			}
			k++;
		}
		return bestChild(sucs);
	}
	
}
