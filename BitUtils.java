
public class BitUtils {

    private BitUtils() {
    }

    /**
     * Set bit given index - MSB has highest index
     * 
     * @param n        number to set bit in
     * @param bitIndex index to set bit
     * @return the resulting number
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static long setBit(long n, int bitIndex) {
        n |= (1 << bitIndex);
        return n;
    }

    /**
     * Clear bit given index - MSB has highest index
     * 
     * @param n        number to clear bit in
     * @param bitIndex index to clear bit
     * @return the resulting number
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static long clearBit(long n, int bitIndex) {
        n &= ~(1 << bitIndex);
        return n;
    }

    /**
     * Clear lower bits
     * 
     * @param n       number to clear lower bits in
     * @param numBits number of lower bits to clear
     * @return the resulting number
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static long clearLowerBits(long n, int numBits) {
        n &= ~((1 << numBits) - 1);
        return n;
    }

    /**
     * Set the lower bits
     * 
     * @param n       number to set lower bits in
     * @param numBits number of lower bits to set
     * @return the resulting number
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static long setLowerBits(long n, int numBits) {
        n |= ((1 << numBits) - 1);
        return n;
    }

    /**
     * Set bits in a given range
     * 
     * @param n        number to set bits in
     * @param bitIndex starting index of the range
     * @param numBits  towards the right
     * @return the resulting number
     * 
     *         Time complexity : O(1) Space complexity : O(1)
     */
    public static long setBitsInRange(long n, int bitIndex, int numBits) {
        long mask = (1 << numBits) - 1;
        n |= (mask << (bitIndex - numBits + 1));
        return n;
    }

}