import java.util.Random;


public class Matrix {
    private int[][] m;
    private int[][] mCopy;
    private Random rand;
    private int score = 0;
    
    public Matrix() {
    	m = new int[4][4];
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) m[i][j] = 0;
    	}
    	mCopy = new int[4][4];
    	rand = new Random();
    	addNumber();
    	addNumber();
    }
    
    
    // flip the matrix about the central vertical axis
    private void flip_y() {
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 2; j++) {
    			int temp = m[i][j];
    			m[i][j] = m[i][3-j];
    			m[i][3-j] = temp;
    		}
    	}
    }
    
    // flip the matrix about the diagonal from top-left to lower-right
    private void flip_d() {
    	for (int i = 1; i < 4; i++) {
    		for (int j = 0; j < i; j++) {
    			int temp = m[i][j];
    			m[i][j] = m[j][i];
    			m[j][i] = temp;
    		}
    	}
    }
    
    // rotate the matrix 90 degress i times
    private void rotate_90(int i) {
    	i %= 4;
    	for (int j = 0; j < i; j++) {
    		flip_d();
        	flip_y();
    	}
    }
    
    // move all nonzero elements of A to the front
    private void compress(int[] A) {
    	int i = 0, j = 0;
    	while(j < A.length) {
    		A[i] = A[j++];
    		if(A[i] > 0) i++;
    	}
    	while(i < A.length) A[i++] = 0;
    }
    
    private void makeCopy() {
    	for (int i = 0; i < 4; i++){
    		for (int j = 0; j < 4; j++) mCopy[i][j] = m[i][j];
    	}
    }
    
    /*
     * ignoring zeros, combine 2 succesive nonzero elements and add 1
     * e.g. {1, 1, 1, 1, 2, 0, 2} to {2, 2, 3, 0, 0, 0, 0}
     */
    private void move(int[] A) {
    	
    	compress(A);
    	
    	for (int i = 0; i < A.length - 1; i++) {
    		if(A[i] != 0 && A[i] == A[i+1]) {
    			A[i]++;
    			score += (1 << A[i]);
    			A[++i] = 0;
    		}
    	}
    	
    	compress(A);
    }
    
    public void moveLeft() {
    	makeCopy();
    	for(int[] A : m) move(A);
    }
    
    public void moveUp() {
    	makeCopy();
    	rotate_90(3);
    	for(int[] A : m) move(A);
    	rotate_90(1);
    }
    
    public void moveRight() {
    	makeCopy();
    	rotate_90(2);
    	for(int[] A : m) move(A);
    	rotate_90(2);
    }
    
    public void moveDown() {
    	makeCopy();
    	rotate_90(1);
    	for(int[] A : m) move(A);
    	rotate_90(3);
    }
    
    // add a number at an empty position uniformly
    // this number is either 1 or 2
    public boolean addNumber() {
    	int[] free = new int[16];
    	int L = 0;
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			if(m[i][j] < 1) {
    				free[L++] = i * 4 + j;
    			}
    		}
    	}
    	
    	if (L == 0) return false;
    	int pos = rand.nextInt(L);
    	m[free[pos] / 4][free[pos] % 4] = getNumber();
    	return true;
    }
    
    
    
    private int getNumber() {
    	int prob = rand.nextInt(1000);
    	return prob * 16 < score ? 2 : 1;
    }
    
    public int getScore() { return score; }
    public void resetScore() { score = 0; }
    
    
    public int get(int i, int j){
    	return m[i][j];
    }
    
    // returns true if this matrix can be further moved
    public boolean isAlive() {
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			if (m[i][j] != mCopy[i][j]) return true;
    		}
    	}
		return false;
    }
    
}
