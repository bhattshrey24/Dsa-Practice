
public class BulbSwitcher319 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int bulbSwitch(int n) {// its a mathematical question
		// we just have to find the perfect squares smaller than n ,
		// only perfect squares have off number of factors therefore they are left "On"
		// cause they cant be paired in (On,Off) pair, sir explained in video must watch
		int i = 1;
		int ans = 0;
		while (i * i <= n) {
			ans++;
			i++;
		}
		return ans;
	}
}
