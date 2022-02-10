# https://leetcode.com/contest/weekly-contest-279/problems/design-bitset/
# 6002. Design Bitset

class Bitset {
    private long bitset = 0;
    
    private long size = 0;
    
    private long numOnes = 0;

    public Bitset(int size) {
        this.size = size;
    }
    
    public void fix(int idx) {
        long fixer = 1 << (size - idx - 1);
        long newBitset = bitset | fixer;
        if (newBitset != bitset) {
            numOnes++;
        }
        bitset = newBitset;
    }
    
    public void unfix(int idx) {
        long fixer = ((1 << size) - 1) ^ (1 << (size - idx - 1));
        long newBitset = bitset & fixer;
        if (newBitset != bitset) {
            numOnes--;
        }
        bitset = newBitset;
    }
    
    public void flip() {
        long fixer = (1 << size) - 1;
        bitset = fixer - bitset;
        numOnes = size - numOnes;
    }
    
    public boolean all() {
        return numOnes == size;
    }
    
    public boolean one() {
        return numOnes > 0;
    }
    
    public int count() {
        return (int) numOnes;
    }
    
    public String toString() {
        String bitsetStr = Long.toBinaryString(bitset);
        int len = bitsetStr.length();
        for (int i = 0; i < size - len; ++i) {
            bitsetStr = "0" + bitsetStr;
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
