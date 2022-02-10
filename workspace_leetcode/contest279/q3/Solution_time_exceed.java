class Bitset {

    private int[] bitset;
    
    private int size = 0;
    
    private int numOnes = 0;
    
    private String bitsetStr = "";
    
    private boolean dirty = true;
    
    public Bitset(int size) {
        this.size = size;
        bitset = new int[size];
    }
    
    public void fix(int idx) {
        if (bitset[idx] != 1) {
            bitset[idx] = 1;
            numOnes++;
            dirty = true;
            bitsetStr = "";
        }
    }
    
    public void unfix(int idx) {
        if (bitset[idx] != 0) {
            bitset[idx] = 0;
            numOnes--;
            dirty = true;
            bitsetStr = "";
        }
    }
    
    public void flip() {
        for (int i = 0; i < size; ++i) {
            bitset[i] = 1 - bitset[i];
        }
        numOnes = size - numOnes;
        dirty = true;
        bitsetStr = "";
    }
    
    public boolean all() {
        return numOnes == size;
    }
    
    public boolean one() {
        return numOnes > 0;
    }
    
    public int count() {
        return numOnes;
    }
    
    public String toString() {
        if (dirty) {
            bitsetStr = "";
            for (int i = 0; i < size; ++i) {
                bitsetStr += String.valueOf(bitset[i]);
            }
            
            dirty = false;
        }
        
        return bitsetStr;
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
