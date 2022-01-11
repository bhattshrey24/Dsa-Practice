package Stack_And_Queue;

public class CircularTour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

// must watch if doubt https://www.youtube.com/watch?v=zcnVaVJkLhY
	
	// here we just need an answer , there can be multiple one since we dont need
	// the min petrol , we just need to complete a the circle

	// simple concept is that at every step we check whether we can reach next
	// petrol pump or not if yes then add balance petrol to tank and move if not
	// then move to next pointer and start again checking if this new index is
	// answer or not

	int tour(int petrol[], int distance[]) {// we can further optimize it using normal dp array but then space
											// complexity will increase or just do changes in given array

		int rear = 0, front = 0;// front will be at the answer index and rear will move ahead to check if answer
								// is actually the answer or not
		int count = 2 * petrol.length;// cause at max if we didnt get answer in 2 iteration means there no answer
		int i = 0;
		int ans = -1;
		int balance = 0;// i.e. balance fuel

		while (count > i) {
			int nextP = rear + 1 >= petrol.length ? (rear + 1) % petrol.length : rear + 1;// next position , since track
																							// is circular therefore we
																							// have to do this for next
																							// P

			int currDis = distance[rear];
			int currPetrol = petrol[rear];

			if (currPetrol - currDis >= 0 || (currPetrol + balance) - currDis >= 0) {// if this is true means we can
																						// reach next place , and we
																						// check both ways that is with
																						// balance fuel and without
																						// balance fuel
				balance = (balance + currPetrol) - currDis;
				rear = nextP;// move rear to next position

				if (rear == front) {// means we completed the track
					ans = front;
					break;
				}
			} else {// means we cant reach next petrol pump
				rear = nextP;
				front = nextP;
				balance = 0;// since previous front was not the answer so flush out all the balance fuel and
							// now we check for new front
			}
			i++;
		}
		return ans;
	}
}
