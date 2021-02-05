import java.util.ArrayList;
import java.util.Arrays; 


public class VacuumWorld {
	
	public static String breadthFirstSearch() {
		//declare initial state
		int state = 1;
		int goalState1 = 8;
		int goalState2 = 7;
		int currentNode;
		ArrayList<Integer> frontier = new ArrayList<Integer>();
		ArrayList<Integer> explored = new ArrayList<Integer>();
		//two dimensional array for storing neighbouring nodes 
		Integer[][] neighbourNodes = new Integer[][] {
			 {1, 2, 3}, //neighbouring nodes of node 1
			 {1, 2, 6}, //neighbouring nodes of node 2
			 {1, 3, 4}, //neighbouring nodes of node 3
			 {3, 4, 8}, //neighbouring nodes of node 4
			 {5, 6, 7}, //neighbouring nodes of node 5
			 {2, 5, 6}, //neighbouring nodes of node 6
			 {5, 7, 8}, //neighbouring nodes of node 7
			 {4, 7, 8}  //neighbouring nodes of node 8
		};			
		frontier.add(state);
		do {
			if(frontier.isEmpty()){
				return "Frontier queue is empty";
			} else {
				currentNode = frontier.get(0);
				frontier.remove(0);
				explored.add(currentNode);
				System.out.println("Node to be expanded: " + currentNode);
				System.out.println("Explored set: " + explored);
				System.out.print("Node " + currentNode + " expands to: " + Arrays.deepToString(neighbourNodes[currentNode - 1]));
				for(int i = 0; i < neighbourNodes[currentNode - 1].length; i++)
					//add successor nodes that haven't been explored yet to the frontier 
					if(!explored.contains(neighbourNodes[currentNode - 1][i]) && !frontier.contains(neighbourNodes[currentNode - 1][i])) {	
						frontier.add(neighbourNodes[currentNode - 1][i]);
					}
				System.out.println("\nNodes in the frontier: " + frontier);
			}	
			
		}//repeat until both goal states have been explored  
		while(!explored.contains(goalState1) || !explored.contains(goalState2));	
		System.out.println("\n***SOLUTION***");
		System.out.println("Nodes in the frontier: " + frontier);
		System.out.println("Explored set: " + explored);
		return "Goal states " + goalState1 + " and " + goalState2 + " reached.";
		}		
	
	public static void main(String[] args) {
		System.out.print(breadthFirstSearch());
	}

}
