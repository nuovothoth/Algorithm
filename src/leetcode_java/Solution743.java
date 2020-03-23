package leetcode_java;

public class Solution743 {
    private static final int MAX_VALUE = 700000;
    private int[][] weight;
    private int[] nodeDist;
    private int[] visitedNode;

    public int networkDelayTime(int[][] times, int N, int K) {
        weight = new int[N+1][N+1];
        nodeDist = new int[N+1];
        visitedNode = new int[N+1];
        int result = Integer.MIN_VALUE;

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                weight[i][j] = MAX_VALUE;
            }
            nodeDist[i] = MAX_VALUE;
        }

        for(int i=0;i<times.length;i++){
            weight[times[i][0]][times[i][1]] = times[i][2];
        }

        for(int i=1;i<=N;i++){
            if(K==i) nodeDist[i] = 0;
            else nodeDist[i] = weight[K][i];
        }

        visitedNode[K] = 1;

        DK(N);

        for(int i=1;i<=N;i++){
            //System.out.println("nodeDist["+i+"]: "+nodeDist[i]);
            if(nodeDist[i] == MAX_VALUE) return -1;

            if(result<nodeDist[i]) result=nodeDist[i];
        }

        return result;
    }

    private int getMinNode(){
        int minVal = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int i=1;i<nodeDist.length;i++){
            if(visitedNode[i]==0 && nodeDist[i]<minVal){
                minVal = nodeDist[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    private void DK(int N){
        int curNode = 0;

        for(int i=0;i<N-1;i++){
            curNode = getMinNode();
            visitedNode[curNode] = 1;

            for(int trackedNode = 1; trackedNode<=N; trackedNode++){
                if(visitedNode[trackedNode]==0){
                    if(nodeDist[trackedNode]>nodeDist[curNode]+weight[curNode][trackedNode]){
                        nodeDist[trackedNode]=nodeDist[curNode]+weight[curNode][trackedNode];
                    }
                }
            }
        }
    }
}
