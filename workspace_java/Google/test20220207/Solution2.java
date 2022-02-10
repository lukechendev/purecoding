class Solution {
  public List<Integer> sampleLogs(int[] logs, int total) {
    List<Integer> numSamples = new ArrayList<>();

    Arrays.sort(logs);

    for (int i = 0; i < logs.length; ++i) {
      int avg = total / (logs.length - i);
      if (logs[i] <= avg) {
        numSamples.add(logs[i]);
        total -= logs[i];
      } else {
        for (int j = i; j < logs.length; ++j) {
          numSamples.add(avg);
        }

        break;
      }
    }

    return numSamples;
  }
}
