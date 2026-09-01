
import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0;
        int startC = 0;
        int litterCount = 0;

        int[][] litterIndex = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterIndex[i], -1);

            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    startR = i;
                    startC = j;
                }

                if (ch == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // No litter
        if (litterCount == 0) {
            return 0;
        }

        int totalMasks = 1 << litterCount;

        /*
         * bestEnergy[mask][row][col]
         * = maximum energy with which we have reached this state.
         */
        int[][][] bestEnergy = new int[totalMasks][m][n];

        for (int mask = 0; mask < totalMasks; mask++) {
            for (int i = 0; i < m; i++) {
                Arrays.fill(bestEnergy[mask][i], -1);
            }
        }

        /*
         * State:
         * row, col, mask, remaining energy
         */
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startR, startC, 0, energy});
        bestEnergy[0][startR][startC] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int moves = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] current = queue.poll();

                int r = current[0];
                int c = current[1];
                int mask = current[2];
                int currEnergy = current[3];

                // All litter collected
                if (mask == totalMasks - 1) {
                    return moves;
                }

                // Cannot move without energy
                if (currEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // Outside grid
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    // Obstacle
                    if (classroom[nr].charAt(nc) == 'X') {
                        continue;
                    }

                    // One move costs 1 energy
                    int newEnergy = currEnergy - 1;

                    int newMask = mask;

                    // Collect litter
                    if (classroom[nr].charAt(nc) == 'L') {

                        int index = litterIndex[nr][nc];

                        newMask = mask | (1 << index);
                    }

                    // Reset energy at R
                    if (classroom[nr].charAt(nc) == 'R') {
                        newEnergy = energy;
                    }

                    /*
                     * If we have already reached this position
                     * with the same mask and more energy,
                     * this state is unnecessary.
                     */
                    if (bestEnergy[newMask][nr][nc] >= newEnergy) {
                        continue;
                    }

                    bestEnergy[newMask][nr][nc] = newEnergy;

                    queue.offer(new int[]{
                        nr,
                        nc,
                        newMask,
                        newEnergy
                    });
                }
            }

            moves++;
        }

        return -1;
    }
}

