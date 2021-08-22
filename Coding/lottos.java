
public class lottos {
	
	    public static int[] solution(int[] lottos, int[] win_nums) {
	        
	        int min=7; int max=7;

	        for(int i=0;i<lottos.length;i++) {
	        	if(lottos[i]==0)
	        		max--;
	        	else {
	        		for(int j=0;j<win_nums.length;j++) {
	        			if(lottos[i]==win_nums[j]) {
	        				min--;
	        				max--;
	        			}
	        		}
	        	}
	        	
	        }
	        if(min==7)
        		min=6;
	        int[] answer = {max,min};

	        return answer;
	    }
	public static void main(String[] args) {
		int[] lottos = {0,0,0,0,1,0};
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		int[] ans = solution(lottos, win_nums);
		System.out.println(ans[0]+","+ans[1]);
	}
	
	//람다 풀이
//	public int[] solution(int[] lottos, int[] winNums) {
//        return LongStream.of(
//                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l) || l == 0).count(),
//                (lottos.length + 1) - Arrays.stream(lottos).filter(l -> Arrays.stream(winNums).anyMatch(w -> w == l)).count()
//        )
//                .mapToInt(op -> (int) (op > 6 ? op - 1 : op))
//                .toArray();
//    }
	
	
	//MAP 활용 풀이
//	public int[] solution(int[] lottos, int[] win_nums) {
//        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
//        int zeroCount = 0;
//
//        for(int lotto : lottos) {
//            if(lotto == 0) {
//                zeroCount++;
//                continue;
//            }
//            map.put(lotto, true);
//        }
//
//
//        int sameCount = 0;
//        for(int winNum : win_nums) {
//            if(map.containsKey(winNum)) sameCount++;
//        }
//
//        int maxRank = 7 - (sameCount + zeroCount);
//        int minRank = 7 - sameCount;
//        if(maxRank > 6) maxRank = 6;
//        if(minRank > 6) minRank = 6;
//
//        return new int[] {maxRank, minRank};
//    }
	
	
	//SWITCH 활용
//	public int[] solution(int[] lottos, int[] win_nums) {
//        int[] answer = new int[2];
//
//        int cnt1 = 0;
//        int cnt2 = 0;
//        for(int i : lottos) {
//            if(i == 0) {
//                cnt1++;
//                continue;
//            }
//            for(int j : win_nums) {
//                if(i == j) cnt2++;
//            }
//        }
//
//
//        answer[0] = getGrade(cnt1+cnt2);
//        answer[1] = getGrade(cnt2);
//
//        return answer;
//    }
//
//    public int getGrade(int n) {
//        switch(n) {
//            case 6 :
//                return 1;
//            case 5 :
//                return 2;
//            case 4 :
//                return 3;
//            case 3 :
//                return 4;
//            case 2 :
//                return 5;
//            default :
//                return 6;
//        }
//    }
}
// 출처 : https://programmers.co.kr/learn/courses/30/lessons/77484?language=java